package com.cieloecommerce.ws15;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "transacao", namespace = Cielo.NS)
public class Transaction {
	public enum AuthorizationMethod {
		@XmlEnumValue("0")
		ONLY_AUTHENTICATE,

		@XmlEnumValue("1")
		AUTHORIZE_IF_AUTHENTICATED,

		@XmlEnumValue("2")
		AUTHORIZE,

		@XmlEnumValue("3")
		AUTHORIZE_WITHOUT_AUTHENTICATION,

		@XmlEnumValue("4")
		RECURRENCE;
	}

	@XmlElement(name = "tid")
	private String tid;

	@XmlElement(name = "pan")
	private String pan;

	@XmlElement(name = "status")
	private Integer status;

	@XmlElement(name = "url-autenticacao")
	private String authenticationUrl;

	@XmlElement(name = "autorizacao")
	private Authorization authorization;

	@XmlElement(name = "autenticacao")
	private Authentication authentication;

	@XmlElement(name = "dados-ec")
	private Merchant merchant;

	@XmlElement(name = "dados-portador")
	private Holder holder;

	@XmlElement(name = "dados-pedido")
	private Order order;

	@XmlElement(name = "forma-pagamento")
	private PaymentMethod paymentMethod;

	@XmlElement(name = "url-retorno")
	private String returnUrl;

	@XmlElement(name = "autorizar")
	private AuthorizationMethod authorize;

	@XmlElement(name = "capturar")
	private boolean capture;

	@XmlElement(name = "campo-livre")
	private String freeField;

	@XmlElement(name = "bin")
	private String bin;

	@XmlElement(name = "gerar-token")
	private boolean generateToken;

	@XmlElement(name = "avs")
	private String avs;

	@XmlElement(name = "token")
	private Token token;

	@XmlElement(name = "cancelamentos")
	private List<Void> voids = new ArrayList<Void>();

	public Transaction() {

	}

	public Transaction(Merchant merchant, Holder holder, Order order, PaymentMethod paymentMethod,
			AuthorizationMethod authorize, boolean capture) {

		this.merchant = merchant;
		this.holder = holder;
		this.order = order;
		this.paymentMethod = paymentMethod;
		this.authorize = authorize;
		this.capture = capture;
	}

	public String getTid() {
		return tid;
	}

	public String getPan() {
		return pan;
	}

	public Integer getStatus() {
		return status;
	}

	public String getAuthenticationUrl() {
		return authenticationUrl;
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public Holder getHolder() {
		return holder;
	}

	public Order getOrder() {
		return order;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public AuthorizationMethod getAuthorize() {
		return authorize;
	}

	public boolean getCapture() {
		return capture;
	}

	public String getFreeField() {
		return freeField;
	}

	public String getBin() {
		return bin;
	}

	public boolean getGenerateToken() {
		return generateToken;
	}

	public String getAvs() {
		return avs;
	}

	public Token getToken() {
		return token;
	}

	public List<Void> getVoids() {
		return voids;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setAuthenticationUrl(String authenticationUrl) {
		this.authenticationUrl = authenticationUrl;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public void setHolder(Holder holder) {
		this.holder = holder;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public void setAuthorize(AuthorizationMethod authorize) {
		this.authorize = authorize;
	}

	public void setCapture(boolean capture) {
		this.capture = capture;
	}

	public void setFreeField(String freeField) {
		this.freeField = freeField;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public void setGenerateToken(boolean generateToken) {
		this.generateToken = generateToken;
	}

	public void setAvs(String avs) {
		this.avs = avs;
	}

	public void setToken(Token token) {
		this.token = token;
	}
}
