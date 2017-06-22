package com.dev.hospital.management.web.controller;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.dao.PersonDao;
import com.dev.hospital.management.data.dao.UserDao;
import com.dev.hospital.management.data.dao.impl.PersonDaoImpl;
import com.dev.hospital.management.web.ui.bean.LoginBean;
import com.dev.hospital.management.web.ui.bean.PatientBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class PatientController {

	@Autowired
	UserDao userDao;

	PersonDao personDao = new PersonDaoImpl();


	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	@ManagedProperty(value = "#{patientBean}")
	private PatientBean patientBean;

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}

	public String showPatients() {
		String page = null;
		List<Patient> patientList = personDao.getPatients();
		for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
			Patient patient = iterator.next();
			patientBean.addPatient(patient);
		}
		if (!patientBean.getPatients().isEmpty()) {
			page = "patients";
		} else {
			String msg = "No Patients Found!!";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
			page = null;
		}
		return page;
	}

	public String addNewPatient() {
		personDao.savePatient(patientBean.getNewPatient());
		return "welcome";
	}

}
