/**
 * 
 */
package com.dev.hospital.management.web.ui.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author dayanlazare
 *
 */
@ManagedBean(name = "loginBean", eager = true)
@SessionScoped
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