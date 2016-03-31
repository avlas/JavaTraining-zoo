package com.zoo.model.animals;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Diet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private Carnivore carnivore;
	private Herbivore herbivore;

	public Carnivore getCarnivore() {
		return carnivore;
	}
	public void setCarnivore(Carnivore carnivore) {
		this.carnivore = carnivore;
	}
	public Herbivore getHerbivore() {
		return herbivore;
	}
	public void setHerbivore(Herbivore herbivore) {
		this.herbivore = herbivore;
	}

}