// Allison Nguyen CS 2336.001

// Analysis: We must create an Ultimate Tic Tac Toe Game in the Console



import java.util.Scanner;

public class DriverMainUlt {

	public static void main(String[] args) {
		
		// introduction and prompt user for choice
		System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME! =====");
		System.out.println("What version would you like to play? (1-3)");
		
		System.out.println("1. AI vs AI");
		System.out.println("2. Player vs Player");
		System.out.println("3. Player vs AI");
		
		int gameMode = 0;
		Scanner input = new Scanner(System.in);
		gameMode = input.nextInt();
		
		switch(gameMode) {
			// AI VS AI
			case 1:
				TTTUltimateGame game0 = new TTTUltimateGame();
				game0.start();
				break;
				
			// Player VS Player
			case 2:
				TTTUltimateGame1 game1 = new TTTUltimateGame1();
				game1.start();
				break;	
				
			// Player VS AI
			case 3:
				TTTUltimateGame2 game2 = new TTTUltimateGame2();
				game2.start();
				break;
		
		
		
		
		}
	}
	
}
