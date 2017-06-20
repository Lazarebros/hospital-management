package com.dev.hospital.management.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dev.hospital.management.data.bean.User;
import com.dev.hospital.management.data.dao.UserDao;
import com.dev.hospital.management.data.dao.UserDaoImpl;
import com.dev.hospital.management.ui.bean.LoginBean;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class LoginController {

	UserDao dao = new UserDaoImpl();

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String login() {
		User user = dao.getUser(loginBean.getUsername(), loginBean.getPassword());
		if (user != null) {
			return "welcome";
		} else {
			String msg = "Username or password is incorrect!";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
			return null;
		}
	}
}
