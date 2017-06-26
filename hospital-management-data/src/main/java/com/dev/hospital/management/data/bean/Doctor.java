/**
 * 
 */
package com.dev.hospital.management.data.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author dayanlazare
 *
 */
@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	protected Long id;

	@Column(name = "first_name")
	protected String firstname;

	@Column(name = "last_name")
	protected String lastname;

	@Column(name = "date_of_birth")
	protected Date dateOfBirth;

	@Column(name = "email")
	protected String email;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "pager_number")
	private String pagerNumber;

	@Transient
	private Set<String> specialties = new HashSet<String>();
	
	@Transient
	private Set<Patient> Patients = new HashSet<Patient>();

	public Doctor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPagerNumber() {
		return pagerNumber;
	}

	public void setPagerNumber(String pagerNumber) {
		this.pagerNumber = pagerNumber;
	}

	public Set<String> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<String> specialties) {
		this.specialties = specialties;
	}

	public void addSpecialty(String specialty) {
		this.specialties.add(specialty);
	}

	public Set<Patient> getPatients() {
		return Patients;
	}

	public void setPatients(Set<Patient> patients) {
		Patients = patients;
	}

	public void addPatient(Patient patient) {
		this.Patients.add(patient);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((pagerNumber == null) ? 0 : pagerNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Doctor other = (Doctor) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstname == null) {
			if (other.firstname != null) {
				return false;
			}
		} else if (!firstname.equals(other.firstname)) {
			return false;
		}
		if (lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!lastname.equals(other.lastname)) {
			return false;
		}
		if (mobileNumber == null) {
			if (other.mobileNumber != null) {
				return false;
			}
		} else if (!mobileNumber.equals(other.mobileNumber)) {
			return false;
		}
		if (pagerNumber == null) {
			if (other.pagerNumber != null) {
				return false;
			}
		} else if (!pagerNumber.equals(other.pagerNumber)) {
			return false;
		}
		return true;
	}
	
}
