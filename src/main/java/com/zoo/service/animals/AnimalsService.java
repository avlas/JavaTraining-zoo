package com.zoo.service.animals;

import java.util.List;

import com.zoo.model.animals.Animal;

public interface AnimalsService {

	Animal createAnimal(String diet, String family, String sex, String name, String age);

	void addAnimal(Animal animal);

	Animal findAnimalById(int id);

//	void updateAnimal(Animal animal);

	void removeAnimal(Animal animal);

	List<Animal> findAnimals();

	List<Animal> findAnimalsByFamily(String family);

}
