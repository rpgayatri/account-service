package com.gayatri.accountservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gayatri.accountservice.controller.service.TransactionControllerService;
import com.gayatri.accountservice.exception.AccountNumberTooLengthyException;
import com.gayatri.accountservice.exception.AccountNumberWithSpecialCharactersException;
import com.gayatri.accountservice.exception.EmptyAccountNumberException;
import com.gayatri.accountservice.exception.NullAccountNumberException;
import com.gayatri.accountservice.exception.TransactionsNotFoundForAccountNumberException;
import com.gayatri.accountservice.model.AccountTransaction;

@RestController
public class TransactionController extends AbstractController {

	@Autowired
	private TransactionControllerService service;

	/* API to get account-transactions for provided account number */
	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<AccountTransaction>> getTransactionsForAccountNumber(
			@RequestParam(value = "accountNumber") String accountNumber)
			throws NullAccountNumberException, EmptyAccountNumberException, AccountNumberTooLengthyException,
			AccountNumberWithSpecialCharactersException, TransactionsNotFoundForAccountNumberException {

		return service.getTransactionsForAccountNumber(accountNumber);
	}

}
