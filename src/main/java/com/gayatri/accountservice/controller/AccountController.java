package com.gayatri.accountservice.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gayatri.accountservice.controller.service.AccountControllerService;
import com.gayatri.accountservice.exception.EmptyUserIdException;
import com.gayatri.accountservice.exception.NoAccountFoundForUserIdException;
import com.gayatri.accountservice.exception.NullUserIdException;
import com.gayatri.accountservice.exception.UserIdTooLengthyException;
import com.gayatri.accountservice.model.UserAccount;

@RestController
public class AccountController extends AbstractController {
		
	@Autowired
	private AccountControllerService service;
	
	/* API for getting accounts for the provided user ID */
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Set<UserAccount>> getAccountsForUserId(@RequestParam(value = "userId") String userId)
			throws EmptyUserIdException, NoAccountFoundForUserIdException, NullUserIdException, UserIdTooLengthyException {
		return service.getAccountsForUserId(userId);
	}

}
