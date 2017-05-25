/**
 * 
 */
package com.dev.hospital.management.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author dayanlazare
 *
 */
@Entity
@Table(name = "Patient")
public class Patient extends Person {
	
	private InsuranceType insuranceType;
	
	public Patient(
			String firstname, 
			String lastname, 
			Date dateOfBirth, 
			InsuranceType insuranceType) {
		
		super(firstname, lastname, dateOfBirth);
		this.insuranceType = insuranceType;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}
	
}
