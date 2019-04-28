package com.gayatri.accountservice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIdValidatorTest {
	
	/* test case for valid user ID */
	@Test
	public void testUserIdValidity() {
		assertEquals(true, UserIdValidator.isValid("user1"));
	}
	
	/* test case for user ID with null value */
	@Test
	public void testNullUserId() {
		assertEquals(false, UserIdValidator.isValid(null));
	}
	
	/* test case for user ID with empty string value */
	@Test
	public void testEmptyUserId() {
		assertEquals(false, UserIdValidator.isValid(""));
	}
	
	/* test case for user ID which is too lengthy */
	@Test
	public void testLengthyUserId() {
		assertEquals(false, UserIdValidator.isValid("user1user1user1user1user1user1user1"));
	}
	
	/* test case for user ID which has length of 15 */
	@Test
	public void testUserIdWithValidLength() {
		assertEquals(true, UserIdValidator.isValid("user1user1user1"));
	}
	
	/* test case for user ID value with special characters */
	@Test
	public void testUserIdWithSpecialCharacters() {
		assertEquals(true, UserIdValidator.isValid("userId#as'"));
	}

}
