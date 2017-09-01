/**
 * 
 */
package com.dev.hospital.management.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;

/**
 * @author dayanlazare
 *
 */
public interface DoctorDao extends JpaRepository<Patient, Integer> {
	
	public void saveDoctor(Doctor doctor) throws Exception;
	
	public List<Doctor> getDoctors() throws Exception;
	
	public Doctor getDoctor(Long id) throws Exception;
	
}
