package com.zoo.service.user;

import java.util.Collection;

import javax.inject.Inject;

import com.zoo.data.user.UserDao;
import com.zoo.model.User;

public class UserServiceImpl implements UserService {

	private static final String ADMIN_AUTHORITY = "admin";
	private static final String USER_AUTHORITY = "user";

	@Inject
	private UserDao userDao;

	@Inject
	private UserHolder userHolder;

	@Override
	public User createUser(String email, String firstName, String lastName, String pass) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPass(pass);
		user.setAuthority(USER_AUTHORITY);
		return user;
	}

	@Override
	public User createAdmin(String email, String firstName, String lastName, String pass) {
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPass(pass);
		user.setAuthority(ADMIN_AUTHORITY);
		return user;
	}

	@Override
	public void disconnectUser() {
		userHolder.setUser(null);
	}

	@Override
	public void saveUser(User user) {
		userDao.persist(user);
	}

	@Override
	public void removeUser(User user) {
		userDao.remove(user);

	}

	@Override
	public User findUserById(String email) {
		return userDao.findById(email);

	}

	@Override
	public Collection<User> findAllUser() {
		return userDao.findAll();

	}

}
