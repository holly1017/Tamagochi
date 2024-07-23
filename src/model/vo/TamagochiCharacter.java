package model.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class TamagochiCharacter implements Serializable {
	protected String name;
	protected int hunger;
	protected int cleanliness;
	protected int happiness;
	protected int affection;
	protected boolean alive;
	protected boolean hasPoop;
	protected int mealCount;
	protected Map<String, Snack> snacks;

	public TamagochiCharacter(String name) {
		this.name = name;
		this.hunger = 100;
		this.cleanliness = 100;
		this.happiness = 100;
		this.affection = 50;
		this.alive = true;
		this.hasPoop = false;
		this.mealCount = 0;
		this.snacks = new HashMap<>();
	}

	public void passTime(int difficulty) {
		hunger -= 3 * difficulty;
		cleanliness -= 3 * difficulty;
		happiness -= 3 * difficulty;
		affection -= 1 * difficulty;
		checkAlive();
	}

	public void feed() {
		hunger = Math.min(100, hunger + 20);
		affection = Math.min(150, affection + 5);
		mealCount++;
	}

	public void clean() {
		cleanliness = Math.min(100, cleanliness + 20);
	}

	public void goBathroom() {
		checkPoop();
		if (hasPoop) {
			cleanliness = Math.min(100, cleanliness + 20);
			hasPoop = false;
		} else {
			happiness = Math.max(0, happiness - 10);
		}
	}

	public void walk() {
		happiness = Math.min(100, happiness + 20);
		cleanliness = Math.max(0, cleanliness - 10);
		affection = Math.min(150, affection + 5);
		checkForSnack();
	}

	public void play() {
		happiness = Math.min(100, happiness + 20);
		affection = Math.min(150, affection + 5);
	}

	public void giveSnack(Snack snack) {
		hunger = Math.min(100, hunger + snack.getHungerBoost());

		snack.decreaseCount();
		if (snack.getCount() <= 0) {
			snacks.remove(snack.getName());
		}
	}

	private void checkPoop() {
		if (mealCount >= 3) {
			hasPoop = true;
			mealCount -= 3;
		}
	}

	private void checkForSnack() { // 산책 메소드에서 호출 될 메소드
		Random rand = new Random(); // Random -> 난수 생성 메소드 제공 클래스
		if (rand.nextInt(100) < 30) { 
			// nextInt(int bound) -> 0부터 bound - 1까지의 정수를 랜덤하게 생성 
			// 0~99까지 생성 / 조건 : 30보다 작을 때 실행 --> 30% 확률로 간식 발견
			Snack snack = generateRandomSnack(); // 랜덤 간식 객체 생성
			String snackName = snack.getName(); 
			if (snacks.containsKey(snackName)) { // 가지고 있는 간식이라면
				snacks.get(snackName).increaseCount(); // 갯수만 증가
			} else { // 가지고 있지 않다면
				snacks.put(snackName, snack); // 새롭게 저장
			}
			System.out.println(name + "가 공원에서 " + snack.getName() + "를 발견했습니다!");
		}
	}

	private Snack generateRandomSnack() { // 간식 랜덤 생성 메소드
		Random rand = new Random();
		int snackType = rand.nextInt(3); // 0부터 2까지의 정수를 랜덤하게 생성
		switch (snackType) { // 생성되는 정수에 따라 발견되는 간식 인스턴스 생성
		case 0:
			return new Snack("초콜릿", 15, 1);
		case 1:
			return new Snack("사과", 10, 1);
		case 2:
			return new Snack("쿠키", 20, 1);
		default:
			return null;
		}
	}

	public void checkAlive() {
		if (hunger <= 0 || cleanliness <= 0 || happiness <= 0 || affection <= 0) {
			alive = false;
			System.out.println("\n--------------------BAD ENDING--------------------");
			System.out.println(name + "는 죽었습니다.");
			System.out.println("\n--------------------------------------------------");
		} else if (affection >= 100) {
			System.out.println("-------------------HAPPY ENDING-------------------");
			System.out.println(name + "는 애정도가 가득 차서 다른 다마고치와 결혼했습니다!");
			System.out.println("--------------------------------------------------");
			alive = false;
		}
	}

	public String getStatus() {
		return String.format(
				"---------------------------------------\n" + "%s의 현재 상태\n"
						+ "배고픔: %d 🍔 | 청결도: %d 🛁 | 행복도: %d 😃 | 애정도: %d 💖\n" + "생존 상태: %s\n"
						+ "---------------------------------------",
				name, hunger, cleanliness, happiness, affection, alive ? "생존" : "죽음");
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean hasPoop() {
		return hasPoop;
	}

	public Map<String, Snack> getSnacks() {
		return snacks;
	}
}
