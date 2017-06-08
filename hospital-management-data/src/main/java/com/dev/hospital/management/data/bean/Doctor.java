/**
 * 
 */
package com.dev.hospital.management.data.bean;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dayanlazare
 *
 */
public class Doctor extends Person {
	
	private Set<Specialty> specialties = new HashSet<Specialty>();
	
	private Set<Patient> Patients = new HashSet<Patient>();
	
	private String pagerNumber;

	public Doctor(
			String firstname, 
			String lastname, 
			String email, 
			Date dateOfBirth) {
		super(firstname, lastname, email, dateOfBirth);
	}

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

	public void addSpecialty(Specialty specialty) {
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

	@Override
	public String toString() {
		return "Doctor [specialties=" + specialties + ", Patients=" + Patients + ", pagerNumber=" + pagerNumber
				+ ", personId=" + personId + ", firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}
	
}
