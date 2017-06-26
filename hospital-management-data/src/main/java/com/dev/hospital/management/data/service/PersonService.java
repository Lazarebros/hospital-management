/**
 * 
 */
package com.dev.hospital.management.data.service;

import java.util.List;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
public interface PersonService {
	
	public void saveDoctor(Doctor doctor) throws Exception;
	
	public void savePatient(Patient patient) throws Exception;
	
	public List<Doctor> getDoctors() throws Exception;
	
	public List<Patient> getPatients() throws Exception;
	
	public Doctor getDoctor(Long id) throws Exception;
	
	public Patient getPatient(Long id) throws Exception;

}
