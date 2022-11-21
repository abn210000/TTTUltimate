import java.util.LinkedList;

public class TTTUltimateGame {
	private ComputerPlayer[] players = new ComputerPlayer[2];
	private WholeBoard wholeBoard;
	
	private String[] marks = {"X", "O"};
	private String name = "TicTacToe";
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	
	private int currentPlayerIndex = 0;
	private int currentBoard = 0;
	
	public int lastMove = 0;
	
	
	// constructor
	public TTTUltimateGame() {
		setPlayers();
		setBoard();
	}
	
	// create game board
	private void setBoard() {
		this.wholeBoard = new WholeBoard(gameRowSize, gameColSize);
	}
	
	
	private void setPlayers() {
		for (int i = 0; i < players.length; i++) {
			ComputerPlayer p = new ComputerPlayer("player" + i+1, marks[i]);
			players[i] = p;
		}
	}
	
	int count = 0;
	public void start() {
		
		System.out.println("game has started...");
		do {
				switchPlayer();
				// while loop to alternate player moves, passing in random row, col and board num
				while(!wholeBoard.makeMove(players[this.currentPlayerIndex].getSymbol(),// mark
						players[this.currentPlayerIndex].randomNumber(gameRowSize),	// random row
						players[this.currentPlayerIndex].randomNumber(gameColSize), // random col
						players[this.currentPlayerIndex].randomNumber(9), count));	// random board
						
						System.out.println("count == " + count);
						count++;
					print(currentBoard);
				
			
			
		}while(!GAMEOVER());
	}
	
	
	
	void print(int currentBoard) {
		
		wholeBoard.print(currentBoard);
	}
	
	
	
	// this method switches the players
	private void switchPlayer() {
		if (this.currentPlayerIndex == -1 || this.currentPlayerIndex == 1) {
			this.currentPlayerIndex = 0;
		}
		else {
			this.currentPlayerIndex = 1;
		}
	}
	
	

	boolean GAMEOVER() {
		
		if(checkWholeBoard(wonBoards)) {
			System.out.println(this.marks[this.currentPlayerIndex] + " is the winner!");
			return true;
		}
		else if (count == 81) {
			System.out.println("TIE");
			return true;
		}
		return false;
	}
	
	// create a new array and initialize with 9s
	String[] wonBoards = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
	
	//LinkedList<Integer> wonBoards = new LinkedList<Integer>();
	
	boolean checkWholeBoard(String[] wonBoards) {
		
		checkSmallWinLoop();
		if(wonBoards[0] == players[currentPlayerIndex].getSymbol() && wonBoards[1] == players[currentPlayerIndex].getSymbol() && wonBoards[2] == players[currentPlayerIndex].getSymbol()) {
			return true;
		}
		else if(wonBoards[3] == players[currentPlayerIndex].getSymbol() && wonBoards[4] == players[currentPlayerIndex].getSymbol() && wonBoards[5] == players[currentPlayerIndex].getSymbol()) {
			return true;
		}
		else if(wonBoards[6] == players[currentPlayerIndex].getSymbol() && wonBoards[7] == players[currentPlayerIndex].getSymbol() && wonBoards[8] == players[currentPlayerIndex].getSymbol())  {
			return true;
		}
		else if(wonBoards[0] == players[currentPlayerIndex].getSymbol() && wonBoards[3] == players[currentPlayerIndex].getSymbol() && wonBoards[6] == players[currentPlayerIndex].getSymbol()) {
			return true;
		}
		else if (wonBoards[1] == players[currentPlayerIndex].getSymbol() && wonBoards[4] == players[currentPlayerIndex].getSymbol() && wonBoards[7] == players[currentPlayerIndex].getSymbol()) {
			return true;
		}
		else if (wonBoards[2] == players[currentPlayerIndex].getSymbol() && wonBoards[5] == players[currentPlayerIndex].getSymbol() && wonBoards[8] == players[currentPlayerIndex].getSymbol()){
			return true;
		}
		else if(wonBoards[0] == players[currentPlayerIndex].getSymbol() && wonBoards[4] == players[currentPlayerIndex].getSymbol() && wonBoards[8] == players[currentPlayerIndex].getSymbol())  {
			return true;
		}
		else if(wonBoards[2] == players[currentPlayerIndex].getSymbol() && wonBoards[4] == players[currentPlayerIndex].getSymbol() && wonBoards[6] == players[currentPlayerIndex].getSymbol())  {
			return true;
		}
		
		for(int i = 0; i < 9; i++) {
			System.out.print(wonBoards[i]);
			
		}
		return false;
		// if(wonBoards[0] == wonBoards[1] == wonBoards[2]
	}
	
	
	void checkSmallWinLoop() {
		// iterate through each small board
		for(int smallBoard = 0; smallBoard < 9; smallBoard++) {
			// if current player mark is X and there is NOT an 0 already in wonboards[smallBoards], place mark
			if(wonBoards[smallBoard] != "O" && players[currentPlayerIndex].getSymbol() == "X") {
				if(checkSmallBoardWin(smallBoard) == true) {
					// if the opposing board has NOT already placed there, may place own mark
					
						wonBoards[smallBoard] = players[currentPlayerIndex].getSymbol();
				}
			}
			else if(wonBoards[smallBoard] != "X" && players[currentPlayerIndex].getSymbol() == "O") {
				if(checkSmallBoardWin(smallBoard) == true) {
					wonBoards[smallBoard] = players[currentPlayerIndex].getSymbol();
				}
			}
				
			
		}
	}
	
	// check small board win
	boolean checkSmallBoardWin(int smallBoard) {
			if(checkSmallRows(smallBoard)) {
				
				System.out.println("3 in a row on board" + smallBoard);
				
				return true;
			}
			else if(checkSmallCols(smallBoard)) {
			
				System.out.println("3 in a rol on board" + smallBoard);
				return true;
			}
			else if(checkSmallDiagLR(smallBoard)) {
				
				System.out.println("3 in a diag LR on board" + smallBoard);
				return true;
			}
			else if(checkSmallDiagRL(smallBoard)) {
				
				System.out.println("3 in a diag RL on board" + smallBoard);
				return true;
			}
		
		return false;
	}
	
	// check if a row has been won
	boolean checkSmallRows(int smallBoard) {
		for(int row = 0; row < 3; row++) {
			if(checkEachRow(row, smallBoard)) {
				return true;
			}
		}
		return false;
	}
	
	// check each row
	boolean checkEachRow(int row, int smallBoard) {
		int count = 0;
		for (int col = 0; col < this.gameColSize; col++) {
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			if (count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}
	
	
	// check for win in cols
	boolean checkSmallCols(int smallBoard) {
		for(int col = 0; col < 3; col++) {
			if(checkEachCol(col, smallBoard)) {
				return true;
			}
		}
		return false;
	}
	
	// check each col
	boolean checkEachCol(int col, int smallBoard) {
		int count = 0;
		for (int row = 0; row < this.gameRowSize; row++) {
			
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			
		}
		if (count == this.gameScoreToWin) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	boolean checkSmallDiagLR(int smallBoard) {
		int count = 0;
		for (int row = 0, col = this.gameRowSize - 1; row < this.gameColSize && col >= 0; row++, col--) {
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			if (count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}
	
	boolean checkSmallDiagRL(int smallBoard) {
		int count = 0;
		for (int col = 0, row = 0; col < this.gameColSize && row < this.gameRowSize; col++, row++) {
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			
			if(count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}
	
}