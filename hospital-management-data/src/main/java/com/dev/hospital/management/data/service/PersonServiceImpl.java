package com.dev.hospital.management.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.dao.PersonDao;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Transactional
	@Override
	public void saveDoctor(Doctor doctor) throws Exception {
		personDao.saveDoctor(doctor);
	}

	@Transactional
	@Override
	public void savePatient(Patient patient) throws Exception {
		personDao.savePatient(patient);;
	}

	@Transactional
	@Override
	public List<Doctor> getDoctors() throws Exception {
		return personDao.getDoctors();
	}

	@Transactional
	@Override
	public List<Patient> getPatients() throws Exception {
		return personDao.getPatients();
	}

	@Transactional
	@Override
	public Doctor getDoctor(Long id) throws Exception {
		return personDao.getDoctor(id);
	}

	@Transactional
	@Override
	public Patient getPatient(Long id) throws Exception {
		return personDao.getPatient(id);
	}

}
