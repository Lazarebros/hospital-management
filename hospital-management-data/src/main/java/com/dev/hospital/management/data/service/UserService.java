/**
 * 
 */
package com.dev.hospital.management.data.service;

import java.util.List;

import com.dev.hospital.management.data.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserService {

	public User validateUser(String username, String password) throws Exception;

	public void add(User user) throws Exception;

	public List<User> listUsers() throws Exception;

}
