package com.cieloecommerce.ws15.request;

public class CieloException extends Exception {
	private static final long serialVersionUID = 7098967989572112073L;
	private String code;

	public CieloException(String code, String message) {
		super(message);

		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
