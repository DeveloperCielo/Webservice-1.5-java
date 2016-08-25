package com.cieloecommerce.ws15;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
	@XmlElement(name = "numero", namespace = Cielo.NS)
	private String number;

	@XmlElement(name = "valor", namespace = Cielo.NS)
	private Integer total;

	@XmlElement(name = "moeda", namespace = Cielo.NS)
	private Integer currency;

	@XmlElement(name = "data-hora", namespace = Cielo.NS)
	private String dateTime;

	@XmlElement(name = "descricao", namespace = Cielo.NS)
	private String description;

	@XmlElement(name = "idioma", namespace = Cielo.NS)
	private String language;

	@XmlElement(name = "taxa-embarque", namespace = Cielo.NS)
	private Integer shipping;

	@XmlElement(name = "soft-descriptor", namespace = Cielo.NS)
	private String softDescriptor;

	public Order() {

	}

	public Order(String number, Integer total, Integer currency) {
		this.number = number;
		this.total = total;
		this.currency = currency;
		this.dateTime = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss").format(new Date());
		this.description = "";
		this.language = "PT";
	}

	public Order(String number, Integer total) {
		this(number, total, 986);
	}

	public String getNumber() {
		return number;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getCurrency() {
		return currency;
	}

	public String getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public Integer getShipping() {
		return shipping;
	}

	public String getSoftDescriptor() {
		return softDescriptor;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}
}
