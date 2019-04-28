package com.gayatri.accountservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gayatri.accountservice.constants.Constants;

public class UserIdValidator {
	
	private static final Logger logger = LoggerFactory.getLogger(UserIdValidator.class);
	
	/**
	 * This utility checks if the userId provided is valid or not
	 * @param userId
	 * @return true or false
	 */
	public static boolean isValid(String userId) {
		boolean isValid = false;
		
		/* check if userId is null */
		if(userId == null) {
			logger.info("user ID is null");
		} else if(userId.isEmpty()) {
			logger.info("User ID is empty");
		} else if (userId.length() > Constants.USERID_SIZE) {
			logger.info("User ID too lengthy");
		}else {
			return true;
		}
		
		return isValid;
	}
}
