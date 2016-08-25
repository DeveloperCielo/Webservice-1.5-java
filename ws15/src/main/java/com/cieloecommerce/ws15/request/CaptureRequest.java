package com.cieloecommerce.ws15.request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cieloecommerce.ws15.Cielo;
import com.cieloecommerce.ws15.Merchant;
import com.cieloecommerce.ws15.Transaction;

@XmlRootElement(name = "requisicao-captura", namespace = Cielo.NS)
public class CaptureRequest extends AbstractRequest<Transaction> {
	@XmlElement(name = "tid", namespace = Cielo.NS)
	private String tid;

	@XmlElement(name = "dados-ec", namespace = Cielo.NS)
	private Merchant merchant;

	@XmlElement(name = "valor", namespace = Cielo.NS)
	private Integer amount;

	@XmlElement(name = "taxa-embarque", namespace = Cielo.NS)
	private Integer shipping;

	public CaptureRequest() {
		super(Cielo.PRODUCTION);
	}

	public CaptureRequest(String tid, Merchant merchant, Integer amount, Integer shipping, String endpoint) {
		super(endpoint);

		this.tid = tid;
		this.merchant = merchant;
		this.amount = amount;
		this.shipping = shipping;
	}

	@Override
	protected void createContext() {
		try {
			requestContext = JAXBContext.newInstance(CaptureRequest.class);
			responseContext = JAXBContext.newInstance(Transaction.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}