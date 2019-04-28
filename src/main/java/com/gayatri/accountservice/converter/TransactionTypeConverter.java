package com.gayatri.accountservice.converter;

import javax.persistence.AttributeConverter;

import com.gayatri.accountservice.model.AccountTransaction.TransactionType;

public class TransactionTypeConverter implements AttributeConverter<TransactionType, String>{

	@Override
	public String convertToDatabaseColumn(TransactionType attribute) {
		if(attribute == null) {
			return null;
		}
		return attribute.toString().toUpperCase();
	}

	@Override
	public TransactionType convertToEntityAttribute(String dbData) {
		if(dbData == null) {
			return null;
		}
		return TransactionType.valueOf(dbData.toUpperCase());
	}

}
