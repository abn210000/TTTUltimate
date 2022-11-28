//HUMAN VS AI

public class PlayerVSAI {
	private ComputerPlayer ai = new ComputerPlayer("player 1" , "O");
	private HumanPlayer human = new HumanPlayer("player 2" , "X");
	
	private WholeBoard wholeBoard;
	
	private String[] marks = {"X", "O"};
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	
	int boardChoice = 0;
	int rowChoice = 0; 
	int colChoice = 0;
	
	String[] wonBoards = new String[9]; // create a new array to hold the won boards and marks
	
	private int currentBoard = 0;
	int aiFlag = 0;
	int humanFlag = 1;	// to hold if player or ai
	int tempMakeMoveBoard = 0;	// to hold the temp board choice to determine if valid
	boolean tempFlag = false; // check if board is full
	boolean booleanMakeMoveHumanTemp;	// to hold whether or not move is valid
	
	// constructor
	public PlayerVSAI() {
		setPlayers("X", "O");
		
		setBoard();
	}
	
	// create game board
	private void setBoard() {
		this.wholeBoard = new WholeBoard(gameRowSize, gameColSize);
	}
	
	
	private void setPlayers(String mark1, String mark2) {
		HumanPlayer h = new HumanPlayer("player 1", "X");	// human player is X
		human = h;
		ComputerPlayer c = new ComputerPlayer("player 2", "O"); // ai is O
		ai = c;
		
	}
	// making an ai move
	public boolean makeMoveAI() {
		boolean temp;
		int tempRow = ai.randomNumber(gameRowSize);
		int tempCol = ai.randomNumber(gameColSize);
	
		// make ai move if true
		temp = wholeBoard.makeMove(ai.getSymbol(),// mark
				wholeBoard.tempBoard,
				tempRow,	// random row
				tempCol, // random col
				count, aiFlag);
		
		
		
		// display AI move
		if(temp == true) {
			
			System.out.println("AI has placed on board# " + wholeBoard.tempBoard + " row " + wholeBoard.getRow() + " col " + wholeBoard.getCol());
			wholeBoard.boards[wholeBoard.tempBoard].boxes[wholeBoard.getRow() * 3 + wholeBoard.getCol()].setPlaceHolder(ai.getSymbol(), aiFlag);
		}
		
		
		return temp;
		
	}
	
	

