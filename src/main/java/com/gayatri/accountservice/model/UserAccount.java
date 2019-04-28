package com.gayatri.accountservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.joda.money.CurrencyUnit;

import com.gayatri.accountservice.converter.AccountTypeConverter;
import com.gayatri.accountservice.converter.CurrencyUnitConverter;

@Table(name = "user_account")
@Entity
@Proxy(lazy=false)
public class UserAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum AccountType {
		SAVINGS,
		CURRENT
	}
	
	@EmbeddedId
	private AccountIdentity accountIdentity;
	
	@Column(name = "Account_Name")
	private String accountName;
	
	@Column(name = "Balance_Date")
	private LocalDate balanceDate;
	
	@Column(name = "Currency")
	@Convert(converter = CurrencyUnitConverter.class)
	private CurrencyUnit currency;
	
	@Column(name = "Opening_Balance")
	private BigDecimal openingAvailableBalance;
	
	@Column(name = "Account_Type")
	@Convert(converter = AccountTypeConverter.class)
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
