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
	public User validateUser(String username, String password) throws Exception {
		return userDao.getUser(username, password);
	}

	@Transactional
	@Override
	public void add(User user) throws Exception {
		userDao.add(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> listUsers() throws Exception {
		return userDao.listUsers();
	}

}
