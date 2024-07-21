package model.vo;

import java.io.Serializable;

public abstract class TamagochiCharacter implements Serializable {
	protected String name;
	protected int hunger;
	protected int cleanliness;
	protected int happiness;
	protected boolean alive;

	public TamagochiCharacter(String name) {
		this.name = name;
		this.hunger = 100;
		this.cleanliness = 100;
		this.happiness = 100;
		this.alive = true;
	}

	public void passTime(int difficulty) {
		hunger -= 5 * difficulty;
		cleanliness -= 5 * difficulty;
		happiness -= 5 * difficulty;
		checkAlive();
	}

	public void feed() {
		hunger = Math.min(100, hunger + 20);
	}

	public void clean() {
		cleanliness = Math.min(100, cleanliness + 20);
	}

	public void walk() {
		happiness = Math.min(100, happiness + 20);
		cleanliness = Math.max(0, cleanliness - 10);
	}

	public void checkAlive() {
		if (hunger <= 0 || cleanliness <= 0 || happiness <= 0) {
			alive = false;
			System.out.println(name + "는 죽었습니다.");
		}
	}

	public String getStatus() {
		return name + "는 현재 배고픔 : " + hunger + ", 청결도 : " + cleanliness + ", 행복도 : " + happiness + ", 생존 : " + alive;

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
	
	
}
