package com.gayatri.accountservice.data.service;

import java.util.List;

import com.gayatri.accountservice.exception.TransactionsNotFoundForAccountNumberException;
import com.gayatri.accountservice.model.AccountTransaction;

public interface TransactionDataService {

	public List<AccountTransaction> getTransactionsForAccountNumber(String accountNumber)
			throws TransactionsNotFoundForAccountNumberException;
}
