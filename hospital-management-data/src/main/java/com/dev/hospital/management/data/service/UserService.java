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

	public Boolean validateUser(String username, String password);

	public void add(User user);

	public List<User> listUsers();

}
