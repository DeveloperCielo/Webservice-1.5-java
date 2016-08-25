package com.cieloecommerce.ws15;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Holder {
	@XmlEnum
	public enum CVV {
		@XmlEnumValue("0")
		NOT_INFORMED, @XmlEnumValue("1")
		INFORMED, @XmlEnumValue("2")
		UNREADABLE, @XmlEnumValue("9")
		NONEXISTENT;
	}

	@XmlElement(name = "numero", namespace = Cielo.NS)
	private String number;

	@XmlElement(name = "validade", namespace = Cielo.NS)
	private String expiration;

	@XmlElement(name = "indicador", namespace = Cielo.NS)
	private CVV indicator;

	@XmlElement(name = "codigo-seguranca", namespace = Cielo.NS)
	private String cvv;

	@XmlElement(name = "nome", namespace = Cielo.NS)
	private String name;

	@XmlElement(name = "token", namespace = Cielo.NS)
	private String token;

	public Holder(String token) {
		this.token = token;
	}

	public Holder(String number, String expiration, CVV indicator) {
		this.number = number;
		this.expiration = expiration;
		this.indicator = indicator;
	}

	public Holder(String number, String expiration, String cvv) {
		this.number = number;
		this.expiration = expiration;
		this.cvv = cvv;
		this.indicator = CVV.INFORMED;
	}

	public String getNumber() {
		return number;
	}

	public String getExpiration() {
		return expiration;
	}

	public CVV getIndicator() {
		return indicator;
	}

	public String getCvv() {
		return cvv;
	}

	public String getName() {
		return name;
	}

	public String getToken() {
		return token;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public void setIndicator(CVV indicator) {
		this.indicator = indicator;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
