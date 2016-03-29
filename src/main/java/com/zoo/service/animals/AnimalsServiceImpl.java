package com.zoo.service.animals;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.zoo.data.animals.AnimalsDao;
import com.zoo.model.animals.Animal;

@Stateless
public class AnimalsServiceImpl implements AnimalsService {

    @Inject
    private Logger log;

    @Inject
    private AnimalsDao animalsDao;

	@Override
	public Animal createAnimal(String diet, String family, String sex, String name, String age) {
		log.info("AnimalsServiceImpl.createAnimal");

		Animal animal = new Animal();
		animal.setDiet(diet);
		animal.setFamily(family);
		animal.setName(name);
		animal.setSex(sex);
		animal.setAge(Integer.valueOf(age));
		return animal;
	}

	@Override
	public void addAnimal(Animal animal) {
		log.info("AnimalsServiceImpl.addAnimal");
		animalsDao.persist(animal);
	}

	@Override
	public Animal findAnimalById(int id) {
		log.info("AnimalsServiceImpl.findAnimalById");
		return animalsDao.findById(id);
	}

	@Override
	public void removeAnimal(Animal animal) {
		log.info("AnimalsServiceImpl.removeAnimal");
		animalsDao.remove(animal);
	}

	@Override
	public List<Animal> findAnimals() {
		log.info("AnimalsServiceImpl.findAnimals");
		return animalsDao.findAll();
	}

	@Override
	public List<Animal> findAnimalsByFamily(String family) {
		log.info("AnimalsServiceImpl.findAnimalsByFamily");
		return animalsDao.findAnimalsByFamily(family);
	}

}
