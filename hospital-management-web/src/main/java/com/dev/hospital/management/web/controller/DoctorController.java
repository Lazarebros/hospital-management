package com.dev.hospital.management.web.controller;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.service.PersonService;
import com.dev.hospital.management.web.ui.bean.DoctorBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class DoctorController {

	@ManagedProperty(value = "#{personService}")
	PersonService personService;

	@ManagedProperty(value = "#{doctorBean}")
	private DoctorBean doctorBean;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public void setDoctorBean(DoctorBean doctorBean) {
		this.doctorBean = doctorBean;
	}

	public String showDoctors() {
		String page = null;
		String message = null;
		try {
			this.retreiveDoctors();
			if (!doctorBean.getDoctors().isEmpty()) {
				page = "doctors";
			} else {
				message = "No Patients Found!!";
			}
		} catch (Exception e) {
			message = "Something went wrong...";
		}
		if(message != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		}
		return page;
	}

	public String addNewDoctor() {
		String page = null;
		try {
			personService.saveDoctor(doctorBean.getNewDoctor());
			this.retreiveDoctors();
			page = "doctors";
		} catch (Exception e) {
			String message = "Something went wrong...";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		}
		return page;
	}
	
	private void retreiveDoctors() throws Exception {
		List<Doctor> doctorList = personService.getDoctors();
		for (Iterator<Doctor> iterator = doctorList.iterator(); iterator.hasNext();) {
			Doctor doctor = iterator.next();
			doctorBean.addDoctor(doctor);
		}
	}

}
