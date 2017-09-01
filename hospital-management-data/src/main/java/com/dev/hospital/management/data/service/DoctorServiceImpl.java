package com.dev.hospital.management.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.dao.DoctorDao;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Transactional("hospitalTransactionManager")
	@Override
	public void saveDoctor(Doctor doctor) throws Exception {
		doctorDao.saveDoctor(doctor);
	}

	@Transactional("hospitalTransactionManager")
	@Override
	public List<Doctor> getDoctors() throws Exception {
		return doctorDao.getDoctors();
	}

	@Transactional("hospitalTransactionManager")
	@Override
	public Doctor getDoctor(Long id) throws Exception {
		return doctorDao.getDoctor(id);
	}

}
