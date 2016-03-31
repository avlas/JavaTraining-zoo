package com.zoo.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.zoo.model.User;

@Singleton
@Startup
public class LifeCycleBean {

	private static final String ADMIN_EMAIL = "admin@admin.com";
	private static final String ADMIN = "admin";

	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void init() {
		// ADD an admin to the data base
		User admin = new User();
		admin.setEmail(ADMIN_EMAIL);
		admin.setFirstName(ADMIN);
		admin.setLastName(ADMIN);
		admin.setPass(ADMIN);
		admin.setAuthority(ADMIN);
		em.persist(admin);

		// ADD an user to the data base
		User toto = new User();
		toto.setEmail("toto@toto.com");
		toto.setFirstName("toto");
		toto.setLastName("toto");
		toto.setPass("toto");
		toto.setAuthority("user");
		em.persist(toto);

		// ADD an user to the data base
		User tata = new User();
		tata.setEmail("tata@tata.com");
		tata.setFirstName("tata");
		tata.setLastName("tata");
		tata.setPass("tata");
		tata.setAuthority("user");
		em.persist(tata);

	}

}
