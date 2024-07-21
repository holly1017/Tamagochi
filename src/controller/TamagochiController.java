package controller;

import model.dao.CharacterDAO;
import model.vo.RandomCharacter;
import model.vo.TamagochiCharacter;

public class TamagochiController {
	private TamagochiCharacter character;
	private int difficultyLevel;
	private CharacterDAO cd = new CharacterDAO();

	public void createCharacter(String userName) {
		character = new RandomCharacter();
	}

	public void setDifficultyLevel(int level) {
		this.difficultyLevel = level;
	}

	public TamagochiCharacter getCharacter() {
		return character;
	}

	public boolean isGameOver() {
		return !character.isAlive();
	}

	public void passTime() {
		character.passTime(difficultyLevel);
	}

	public void feedCharacter() {
		character.feed();
	}

	public void cleanCharacter() {
		character.clean();
	}

	public void walkCharacter() {
		character.walk();
	}

	public String getCharacterStatus() {
		return character.getStatus();
	}

	public void saveState(String userName) {
        cd.saveState(character, difficultyLevel, userName);
    }

	public boolean readState(String userName) {
        return cd.readState(userName, this);
    }
	public void setCharacter(TamagochiCharacter character) {
	    this.character = character;
	}

	public void deleteState(String userName) {
		cd.deleteState(userName);
	}


}
