package com.gayatri.accountservice.controller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gayatri.accountservice.controller.service.TransactionControllerService;
import com.gayatri.accountservice.data.service.TransactionDataService;
import com.gayatri.accountservice.exception.AccountNumberTooLengthyException;
import com.gayatri.accountservice.exception.AccountNumberWithSpecialCharactersException;
import com.gayatri.accountservice.exception.EmptyAccountNumberException;
import com.gayatri.accountservice.exception.NullAccountNumberException;
import com.gayatri.accountservice.exception.TransactionsNotFoundForAccountNumberException;
import com.gayatri.accountservice.model.AccountTransaction;
import com.gayatri.accountservice.util.AccountNumberValidator;

@Service
public class TransactionControllerServiceImpl implements TransactionControllerService {

	@Autowired
	private TransactionDataService dataService;

	@Override
	public ResponseEntity<List<AccountTransaction>> getTransactionsForAccountNumber(String accountNumber)
			throws NullAccountNumberException, EmptyAccountNumberException, AccountNumberTooLengthyException,
			AccountNumberWithSpecialCharactersException, TransactionsNotFoundForAccountNumberException {

		/* check if account number input is valid */
		AccountNumberValidator.isValid(accountNumber);

		/* fetch from database if account number is valid */
		List<AccountTransaction> transactions = dataService.getTransactionsForAccountNumber(accountNumber);

		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

}
