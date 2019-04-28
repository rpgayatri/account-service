package com.gayatri.accountservice.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
import com.gayatri.accountservice.model.AccountTransaction;
import com.gayatri.accountservice.model.AccountTransaction.TransactionType;
import com.gayatri.accountservice.model.UserAccount;
import com.gayatri.accountservice.model.UserAccount.AccountType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TransactionRepository transactionRepository;

	/* persisting test data into account repository */
	@Before
	public void setUp() {
		/* given */
		AccountIdentity accountIdentiy1 = new AccountIdentity("user1", "123-123-123");
		AccountIdentity accountIdentiy2 = new AccountIdentity("user2", "123-123-124");
		AccountIdentity accountIdentiy3 = new AccountIdentity("user1", "123-123-125");

		UserAccount account1 = new UserAccount(accountIdentiy1, "user-1 account-1", LocalDate.now(), CurrencyUnit.AUD,
				BigDecimal.valueOf(100.21), AccountType.CURRENT);
		UserAccount account2 = new UserAccount(accountIdentiy2, "user-2 account-1", LocalDate.now(), CurrencyUnit.AUD,
				BigDecimal.valueOf(1232.21), AccountType.SAVINGS);
		UserAccount account3 = new UserAccount(accountIdentiy3, "user-1 account-2", LocalDate.now(), CurrencyUnit.AUD,
				BigDecimal.valueOf(123.21), AccountType.SAVINGS);

		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);

		AccountTransaction transaction1 = new AccountTransaction(account1, LocalDate.now(), CurrencyUnit.AUD,
				BigDecimal.ZERO, BigDecimal.valueOf(12313.12), TransactionType.CREDIT, "test narrative");
		AccountTransaction transaction2 = new AccountTransaction(account1, LocalDate.now(), CurrencyUnit.AUD,
				BigDecimal.valueOf(12313.12), BigDecimal.ZERO, TransactionType.DEBIT, "test narrative");
		AccountTransaction transaction3 = new AccountTransaction(account2, LocalDate.now(), CurrencyUnit.AUD,
				BigDecimal.ZERO, BigDecimal.valueOf(10000.00), TransactionType.CREDIT, "test narrative");

		entityManager.persist(transaction1);
		entityManager.persist(transaction2);
		entityManager.persist(transaction3);
	}

	/* test case for checking transation count for a given account number */
	@Test
	public void testFindTransactionsCountByAccountNumber() {
		/* when */
		List<AccountTransaction> foundTransactions = transactionRepository.findTransactionByAccountNumber("123-123-123");
		
		/* then */
		assertEquals(2, foundTransactions.size());
	}
	
	/* test case for checking if jpa query returns valid transaction object */
	@Test
	public void testFindTransactionByAccountNumberFetchesValidTransaction() {
		/* when */
		List<AccountTransaction> foundTransactions = transactionRepository.findTransactionByAccountNumber("123-123-124");
		
		/* then */
		assertEquals("user-2 account-1", foundTransactions.get(0).getAccount().getAccountName());
	}
	
	/* test case for invalid account number */
	@Test
	public void testFindTransactionForInvalidAccountNumber() {
		/* when */
		List<AccountTransaction> foundTransactions = transactionRepository.findTransactionByAccountNumber("123-123-12_acc");
		
		/* then */
		assertTrue(foundTransactions.isEmpty());
	}
	
	/* test case for empty account number */
	@Test
	public void testFindTransactionForEmptyAccountNumber() {
		/* when */
		List<AccountTransaction> foundTransactions = transactionRepository.findTransactionByAccountNumber("");
		
		/* then */
		assertTrue(foundTransactions.isEmpty());
	}
	
	/* test case for null account number */
	@Test
	public void testFindTransactionForNullAccountNumber() {
		/* when */
		List<AccountTransaction> foundTransactions = transactionRepository.findTransactionByAccountNumber(null);
		
		/* then */
		assertTrue(foundTransactions.isEmpty());
	}

	/* flushing all data */
	@After
	public void flush() {
		entityManager.flush();
	}

}
