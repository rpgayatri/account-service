package com.gayatri.accountservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gayatri.accountservice.model.AccountIdentity;
import com.gayatri.accountservice.model.UserAccount;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, AccountIdentity>{
	
	Set<UserAccount> findByAccountIdentityUserId(String userId);
}
