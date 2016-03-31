package com.zoo.service.animals;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.zoo.data.animals.AnimalsDao;
import com.zoo.model.animals.Animal;

@Stateless
public class AnimalsServiceImpl implements AnimalsService {
    @Inject
    private AnimalsDao animalsDao;

	@Override
	public Animal createAnimal(String diet, String family, String sex, String name, String age) {
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
		animalsDao.persist(animal);
	}

	@Override
	public Animal findAnimalById(int id) {
		return animalsDao.findById(id);
	}

	@Override
	public void removeAnimal(Animal animal) {
		animalsDao.remove(animal);
	}

	@Override
	public List<Animal> findAnimals() {
		return animalsDao.findAll();
	}

	@Override
	public List<Animal> findAnimalsByDiet(String diet) {
		return animalsDao.findAnimalsByDiet(diet);
	}

	@Override
	public void refresh(Animal animal) {
		animalsDao.refresh(animal);
	}

}
