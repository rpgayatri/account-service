package com.gayatri.accountservice.controller.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gayatri.accountservice.controller.service.AccountControllerService;
import com.gayatri.accountservice.data.service.AccountDataService;
import com.gayatri.accountservice.exception.EmptyUserIdException;
import com.gayatri.accountservice.exception.NoAccountFoundForUserIdException;
import com.gayatri.accountservice.exception.NullUserIdException;
import com.gayatri.accountservice.exception.UserIdTooLengthyException;
import com.gayatri.accountservice.model.UserAccount;
import com.gayatri.accountservice.util.UserIdValidator;

@Service
public class AccountControllerServiceImpl implements AccountControllerService {
	
	@Autowired
	private AccountDataService dataService;
	
	@Override
	public ResponseEntity<Set<UserAccount>> getAccountsForUserId(String userId) throws EmptyUserIdException,
			NoAccountFoundForUserIdException, NullUserIdException, UserIdTooLengthyException {

		/* check if user ID input is valid */
		UserIdValidator.isValid(userId);
		
		/* fetch from database if userId is valid */
		Set<UserAccount> accounts = dataService.getUserAccounts(userId);
				
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}
	
}
