package controller;
// ³ª´Â ÄÄ
import model.Character;
import model.RandomCharacter;

public class TamagochiController {
    private Character character;
    private int difficultyLevel;

    public void createCharacter() {
        character = new RandomCharacter();
    }

    public void setDifficultyLevel(int level) {
        this.difficultyLevel = level;
    }

    public Character getCharacter() {
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
}
