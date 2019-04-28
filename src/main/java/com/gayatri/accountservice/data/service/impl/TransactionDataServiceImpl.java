package com.gayatri.accountservice.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gayatri.accountservice.data.service.TransactionDataService;
import com.gayatri.accountservice.exception.TransactionsNotFoundForAccountNumberException;
import com.gayatri.accountservice.model.AccountTransaction;
import com.gayatri.accountservice.repository.TransactionRepository;

@Service
public class TransactionDataServiceImpl implements TransactionDataService{
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<AccountTransaction> getTransactionsForAccountNumber(String accountNumber) throws TransactionsNotFoundForAccountNumberException {
		
		/* fetch from database */
		List<AccountTransaction> transactions = transactionRepository.findTransactionByAccountNumber(accountNumber);
		
		if(transactions.isEmpty()) {
			throw new TransactionsNotFoundForAccountNumberException();
		}
		return transactions;
	}

}
