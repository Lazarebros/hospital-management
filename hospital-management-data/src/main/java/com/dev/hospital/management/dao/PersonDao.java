/**
 * 
 */
package com.dev.hospital.management.dao;

import java.util.List;

import com.dev.hospital.management.bean.Person;

/**
 * @author dayanlazare
 *
 */
public interface PersonDao {
	
	public void save(Person person);
	
	public List<Person> getDoctors();
	
	public List<Person> getPatients();
	
	public Person getDoctor(Long id);
	
	public Person getPatient(Long id);

}
