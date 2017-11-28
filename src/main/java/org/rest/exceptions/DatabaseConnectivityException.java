package org.rest.exceptions;

import org.rest.util.ErrorCodes;

public class DatabaseConnectivityException extends Exception {

	private ErrorCodes errorCode;

	public DatabaseConnectivityException() {
		super();
	}

	public DatabaseConnectivityException(ErrorCodes errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public String toString() {
		return ("MyException Occurred: " + errorCode);
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}
}
