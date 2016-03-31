package com.zoo.data.animals;

import java.util.List;

import com.zoo.data.Dao;
import com.zoo.model.animals.Animal;

public interface AnimalsDao extends Dao<Integer, Animal> {
	List<Animal> findAnimalsByDiet(String diet);
}
