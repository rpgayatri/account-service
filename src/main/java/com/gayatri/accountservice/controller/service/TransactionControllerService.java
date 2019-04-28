package com.gayatri.accountservice.controller.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gayatri.accountservice.exception.AccountNumberTooLengthyException;
import com.gayatri.accountservice.exception.AccountNumberWithSpecialCharactersException;
import com.gayatri.accountservice.exception.EmptyAccountNumberException;
import com.gayatri.accountservice.exception.NullAccountNumberException;
import com.gayatri.accountservice.exception.TransactionsNotFoundForAccountNumberException;
import com.gayatri.accountservice.model.AccountTransaction;

public interface TransactionControllerService {

	ResponseEntity<List<AccountTransaction>> getTransactionsForAccountNumber(String accountNumber)
			throws NullAccountNumberException, EmptyAccountNumberException, AccountNumberTooLengthyException,
			AccountNumberWithSpecialCharactersException, TransactionsNotFoundForAccountNumberException;

}
