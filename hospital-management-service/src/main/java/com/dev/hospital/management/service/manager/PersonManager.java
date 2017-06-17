/**
 * 
 */
package com.dev.hospital.management.service.manager;

import java.util.List;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.bean.Person;

/**
 * @author dayanlazare
 *
 */
public interface PersonManager {

	public void savePerson(Person person);

	public List<Doctor> getDoctors();

	public List<Patient> getPatients();

	public Person getDoctor(Long id);

	public Person getPatient(Long id);

}
