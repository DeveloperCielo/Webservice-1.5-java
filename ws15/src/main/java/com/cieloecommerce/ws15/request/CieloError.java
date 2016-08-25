package com.cieloecommerce.ws15.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cieloecommerce.ws15.Cielo;

@XmlRootElement(name = "erro", namespace = Cielo.NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class CieloError {
	@XmlAttribute(name = "id")
	private String id;

	@XmlElement(name = "codigo", namespace = Cielo.NS)
	private String code;

	@XmlElement(name = "mensagem", namespace = Cielo.NS)
	private String message;

	public CieloError() {
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}