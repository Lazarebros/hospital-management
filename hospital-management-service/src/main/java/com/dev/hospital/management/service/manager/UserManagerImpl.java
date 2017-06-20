package com.dev.hospital.management.service.manager;

import com.dev.hospital.management.data.bean.User;
import com.dev.hospital.management.data.dao.UserDao;
import com.dev.hospital.management.data.dao.UserDaoImpl;

/**
 * @author dayanlazare
 *
 */
public class UserManagerImpl implements UserManager {

	UserDao userDao = new UserDaoImpl();

	@Override
	public boolean validateUser(String username, String password) {
		User user = userDao.getUser(username, password);
		return user != null;
	}

}
