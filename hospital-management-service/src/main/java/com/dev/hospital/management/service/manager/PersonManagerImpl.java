package com.dev.hospital.management.service.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.bean.Person;
import com.dev.hospital.management.data.dao.PersonDao;

/**
 * @author dayanlazare
 *
 */
public class PersonManagerImpl implements PersonManager {
	
	@Autowired
	public PersonDao personDao;

	public void savePerson(Person person) {
		if(person instanceof Doctor) {
			personDao.saveDoctor((Doctor) person);
		} else {
			personDao.savePatient((Patient) person);
		}
	}

	public List<Person> getDoctors() {
		return personDao.getDoctors();
	}

	public List<Person> getPatients() {
		return personDao.getPatients();
	}

	public Person getDoctor(Long id) {
		return personDao.getDoctor(id);
	}

	public Person getPatient(Long id) {
		return personDao.getPatient(id);
	}

}
