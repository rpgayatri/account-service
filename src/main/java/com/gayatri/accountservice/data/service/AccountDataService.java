package com.gayatri.accountservice.data.service;

import java.util.Set;

import com.gayatri.accountservice.exception.NoAccountFoundForUserIdException;
import com.gayatri.accountservice.model.UserAccount;

public interface AccountDataService {
	
	public Set<UserAccount> getUserAccounts(String userId) throws NoAccountFoundForUserIdException;
}
