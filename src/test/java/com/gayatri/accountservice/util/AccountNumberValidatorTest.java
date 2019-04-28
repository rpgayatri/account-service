package com.gayatri.accountservice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountNumberValidatorTest {
	
	/* test case for valid Account Number */
	@Test
	public void testValidAccountNumber() {
		assertEquals(true, AccountNumberValidator.isValid("123-123-123-123"));
	}
	
	/* test case for Account Number with null value */
	@Test
	public void testNullAccountNumber() {
		assertEquals(false, AccountNumberValidator.isValid(null));
	}
	
	/* test case for Account Number with empty string value */
	@Test
	public void testEmptyAccountNumber() {
		assertEquals(false, AccountNumberValidator.isValid(""));
	}
	
	/* test case for Account Number which is too lengthy */
	@Test
	public void testLengthyAccountNumber() {
		assertEquals(false, AccountNumberValidator.isValid("123-123-435-1231"));
	}
	
	/* test case for Account Number which has length of 15 */
	@Test
	public void testAccountNumberWithValidLength() {
		assertEquals(true, AccountNumberValidator.isValid("123-123-1234-12"));
	}
	
	/* test case for Account Number value with special characters */
	@Test
	public void testAccountNumberWithSpecialCharacters() {
		assertEquals(false, AccountNumberValidator.isValid("123@das#"));
	}
	
	/* test case for Account Number with valid special character hiphen and underscore */
	@Test
	public void testAccountNumberWithValidSpecialCharacters() {
		assertEquals(true, AccountNumberValidator.isValid("acc_123-432"));
	}

}
