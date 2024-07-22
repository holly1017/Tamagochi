package controller;

import model.dao.CharacterDAO;
import model.vo.RandomCharacter;
import model.vo.Snack;
import model.vo.TamagochiCharacter;

import java.util.List;
import java.util.Map;

public class TamagochiController {
    private TamagochiCharacter character;
    private int difficultyLevel;
    private CharacterDAO cd = new CharacterDAO();

    public void createCharacter() {
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
    
    public void goBathroom() {
        character.goBathroom();
    }

    public void walkCharacter() {
        character.walk();
    }

    public void playWithCharacter() {
        character.play();
    }

   public void giveSnack(Snack snack) {
	   character.giveSnack(snack);
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

    public void deleteState(String userName) {
        cd.deleteState(userName);
    }

    public Map<String, Snack> getSnacks() {
        return character.getSnacks();
    }

	public void setCharacter(TamagochiCharacter character) {
		this.character = character;
	}
}
