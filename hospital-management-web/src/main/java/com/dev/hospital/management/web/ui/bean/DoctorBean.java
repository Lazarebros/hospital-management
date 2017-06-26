/**
 * 
 */
package com.dev.hospital.management.web.ui.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.InsuranceType;

/**
 * @author dayanlazare
 *
 */
@SessionScoped
@ManagedBean(name = "doctorBean", eager = true)
public class DoctorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Doctor newDoctor = new Doctor();

	private Set<Doctor> doctors = new HashSet<Doctor>();

	public InsuranceType[] getInsuranceTypeValues() {
		return InsuranceType.values();
	}

	public Doctor getNewDoctor() {
		return newDoctor;
	}

	public void setNewDoctor(Doctor newDoctor) {
		this.newDoctor = newDoctor;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void addDoctor(Doctor doctor) {
		this.doctors.add(doctor);
	}

}
