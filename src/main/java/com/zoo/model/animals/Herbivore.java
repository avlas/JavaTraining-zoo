package com.zoo.model.animals;

public class Herbivore extends Animal {
	private static final String TYPE = "carnivore";

	public enum Family {
	    RABBIT, GIRAFFE, GOAT, HORSE
	}

	public static String getType() {
		return TYPE;
	}

}
