package com.cieloecommerce.ws15.request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cieloecommerce.ws15.Cielo;
import com.cieloecommerce.ws15.Merchant;
import com.cieloecommerce.ws15.Transaction;

@XmlRootElement(name = "requisicao-cancelamento", namespace = Cielo.NS)
public class VoidRequest extends AbstractRequest<Transaction> {
	@XmlElement(name = "tid", namespace = Cielo.NS)
	private String tid;

	@XmlElement(name = "dados-ec", namespace = Cielo.NS)
	private Merchant merchant;

	@XmlElement(name = "valor", namespace = Cielo.NS)
	private Integer amount;

	public VoidRequest() {
		super(Cielo.PRODUCTION);
	}

	public VoidRequest(String tid, Merchant merchant, Integer amount, String endpoint) {
		super(endpoint);

		this.tid = tid;
		this.merchant = merchant;
		this.amount = amount;
	}

	@Override
	protected void createContext() {
		try {
			requestContext = JAXBContext.newInstance(VoidRequest.class);
			responseContext = JAXBContext.newInstance(Transaction.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}