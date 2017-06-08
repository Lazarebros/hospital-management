/**
 * 
 */
package com.dev.hospital.management.data.dao;

import java.util.List;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.bean.Person;

/**
 * @author dayanlazare
 *
 */
public interface PersonDao {
	
	public void saveDoctor(Doctor doctor);
	
	public void savePatient(Patient patient);
	
	public List<Person> getDoctors();
	
	public List<Person> getPatients();
	
	public Person getDoctor(Long id);
	
	public Person getPatient(Long id);

}
