package com.zoo.service.animals;

import java.util.List;

import com.zoo.model.animals.Animal;

public interface AnimalsService {

	Animal createAnimal(String diet, String family, String sex, String name, Integer age);

	void saveAnimal(Animal animal);

	Animal findById(int id);

	void removeAnimal(Animal animal);

	void refresh(Animal animal);

	List<Animal> findAnimals();

	List<Animal> findAnimalsByDiet(String diet);

}
