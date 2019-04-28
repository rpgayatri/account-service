package com.gayatri.accountservice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTests {

	@Autowired
	private MockMvc mvc;

	/* Integration Tests */

	/* test-case for a valid user ID input to the GetAccounts API */
	@Test
	public void getAccountsForValidUserIdInputTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/accounts").param("userId", "user5")).andExpect(status().isOk());
	}

	/* test-case for an empty user ID input to the GetAccounts API */
	@Test
	public void getAccountsForEmptyUserIdInputTest() throws Exception {
		
		String jsonOutput = "{\"errorMsg\":\"User ID cannot be empty. Please provide a valid user ID\",\"errorCode\":400}";
		
		mvc.perform(MockMvcRequestBuilders.get("/accounts").param("userId", ""))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(content().json(jsonOutput));
	}
	
	/* test-case for an lengthy user ID input to the GetAccounts API */
	@Test
	public void getAccountsForNullUserIdInputTest() throws Exception {
		String jsonOutput = "{\"errorMsg\":\"User ID provided is too lengthy. Maximum length is 15\",\"errorCode\":400}";
		
		mvc.perform(MockMvcRequestBuilders.get("/accounts").param("userId", "user1user1user1user1user1user1user1"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(content().json(jsonOutput));
	}

}
