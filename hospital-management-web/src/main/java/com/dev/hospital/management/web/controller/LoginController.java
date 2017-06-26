package com.dev.hospital.management.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dev.hospital.management.data.service.UserService;
import com.dev.hospital.management.web.ui.bean.LoginBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class LoginController {

	@ManagedProperty(value = "#{userService}")
	UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String login() {
		String page = null;
		String message = null;
		Boolean valid = false;
		try {
			valid = userService.validateUser(loginBean.getUsername(), loginBean.getPassword());
			if (valid) {
				page = "welcome";
			} else {
				message = "Username or password is incorrect!";
			}
		} catch (Exception e) {
			message = "Something went wrong...";
		}
		if(message != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		}
		return page;
	}
}
