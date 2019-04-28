package com.gayatri.accountservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gayatri.accountservice.constants.Constants;
import com.gayatri.accountservice.exception.EmptyUserIdException;
import com.gayatri.accountservice.exception.NullUserIdException;
import com.gayatri.accountservice.exception.UserIdTooLengthyException;

public class UserIdValidator {

	private static final Logger logger = LoggerFactory.getLogger(UserIdValidator.class);

	/**
	 * This utility checks if the user ID provided is valid or not
	 * 
	 * @param userId
	 * @return true or false
	 * @throws NullUserIdException
	 * @throws EmptyUserIdException
	 * @throws UserIdTooLengthyException
	 */
	public static boolean isValid(String userId)
			throws NullUserIdException, EmptyUserIdException, UserIdTooLengthyException {
		boolean isValid = false;

		/* check if userId is null */
		if (userId == null) {
			logger.error("user ID is null");
			throw new NullUserIdException();
		} else if (userId.isEmpty()) {
			logger.error("User ID is empty");
			throw new EmptyUserIdException();
		} else if (userId.length() > Constants.USERID_SIZE) {
			logger.error("User ID too lengthy");
			throw new UserIdTooLengthyException();
		} else {
			isValid = true;
		}
		return isValid;
	}
}
