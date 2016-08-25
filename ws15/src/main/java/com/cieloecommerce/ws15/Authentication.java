package com.cieloecommerce.ws15;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Authentication {
	@XmlElement(name = "codigo")
	private String code;

	@XmlElement(name = "mensagem")
	private String message;

	@XmlElement(name = "data-hora")
	private String dateTime;

	@XmlElement(name = "valor")
	private Integer total;

	@XmlElement(name = "eci")
	private Integer eci;

	public Authentication() {
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

	public Integer getTotal() {
		return total;
	}

	public Integer getEci() {
		return eci;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setEci(Integer eci) {
		this.eci = eci;
	}

}
