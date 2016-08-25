package com.cieloecommerce.ws15;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cancelamento", namespace = Cielo.NS)
public class Void {
	@XmlElement(name = "codigo")
	private String code;

	@XmlElement(name = "mensagem")
	private String message;

	@XmlElement(name = "data-hora")
	private String dateTime;

	@XmlElement(name = "valor")
	private Integer amount;

	public Void() {
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDateTime() {
		return dateTime;
	}

	public Integer getAmount() {
		return amount;
	}

}
