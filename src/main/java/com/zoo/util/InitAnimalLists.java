package com.zoo.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.zoo.model.animals.Animal;
import com.zoo.model.animals.Carnivore;
import com.zoo.model.animals.DietEnum;
import com.zoo.model.animals.Herbivore;

@Singleton
@Startup
public class InitAnimalLists {

	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void init() {
		Animal lion = new Animal();
		lion.setDiet(DietEnum.CARNIVORE.toString());
		lion.setFamily(Carnivore.Family.LION.toString());
		lion.setName("mara");
		lion.setSex("female");
		lion.setAge(1);
		em.persist(lion);

		Animal wolf = new Animal();
		wolf.setDiet(DietEnum.CARNIVORE.toString());
		wolf.setFamily(Carnivore.Family.WOLF.toString());
		wolf.setName("tata");
		wolf.setSex("male");
		wolf.setAge(3);
		em.persist(wolf);

		Animal lion2= new Animal();
		lion2.setDiet(DietEnum.CARNIVORE.toString());
		lion2.setFamily(Carnivore.Family.LION.toString());
		lion2.setName("mara");
		lion2.setSex("female");
		lion2.setAge(1);
		em.persist(lion2);

		Animal wolf2 = new Animal();
		wolf2.setDiet(DietEnum.CARNIVORE.toString());
		wolf2.setFamily(Carnivore.Family.WOLF.toString());
		wolf2.setName("tata");
		wolf2.setSex("male");
		wolf2.setAge(3);
		em.persist(wolf2);

		Animal goat = new Animal();
		goat.setDiet(DietEnum.HERBIVORE.toString());
		goat.setFamily(Herbivore.Family.GOAT.toString());
		goat.setName("mimi");
		goat.setSex("female");
		goat.setAge(7);
		em.persist(goat);

		Animal giraffe = new Animal();
		giraffe.setDiet(DietEnum.HERBIVORE.toString());
		giraffe.setFamily(Herbivore.Family.GIRAFFE.toString());
		giraffe.setName("mimi");
		giraffe.setSex("female");
		giraffe.setAge(7);
		em.persist(giraffe);

		Animal rabbit = new Animal();
		rabbit.setDiet(DietEnum.HERBIVORE.toString());
		rabbit.setFamily(Herbivore.Family.RABBIT.toString());
		rabbit.setName("toto");
		rabbit.setSex("male");
		rabbit.setAge(5);
		em.persist(rabbit);

		Animal giraffe2 = new Animal();
		giraffe2.setDiet(DietEnum.HERBIVORE.toString());
		giraffe2.setFamily(Herbivore.Family.GIRAFFE.toString());
		giraffe2.setName("mimi");
		giraffe2.setSex("female");
		giraffe2.setAge(7);
		em.persist(giraffe2);

	}
}