	public boolean makeMoveHuman() {
		
		booleanMakeMoveHumanTemp = wholeBoard.makeMove(human.getSymbol(),
				boardChoice, // mark
				rowChoice,	// random row
				colChoice, // random col
				count, humanFlag);
		
		 tempMakeMoveBoard = wholeBoard.convertToBoard(human.getSymbol(), human.rowChoice, human.colChoice);
		 
		 // if mandatory board is full, player can choose board
		 if(checkBoardFull(wholeBoard.convertToBoard(human.getSymbol(), wholeBoard.getRow(), wholeBoard.getCol()))) {
			tempFlag = true;
			// player gets to make move at ANY BOARD
			wholeBoard.makeMove(human.getSymbol(),
				human.getBoard(count, tempFlag),
				human.getRow(),	// random row
				human.getCol(), count, humanFlag);
			
			// place mark
			wholeBoard.boards[wholeBoard.tempBoard].boxes[wholeBoard.getRow() * 3 + wholeBoard.getCol()].setPlaceHolder(human.getSymbol(), 0);
			
			// reset flag
			tempFlag = false;
			
		}
		

	

		 return booleanMakeMoveHumanTemp;
	}
	
	
	boolean tempMakeMoveAI;
	int count = 0;
	public void start() {
		
		System.out.println("game has started...");
			
				
			while(!gameOver()) {
				boardChoice = human.getBoard(count, tempFlag );
				rowChoice = human.getRow();
				colChoice = human.getCol();
				// loop human move until valid choice
				if(makeMoveHuman() == true) {
					print(currentBoard);
				}
				// if makeMoveHuman is invalid, do another iteration of the loop
				else if(makeMoveHuman() == false) {
					System.out.println("Invalid Choice. Please select a valid choice (box with an integer)");
					continue;
				}
				
				// loop until makeMoveAI returns true
				while(!makeMoveAI());
				
				
				// display for board choice is wrong
				System.out.println("Must place NEXT move on board #" + wholeBoard.convertToBoard(human.getSymbol(), wholeBoard.getRow(), wholeBoard.getCol()));
				count = count + 2;
				
				print(currentBoard);
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
	

	boolean gameOver() {
		
		if(checkWholeBoard(wonBoards)) {
			System.out.println(this.marks[0] + " is the winner!");
			return true;
		}
		else if (count == 81) {
			System.out.println("TIE");
			return true;
		}
		return false;
	}

	
	
	boolean checkWholeBoard(String[] wonBoards) {
		
		checkSmallWinLoop();
		if(wonBoards[0] == ai.getSymbol() && wonBoards[1] == ai.getSymbol() && wonBoards[2] == ai.getSymbol()) {
			return true;
		}
		else if(wonBoards[3] == ai.getSymbol() && wonBoards[4] == ai.getSymbol() && wonBoards[5] == ai.getSymbol()) {
			return true;
		}
		else if(wonBoards[6] == ai.getSymbol() && wonBoards[7] == ai.getSymbol() && wonBoards[8] == ai.getSymbol())  {
			return true;
		}
		else if(wonBoards[0] == ai.getSymbol() && wonBoards[3] == ai.getSymbol() && wonBoards[6] == ai.getSymbol()) {
			return true;
		}
		else if (wonBoards[1] == ai.getSymbol() && wonBoards[4] == ai.getSymbol() && wonBoards[7] == ai.getSymbol()) {
			return true;
		}
		else if (wonBoards[2] == ai.getSymbol() && wonBoards[5] == ai.getSymbol() && wonBoards[8] == ai.getSymbol()){
			return true;
		}
		else if(wonBoards[0] == ai.getSymbol() && wonBoards[4] == ai.getSymbol() && wonBoards[8] == ai.getSymbol())  {
			return true;
		}
		else if(wonBoards[2] == ai.getSymbol() && wonBoards[4] == ai.getSymbol() && wonBoards[6] == ai.getSymbol())  {
			return true;
		}
		
		
		if(wonBoards[0] == human.getSymbol() && wonBoards[1] == human.getSymbol() && wonBoards[2] == human.getSymbol()) {
			return true;
		}
		else if(wonBoards[3] == human.getSymbol() && wonBoards[4] == human.getSymbol() && wonBoards[5] == human.getSymbol()) {
			return true;
		}
		else if(wonBoards[6] == human.getSymbol() && wonBoards[7] == human.getSymbol() && wonBoards[8] == human.getSymbol())  {
			return true;
		}
		else if(wonBoards[0] == human.getSymbol() && wonBoards[3] == human.getSymbol() && wonBoards[6] == human.getSymbol()) {
			return true;
		}
		else if (wonBoards[1] == human.getSymbol() && wonBoards[4] == human.getSymbol() && wonBoards[7] == human.getSymbol()) {
			return true;
		}
		else if (wonBoards[2] == human.getSymbol() && wonBoards[5] == human.getSymbol() && wonBoards[8] == human.getSymbol()){
			return true;
		}
		else if(wonBoards[0] == human.getSymbol() && wonBoards[4] == human.getSymbol() && wonBoards[8] == human.getSymbol())  {
			return true;
		}
		else if(wonBoards[2] == human.getSymbol() && wonBoards[4] == human.getSymbol() && wonBoards[6] == human.getSymbol())  {
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
					
						wonBoards[smallBoard] = ai.getSymbol();
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
		int countAI = 0;
		int countHuman = 0;
		for (int col = 0; col < this.gameColSize; col++) {
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol())){
				countAI++;
			}
			if(wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())) {
				countHuman++;
			}
			if (countAI == this.gameScoreToWin || countHuman == this.gameScoreToWin) {
				return true;
			}
			else {
				return false;
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
		int countAI = 0;
		int countHuman = 0;
		for (int row = 0; row < this.gameRowSize; row++) {
			
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol())) {
				countAI++;
			}
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())){
				countHuman++;
			}
			
		}
		if (countAI == this.gameScoreToWin || countHuman == this.gameScoreToWin) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	// check each diag lr
	boolean checkSmallDiagLR(int smallBoard) {
		int countAI = 0;
		int countHuman = 0;
		for (int row = 0, col = this.gameRowSize - 1; row < this.gameColSize && col >= 0; row++, col--) {
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol())) {
				countAI++;
			}
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())) {
				countHuman++;
			}
			if (countAI == this.gameScoreToWin || countHuman == this.gameScoreToWin) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	// check each small diag rl
	boolean checkSmallDiagRL(int smallBoard) {
		int countAI = 0;
		int countHuman = 0;
		for (int col = 0, row = 0; col < this.gameColSize && row < this.gameRowSize; col++, row++) {
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol())) {
				countAI++;
			}
			if(wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())) {
				countHuman++;
			}
			
			if (countAI == this.gameScoreToWin || countHuman == this.gameScoreToWin) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
}