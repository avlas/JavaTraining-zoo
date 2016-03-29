package com.zoo.service.animals;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.zoo.model.animals.Animal;

@ManagedBean
@SessionScoped
public class AnimalMB  implements Serializable {
		private Animal animal;

		public Animal getAnimal() {
			return animal;
		}

		public void setAnimal(Animal animal) {
			this.animal = animal;
		}
}
