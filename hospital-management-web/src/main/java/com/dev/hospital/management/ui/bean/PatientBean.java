/**
 * 
 */
package com.dev.hospital.management.ui.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dev.hospital.management.data.bean.InsuranceType;
import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
@ManagedBean(name = "patientBean", eager = true)
public class PatientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Patient newPatient = new Patient();

	private List<Patient> patients = new ArrayList<Patient>();

	public InsuranceType[] getInsuranceTypeValues() {
		return InsuranceType.values();
	}

	public Patient getNewPatient() {
		return newPatient;
	}

	public void setNewPatient(Patient newPatient) {
		this.newPatient = newPatient;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}

}
