package com.zoo.service.user;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.zoo.model.User;

@ManagedBean
@SessionScoped
public class UserHolder implements Serializable {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
