package com.dev.hospital.management.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.hospital.management.data.service.UserService;
import com.dev.hospital.management.web.ui.bean.LoginBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class LoginController {

	@Autowired
	UserService userService;

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String login() {
		Boolean valid = userService.validateUser(loginBean.getUsername(), loginBean.getPassword());
		if (valid) {
			return "welcome";
		} else {
			String msg = "Username or password is incorrect!";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
			return null;
		}
	}
}
