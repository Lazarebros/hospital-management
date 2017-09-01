package com.dev.hospital.management.web.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.service.PatientService;
import com.dev.hospital.management.web.ui.bean.PatientBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class PatientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@ManagedProperty(value = "#{patientService}")
	PatientService patientService;

	@ManagedProperty(value = "#{patientBean}")
	private PatientBean patientBean;
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}
	
	@PostConstruct
	public void init() {
	}

	public String showPatients() {
		String page = null;
		String message = null;
		try {
			this.retreivePatients();
			if (!patientBean.getPatients().isEmpty()) {
				page = "patients";
			} else {
				message = "No Patients Found!!";
				page = null;
			}
		} catch (Exception e) {
			message = "Something went wrong...";
			LOGGER.error(e.getMessage());
		}
		if(message != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		}
		return page;
	}

	public String addNewPatient() {
		String page = null;
		try {
			patientService.savePatient(patientBean.getNewPatient());
			this.retreivePatients();
			page = "patients";
			patientBean.setNewPatient(new Patient());
		} catch (Exception e) {
			String message = "Something went wrong...";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			LOGGER.error(e.getMessage());
		}
		return page;
	}
	
	private void retreivePatients() throws Exception {
		List<Patient> patientList = patientService.getPatients();
		for (Iterator<Patient> iterator = patientList.iterator(); iterator.hasNext();) {
			Patient patient = iterator.next();
			patientBean.addPatient(patient);
		}
	}

}
