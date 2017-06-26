/**
 * 
 */
package com.dev.hospital.management.web.ui.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dev.hospital.management.data.bean.InsuranceType;
import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
@SessionScoped
@ManagedBean(name = "patientBean", eager = true)
public class PatientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Patient newPatient = new Patient();

	private Set<Patient> patients = new HashSet<Patient>();

	public InsuranceType[] getInsuranceTypeValues() {
		return InsuranceType.values();
	}

	public Patient getNewPatient() {
		return newPatient;
	}

	public void setNewPatient(Patient newPatient) {
		this.newPatient = newPatient;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}

}
