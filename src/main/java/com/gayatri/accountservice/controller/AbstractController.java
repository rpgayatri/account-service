package com.gayatri.accountservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gayatri.accountservice.constants.Constants;
import com.gayatri.accountservice.exception.AccountNumberTooLengthyException;
import com.gayatri.accountservice.exception.AccountNumberWithSpecialCharactersException;
import com.gayatri.accountservice.exception.EmptyAccountNumberException;
import com.gayatri.accountservice.exception.EmptyUserIdException;
import com.gayatri.accountservice.exception.NoAccountFoundForUserIdException;
import com.gayatri.accountservice.exception.NullAccountNumberException;
import com.gayatri.accountservice.exception.NullUserIdException;
import com.gayatri.accountservice.exception.TransactionsNotFoundForAccountNumberException;
import com.gayatri.accountservice.exception.UserIdTooLengthyException;
import com.gayatri.accountservice.model.ErrorResource;


@ControllerAdvice
public class AbstractController {
	
	/* handler for empty User ID Exception */
	@ResponseBody
	@ExceptionHandler(EmptyUserIdException.class)
	public ResponseEntity<ErrorResource> emptyUserIdException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), Constants.USER_ID_EMPTY);

		return new ResponseEntity<>(error,
				HttpStatus.BAD_REQUEST);
	}
	
	/* handler for null User ID Exception */
	@ResponseBody
	@ExceptionHandler(NullUserIdException.class)
	public ResponseEntity<ErrorResource> nullUserIdException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), Constants.USER_ID_NULL);
	
		return new ResponseEntity<>(error,
				HttpStatus.BAD_REQUEST);
	}
	
	/* handler for lengthy User ID Exception */
	@ResponseBody
	@ExceptionHandler(UserIdTooLengthyException.class)
	public ResponseEntity<ErrorResource> userIdTooLengthyException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), Constants.USER_ID_TOO_LENGTHY);

		return new ResponseEntity<>(error,
				HttpStatus.BAD_REQUEST);
	}
	
	/* handler for no accounts found for userId Exception */
	@ResponseBody
	@ExceptionHandler(NoAccountFoundForUserIdException.class)
	public ResponseEntity<ErrorResource> noAccountFoundForUserIdException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.OK.value(), Constants.NO_ACCOUNTS_FOUND_FOR_USERID);

		return new ResponseEntity<>(error,
				HttpStatus.OK);
	}
	
	/* handler for empty account number Exception */
	@ResponseBody
	@ExceptionHandler(EmptyAccountNumberException.class)
	public ResponseEntity<ErrorResource> emptyAccountNumberException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), Constants.ACCOUNT_NUMBER_EMPTY);

		return new ResponseEntity<>(error,
				HttpStatus.BAD_REQUEST);
	}
	
	/* handler for null account number Exception */
	@ResponseBody
	@ExceptionHandler(NullAccountNumberException.class)
	public ResponseEntity<ErrorResource> nullAccountNumberException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), Constants.ACCOUNT_NUMBER_NULL);

		return new ResponseEntity<>(error,
				HttpStatus.BAD_REQUEST);
	}
	
	/* handler for lengthy account number Exception */
	@ResponseBody
	@ExceptionHandler(AccountNumberTooLengthyException.class)
	public ResponseEntity<ErrorResource> accountNumberTooLengthyException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), Constants.ACCOUNT_NUMBER_TOO_LENGTHY);

		return new ResponseEntity<>(error,
				HttpStatus.BAD_REQUEST);
	}
	
	/* handler for account number with special characters Exception */
	@ResponseBody
	@ExceptionHandler(AccountNumberWithSpecialCharactersException.class)
	public ResponseEntity<ErrorResource> accountNumberContainsSpecialCharacterException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.BAD_REQUEST.value(), Constants.ACCOUNT_NUMBER_HAS_SPECIAL_CHARACTERS);

		return new ResponseEntity<>(error,
				HttpStatus.BAD_REQUEST);
	}
	
	/* handler for account number with no transactions Exception */
	@ResponseBody
	@ExceptionHandler(TransactionsNotFoundForAccountNumberException.class)
	public ResponseEntity<ErrorResource> transactionsNotFoundForAccountNumberException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource(HttpStatus.OK.value(), Constants.NO_TRANSACTIONS_FOUND_FOR_ACCOUNT_NUMBER);

		return new ResponseEntity<>(error,
				HttpStatus.OK);
	}
}
