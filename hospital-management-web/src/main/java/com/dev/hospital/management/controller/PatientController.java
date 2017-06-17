package com.dev.hospital.management.controller;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.bean.User;
import com.dev.hospital.management.data.dao.PersonDao;
import com.dev.hospital.management.data.dao.PersonDaoImpl;
import com.dev.hospital.management.data.dao.UserDao;
import com.dev.hospital.management.data.dao.UserDaoImpl;
import com.dev.hospital.management.ui.bean.LoginBean;
import com.dev.hospital.management.ui.bean.PatientBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class PatientController {

	UserDao userDAO = new UserDaoImpl();

	PersonDao personDAO = new PersonDaoImpl();

	private String msg;

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	@ManagedProperty(value = "#{patientBean}")
	private PatientBean patientBean;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}

	public String showPatients() {
		String page = null;
		User user = userDAO.getUser(loginBean.getUsername(), loginBean.getPassword());
		if (user != null) {
			List<Patient> patientList = personDAO.getPatients();
			for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
				Patient patient = iterator.next();
				patientBean.addPatient(patient);
				
				patientBean.setFirstname(patient.getFirstname());
				patientBean.setLastname(patient.getLastname());
			}
			if (!patientBean.getPatients().isEmpty()) {
				page = "patients";
			} else {
				msg = "No Patients Found!!";
				page = "welcome";
			}
		} else {
			msg = "Bad credentials!!";
		}
		return page;
	}
}
