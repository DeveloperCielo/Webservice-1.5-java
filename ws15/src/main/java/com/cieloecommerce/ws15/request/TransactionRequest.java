package com.cieloecommerce.ws15.request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cieloecommerce.ws15.Cielo;
import com.cieloecommerce.ws15.Holder;
import com.cieloecommerce.ws15.Merchant;
import com.cieloecommerce.ws15.Order;
import com.cieloecommerce.ws15.PaymentMethod;
import com.cieloecommerce.ws15.Transaction;
import com.cieloecommerce.ws15.Transaction.AuthorizationMethod;

@XmlRootElement(name = "requisicao-transacao", namespace = Cielo.NS)
public class TransactionRequest extends AbstractRequest<Transaction> {
	@XmlElement(name = "dados-ec", namespace = Cielo.NS)
	protected Merchant merchant;

	@XmlElement(name = "dados-portador", namespace = Cielo.NS)
	private Holder holder;

	@XmlElement(name = "dados-pedido", namespace = Cielo.NS)
	private Order order;

	@XmlElement(name = "forma-pagamento", namespace = Cielo.NS)
	private PaymentMethod paymentMethod;

	@XmlElement(name = "url-retorno", namespace = Cielo.NS)
	private String returnUrl;

	@XmlElement(name = "autorizar", namespace = Cielo.NS)
	private AuthorizationMethod authorize;

	@XmlElement(name = "capturar", namespace = Cielo.NS)
	private boolean capture;

	@XmlElement(name = "campo-livre", namespace = Cielo.NS)
	private String freeField;

	@XmlElement(name = "bin", namespace = Cielo.NS)
	private String bin;

	@XmlElement(name = "gerar-token", namespace = Cielo.NS)
	private boolean generateToken;

	public TransactionRequest() {
		super(Cielo.PRODUCTION);
	}

	public TransactionRequest(Transaction transaction, String endpoint) {
		super(endpoint);

		this.merchant = transaction.getMerchant();
		this.holder = transaction.getHolder();
		this.order = transaction.getOrder();
		this.paymentMethod = transaction.getPaymentMethod();
		this.returnUrl = transaction.getReturnUrl();
		this.authorize = transaction.getAuthorize();
		this.capture = transaction.getCapture();
		this.freeField = transaction.getFreeField();
		this.bin = transaction.getBin();
		this.generateToken = transaction.getGenerateToken();
	}

	@Override
	protected void createContext() {
		try {
			requestContext = JAXBContext.newInstance(TransactionRequest.class);
			responseContext = JAXBContext.newInstance(Transaction.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
