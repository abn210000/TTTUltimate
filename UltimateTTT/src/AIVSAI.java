
// AI VS AI
public class AIVSAI {
	
	private ComputerPlayer[] players = new ComputerPlayer[2];
	
	private WholeBoard wholeBoard;
	
	private String[] marks = {"X", "O"};
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	
	private int currentPlayerIndex = 0;
	private int currentBoard = 0;
	
	
	String[] wonBoards = new String[9];	// create a new array to hold the won boards and marks
	
	public int aiFlag = 0;
	public int count = 0;
	
	// constructor
	public AIVSAI() {
		setPlayers();
		setBoard();
	}
	
	// create game board
	private void setBoard() {
		this.wholeBoard = new WholeBoard(gameRowSize, gameColSize);
	}
	
	// set players
	private void setPlayers() {
		for (int i = 0; i < players.length; i++) {
			ComputerPlayer p = new ComputerPlayer("player " + i+1, marks[i]);
			players[i] = p;
		}
	}

	boolean makeMoveAI() {
		return(wholeBoard.makeMove(players[this.currentPlayerIndex].getSymbol(),// mark
				players[this.currentPlayerIndex].randomNumber(9),
				players[this.currentPlayerIndex].randomNumber(gameRowSize),	// random row
				players[this.currentPlayerIndex].randomNumber(gameColSize), // random col
				count, aiFlag));
	}
	
	public void start() {
		
		System.out.println("game has started...");
		while(!gameOver()) {
				// alternate players
				switchPlayer();
				//if move is valid, increase count
				if(makeMoveAI()) {
					count++;
				}
			print(currentBoard);
				
		}
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
	
	boolean gameOver() {
		
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
	
	private boolean checkWholeBoard(String[] wonBoards) {
		
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
		
		return false;
		
	}
	
	
	private void checkSmallWinLoop() {
		// iterate through each small board
		for(int smallBoard = 0; smallBoard < 9; smallBoard++) {
			// if element at smallBoard in wonBoards array is null, you are permitted to place a mark
			if(wonBoards[smallBoard] == null) {
				if(checkSmallBoardWin(smallBoard) == true) {
					// if the opposing board has NOT already placed there, may place own mark
					
						wonBoards[smallBoard] = players[currentPlayerIndex].getSymbol();
				}
			}
			
		}
	}
	
	// check small board win
	private boolean checkSmallBoardWin(int smallBoard) {
			if(checkSmallRows(smallBoard)) {
				return true;
			}
			else if(checkSmallCols(smallBoard)) {
				return true;
			}
			else if(checkSmallDiagLR(smallBoard)) {
				return true;
			}
			else if(checkSmallDiagRL(smallBoard)) {
				return true;
			}
		
		return false;
	}
	
	// check if a row has been won
	private boolean checkSmallRows(int smallBoard) {
		for(int row = 0; row < this.gameRowSize; row++) {
			if(checkEachRow(row, smallBoard)) {
				return true;
			}
		}
		return false;
	}
	
	// check each row
	private boolean checkEachRow(int row, int smallBoard) {
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
	private boolean checkSmallCols(int smallBoard) {
		for(int col = 0; col < this.gameColSize; col++) {
			if(checkEachCol(col, smallBoard)) {
				return true;
			}
		}
		return false;
	}
	
	// check each col
	private boolean checkEachCol(int col, int smallBoard) {
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
	
	
	// check each diag lr
	private boolean checkSmallDiagLR(int smallBoard) {
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
	
	// check each small diag rl
	private boolean checkSmallDiagRL(int smallBoard) {
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