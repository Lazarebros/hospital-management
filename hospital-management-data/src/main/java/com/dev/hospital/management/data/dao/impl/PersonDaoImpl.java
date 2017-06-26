package com.dev.hospital.management.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.dao.PersonDao;

/**
 * @author dayanlazare
 *
 */
@Repository("PersonService")
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	public void savePatient(Patient patient) {
		em.persist(patient);
	}

	@Override
	public List<Doctor> getDoctors() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
		Root<Doctor> doctorRoot = criteria.from(Doctor.class);
		criteria.select(doctorRoot);
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<Patient> getPatients() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = builder.createQuery(Patient.class);
		Root<Patient> patientRoot = criteria.from(Patient.class);
		criteria.select(patientRoot);
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public Doctor getDoctor(Long id) {
		Doctor doctor = null;

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Doctor> criteria = builder.createQuery(Doctor.class);
		Root<Doctor> doctorRoot = criteria.from(Doctor.class);
		criteria.select(doctorRoot);
		criteria.where(builder.equal(doctorRoot.get("id"), id));
		List<Doctor> doctorList = em.createQuery(criteria).getResultList();
		if (!doctorList.isEmpty()) {
			doctor = doctorList.get(0);
		}
		return doctor;
	}

	@Override
	public Patient getPatient(Long id) {
		Patient patient = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = builder.createQuery(Patient.class);
		Root<Patient> patientRoot = criteria.from(Patient.class);
		criteria.select(patientRoot);
		criteria.where(builder.equal(patientRoot.get("id"), id));
		List<Patient> patientList = em.createQuery(criteria).getResultList();
		if (!patientList.isEmpty()) {
			patient = patientList.get(0);
		}
		return patient;
	}

}
