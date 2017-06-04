package com.dev.hospital.management.bean;

public enum Specialty {

	Undefined("Undefined"),
	Cardiology("Cardiology"),
	Gastroenterology("Gastroenterology"),
	Anesthesiology("Anesthesiology"),
	PlasticSurgery("PlasticSurgery"),
	Pediatrics("Pediatrics"),
	OBGYN("OBGYN");

	private String value;

	Specialty(String value) {
		this.value = value;
	}

	public static Specialty fromValue(String value) {
		Specialty result = Undefined;
		for (Specialty unit : Specialty.values()) {
			if (unit.value.equalsIgnoreCase(value)) {
				result = unit;
			}
		}
		return result;
	}

}
