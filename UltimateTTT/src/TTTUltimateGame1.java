// PLAYER VS PLAYER

public class TTTUltimateGame1 {
	
	private HumanPlayer[] players = new HumanPlayer[2];
	private WholeBoard wholeBoard;
	
	private String[] marks = {"X", "O"};
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	
	private int currentPlayerIndex = 0;
	private int currentBoard = 0;
	
	int humanFlag = 1;
	int count = 0;
	
	// create a new array to hold the won boards and marks
	String[] wonBoards = new String[9];
	
	
	// constructor
	public TTTUltimateGame1() {
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
	
	public void start() {
		
		System.out.println("game has started...");
		do {
				switchPlayer();
				// while loop to alternate player moves, passing in random row, col and board num
				
				while(!wholeBoard.makeMove(players[this.currentPlayerIndex].getSymbol(),
						players[this.currentPlayerIndex].getBoard(count), // mark
						players[this.currentPlayerIndex].getRow(),	// random row
						players[this.currentPlayerIndex].getCol(), // random col
						count, humanFlag));	// random board
	
					System.out.println("Must place NEXT move on board #" + wholeBoard.makeMove1(players[this.currentPlayerIndex].getSymbol(), wholeBoard.getRow(), wholeBoard.getCol()));
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
		
		// print (DELETE LATER)
		for(int i = 0; i < 9; i++) {
			System.out.print(wonBoards[i] + " ");
			
		}
		System.out.println("");
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
