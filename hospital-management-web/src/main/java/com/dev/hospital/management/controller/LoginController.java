package com.dev.hospital.management.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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

	private String msg;

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String login() {
		User user = dao.getUser(loginBean.getUsername(), loginBean.getPassword());
		if (user != null) {
			return "welcome";
		}
		msg = "Bad credentials!!";
		return null;
	}
}
