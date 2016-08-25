package com.cieloecommerce.ws15;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Merchant {
	@XmlElement(name = "numero", namespace = Cielo.NS)
	private String affiliationId;

	@XmlElement(name = "chave", namespace = Cielo.NS)
	private String affiliationKey;

	public Merchant(String id, String key) {
		affiliationId = id;
		affiliationKey = key;
	}

	public String getAffiliationId() {
		return affiliationId;
	}

	public String getAffiliationKey() {
		return affiliationKey;
	}

	public void setAffiliationId(String affiliationId) {
		this.affiliationId = affiliationId;
	}

	public void setAffiliationKey(String affiliationKey) {
		this.affiliationKey = affiliationKey;
	}
}
