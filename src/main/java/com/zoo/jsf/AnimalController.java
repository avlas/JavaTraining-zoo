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
	private String age;

    public String addAnimal() {
//		Diet diet = new Diet();
    	if (this.diet.equalsIgnoreCase(Carnivore.getType())) {
    		diet = DietEnum.CARNIVORE.name();
//    		diet.setCarnivore(new Carnivore());
    	} else if (this.diet.equalsIgnoreCase(Herbivore.getType())) {
    		diet = DietEnum.HERBIVORE.name();
//    		diet.setHerbivore(new Herbivore());
    	}

    	Animal animal = animalsService.createAnimal(diet, family, sex, name, age);
    	animalsService.addAnimal(animal);

		return "";
    }

    public List<Animal> findCarnivors() {
    	return animalsService.findAnimalsByDiet(DietEnum.CARNIVORE.toString());
    }

    public List<Animal> findHerbivors() {
    	return animalsService.findAnimalsByDiet(DietEnum.HERBIVORE.toString());
    }

	public AnimalsService getAnimalsService() {
		return animalsService;
	}

	public void setAnimalsService(AnimalsService animalsService) {
		this.animalsService = animalsService;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
