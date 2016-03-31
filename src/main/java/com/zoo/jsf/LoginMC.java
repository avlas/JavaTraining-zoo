package com.zoo.jsf;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.model.User;
import com.zoo.service.user.UserService;

@ManagedBean
public class LoginMC {
	private String login;
	private String pass;

	@Inject
	UserService userService;

	public String check() {
		User user = userService.findUserById(login);
		if (user != null && user.isMyPassword(pass)) {
			userService.setCurrentUser(user);
			return userService.getCurrentUser().getAuthority();
		} else {
			return Boolean.FALSE.toString();
		}
	}

	// Getters / Setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
