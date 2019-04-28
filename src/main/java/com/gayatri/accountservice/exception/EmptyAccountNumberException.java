package com.gayatri.accountservice.exception;

public class EmptyAccountNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyAccountNumberException() {
		super();
	}

	public EmptyAccountNumberException(String message) {
		super(message);
	}
	

}
