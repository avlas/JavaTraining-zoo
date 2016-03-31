package com.zoo.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.zoo.model.animals.Animal;
import com.zoo.model.animals.DietEnum;

@Singleton
@Startup
public class InitAnimalLists {

	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void init() {
		Animal lion = new Animal();
		lion.setDiet(DietEnum.CARNIVORE.toString());
		lion.setFamily("lion");
		lion.setName("mara");
		lion.setSex("female");
		lion.setAge(1);
		em.persist(lion);

		Animal wolf = new Animal();
		wolf.setDiet(DietEnum.CARNIVORE.toString());
		wolf.setFamily("wolf");
		wolf.setName("tata");
		wolf.setSex("male");
		wolf.setAge(3);
		em.persist(wolf);

		Animal rabbit = new Animal();
		rabbit.setDiet(DietEnum.HERBIVORE.toString());
		rabbit.setFamily("rabbit");
		rabbit.setName("toto");
		rabbit.setSex("male");
		rabbit.setAge(5);
		em.persist(rabbit);

		Animal giraffe = new Animal();
		giraffe.setDiet(DietEnum.HERBIVORE.toString());
		giraffe.setFamily("goat");
		giraffe.setName("mimi");
		giraffe.setSex("female");
		giraffe.setAge(7);
		em.persist(giraffe);
	}
}
