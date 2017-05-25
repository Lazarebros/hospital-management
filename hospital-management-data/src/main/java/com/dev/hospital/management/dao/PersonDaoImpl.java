package com.dev.hospital.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dev.hospital.management.bean.Person;

/**
 * @author dayanlazare
 *
 */
public class PersonDaoImpl implements PersonDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Person person) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(person);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getDoctors() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Doctor").list();
		session.close();
		return personList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPatients() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Doctor").list();
		session.close();
		return personList;
	}

	@Override
	public Person getDoctor(Long id) {
		return null;
	}

	@Override
	public Person getPatient(Long id) {
		return null;
	}

}
