package com.cieloecommerce.ws15.request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cieloecommerce.ws15.Cielo;
import com.cieloecommerce.ws15.Holder;
import com.cieloecommerce.ws15.Merchant;
import com.cieloecommerce.ws15.Token;

@XmlRootElement(name = "requisicao-token", namespace = Cielo.NS)
public class TokenRequest extends AbstractRequest<Token> {
	@XmlElement(name = "dados-ec", namespace = Cielo.NS)
	protected Merchant merchant;

	@XmlElement(name = "dados-portador", namespace = Cielo.NS)
	protected Holder holder;

	public TokenRequest() {
		super(Cielo.PRODUCTION);
	}

	public TokenRequest(Merchant merchant, Holder holder, String endpoint) {
		super(endpoint);

		this.merchant = merchant;
		this.holder = holder;
	}

	@Override
	protected void createContext() {
		try {
			requestContext = JAXBContext.newInstance(TokenRequest.class);
			responseContext = JAXBContext.newInstance(Token.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
