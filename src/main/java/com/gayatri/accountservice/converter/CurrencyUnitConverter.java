package com.gayatri.accountservice.converter;

import javax.persistence.AttributeConverter;

import org.joda.money.CurrencyUnit;

public class CurrencyUnitConverter implements AttributeConverter<CurrencyUnit, String> {

	@Override
	public String convertToDatabaseColumn(CurrencyUnit attribute) {
		if(attribute == null) {
			return null;
		}
		return attribute.toString().toUpperCase();
	}

	@Override
	public CurrencyUnit convertToEntityAttribute(String dbData) {
		if(dbData == null) {
			return null;
		}
		return CurrencyUnit.of(dbData.toUpperCase());
	}
	

}
