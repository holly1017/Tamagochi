package model.vo;

import java.util.Random;

public class RandomCharacter extends TamagochiCharacter {
	private static final String[] CHARACTERS = { "Mametchi", "Kuchipatchi", "Memetchi" };

	public RandomCharacter() { // RandomCharacter의 생성자
		super(generateRandomCharacter()); // TamagochiCharacter의 생성자에 메소드 반환 값을 넘김
	}

	private static String generateRandomCharacter() {
		Random rand = new Random(); // 랜덤객체 생성
		return CHARACTERS[rand.nextInt(CHARACTERS.length)]; // 3마리의 캐릭터 중 하나를 랜덤으로 골라 이름을 리턴 
															// -> 결과를 상위클래스의 생성자로 넘김
	}
}
