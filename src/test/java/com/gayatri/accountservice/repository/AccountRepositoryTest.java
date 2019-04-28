package com.gayatri.accountservice.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.joda.money.CurrencyUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.gayatri.accountservice.model.AccountIdentity;
import com.gayatri.accountservice.model.UserAccount;
import com.gayatri.accountservice.model.UserAccount.AccountType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AccountRepository accountRepository;
	
	/* persisting test data into account repository */
	@Before
	public void setUp() {
		/* given */
		AccountIdentity accountIdentiy1 = new AccountIdentity("user1", "123-123-123");
		AccountIdentity accountIdentiy2 = new AccountIdentity("user2", "123-123-124");
		AccountIdentity accountIdentiy3 = new AccountIdentity("user1", "123-123-125");
		
		UserAccount account1 = new UserAccount(accountIdentiy1, "user-1 account-1", LocalDate.now(), CurrencyUnit.AUD, BigDecimal.valueOf(100.21), AccountType.CURRENT);
		UserAccount account2 = new UserAccount(accountIdentiy2, "user-2 account-1", LocalDate.now(), CurrencyUnit.AUD, BigDecimal.valueOf(1232.21), AccountType.SAVINGS);
		UserAccount account3 = new UserAccount(accountIdentiy3, "user-1 account-2", LocalDate.now(), CurrencyUnit.AUD, BigDecimal.valueOf(123.21), AccountType.SAVINGS);
		
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);
	}
	
	/* test case for search for valid account details */
	@Test
	public void testFindByValidAccountIdentity() {
		/* when */
		AccountIdentity testAccountIdentity = new AccountIdentity("user1", "123-123-123");
		Optional<UserAccount> found = accountRepository.findById(testAccountIdentity);
		
		/* then*/
		assertEquals(found.get().getAccountIdentity().getAccountNumber(), testAccountIdentity.getAccountNumber());
	}
	
	/* test case for search for valid user ID and invalid account number */
	@Test
	public void testFindByInvalidAccountNumber() {
		/* when */
		AccountIdentity testAccountIdentity = new AccountIdentity("user1", "10-10-10");
		Optional<UserAccount> found = accountRepository.findById(testAccountIdentity);
		
		/* then*/
		assertFalse(found.isPresent());
	}
	
	/* test case for search for invalid user ID and valid account number */
	@Test
	public void testFindByInvalidUserId() {
		/* when */
		AccountIdentity testAccountIdentity = new AccountIdentity("test", "123-123-123");
		Optional<UserAccount> found = accountRepository.findById(testAccountIdentity);
		
		/* then*/
		assertFalse(found.isPresent());
	}
	
	/* test case for search for invalid account and userId details */
	@Test
	public void testFindByInvalidAccountIdentity() {
		/* when */
		AccountIdentity testAccountIdentity = new AccountIdentity("test", "10-10-10");
		Optional<UserAccount> found = accountRepository.findById(testAccountIdentity);
		
		/* then*/
		assertFalse(found.isPresent());
	}
	
	/* test case for search for valid account number and null user ID details */
	@Test
	public void testFindByNullUserId() {
		/* when */
		AccountIdentity testAccountIdentity = new AccountIdentity(null, "10-10-10");
		Optional<UserAccount> found = accountRepository.findById(testAccountIdentity);
		
		/* then*/
		assertFalse(found.isPresent());
	}
	
	/* test case for searching all accounts for a given user ID */
	@Test
	public void testfindAccountsForUserId() {
		/* when */
		Set<UserAccount> found = accountRepository.findByAccountIdentityUserId("user1");
		
		/* then */
		assertEquals(2, found.size());
	}
	
	/* test case for searching all accounts for a user ID which is not found */
	@Test
	public void testfindAccountsForInvalidUserId() {
		/* when */
		Set<UserAccount> found = accountRepository.findByAccountIdentityUserId("test");
		
		/* then */
		assertEquals(0, found.size());
	}
	
	/* test case for searching all accounts for a empty user ID */
	@Test
	public void testfindAccountsForEmptyUserId() {
		/* when */
		Set<UserAccount> found = accountRepository.findByAccountIdentityUserId("");
		
		/* then */
		assertEquals(0, found.size());
	}
	
	/* test case for searching all accounts for a null user ID */
	@Test
	public void testfindAccountsForNullUserId() {
		/* when */
		Set<UserAccount> found = accountRepository.findByAccountIdentityUserId(null);
		
		/* then */
		assertEquals(0, found.size());
	}
	
	/* flushing all data */
	@After
	public void flush() {
		entityManager.flush();
	}

}
