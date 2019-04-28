package com.gayatri.accountservice.exception;

public class AccountNumberTooLengthyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNumberTooLengthyException() {
		super();
	}

	public AccountNumberTooLengthyException(String message) {
		super(message);
	}
	
}
