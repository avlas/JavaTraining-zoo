package com.zoo.jsf.admin;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.model.User;
import com.zoo.service.user.UserService;

@ManagedBean
public class NewAdminMC {
	private String email;
	private String firstName;
	private String lastName;
	private String pass;
	private String repass;

	@Inject
	UserService userService;

	public String checkAdmin() {
		if (pass.equals(repass)) {
			User user = userService.createAdmin(email, firstName, lastName, pass);
			userService.saveUser(user);
		}
		return Boolean.FALSE.toString();
	}

	// Getters / Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

}
