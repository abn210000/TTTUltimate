// Allison Nguyen CS 2336.001

// Purpose: We must create an Ultimate Tic Tac Toe Game in the Console
// Analysis: Using OOP, we must create objects to create an Ultimate Tic Tac Toe Game, where each move is based on your opponents previous
// Design: To create the structure of the WholeBoard, we create an array of 9 BoardUlt objects that each have an array of 9 BoxUlt objects.
// We then create the HumanPlayer class and ComputerPlayer class to hold the attributes of each type of player. While running the DriverMainUlt, 
// the user is prompted to choose which game mode they would like to play. If the user chooses any AI, then each move is placed with random number generators,
// if the user chooses any Player versions, each move is made with given input for the board (if permissible), row, and column. When a move is made, a mark will 
// be placed in the desired small box (every move is based on the opponents previous move). After each move, the game checks if there is a winner as well as if the
// next mandatory board choice is full. If there is a winner, the game ends. If the next mandatory board choice is full, then the next player has a choice to
// place on any board of their desire.




import java.util.InputMismatchException;
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
		
		// input validate if input is incorrect type or out of range
		boolean valid = false;
		while(!valid) {
			
			try {
				gameMode = input.nextInt();
				
				// if gameMode is in range, return
				if(gameMode >= 1 && gameMode <= 3) {
					valid = true;
				}
				else {
					System.out.println("Please valid choice (1-3)");
				}
			}
			catch (InputMismatchException e){
				System.out.println("Please valid choice (1-3)");
				input.next();
				
			}
		}
		while(gameMode < 1 || gameMode > 3);
		
		switch(gameMode) {
			// AI VS AI
			case 1:
				AIVSAI game0 = new AIVSAI();
				game0.start();
				break;
				
			// Player VS Player
			case 2:
				PlayerVSPlayer game1 = new PlayerVSPlayer();
				game1.start();
				break;	
				
			// Player VS AI
			case 3:
				PlayerVSAI game2 = new PlayerVSAI();
				game2.start();
				break;
		
		
			}
		}
	}
