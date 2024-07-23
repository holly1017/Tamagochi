package model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.TamagochiController;
import model.vo.TamagochiCharacter;

public class CharacterDAO {

	public void saveState(TamagochiCharacter character, int difficultyLevel, String userName) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userName + "_character.txt"))) {
			oos.writeInt(difficultyLevel); // 난이도 저장
			oos.writeObject(character); // 캐릭터 상태 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean readState(String userName, TamagochiController tc) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userName + "_character.txt"))) {
			int difficultyLevel = ois.readInt(); // 난이도 복원
			TamagochiCharacter character = (TamagochiCharacter) ois.readObject(); // 캐릭터 상태 복원
			tc.setDifficultyLevel(difficultyLevel); // 난이도 설정
			tc.setCharacter(character); // 캐릭터 설정
			return true;
		} catch (EOFException e) {

		} catch (FileNotFoundException e) {
			System.out.println("저장된 사용자가 없습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteState(String userName) {
		File file = new File(userName + "_character.dat");
		if (file.exists()) {
			file.delete();
		}
	}
}
