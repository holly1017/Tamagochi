package model.vo;

import java.util.Random;

public class RandomCharacter extends TamagochiCharacter {
	private static final String[] CHARACTERS = { "Mametchi", "Kuchipatchi", "Memetchi" };

	public RandomCharacter() {
		super(generateRandomCharacter());
	}

	private static String generateRandomCharacter() {
		Random rand = new Random();
		return CHARACTERS[rand.nextInt(CHARACTERS.length)];
	}
}
