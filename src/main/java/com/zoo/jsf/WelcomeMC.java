package com.zoo.jsf;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.service.user.UserService;

@ManagedBean
public class WelcomeMC {

	@Inject
	UserService userService;

	public String disconnect() {
		userService.disconnectCurrentUser();
		return "disconnect";
	}
	
	public String deleteAccount(){
		userService.removeUser(userService.getCurrentUser());
		return disconnect();
	}
}
