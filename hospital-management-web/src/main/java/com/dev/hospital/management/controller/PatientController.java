package com.dev.hospital.management.controller;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.service.manager.PersonManager;
import com.dev.hospital.management.service.manager.PersonManagerImpl;
import com.dev.hospital.management.service.manager.UserManager;
import com.dev.hospital.management.service.manager.UserManagerImpl;
import com.dev.hospital.management.ui.bean.LoginBean;
import com.dev.hospital.management.ui.bean.PatientBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class PatientController {

	UserManager userManager = new UserManagerImpl();

	PersonManager personManager = new PersonManagerImpl();


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
		List<Patient> patientList = personManager.getPatients();
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
		personManager.savePatient(patientBean.getNewPatient());
		return "welcome";
	}

}
