/**
 * 
 */
package com.dev.hospital.management.data.dao;

import com.dev.hospital.management.data.bean.User;

/**
 * @author dayanlazare
 *
 */
public interface UserDao {

	public User getUser(String username, String password);

}
