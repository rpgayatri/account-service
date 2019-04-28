package com.gayatri.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gayatri.accountservice.model.AccountTransaction;

@Repository
public interface TransactionRepository extends JpaRepository<AccountTransaction, Long> {
	
	@Query(value = "SELECT * FROM account_transaction m where m.account_number = ?1", 
			  nativeQuery = true)
	List<AccountTransaction> findTransactionByAccountNumber(String accountNumber);

}
