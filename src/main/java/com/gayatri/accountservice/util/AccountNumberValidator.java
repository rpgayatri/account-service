package com.gayatri.accountservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gayatri.accountservice.constants.Constants;
import com.gayatri.accountservice.exception.AccountNumberTooLengthyException;
import com.gayatri.accountservice.exception.AccountNumberWithSpecialCharactersException;
import com.gayatri.accountservice.exception.EmptyAccountNumberException;
import com.gayatri.accountservice.exception.NullAccountNumberException;

public class AccountNumberValidator {

	private static final Logger logger = LoggerFactory.getLogger(AccountNumberValidator.class);

	/**
	 * This utility checks if the account number provided is valid or not
	 * @param accountNumber
	 * @return true or false
	 * @throws NullAccountNumberException
	 * @throws EmptyAccountNumberException
	 * @throws AccountNumberTooLengthyException
	 * @throws AccountNumberWithSpecialCharactersException
	 */
	public static boolean isValid(String accountNumber) throws NullAccountNumberException, EmptyAccountNumberException,
			AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		boolean isValid = false;

		/* check if userId is null */
		if (accountNumber == null) {
			logger.error("Account number is null");
			throw new NullAccountNumberException();
		} else if (accountNumber.isEmpty()) {
			logger.error("Account number is empty");
			throw new EmptyAccountNumberException();
		} else if (accountNumber.length() > Constants.ACCOUNTNUMBER_SIZE) {
			logger.error("Account number too lengthy");
			throw new AccountNumberTooLengthyException();
		} else if (!accountNumber.matches(Constants.ACCOUNTNUMBER_REGEX)) {
			logger.error("Account number not valid");
			throw new AccountNumberWithSpecialCharactersException();
		} else {
			isValid = true;
		}

		return isValid;
	}

}
