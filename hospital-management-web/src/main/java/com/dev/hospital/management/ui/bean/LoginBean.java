/**
 * 
 */
package com.dev.hospital.management.ui.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
@ManagedBean(name = "loginBean", eager = true)
public class LoginBean {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	
	
	
	protected String firstname;
	protected String lastname;
	
	private List<Patient> patients = new ArrayList<Patient>();

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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