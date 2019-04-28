package com.gayatri.accountservice.exception;

public class NoAccountFoundForUserIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAccountFoundForUserIdException() {
		super();
	}

	public NoAccountFoundForUserIdException(String message) {
		super(message);
	}

}
