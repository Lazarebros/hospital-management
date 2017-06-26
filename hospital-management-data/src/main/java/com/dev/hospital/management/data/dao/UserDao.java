/**
 * 
 */
package com.dev.hospital.management.data.dao;

import java.util.List;

import com.dev.hospital.management.data.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserDao {

	public User getUser(String username, String password) throws Exception;

	public void add(User user) throws Exception;

	public List<User> listUsers() throws Exception;

}
