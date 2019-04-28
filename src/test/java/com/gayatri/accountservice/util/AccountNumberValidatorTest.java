package com.gayatri.accountservice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gayatri.accountservice.exception.AccountNumberTooLengthyException;
import com.gayatri.accountservice.exception.AccountNumberWithSpecialCharactersException;
import com.gayatri.accountservice.exception.EmptyAccountNumberException;
import com.gayatri.accountservice.exception.NullAccountNumberException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountNumberValidatorTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/* test case for valid Account Number */
	@Test
	public void testValidAccountNumber() throws NullAccountNumberException, EmptyAccountNumberException,
			AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		assertEquals(true, AccountNumberValidator.isValid("123-123-123-123"));
	}

	/* test case for Account Number with null value */
	@Test
	public void testNullAccountNumber() throws NullAccountNumberException, EmptyAccountNumberException,
			AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		exception.expect(NullAccountNumberException.class);
		AccountNumberValidator.isValid(null);
	}

	/* test case for Account Number with empty string value */
	@Test
	public void testEmptyAccountNumber() throws NullAccountNumberException, EmptyAccountNumberException,
			AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		exception.expect(EmptyAccountNumberException.class);
		AccountNumberValidator.isValid("");
	}

	/* test case for Account Number which is too lengthy */
	@Test
	public void testLengthyAccountNumber() throws NullAccountNumberException, EmptyAccountNumberException,
			AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		exception.expect(AccountNumberTooLengthyException.class);
		AccountNumberValidator.isValid("123-123-435-1231");
	}

	/* test case for Account Number which has length of 15 */
	@Test
	public void testAccountNumberWithValidLength() throws NullAccountNumberException, EmptyAccountNumberException,
			AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		assertEquals(true, AccountNumberValidator.isValid("123-123-1234-12"));
	}

	/* test case for Account Number value with special characters */
	@Test
	public void testAccountNumberWithSpecialCharacters() throws NullAccountNumberException, EmptyAccountNumberException,
			AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		exception.expect(AccountNumberWithSpecialCharactersException.class);
		AccountNumberValidator.isValid("123@das#");
	}

	/*
	 * test case for Account Number with valid special character hiphen and
	 * underscore
	 */
	@Test
	public void testAccountNumberWithValidSpecialCharacters() throws NullAccountNumberException,
			EmptyAccountNumberException, AccountNumberTooLengthyException, AccountNumberWithSpecialCharactersException {
		assertEquals(true, AccountNumberValidator.isValid("acc_123-432"));
	}

}
