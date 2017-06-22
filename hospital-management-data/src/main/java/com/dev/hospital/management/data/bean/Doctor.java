/**
 * 
 */
package com.dev.hospital.management.data.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dayanlazare
 *
 */
public class Doctor extends Person {
	
	private Set<String> specialties = new HashSet<String>();
	
	private Set<Patient> Patients = new HashSet<Patient>();
	
	private String pagerNumber;

	public Doctor(String firstname, String lastname, Date dateOfBirth) {
		super(firstname, lastname, dateOfBirth);
	}

	public Set<String> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<String> specialties) {
		this.specialties = specialties;
	}

	public void addSpecialty(String specialty) {
		this.specialties.add(specialty);
	}
	
	public Set<Patient> getPatients() {
		return Patients;
	}

	public void setPatients(Set<Patient> patients) {
		Patients = patients;
	}

	public void addPatient(Patient patient) {
		this.Patients.add(patient);
	}

	public String getPagerNumber() {
		return pagerNumber;
	}

	public void setPagerNumber(String pagerNumber) {
		this.pagerNumber = pagerNumber;
	}
	
}
