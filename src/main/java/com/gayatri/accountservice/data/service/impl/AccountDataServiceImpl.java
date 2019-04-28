package com.gayatri.accountservice.data.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gayatri.accountservice.data.service.AccountDataService;
import com.gayatri.accountservice.exception.NoAccountFoundForUserIdException;
import com.gayatri.accountservice.model.UserAccount;
import com.gayatri.accountservice.repository.AccountRepository;

@Service
public class AccountDataServiceImpl implements AccountDataService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Set<UserAccount> getUserAccounts(String userId) throws NoAccountFoundForUserIdException {
		
		/* fetch from database */
		Set<UserAccount> accounts = accountRepository.findByAccountIdentityUserId(userId);
		
		if(accounts.isEmpty()) {
			throw new NoAccountFoundForUserIdException();
		}
		
		return accounts;
	}
	
	
}
