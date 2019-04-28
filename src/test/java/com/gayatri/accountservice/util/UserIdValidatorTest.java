package com.gayatri.accountservice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gayatri.accountservice.exception.EmptyUserIdException;
import com.gayatri.accountservice.exception.NullUserIdException;
import com.gayatri.accountservice.exception.UserIdTooLengthyException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserIdValidatorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	/* test case for valid user ID */
	@Test
	public void testUserIdValidity() throws NullUserIdException, EmptyUserIdException, UserIdTooLengthyException {
		assertEquals(true, UserIdValidator.isValid("user1"));
	}

	/* test case for user ID with null value */
	@Test
	public void testNullUserId() throws NullUserIdException, EmptyUserIdException, UserIdTooLengthyException {
		exception.expect(NullUserIdException.class);
		UserIdValidator.isValid(null);
	}

	/* test case for user ID with empty string value */
	@Test
	public void testEmptyUserId() throws NullUserIdException, EmptyUserIdException, UserIdTooLengthyException {
		exception.expect(EmptyUserIdException.class);
		UserIdValidator.isValid("");
	}

	/* test case for user ID which is too lengthy */
	@Test
	public void testLengthyUserId() throws NullUserIdException, EmptyUserIdException, UserIdTooLengthyException {
		exception.expect(UserIdTooLengthyException.class);
		UserIdValidator.isValid("user1user1user1user1user1user1user1");
	}

	/* test case for user ID which has length of 15 */
	@Test
	public void testUserIdWithValidLength()
			throws NullUserIdException, EmptyUserIdException, UserIdTooLengthyException {
		assertEquals(true, UserIdValidator.isValid("user1user1user1"));
	}

	/* test case for user ID value with special characters */
	@Test
	public void testUserIdWithSpecialCharacters()
			throws NullUserIdException, EmptyUserIdException, UserIdTooLengthyException {
		assertEquals(true, UserIdValidator.isValid("userId#as'"));
	}

}
