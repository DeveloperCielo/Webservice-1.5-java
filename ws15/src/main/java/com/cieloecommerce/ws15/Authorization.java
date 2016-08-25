package com.cieloecommerce.ws15;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Authorization {
	@XmlElement(name = "codigo")
	private String code;

	@XmlElement(name = "mensagem")
	private String message;

	@XmlElement(name = "data-hora")
	private String dateTime;

	@XmlElement(name = "valor")
	private Integer total;

	@XmlElement(name = "lr")
	private String lr;

	@XmlElement(name = "arp")
	private String arp;

	@XmlElement(name = "nsu")
	private Integer nsu;

	public Authorization() {

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

	public String getLr() {
		return lr;
	}

	public String getArp() {
		return arp;
	}

	public Integer getNsu() {
		return nsu;
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

	public void setLr(String lr) {
		this.lr = lr;
	}

	public void setArp(String arp) {
		this.arp = arp;
	}

	public void setNsu(Integer nsu) {
		this.nsu = nsu;
	}

}
