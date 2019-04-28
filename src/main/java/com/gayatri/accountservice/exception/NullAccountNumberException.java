package com.gayatri.accountservice.exception;

public class NullAccountNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullAccountNumberException() {
		super();
	}

	public NullAccountNumberException(String message) {
		super(message);
	}

}
