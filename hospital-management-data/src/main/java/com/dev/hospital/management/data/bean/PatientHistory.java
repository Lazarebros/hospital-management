/**
 * 
 */
package com.dev.hospital.management.data.bean;

import java.util.Date;

/**
 * @author dayanlazare
 *
 */
public class PatientHistory {

	private Date admissionDate;
	private Date dischargeDate;

	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date inDate) {
		this.admissionDate = inDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date outDate) {
		this.dischargeDate = outDate;
	}

}
