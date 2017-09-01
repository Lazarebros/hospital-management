/**
 * 
 */
package com.dev.hospital.management.data.service;

import java.util.List;

import com.dev.hospital.management.data.bean.Doctor;

/**
 * @author dayanlazare
 *
 */
public interface DoctorService {
	
	public void saveDoctor(Doctor doctor) throws Exception;
	
	public List<Doctor> getDoctors() throws Exception;
	
	public Doctor getDoctor(Long id) throws Exception;
	
}
