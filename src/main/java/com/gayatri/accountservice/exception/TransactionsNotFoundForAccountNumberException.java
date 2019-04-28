package com.gayatri.accountservice.exception;

public class TransactionsNotFoundForAccountNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionsNotFoundForAccountNumberException() {
		super();
	}

	public TransactionsNotFoundForAccountNumberException(String message) {
		super(message);
	}
	
	

}
