/**
 * 
 */
package com.dev.hospital.management.ui.bean;

import javax.faces.bean.ManagedBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean(name = "loginBean", eager = true)
public class LoginBean {

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

}