package com.dev.hospital.management.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.dao.PatientDao;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Transactional("hospitalTransactionManager")
	@Override
	public void savePatient(Patient patient) throws Exception {
		patientDao.savePatient(patient);;
	}

	@Transactional("hospitalTransactionManager")
	@Override
	public List<Patient> getPatients() throws Exception {
		return patientDao.findAll();
	}

	@Transactional("hospitalTransactionManager")
	@Override
	public Patient getPatient(Long id) throws Exception {
		return patientDao.getPatient(id);
	}

}
