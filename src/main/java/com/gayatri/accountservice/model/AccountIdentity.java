package com.gayatri.accountservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gayatri.accountservice.constants.Constants;

@Embeddable
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountIdentity other = (AccountIdentity) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
