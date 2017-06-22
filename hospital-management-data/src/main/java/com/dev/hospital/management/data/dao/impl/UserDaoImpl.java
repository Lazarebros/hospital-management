package com.dev.hospital.management.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dev.hospital.management.data.bean.User;
import com.dev.hospital.management.data.dao.UserDao;

/**
 * @author dayanlazare
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String username, String password) {
		User user = null;

		Query query = em.createQuery("Select user From user Where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setMaxResults(1);

		List<User> listUsers = query.getResultList();
		if (!listUsers.isEmpty()) {
			user = listUsers.get(0);
		}
		return user;
	}

	@Override
	public void add(User user) {
		em.persist(user);
	}

	@Override
	public List<User> listUsers() {
		CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
		@SuppressWarnings("unused")
		Root<User> root = criteriaQuery.from(User.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
