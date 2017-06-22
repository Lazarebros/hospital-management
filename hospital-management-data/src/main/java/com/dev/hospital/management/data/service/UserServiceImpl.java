package com.dev.hospital.management.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.hospital.management.data.bean.User;
import com.dev.hospital.management.data.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public Boolean validateUser(String username, String password) {
		User user = userDao.getUser(username, password);
		return user != null;
	}

	@Transactional
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> listUsers() {
		return userDao.listUsers();
	}

}
