package org.rest.util;

public enum ErrorCodes {
	ONE(404, "Not Found"), 
	TWO(500, "Server Issue"), 
	DEVICE_ID(1000, "Device ID cannot be empty"), 
	NODE_KEY(1001,"Node ID cannot be empty"), 
	SAP_ID(1002, "SAP ID cannot be empty"),
	SQL_EXCEPTION(1003,"Error occured while excecuting query");

	private final int code;
	private final String status;

	ErrorCodes(int code, String status) {
		this.code = code;
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

}
