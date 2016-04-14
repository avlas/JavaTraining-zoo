package com.zoo.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.model.animals.Animal;
import com.zoo.model.animals.Carnivore;
import com.zoo.model.animals.DietEnum;
import com.zoo.model.animals.Herbivore;
import com.zoo.service.animals.AnimalsService;

@ManagedBean
public class AnimalController {

	@Inject
	AnimalsService animalsService;

	private String diet;
	private String family;
	private String sex;
	private String name;
	private Integer age;

    public String addAnimal() {
    	if(diet != null && family !=null && sex != null && name !=null && age !=null ) {
			if (this.diet.equalsIgnoreCase(Carnivore.getType())) {
				diet = DietEnum.CARNIVORE.name();
			} else if (this.diet.equalsIgnoreCase(Herbivore.getType())) {
				diet = DietEnum.HERBIVORE.name();
			}

			for(Carnivore.Family value : Carnivore.Family.values()) {
				if (this.family.equalsIgnoreCase(value.toString())) {
					family = value.toString();
				}
			}

			Animal animal = animalsService.createAnimal(diet, family, sex, name, age);
			animalsService.saveAnimal(animal);
    	}

		return "";
    }
    public String delete(Animal animal) {
    	animalsService.removeAnimal(animal);
		return "";
    }

    public String update(Animal animal) {
    	Animal animal2 = animalsService.findById(animal.getId());
    	if(animal2.getName() != animal.getName()) {
    		animal2.setName(animal.getName());
    	}
    	if(animal2.getAge() != animal.getAge()) {
    		animal2.setAge(animal.getAge());
    	}

		return "";
    }

	public AnimalsService getAnimalsService() {
		return animalsService;
	}

	public void setAnimalsService(AnimalsService animalsService) {
		this.animalsService = animalsService;
	}

    public List<Animal> findCarnivors() {
    	return animalsService.findAnimalsByDiet(DietEnum.CARNIVORE.toString());
    }

    public List<Animal> findHerbivors() {
    	return animalsService.findAnimalsByDiet(DietEnum.HERBIVORE.toString());
    }

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
