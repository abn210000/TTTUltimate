// PLAYER VS PLAYER

public class PlayerVSPlayer {
	
	private HumanPlayer[] players = new HumanPlayer[2];
	private WholeBoard wholeBoard;
	
	private String[] marks = {"X", "O"};
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	
	private int currentPlayerIndex = 0;
	private int currentBoard = 0;
	
	int playerFlag = 1;
	int count = 0;
	int boardChoice;
	int rowChoice;
	int colChoice;
	
	// create a new array to hold the won boards and marks
	String[] wonBoards = new String[9];
	
	
	// constructor
	public PlayerVSPlayer() {
		setPlayers();
		setBoard();
	}
	
	// create game board
	private void setBoard() {
		this.wholeBoard = new WholeBoard(gameRowSize, gameColSize);
	}
	

	private void setPlayers() {
		for (int i = 0; i < players.length; i++) {
			HumanPlayer p = new HumanPlayer("player " + i+1, marks[i]);
			players[i] = p;
		}
	}

	boolean tempFlag = false;
	boolean makeMoveHuman() {
		boolean tempHuman;
		tempHuman = wholeBoard.makeMove(players[this.currentPlayerIndex].getSymbol(),
				boardChoice, // mark
				rowChoice,	// random row
				colChoice, // random col
				count, playerFlag);
		
		// if mandatory board is full, player can choose board
		if(checkBoardFull(wholeBoard.convertToBoard(players[this.currentPlayerIndex].getSymbol(), wholeBoard.getRow(), wholeBoard.getCol()))) {
			tempFlag = true;
			// player gets to make move at ANY BOARD
			wholeBoard.makeMove(players[this.currentPlayerIndex].getSymbol(),
				players[this.currentPlayerIndex].getBoard(count, tempFlag),
				players[this.currentPlayerIndex].getRow(),	// random row
				players[this.currentPlayerIndex].getCol(), count, playerFlag);
			
			// place mark
			wholeBoard.boards[wholeBoard.tempBoard].boxes[wholeBoard.getRow() * 3 + wholeBoard.getCol()].setPlaceHolder(players[this.currentPlayerIndex].getSymbol(), 0);
			
			// reset flag
			tempFlag = false;
			
		}
		
		return tempHuman;
	}
	
	
	public void start() {
		
		System.out.println("game has started...");
		while(!gameOver()) {
				// alternate players
				switchPlayer();
				boardChoice = players[this.currentPlayerIndex].getBoard(count, tempFlag); // mark
				rowChoice = players[this.currentPlayerIndex].getRow();	// random row
				colChoice = players[this.currentPlayerIndex].getCol();
				
				
				// if move is valid, increase count and display what next move is
				if(makeMoveHuman() == true) {
					count++;
					System.out.println("Must place NEXT move on board #" + wholeBoard.convertToBoard(players[this.currentPlayerIndex].getSymbol(), wholeBoard.getRow(), wholeBoard.getCol()));
					print(currentBoard);
				}
				// if move is invalid, display error and switchplayer so that player can redo move
				else if (makeMoveHuman() == false) {
					System.out.println("Invalid Choice. Please select a valid choice (box with an integer)");
					switchPlayer();
					continue;
				}
		}
	}
	

	boolean checkBoardFull(int mandatoryBoard){
		int countFull = 0;
		for(int i = 0; i < 9; i++) {
			// if box is a MARK not a NUMBER, countFull++
			
			if(!wholeBoard.boards[mandatoryBoard].boxes[i].isAvailable(0)) {
				countFull++;
			}
		
		}

		if(countFull == 9) {
			System.out.println("Board#" + mandatoryBoard + " is full! You may choose any board");
		
			return true;
		}
		return false;
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
		
		return false;
		
	}
	
	
	void checkSmallWinLoop() {
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
	boolean checkSmallBoardWin(int smallBoard) {
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
	boolean checkSmallRows(int smallBoard) {
		for(int row = 0; row < this.gameRowSize; row++) {
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
		for(int col = 0; col < this.gameColSize; col++) {
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
	
	
	// check each diag lr
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
	
	// check each small diag rl
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
