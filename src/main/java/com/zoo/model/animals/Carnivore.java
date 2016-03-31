package com.zoo.model.animals;

public class Carnivore extends Animal {
	private static final String TYPE = "carnivore";

	public enum Family {
	    LION, WOLF, PUMA
	}

	public static String getType() {
		return TYPE;
	}
}
