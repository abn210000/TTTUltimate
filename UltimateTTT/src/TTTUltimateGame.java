public class TTTUltimateGame {
	private ComputerPlayer[] players = new ComputerPlayer[2];
	private BoardUlt board;
	private WholeBoard wholeBoard;
	
	private String[] marks = {"X", "O"};
	private String name = "TicTacToe";
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	
	private int currentPlayerIndex = -1;
	private int currentBoard = 0;
	
	
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
	
	
	public void start() {
		System.out.println("game has started...");
		do {
			switchPlayer();
			
			while(!wholeBoard.makeMove(players[this.currentPlayerIndex].getSymbol(), // mark
					players[this.currentPlayerIndex].randomNumber(gameRowSize),	// random row
					players[this.currentPlayerIndex].randomNumber(gameColSize), // random col
					players[this.currentPlayerIndex].randomNumber(9)));			// random board
				
			
				print(currentBoard);
		}while(!boardOver());
	}
	
	void print(int currentBoard) {
		/*
		board.printRow0(currentBoard);
		System.out.println("");
		board.printRow1(currentBoard);
		System.out.println("");
		board.printRow2(currentBoard);
		System.out.println("");
		System.out.println("");
		*/
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
	
	// when board is full or there is a winner
	private boolean boardOver() {
		if (isWinner()) {
			System.out.println(this.marks[this.currentPlayerIndex] + " is the winner!");
			return true;
		}
		else if (wholeBoard.isFull()){
			System.out.println("Tie!");
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isWinner() {
		if (checkRows()) {
			return true;
		}
		else if(checkCols()) {
			return true;
		}
		else if (checkDiagLR()) {
			return true;
		}
		else if (checkDiagRL()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkCols() {
		for (int col = 0; col < this.gameColSize; col++) {
			if (checkCol(col)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkCol(int col)	{
		int count = 0;
		for (int row = 0; row < this.gameRowSize; row++) {
			if (wholeBoard.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
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
	
	private boolean checkRows() {
		for (int row = 0; row < this.gameRowSize; row++) {
			if (checkRow(row)) {
				return true;
			}
		}
		return false;
	}
	private boolean checkRow(int row) {
		int count = 0;
		for (int col = 0; col < this.gameColSize; col++) {
			if (wholeBoard.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			if (count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDiagLR() {
		int count = 0;
		for (int row = 0, col = this.gameRowSize - 1; row < this.gameColSize && col >= 0; row++, col--) {
			if (wholeBoard.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			if (count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDiagRL() {
		int count = 0;
		for (int col = 0, row = 0; col < this.gameColSize && row < this.gameRowSize; col++, row++) {
			if (wholeBoard.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			
			if(count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}
}