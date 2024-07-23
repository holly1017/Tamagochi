package view;

import java.util.Map;
import java.util.Scanner;

import controller.TamagochiController;
import model.vo.Snack;
import model.vo.TamagochiCharacter;

public class GameMenu {
	private TamagochiController tc = new TamagochiController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			System.out.println("******** Welcome to Tamagochi Game! ********");
			// 사용자 이름 입력 받기
			System.out.print("사용자의 이름을 입력하세요: ");
			String userName = sc.nextLine();

			// 사용자 캐릭터 로드 시도
			boolean isSaved = tc.readState(userName);

			if (!isSaved) {
				// 게임 난이도를 입력 받음
				System.out.print("- 난이도를 골라주세요( 1 / 2 / 3 ) : ");
				int level = sc.nextInt();
				sc.nextLine();
				tc.setDifficultyLevel(level);

				System.out.print("캐릭터를 생성하시겠습니까? ( y / n ) : ");
				char reply = sc.nextLine().charAt(0);
				if (reply == 'y' || reply == 'Y') {
					// 캐릭터를 생성
					tc.createCharacter();
				} else {
					System.out.println("게임을 종료합니다.");
					return;
				}

				// 랜덤으로 생성된 다마고치의 이름을 출력하기
				String name = tc.getCharacter().getName();
				System.out.println("당신의 다마고치는 " + name + "입니다.");
				displayCharacter(name);
				gameLoop(userName);
				return;
			} else {
				String name = tc.getCharacter().getName();
				System.out.println(userName + "님의 기존 다마고치는 " + name + "입니다.");
				displayCharacter(name);
				gameLoop(userName);
				return;
			}

		}
	}

	private void displayCharacter(String name) {
		switch (name) {
		case "Mametchi":
			System.out.println("" + "        %%#######%%               @%%%@           \r\n"
					+ "      %#**#%%%%%%%#%@          %#***#####%        \r\n"
					+ "     %#*#%%%%%%%%%%%#%       %#*#%%%%%%%%%#%      \r\n"
					+ "    %#*#%%%%%%%%%%%%%#      @#*#%%%%%%%%%%%%%     \r\n"
					+ "    %#*%%%%%%%%%%%%%%#@     ##*%%%%%%%%%%%%%%%    \r\n"
					+ "    %*#%%%%%%%%%%%%%%#@     #*#%%%%%%%%%%%%%%%    \r\n"
					+ "    %*#%%%%%%%%%%%%%%%@    %%*%%%%%%%%%%%%%%#%    \r\n"
					+ "    %*#%%%%%%%%%%%%%%%     @%*%%%%%%%%%%%%%%#%    \r\n"
					+ "    %*#%%%%%%%%%%%%%%########*%%%%%%%%%%%%%%#@    \r\n"
					+ "    %**%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#@    \r\n"
					+ "    %*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@   \r\n"
					+ "  @%*#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@  \r\n"
					+ "  %*#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@ \r\n"
					+ " %%#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#% \r\n"
					+ "@+:......:------:.............................:=#%\r\n"
					+ "#=....:%%%+-%%#%%#+..............%%%*-=%%#*-....=#\r\n"
					+ "#:...:%..=. .=%%%%%%:..........-%%%:. .%%%%%*:..:#\r\n"
					+ "#....%: :+.:=%%%%#%%*.........-%%%:..:#%%%%%%+...*\r\n"
					+ "*...:%% -%%#%%%%%#*%+.........%. *%##%%%%%%#%#...*\r\n"
					+ "*....%: :%#*%%%%#**#..........%: *%%#%%%%%%*%*...*\r\n"
					+ "#.....%-:=#%%%%%%%%:...........%:=%%%%###%%%#:...#\r\n"
					+ "#-..:::::%%%%%%%%%..............%%%%%%%%%%#+:...-#\r\n"
					+ "%+.:-----.................................::::.:+@\r\n"
					+ " %=...::.................................:----:=% \r\n"
					+ "  %*-...............%%.....%%:...............:*%  \r\n"
					+ "    %#=:..............%%%%.................:*%    \r\n"
					+ "       %*+=-::.........................:-+%%      \r\n"
					+ "          @%%#***++=--::::::::---=+**#%@          \r\n"
					+ "             %#.::-----------------#@             \r\n"
					+ "            #=..:=:......:::::::....-#            \r\n"
					+ "           %-...-=.............:=:...:#           \r\n"
					+ "          %=...=#:...............*+....%          \r\n"
					+ "           %*#% *...............:+ @%*%%          \r\n"
					+ "               @=...............:+                \r\n"
					+ "               %:...............:+                \r\n"
					+ "               %................-*                \r\n"
					+ "               %...:=*++++++-...=#                \r\n"
					+ "               %-.:=%       *-..=%                \r\n"
					+ "                #=#@         #+=%                 ");
			break;
		case "Kuchipatchi":
			System.out.println("" + "               %%%%%%%%%%%%%%%%%%%               \r\n"
					+ "           %%%%#*++++++++++++++++*#%%%            \r\n"
					+ "         %%%+++++++++++++++++++++++++*%%          \r\n"
					+ "        %#+++++++++++++++++++++++++++++#%%        \r\n"
					+ "      %%#++#%#*+++++++++++++++++++#%%%*+*%%       \r\n"
					+ "      %#++#%%%%+++++++++++++++++++#%%%%+++%%      \r\n"
					+ "     %%++++%%%#+++*##%%%%%%%%#**+++*##*+++#%      \r\n"
					+ "     %%++++++++#%*+++++++++++++*%#+++++++++%%     \r\n"
					+ "     %#++====++%*+++++++++++++++*%++=====++%%     \r\n"
					+ "     %#=======+%#***************%#+=======+#%     \r\n"
					+ "     %#========%%**************#%*+=======+%%     \r\n"
					+ "     %%+======*%++++++++++++++++*%++=====++%%     \r\n"
					+ "     %%++++++++%#++++++++++++++*%#+++++++++%%     \r\n"
					+ "     %%%++++++++*#%%%%%%%%%%##**+++++++++++#%%    \r\n"
					+ "    %%+++++++++++++++++++++++++++++++++++++++#%   \r\n"
					+ "  %%#++++++++++++++++++++++++++++++++++++++%*+*%% \r\n"
					+ " %%++*%++++++++++++++++++++++++++++++++++++##++*%%\r\n"
					+ "%%+++##+++++++++++++++++++++++++++++++++++++%*++#%\r\n"
					+ "%*+++%*+++++++++++++++++++++++++++++++++++++##++*%\r\n"
					+ "%#+++%*+++++++++++++++++++++++++++++++++++++*%#%%%\r\n"
					+ " %%%%%*++++++++++++++++++++++++++++++++++++++%%   \r\n"
					+ "     %#++++++++++++++++++++++++++++++++++++++%%   \r\n"
					+ "     %%+++++++++++++++++++++++++++++++++++++#%    \r\n"
					+ "      %%+++++++++++++++++++++++++++++++++++#%     \r\n"
					+ "       %%*+++++++++++++++++++++++++++++++#%%      \r\n"
					+ "         %%%#*+++++++++++++++++++++*##%%%%        \r\n"
					+ "          %*+*##%%%%%%%%%%%%%%%%##*++++*%         \r\n"
					+ "          %%++++++++%%       %%++++++++%%         \r\n"
					+ "           %%%%%%%%%%         %%%%%%%%%%    ");
			break;
		case "Memetchi":
			System.out.println("" + "                  %%%%%%%%%%%                     \r\n"
					+ "                %%%%        %%%%                  \r\n"
					+ "               %%             %%%                 \r\n"
					+ "              %%       %%%%     %%                \r\n"
					+ "             %%%    %%%%  %%%    %%               \r\n"
					+ "             %%   %%%  %%%  %%   %%               \r\n"
					+ "             %%   %%   %%%% %%   %%               \r\n"
					+ "              %%  %%    %%%%%%  %%%               \r\n"
					+ "              %%%  %%%        %%%%                \r\n"
					+ "              %%%%%%%%%%%%%%%%%%%%%%%             \r\n"
					+ "          %%%#++==*#%%#*============+#%%%         \r\n"
					+ "       %%#+=============================+#%%      \r\n"
					+ "     %%*+==================================*%%    \r\n"
					+ "   %%#====++=================================#%%  \r\n"
					+ "  %%+==##=*%+=%*===================*%+=**=====*%% \r\n"
					+ " %%+===##=*%*+%+===================*%+=%*=##===+%%\r\n"
					+ "%%+====*%%%%+#%%#=================+#%#%%+*%+====#%\r\n"
					+ "%#=====*%%%%-%%%%+===============*%%%-#%%%+=====*%\r\n"
					+ "%*====+%%%%+-*%%%*==============*%%%#-%%%%+=====*%\r\n"
					+ "%*====*%%%+--#%%%*=============+%%#+--#%%%*=====*%\r\n"
					+ "%*====+%%%%+%%%%#+==============#%%%+-+#%%#=====#%\r\n"
					+ "%#=====+#%%#%%%*================+%%%##%%%%+====+%%\r\n"
					+ "%%+======*%*%#%+=================+%%%%%%%+====+%% \r\n"
					+ " %%+=====**++====================#*%*%*======+%%  \r\n"
					+ "  %%+================================**=====*%%   \r\n"
					+ "   %%*==========+*%%=========%%+==========+%%     \r\n"
					+ "     %%*+============%%%%%%++===========+%%%      \r\n"
					+ "       %%%%#++=======================+*%%         \r\n"
					+ "            %%%%%%*+==============+%%%%           \r\n"
					+ "                  %%#============#%               \r\n"
					+ "                   %%#+=========+%%               \r\n"
					+ "                  %%%%*+==++==+#%%%%              \r\n"
					+ "                  %%  %%%%%%%%%                   \r\n"
					+ "                        %%   %%                   \r\n"
					+ "                        %%   %%                   ");
			break;
		default:
			break;
		}
	}

	private void gameLoop(String userName) {
		while (!tc.isGameOver()) {
			System.out.println(tc.getCharacterStatus());
			displayMenu();
			System.out.print("다마고치와 무엇을 하시겠습니까? : ");
			int choice = sc.nextInt();
			sc.nextLine();
			handleMenuChoice(choice, userName);
			if (choice == 8) { // 게임 종료하기
				System.out.println("게임을 종료합니다.");
				return;
			}

			if (choice != 7) { // 저장하기 선택이 아닌 경우에만 시간 경과 처리
				tc.passTime();
			}

			if (tc.isGameOver()) { // 시간이 경과한 후 캐릭터가 죽었는지 확인
				System.out.println("Game over.");
				tc.deleteState(userName);
				return;
			}
		}
	}

	private void displayMenu() {
		System.out.println("1. 밥 주기");
		System.out.println("2. 씻기기");
		System.out.println("3. 화장실 가기");
		System.out.println("4. 산책하기");
		System.out.println("5. 놀아주기");
		System.out.println("6. 간식 먹이기");
		System.out.println("7. 저장하기");
		System.out.println("8. 게임 종료하기");
	}

	private void handleMenuChoice(int choice, String userName) {
		TamagochiCharacter character = tc.getCharacter();
		switch (choice) {
		case 1:
			tc.feedCharacter();
			System.out.println(character.getName() + "에게 밥을 먹였습니다.");
			break;
		case 2:
			tc.cleanCharacter();
			System.out.println(character.getName() + "를 씻겼습니다.");
			break;
		case 3:
			tc.goBathroom();
			if (character.hasPoop()) {
				System.out.println(character.getName() + "가 화장실에 갔습니다.");
			} else {
				System.out.println(character.getName() + "가 화장실에 갔지만 응가가 없었습니다.");
			}
			break;
		case 4:
			tc.walkCharacter();
			System.out.println(character.getName() + "와 산책을 했습니다.");
			break;
		case 5:
			tc.playWithCharacter();
			System.out.println(character.getName() + "와 놀아주었습니다.");
			break;
		case 6:
			Map<String, Snack> snacks = tc.getSnacks();
			if (snacks.isEmpty()) {
				System.out.println("보관된 간식이 없습니다.");
			} else {
				System.out.println("----- 보관된 간식 목록 -----");
				int index = 1;
				for (String snackName : snacks.keySet()) {
					Snack snack = snacks.get(snackName);
					System.out.println(index + ". " + snackName + " (개수: " + snack.getCount() + ")");
					index++;
				}
				System.out.println("------------------------");
				System.out.print("간식을 선택하세요 (간식 이름 입력): ");
				String snackChoice = sc.nextLine().trim();
				if (snacks.containsKey(snackChoice)) {
					tc.giveSnack(snacks.get(snackChoice));
					System.out.println("간식을 먹였습니다.");
				} else {
					System.out.println("다시 선택해주세요.");
				}
			}
			break;
		case 7:
			tc.saveState(userName);
			System.out.println("저장되었습니다.");
			return;
		case 8:
			return;
		default:
			System.out.println("다시 선택해주세요.");
			break;
		}
	}

}
