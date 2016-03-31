package com.zoo.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.model.animals.Animal;
import com.zoo.model.animals.DietEnum;
import com.zoo.service.animals.AnimalsService;

@ManagedBean
public class AnimalsController {

	@Inject
	AnimalsService animalsService;

	private List<Animal> carnivors;
	private List<Animal> herbivors;

    @PostConstruct
    public void init() {
    	carnivors = animalsService.findAnimalsByDiet(DietEnum.CARNIVORE.toString());
    	herbivors = animalsService.findAnimalsByDiet(DietEnum.HERBIVORE.toString());
    }

	public List<Animal> getCarnivors() {
		return carnivors;
	}

	public void setCarnivors(List<Animal> carnivors) {
		this.carnivors = carnivors;
	}

	public List<Animal> getHerbivors() {
		return herbivors;
	}

	public void setHerbivors(List<Animal> herbivors) {
		this.herbivors = herbivors;
	}

}
