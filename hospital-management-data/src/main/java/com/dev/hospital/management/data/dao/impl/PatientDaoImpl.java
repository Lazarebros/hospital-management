package com.dev.hospital.management.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.dev.hospital.management.data.bean.Patient;
import com.dev.hospital.management.data.dao.PatientDao;

/**
 * @author dayanlazare
 *
 */
@Repository("patientService")
public class PatientDaoImpl implements PatientDao {

	@PersistenceContext(name = "hospitalEntityManager", unitName = "hospitalPersistenceUnit")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void savePatient(Patient patient) {
		em.persist(patient);
	}

	@Override
	public List<Patient> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = builder.createQuery(Patient.class);
		Root<Patient> patientRoot = criteria.from(Patient.class);
		criteria.select(patientRoot);
		return em.createQuery(criteria).getResultList();
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

	@Override
	public List<Patient> findAll(Sort sort) {
		return null;
	}

	@Override
	public List<Patient> findAll(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public <S extends Patient> List<S> save(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {
	}

	@Override
	public <S extends Patient> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Patient> entities) {
	}

	@Override
	public void deleteAllInBatch() {
	}

	@Override
	public <S extends Patient> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Patient> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public Page<Patient> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Patient> S save(S entity) {
		return null;
	}

	@Override
	public Patient findOne(Integer id) {
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(Integer id) {
	}

	@Override
	public void delete(Patient entity) {
	}

	@Override
	public void delete(Iterable<? extends Patient> entities) {
	}

	@Override
	public void deleteAll() {
	}

	@Override
	public <S extends Patient> S findOne(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Patient> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Patient> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Patient> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public Patient getOne(Integer id) {
		return null;
	}

}
