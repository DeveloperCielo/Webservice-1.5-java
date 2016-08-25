package com.cieloecommerce.ws15.request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cieloecommerce.ws15.Cielo;
import com.cieloecommerce.ws15.Merchant;
import com.cieloecommerce.ws15.Transaction;

@XmlRootElement(name = "requisicao-autorizacao-tid", namespace = Cielo.NS)
public class AuthorizationRequest extends AbstractRequest<Transaction> {
	@XmlElement(name = "tid", namespace = Cielo.NS)
	private String tid;

	@XmlElement(name = "dados-ec", namespace = Cielo.NS)
	protected Merchant merchant;

	public AuthorizationRequest() {
		super(Cielo.PRODUCTION);
	}

	public AuthorizationRequest(String tid, Merchant merchant, String endpoint) {
		super(endpoint);

		this.tid = tid;
		this.merchant = merchant;
	}

	@Override
	protected void createContext() {
		try {
			requestContext = JAXBContext.newInstance(AuthorizationRequest.class);
			responseContext = JAXBContext.newInstance(Transaction.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
