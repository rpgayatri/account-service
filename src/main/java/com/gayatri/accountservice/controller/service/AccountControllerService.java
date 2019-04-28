package com.gayatri.accountservice.controller.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.gayatri.accountservice.exception.EmptyUserIdException;
import com.gayatri.accountservice.exception.NoAccountFoundForUserIdException;
import com.gayatri.accountservice.exception.NullUserIdException;
import com.gayatri.accountservice.exception.UserIdTooLengthyException;
import com.gayatri.accountservice.model.UserAccount;

public interface AccountControllerService {
	
	public ResponseEntity<Set<UserAccount>> getAccountsForUserId(String userId)
			throws EmptyUserIdException, NoAccountFoundForUserIdException, NullUserIdException, UserIdTooLengthyException;
}
