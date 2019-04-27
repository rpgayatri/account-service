package com.gayatri.accountservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.joda.money.CurrencyUnit;


public class UserAccount {
	
	public enum AccountType {
		SAVINGS,
		CURRENT
	}
	
	private AccountIdentity accountIdentity;
	
	private String accountName;
	
	private LocalDate balanceDate;
	
	private CurrencyUnit currency;
	
	private BigDecimal openingAvailableBalance;
	
	private AccountType accountType;

	public AccountIdentity getAccountIdentity() {
		return accountIdentity;
	}

	public void setAccountIdentity(AccountIdentity accountIdentity) {
		this.accountIdentity = accountIdentity;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public CurrencyUnit getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyUnit currency) {
		this.currency = currency;
	}

	public BigDecimal getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public UserAccount() {
		super();
	}

	public UserAccount(AccountIdentity accountIdentity, String accountName, LocalDate balanceDate,
			CurrencyUnit currency, BigDecimal openingAvailableBalance, AccountType accountType) {
		super();
		this.accountIdentity = accountIdentity;
		this.accountName = accountName;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.openingAvailableBalance = openingAvailableBalance;
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "UserAccount [accountIdentity=" + accountIdentity + ", accountName=" + accountName + ", balanceDate="
				+ balanceDate + ", currency=" + currency + ", openingAvailableBalance=" + openingAvailableBalance
				+ ", accountType=" + accountType + "]";
	}
	
}
