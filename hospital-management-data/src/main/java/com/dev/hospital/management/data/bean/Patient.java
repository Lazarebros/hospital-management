/**
 * 
 */
package com.dev.hospital.management.data.bean;

import java.util.Date;

/**
 * @author dayanlazare
 *
 */
public class Patient extends Person {

	private InsuranceType insuranceType;

	public Patient() {
		super();
	}

	public Patient(
			String firstname, 
			String lastname, 
			String email, 
			Date dateOfBirth, 
			InsuranceType insuranceType) {

		super(firstname, lastname, email, dateOfBirth);
		this.insuranceType = insuranceType;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	@Override
	public String toString() {
		return "Patient [insuranceType=" + insuranceType + ", id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", mobileNumber="
				+ mobileNumber + "]";
	}

}
