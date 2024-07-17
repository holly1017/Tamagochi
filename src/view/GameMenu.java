package view;

import java.util.Scanner;
import controller.TamagochiController;

public class GameMenu {
    TamagochiController tc = new TamagochiController();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        while (true) {
            System.out.println("******** Welcome to Tamagochi Game! ********");
            // ���� ���̵��� �Է� ����
            System.out.print("- ���̵��� ����ּ���( 1 / 2 / 3 ) : ");
            int level = sc.nextInt();
            sc.nextLine();
            tc.setDifficultyLevel(level);

            System.out.print("ĳ���͸� �����Ͻðڽ��ϱ�? ( y / n ) : ");
            char reply = sc.nextLine().charAt(0);
            if (reply == 'y' || reply == 'Y') {
                // ĳ���͸� ����
                tc.createCharacter();
            } else {
                System.out.println("������ �����մϴ�.");
                return;
            }

            // �������� ������ �ٸ���ġ�� �̸��� ����ϱ�
            System.out.println("����� �ٸ���ġ�� " + tc.getCharacter().getName() + "�Դϴ�.");
            gameLoop();
        }
    }

    private void gameLoop() {
        while (!tc.isGameOver()) {
            displayStatus();
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            handleMenuChoice(choice);
            tc.passTime();
        }
        System.out.println("����� �ٸ���ġ�� �׾����ϴ�.");
    }

    private void displayStatus() {
        System.out.println(tc.getCharacter().getStatus());
    }

    private void displayMenu() {
        System.out.println("1. �� �ֱ�");
        System.out.println("2. �ı��");
        System.out.println("3. ��å�ϱ�");
        System.out.println("4. �����ϱ�");
        System.out.println("5. ���� �����ϱ�");
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                tc.feedCharacter();
                break;
            case 2:
                tc.cleanCharacter();
                break;
            case 3:
                tc.walkCharacter();
                break;
            case 4:
                saveGame();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("�ٽ� �������ּ���.");
        }
    }

    private void saveGame() {
        // Implement game saving logic here
        System.out.println("����Ǿ����ϴ�.");
    }

    public static void main(String[] args) {
        GameMenu gameMenu = new GameMenu();
        gameMenu.mainMenu();
    }
}
