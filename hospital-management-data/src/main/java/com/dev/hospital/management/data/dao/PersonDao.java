/**
 * 
 */
package com.dev.hospital.management.data.dao;

import java.util.List;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
public interface PersonDao {
	
	public void saveDoctor(Doctor doctor);
	
	public void savePatient(Patient patient);
	
	public List<Doctor> getDoctors();
	
	public List<Patient> getPatients();
	
	public Doctor getDoctor(Long id);
	
	public Patient getPatient(Long id);

}
