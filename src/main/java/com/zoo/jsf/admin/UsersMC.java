package com.zoo.jsf.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import com.zoo.model.User;
import com.zoo.service.user.UserService;

@ManagedBean
public class UsersMC {
	private String userEmail;
	private List<User> userList;
	private List<User> adminList;

	@Inject
	UserService userService;

	@PostConstruct
	public void init() {
		userList = new ArrayList<>();
		adminList = new ArrayList<>();
		Collection<User> list = userService.findAllUser();
		for (User user : list) {
			if (user.getAuthority().equals("admin")) {
				adminList.add(user);
			} else if (user.getAuthority().equals("user")) {
				userList.add(user);
			}
		}
	}

	public String deleteUser() {
		User user = userService.findUserById(userEmail);
		if (!user.equals(userService.getCurrentUser())) {
			userService.removeUser(user);
		}
		return "false";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setAdminList(List<User> adminList) {
		this.adminList = adminList;
	}

	public List<User> getAdminList() {
		return adminList;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
