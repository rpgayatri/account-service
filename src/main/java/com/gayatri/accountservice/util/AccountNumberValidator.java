package com.gayatri.accountservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gayatri.accountservice.constants.Constants;

public class AccountNumberValidator {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountNumberValidator.class);
	
	public static boolean isValid(String accountNumber) {
		boolean isValid = false;
		
		/* check if userId is null */
		if(accountNumber == null) {
			logger.info("Account number is null");
		} else if(accountNumber.isEmpty()) {
			logger.info("Account number is empty");
		} else if (accountNumber.length() > Constants.ACCOUNTNUMBER_SIZE) {
			logger.info("Account number too lengthy");
		} else if(!accountNumber.matches(Constants.ACCOUNTNUMBER_REGEX)) {
			logger.info("Account number not valid");
		} else {
			return true;
		}
		
		return isValid;
	}

}
