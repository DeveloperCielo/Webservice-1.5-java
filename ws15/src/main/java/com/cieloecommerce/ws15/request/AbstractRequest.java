package com.cieloecommerce.ws15.request;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.xml.sax.SAXException;

import com.cieloecommerce.ws15.Cielo;

public abstract class AbstractRequest<T> {
	@XmlAttribute(name = "id")
	protected String id;

	@XmlAttribute(name = "versao")
	protected String version = Cielo.VERSION;

	protected transient String endpoint;
	protected transient JAXBContext requestContext;
	protected transient JAXBContext responseContext;
	private transient HttpClient httpClient;

	public AbstractRequest(String endpoint) {
		this.id = UUID.randomUUID().toString();
		this.endpoint = endpoint;

		createContext();
	}

	protected abstract void createContext();

	public T execute() {
		T response = null;

		try {
			String request = marshal().toString();

			System.out.println(request);

			request = "mensagem=" + request;

			HttpPost post = new HttpPost(endpoint);

			post.setEntity(new StringEntity(request));

			response = readResponse(sendRequest(post));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	protected HttpResponse sendRequest(HttpUriRequest request) throws ClientProtocolException, IOException {
		if (httpClient == null) {
			httpClient = HttpClientBuilder.create().build();
		}

		request.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=ISO-8859-1");
		request.addHeader("User-Agent", "Java SDK/1.5");

		return httpClient.execute(request);
	}

	protected T readResponse(HttpResponse response) throws IOException, SAXException, JAXBException, CieloException {
		HttpEntity responseEntity = response.getEntity();
		InputStream responseEntityContent = responseEntity.getContent();

		Header contentEncoding = response.getFirstHeader("Content-Encoding");

		if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
			responseEntityContent = new GZIPInputStream(responseEntityContent);
		}

		return unmarshal(response.getStatusLine().getStatusCode(), responseEntityContent);
	}

	@SuppressWarnings("unchecked")
	protected T unmarshal(int statusCode, InputStream responseStream)
			throws SAXException, JAXBException, CieloException {
		Schema schema = getSchema();
		T response = null;

		BufferedReader responseReader = new BufferedReader(new InputStreamReader(responseStream));
		Unmarshaller unmarshaller;

		unmarshaller = responseContext.createUnmarshaller();
		unmarshaller.setSchema(schema);

		try {
			responseReader.mark(1);

			try {
				response = (T) unmarshaller.unmarshal(responseReader);
			} catch (UnmarshalException e) {
				responseReader.reset();

				unmarshaller = JAXBContext.newInstance(CieloError.class).createUnmarshaller();
				unmarshaller.setSchema(schema);

				CieloError error = (CieloError) unmarshaller.unmarshal(responseReader);

				throw new CieloException(error.getCode(), error.getMessage());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	protected StringWriter marshal() throws SAXException, JAXBException {
		StringWriter writer = new StringWriter();

		Marshaller marshaller = requestContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setSchema(getSchema());
		marshaller.marshal(this, new StreamResult(writer));

		return writer;
	}

	Schema getSchema() throws SAXException {
		return SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("ecommerce.xsd"));
	}
}
