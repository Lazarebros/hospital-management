package com.dev.hospital.management.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.d2l2c.user.management.bean.User;
import com.d2l2c.user.management.service.UserService;
import com.dev.hospital.management.web.ui.bean.LoginBean;
import com.dev.hospital.management.web.util.SessionUtils;

/**
 * @author dayanlazare
 *
 */
@ManagedBean
@RequestScoped
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

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
		try {
			User user = userService.validateUser(loginBean.getUsername(), loginBean.getPassword());
			if (user != null) {
				loginBean.setValid(true);
				loginBean.setFirstname(user.getFirstname());
				loginBean.setLastname(user.getLastname());
				page = "welcome";
			} else {
				message = "Username or password is incorrect!";
			}
		} catch (Exception e) {
			message = "Something went wrong...";
			LOGGER.error(e.getMessage());
		}
		if(message != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		}
		return page;
	}

	public String logout() {
		loginBean.setValid(false);
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

}
