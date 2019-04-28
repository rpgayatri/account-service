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
public class TransactionControllerTests {

	@Autowired
	private MockMvc mvc;

	/* Integration Tests */

	/* test-case for a valid Account Number input to the GetTransactions API */
	@Test
	public void getTransactionsForValidAccountNumberTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/transactions").param("accountNumber", "123-123-123"))
				.andExpect(status().isOk());
	}

	/* test-case for a empty Account Number input to the GetTransactions API */
	@Test
	public void getTransactionsForEmptyAccountNumberTest() throws Exception {

		String jsonOutput = "{\"errorMsg\":\"Account number cannot be empty. Please provide a valid Account Number\",\"errorCode\":400}";

		mvc.perform(MockMvcRequestBuilders.get("/transactions").param("accountNumber", ""))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(content().json(jsonOutput));
	}
	
	/* test-case for a lengthy Account Number input to the GetTransactions API */
	@Test
	public void getTransactionsForLengthyAccountNumberTest() throws Exception {

		String jsonOutput = "{\"errorMsg\":\"Account number provided is too lengthy. Maximum length is 15\",\"errorCode\":400}";

		mvc.perform(MockMvcRequestBuilders.get("/transactions").param("accountNumber", "233-133-234-342-344-2342-2342"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(content().json(jsonOutput));
	}
	
	/* test-case for a Account Number input with special characters to the GetTransactions API */
	@Test
	public void getTransactionsForAccountNumberWithSpecialCharacterTest() throws Exception {

		String jsonOutput = "{\"errorMsg\":\"Account number is not valid. Please provide a valid Account number\",\"errorCode\":400}";

		mvc.perform(MockMvcRequestBuilders.get("/transactions").param("accountNumber", "233-133-234@-23"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andExpect(content().json(jsonOutput));
	}
	
	/* test-case for a Account Number input with allowed special characters to the GetTransactions API */
	@Test
	public void getTransactionsForAccountNumberWithAllowedSpecialCharacterTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/transactions").param("accountNumber", "acc_123-432"))
				.andExpect(status().isOk());
	}

}
