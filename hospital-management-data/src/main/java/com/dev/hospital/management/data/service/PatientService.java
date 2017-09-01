/**
 * 
 */
package com.dev.hospital.management.data.service;

import java.util.List;

import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
public interface PatientService {
	
	public void savePatient(Patient patient) throws Exception;
	
	public List<Patient> getPatients() throws Exception;
	
	public Patient getPatient(Long id) throws Exception;

}
