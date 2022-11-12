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
	
	
	// constructor
	public TTTUltimateGame() {
		setPlayers();
		setBoard();
	}
	
	// create game board
	private void setBoard() {
		this.wholeBoard = new WholeBoard(gameRowSize, gameColSize);
		//this.board = new BoardUlt(gameRowSize, gameColSize, "TTT Game");
	}
	
	
	private void setPlayers() {
		for (int i = 0; i < players.length; i++) {
			ComputerPlayer p = new ComputerPlayer("player" + i+1, marks[i]);
			players[i] = p;
		}
	}
	
	/*
	 * 1 - Start game message
	 * 2 - Select current player index
	 * 3 - Player should select row and col to place symbol
	 * 4 - Board should check if box is available, and if so, place mark, otherwise repeat
	 * 5 - Print the board
	 * 6 - Repeat the steps for other player until one player wins or the board is full
	 */
	
	public void start() {
		System.out.println("game has started...");/*
		do {
			switchPlayer();
			while(!board.makeMove(players[this.currentPlayerIndex].getSymbol(), players[this.currentPlayerIndex].randomNumber(gameRowSize),players[this.currentPlayerIndex].randomNumber(gameColSize)));
			board.print();
		}while(!gameOver());*/
	}
	/*
	private void switchPlayer() {
		if (this.currentPlayerIndex == -1 || this.currentPlayerIndex == 1) {
			this.currentPlayerIndex = 0;
		}
		else {
			this.currentPlayerIndex = 1;
		}
	}
	
	// when board is full or there is a winner
	private boolean gameOver() {
		if (isWinner()) {
			System.out.println(this.marks[this.currentPlayerIndex] + " is the winner!");
			return true;
		}
		else if (board.isFull()){
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
			if (board.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
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
			if (board.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
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
			if (board.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
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
			if (board.getMark(row, col).equals(players[currentPlayerIndex].getSymbol())) {
				count++;
			}
			
			if(count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}*/
}