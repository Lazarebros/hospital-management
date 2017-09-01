/**
 * 
 */
package com.dev.hospital.management.data.test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.service.DoctorService;
import com.dev.hospital.management.data.service.PatientService;
import com.dev.hospital.management.data.spring.config.HospitalJPAConfig;

/**
 * @author dayanlazare
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HospitalJPAConfig.class })
public class HospitalDataJPATest {

	private static final Logger LOGGER = LoggerFactory.getLogger(HospitalDataJPATest.class);

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;

	@Test
	@Transactional("hospitalTransactionManager")
	public void listDoctorsTest() {
		List<Doctor> doctors;
		try {
			doctors = doctorService.getDoctors();
			assertThat(doctors.isEmpty(), is(false));
			for (Doctor doctor : doctors) {
				LOGGER.info(doctor.toString());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			fail();
		}
	}

	@Test
	@Transactional("hospitalTransactionManager")
	public void listPatientsTest() {
		List<Patient> patients;
		try {
			patients = patientService.getPatients();
			assertThat(patients.isEmpty(), is(false));
			for (Patient patient : patients) {
				LOGGER.info(patient.toString());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			fail();
		}
	}

}
