package com.dev.hospital.management.service.manager;

import java.util.List;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.dao.PersonDao;
import com.dev.hospital.management.data.dao.PersonDaoImpl;

/**
 * @author dayanlazare
 *
 */
public class PersonManagerImpl implements PersonManager {
	
	PersonDao personDao = new PersonDaoImpl();

	@Override
	public void saveDoctor(Doctor doctor) {
		personDao.saveDoctor(doctor);
	}

	@Override
	public void savePatient(Patient patient) {
		personDao.savePatient(patient);
	}

	@Override
	public List<Doctor> getDoctors() {
		return personDao.getDoctors();
	}

	@Override
	public List<Patient> getPatients() {
		return personDao.getPatients();
	}

	@Override
	public Doctor getDoctor(Long id) {
		return personDao.getDoctor(id);
	}

	@Override
	public Patient getPatient(Long id) {
		return personDao.getPatient(id);
	}

}
