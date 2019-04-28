package com.gayatri.accountservice.constants;

public class Constants {
	
	/* constant for introduction url */
	public static final String GREETING_HELLO = "Hello! Welcome to bank-account service";
	
	/* constants for entity properties */
	public static final int USERID_SIZE = 15;
	public static final int ACCOUNTNUMBER_SIZE = 15;
	public static final String ACCOUNTNUMBER_REGEX = "^[a-zA-Z0-9_-]*$";
	
	/* constants related to Error Controller */
	public static final String ERROR_PATH = "/error";
	public static final String ERROR_MESSAGE = "Something went wrong!";
	
	/* constants related to User ID Validation */
	public static final String USER_ID_EMPTY = "User ID cannot be empty. Please provide a valid user ID";
	public static final String USER_ID_NULL = "User ID provided is not valid. Please provide a valid user ID";
	public static final String USER_ID_TOO_LENGTHY = "User ID provided is too lengthy. Maximum length is "+USERID_SIZE;
	public static final String NO_ACCOUNTS_FOUND_FOR_USERID = "No accounts were found for the user";
	
	/* constants related to Account Number Validation */
	public static final String ACCOUNT_NUMBER_EMPTY = "Account number cannot be empty. Please provide a valid Account Number";
	public static final String ACCOUNT_NUMBER_NULL = "Account number provided is not valid. Please provide a valid Account number";
	public static final String ACCOUNT_NUMBER_TOO_LENGTHY = "Account number provided is too lengthy. Maximum length is "+ACCOUNTNUMBER_SIZE;
	public static final String NO_TRANSACTIONS_FOUND_FOR_ACCOUNT_NUMBER = "No transactions were found for the provided Account Number";
	public static final String ACCOUNT_NUMBER_HAS_SPECIAL_CHARACTERS = "Account number is not valid. Please provide a valid Account number";
}
