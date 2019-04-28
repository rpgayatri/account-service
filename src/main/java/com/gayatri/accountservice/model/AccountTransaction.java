package com.gayatri.accountservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.money.CurrencyUnit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gayatri.accountservice.converter.CurrencyUnitConverter;
import com.gayatri.accountservice.converter.TransactionTypeConverter;

@Entity
@Table(name = "account_transaction")
public class AccountTransaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum TransactionType {
		CREDIT,
		DEBIT
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Account_Number", insertable = true, updatable = false)
	@JoinColumn(name = "User_ID", insertable = true, updatable = false)
	@JsonIgnore
	private UserAccount account;
	
	@Column(name = "Value_Date")
	private LocalDate valueDate;
	
	@Convert(converter = CurrencyUnitConverter.class)
	private CurrencyUnit currency;
	
	@Column(name = "Debit_Amount")
	private BigDecimal debitAmount;
	
	@Column(name = "Credit_Amount")
	private BigDecimal creditAmount;
	
	@Convert(converter = TransactionTypeConverter.class)
	@Column(name = "Debit_Credit")
	private TransactionType transactionType;
	
	@Column(name = "Transaction_Narrative")
	private String transactionNarrative;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserAccount getAccount() {
		return account;
	}

	public void setAccount(UserAccount account) {
		this.account = account;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public CurrencyUnit getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyUnit currency) {
		this.currency = currency;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public AccountTransaction() {
		super();
	}

	public AccountTransaction(UserAccount account, LocalDate valueDate, CurrencyUnit currency, BigDecimal debitAmount,
			BigDecimal creditAmount, TransactionType transactionType, String transactionNarrative) {
		super();
		this.account = account;
		this.valueDate = valueDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transactionType = transactionType;
		this.transactionNarrative = transactionNarrative;
	}

	@Override
	public String toString() {
		return "AccountTransaction [id=" + id + ", account=" + account + ", valueDate=" + valueDate + ", currency="
				+ currency + ", debitAmount=" + debitAmount + ", creditAmount=" + creditAmount + ", transactionType="
				+ transactionType + ", transactionNarrative=" + transactionNarrative + "]";
	}

}
