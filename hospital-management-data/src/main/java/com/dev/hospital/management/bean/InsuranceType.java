package com.dev.hospital.management.bean;

/**
 * @author dlazare
 *
 */
public enum InsuranceType {

	None("None"),

	Aetna("Aetna"),

	Axa("Axa"),

	Allstate("Allstate"),

	AmericanFamilyInsurance("AmericanFamilyInsurance"),

	BankersLifeInsurance("BankersLifeInsurance"),

	Conseco("Conseco");

	private String value;

	InsuranceType(String value) {
		this.value = value;
	}

	public static InsuranceType fromValue(String value) {
		InsuranceType result = None;
		for (InsuranceType unit : InsuranceType.values()) {
			if (unit.value.equalsIgnoreCase(value)) {
				result = unit;
			}
		}
		return result;
	}
}
