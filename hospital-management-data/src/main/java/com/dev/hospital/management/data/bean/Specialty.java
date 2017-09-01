package com.dev.hospital.management.data.bean;

public enum Specialty {

	General("General"),
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static Specialty fromValue(String value) {
		Specialty result = General;
		for (Specialty unit : Specialty.values()) {
			if (unit.value.equalsIgnoreCase(value)) {
				result = unit;
				break;
			}
		}
		return result;
	}

}
