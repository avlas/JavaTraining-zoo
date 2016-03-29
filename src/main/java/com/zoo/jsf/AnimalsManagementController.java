package com.zoo.jsf;

import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.model.animals.Carnivore;
import com.zoo.model.animals.DietEnum;
import com.zoo.model.animals.Herbivore;
import com.zoo.service.animals.AnimalMB;
import com.zoo.service.animals.AnimalsService;

@ManagedBean
public class AnimalsManagementController {

	private String diet;
	private String family;
	private String sex;
	private String name;
	private String age;

	@Inject
	AnimalsService animalsService;

	@Inject
	AnimalMB animalMB;

    @Inject
    private Logger log;

    public String addAnimal() {
//		Diet diet = new Diet();
    	if (this.diet.equalsIgnoreCase(Carnivore.getType())) {
    		diet = DietEnum.CARNIVORE.name();
//    		diet.setCarnivore(new Carnivore());
    	} else if (this.diet.equalsIgnoreCase(Herbivore.getType())) {
    		diet = DietEnum.HERBIVORE.name();
//    		diet.setHerbivore(new Herbivore());
    	}
    	animalMB.setAnimal(animalsService.createAnimal(diet, family, sex, name, age));

    	animalsService.addAnimal(animalMB.getAnimal());

		return Boolean.TRUE.toString();

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

	public AnimalsService getAnimalsService() {
		return animalsService;
	}

	public void setAnimalsService(AnimalsService animalsService) {
		this.animalsService = animalsService;
	}

}
