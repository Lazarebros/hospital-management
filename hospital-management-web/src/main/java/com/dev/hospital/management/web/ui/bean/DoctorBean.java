/**
 * 
 */
package com.dev.hospital.management.web.ui.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.dev.hospital.management.data.bean.Doctor;

/**
 * @author dayanlazare
 *
 */
@ManagedBean(name = "DoctorBean", eager = true)
@RequestScoped
public class DoctorBean {
	
	@ManagedProperty(value = "#{doctor}")
	private Doctor doctor;
	
}
