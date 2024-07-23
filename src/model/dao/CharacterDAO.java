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
		// 캐릭터의 정보와, 설정한 난이도 레벨, 사용자의 이름을 매개변수로 한 저장 메소드
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userName + "_character.txt"))) {
			// 사용자의 이름으로 저장파일 생성
			oos.writeInt(difficultyLevel); // 난이도 저장
			oos.writeObject(character); // 캐릭터 상태 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean readState(String userName, TamagochiController tc) {
		// 사용자의 이름, 컨트롤러의 객체를 매개변수로 받는 불러오기 메소드
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userName + "_character.txt"))) {
			// 사용자의 이름으로 저장된 파일에서 읽어옴
			int difficultyLevel = ois.readInt(); // 난이도 읽어오기
			TamagochiCharacter character = (TamagochiCharacter) ois.readObject(); // 캐릭터 상태 객체 읽어오기
			tc.setDifficultyLevel(difficultyLevel); // 읽어온 난이도로 설정
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

	public void deleteState(String userName) { // 엔딩을 볼 시 저장되어있는 기록을 삭제하기 위한 메소드
		// 사용자의 이름을 매개변수로 받는 파일 삭제 메소드
		File file = new File(userName + "_character.txt"); // 사용자의 이름으로 파일 객체 생성
		if (file.exists()) { // 파일이 존재한다면 삭제
			file.delete();
		}
	}
}
