package com.cieloecommerce.ws15;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethod {
	public enum Issuer {
		@XmlEnumValue("visa")
		VISA, @XmlEnumValue("mastercard")
		MASTERCARD, @XmlEnumValue("diners")
		DINERS, @XmlEnumValue("discover")
		DISCOVER, @XmlEnumValue("elo")
		ELO, @XmlEnumValue("amex")
		AMEX, @XmlEnumValue("jcb")
		JCB, @XmlEnumValue("aura")
		AURA
	}

	public enum Product {
		@XmlEnumValue("1")
		CREDITO_A_VISTA, @XmlEnumValue("2")
		PARCELADO_LOJA, @XmlEnumValue("3")
		PARCELADO_ADM, @XmlEnumValue("A")
		DEBITO;
	}

	@XmlElement(name = "bandeira", namespace = Cielo.NS)
	private Issuer issuer;

	@XmlElement(name = "produto", namespace = Cielo.NS)
	private Product product;

	@XmlElement(name = "parcelas", namespace = Cielo.NS)
	private Integer installments;

	public PaymentMethod() {

	}

	public PaymentMethod(Issuer issuer, Product product, Integer installments) {
		this.issuer = issuer;
		this.product = product;
		this.installments = installments;
	}

	public PaymentMethod(Issuer issuer, Product product) {
		this(issuer, product, 1);
	}

	public Issuer getIssuer() {
		return issuer;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setIssuer(Issuer issuer) {
		this.issuer = issuer;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
}