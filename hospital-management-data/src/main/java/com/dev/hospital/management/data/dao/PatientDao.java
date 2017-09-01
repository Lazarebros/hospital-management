/**
 * 
 */
package com.dev.hospital.management.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
public interface PatientDao extends JpaRepository<Patient, Integer> {
	
	public void savePatient(Patient patient) throws Exception;
	
	public Patient getPatient(Long id) throws Exception;

}
