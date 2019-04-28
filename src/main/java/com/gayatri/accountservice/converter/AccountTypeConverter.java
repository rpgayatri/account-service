package com.gayatri.accountservice.converter;

import javax.persistence.AttributeConverter;

import com.gayatri.accountservice.model.UserAccount.AccountType;

public class AccountTypeConverter implements AttributeConverter<AccountType, String>{

	/* Hibernate type converter for custom type - AccountType */
	
	@Override
	public String convertToDatabaseColumn(AccountType attribute) {
		if(attribute == null) {
			return null;
		}
		return attribute.toString().toUpperCase()
				;
	}

	@Override
	public AccountType convertToEntityAttribute(String dbData) {
		if(dbData == null) {
			return null;
		}
		return AccountType.valueOf(dbData.toUpperCase());
	}

}
