package com.zoo.service.user;

import java.util.Collection;

import com.zoo.model.User;

public interface UserService {
	User createUser(String email, String firstName, String lastName, String pass);

	void saveUser(User user);

	void removeUser(User user);

	User findUserById(String email);

	Collection<User> findAllUser();

	User createAdmin(String email, String firstName, String lastName, String pass);
	
	void disconnectCurrentUser();

	User getCurrentUser();
	
	void setCurrentUser(User user);
	
}
