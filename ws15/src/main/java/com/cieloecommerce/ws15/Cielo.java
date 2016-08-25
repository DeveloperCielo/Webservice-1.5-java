package com.cieloecommerce.ws15;

import com.cieloecommerce.ws15.Transaction.AuthorizationMethod;
import com.cieloecommerce.ws15.request.AuthorizationRequest;
import com.cieloecommerce.ws15.request.CaptureRequest;
import com.cieloecommerce.ws15.request.QueryRequest;
import com.cieloecommerce.ws15.request.TransactionRequest;
import com.cieloecommerce.ws15.request.VoidRequest;

public class Cielo {
	public static final String VERSION = "1.3.0";
	public static final String PRODUCTION = "https://ecommerce.cielo.com.br/servicos/ecommwsec.do";
	public static final String TEST = "https://qasecommerce.cielo.com.br/servicos/ecommwsec.do";
	public static final String NS = "http://ecommerce.cbmp.com.br";

	private final Merchant merchant;
	private final String endpoint;

	public Cielo(Merchant merchant, String endpoint) {
		this.merchant = merchant;
		this.endpoint = endpoint;
	}

	public Cielo(String id, String key, String endpoint) {
		this(new Merchant(id, key), endpoint);
	}

	public Cielo(Merchant merchant) {
		this(merchant, PRODUCTION);
	}

	public Cielo(String id, String key) {
		this(id, key, PRODUCTION);
	}

	public Holder holder(String token) {
		return new Holder(token);
	}

	public Holder holder(String number, String expiration, Holder.CVV indicator) {
		return new Holder(number, expiration, indicator);
	}

	public Holder holder(String number, String expiration, String cvv) {
		return new Holder(number, expiration, cvv);
	}

	public Order order(String number, Integer total, Integer currency) {
		return new Order(number, total, currency);
	}

	public Order order(String number, Integer total) {
		return new Order(number, total);
	}

	public PaymentMethod paymentMethod(PaymentMethod.Issuer issuer, PaymentMethod.Product product,
			Integer installments) {
		return new PaymentMethod(issuer, product, installments);
	}

	public PaymentMethod paymentMethod(PaymentMethod.Issuer issuer, PaymentMethod.Product product) {
		return new PaymentMethod(issuer, product);
	}

	public Transaction transaction(Holder holder, Order order, PaymentMethod paymentMethod,
			AuthorizationMethod authorize, boolean capture) {

		return new Transaction(merchant, holder, order, paymentMethod, authorize, capture);
	}

	public Transaction transaction(Holder holder, Order order, PaymentMethod paymentMethod,
			AuthorizationMethod authorize) {

		return new Transaction(merchant, holder, order, paymentMethod, authorize, true);
	}

	public AuthorizationRequest authorizationRequest(String tid) {
		return new AuthorizationRequest(tid, merchant, endpoint);
	}

	public TransactionRequest transactionRequest(Transaction transaction) {
		TransactionRequest request = new TransactionRequest(transaction, endpoint);

		return request;
	}

	public CaptureRequest captureRequest(String tid, Integer amount, Integer shipping) {
		CaptureRequest request = new CaptureRequest(tid, merchant, amount, shipping, endpoint);

		return request;
	}

	public CaptureRequest captureRequest(String tid, Integer amount) {
		return captureRequest(tid, amount, null);
	}

	public CaptureRequest captureRequest(String tid) {
		return captureRequest(tid, null);
	}

	public VoidRequest voidRequest(String tid, Integer amount) {
		VoidRequest request = new VoidRequest(tid, merchant, amount, endpoint);

		return request;
	}

	public VoidRequest voidRequest(String tid) {
		return voidRequest(tid, null);
	}

	public QueryRequest queryRequest(String tid) {
		QueryRequest request = new QueryRequest(tid, merchant, endpoint);

		return request;
	}
}
