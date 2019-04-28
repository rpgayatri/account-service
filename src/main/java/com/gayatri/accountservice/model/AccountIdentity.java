package com.gayatri.accountservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gayatri.accountservice.constants.Constants;

public class AccountIdentity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name="User_ID")
	@Length(max=Constants.USERID_SIZE)
	private String userId;
	
	@NotNull
	@Column(name="Account_Number")
	@Length(max=Constants.ACCOUNTNUMBER_SIZE)
	private String accountNumber;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountIdentity() {
		super();
	}

	public AccountIdentity(@NotNull @Length(max = 15) String userId, @NotNull @Length(max = 15) String accountNumber) {
		super();
		this.userId = userId;
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "AccountIdentity [userId=" + userId + ", accountNumber=" + accountNumber + "]";
	}
	
}
