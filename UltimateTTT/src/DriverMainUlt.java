import java.util.Scanner;
public class DriverMainUlt {

	public static void main(String[] args) {
		
		// introduction and prompt user for choice
		System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME! =====");
		System.out.println("What version would you like to play? (1-3)");
		System.out.println("1. Player vs AI");
		System.out.println("2. AI vs AI");
		System.out.println("3. Player vs Player");
		
		int gameMode = 0;
		Scanner input = new Scanner(System.in);
		gameMode = input.nextInt();
		
		switch(gameMode) {
		
		case 1:
			TTTUltimateGame game1 = new TTTUltimateGame();
			game1.start();
			break;
		
		
		case 2:
			TTTUltimateGame game2 = new TTTUltimateGame();
			game2.start();
			break;
		case 3:
			TTTUltimateGame game3 = new TTTUltimateGame();
			game3.start();
			break;
		}
	}
		

}
