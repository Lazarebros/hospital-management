/**
 * 
 */
package com.dev.hospital.management.data.bean;

import java.sql.Date;

/**
 * @author dayanlazare
 *
 */
public class User extends Person {

	public User(
			String firstname, 
			String lastname, 
			String email, 
			Date dateOfBirth,
			String username,
			String password) {
		
		super(firstname, lastname, email, dateOfBirth);
		this.username = username;
		this.password = password;
	}

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
}
