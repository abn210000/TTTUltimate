import java.util.LinkedList;
import java.util.Scanner;

//HUMAN VS AI
public class TTTUltimateGame2 {
	private ComputerPlayer ai = new ComputerPlayer("player 1" , "O");
	private HumanPlayer human = new HumanPlayer("player 2" , "X");
	
	private WholeBoard wholeBoard;
	
	private String[] marks = {"X", "O"};
	
	private int gameRowSize = 3;
	private int gameColSize = 3;
	private int gameScoreToWin = 3;
	
	private int currentBoard = 0;
	
	String[] wonBoards = new String[9]; // create a new array to hold the won boards and marks
	
	public int lastMove = 0;
	int humanFlag = 1;	// to hold if player or ai
	int tempMakeMoveBoard = 0;	// to hold the temp board choice to determine if valid
	
	boolean booleanMakeMoveHumanTemp;	// to hold whether or not move is valid
	
	// constructor
	public TTTUltimateGame2() {
		System.out.println("Which mark would you like? (Enter X or O)");
		Scanner input = new Scanner(System.in);
		String playerMark = input.nextLine();
		if(playerMark == "X") {
			setPlayers("X", "O");
		}
		else if(playerMark == "O") {
			setPlayers("O", "X");
		}
		setBoard();
	}
	
	// create game board
	private void setBoard() {
		this.wholeBoard = new WholeBoard(gameRowSize, gameColSize);
	}
	
	
	private void setPlayers(String mark1, String mark2) {
		HumanPlayer h = new HumanPlayer("player 1", "X");
		human = h;
		ComputerPlayer c = new ComputerPlayer("player 2", "O");
		ai = c;
		
	}
	
	int aiFlag = 0;
	public boolean makeMoveAI() {
		boolean temp;
		
		temp = wholeBoard.makeMove(ai.getSymbol(),// mark
				wholeBoard.makeMove1(human.getSymbol(), human.rowChoice, human.colChoice),
				ai.randomNumber(gameRowSize),	// random row
				ai.randomNumber(gameColSize), // random col
				count, aiFlag);
		
		// display AI move
		System.out.println("AI has placed on board# " + wholeBoard.tempBoard + " row " + wholeBoard.getRow() + " col " + wholeBoard.getCol());
		return temp;
	}
	
	public boolean makeMoveHuman() {
		
		booleanMakeMoveHumanTemp = wholeBoard.makeMove(human.getSymbol(),
				human.getBoard(count), // mark
				human.getRow(),	// random row
				human.getCol(), // random col
				count, humanFlag);
		 
		 tempMakeMoveBoard = wholeBoard.makeMove1(human.getSymbol(), human.rowChoice, human.colChoice);
		 return booleanMakeMoveHumanTemp;
	}
	
	
	int count = 0;
	public void start() {
		
		System.out.println("game has started...");
		
				
			while(!GAMEOVER()) {
				// loop human move until valid choice
				while(!makeMoveHuman()) {
					makeMoveHuman();
				}
				print(currentBoard);
				makeMoveAI();
				System.out.println("Must place NEXT move on board #" + wholeBoard.makeMove1(human.getSymbol(), wholeBoard.getRow(), wholeBoard.getCol()));
				count = count + 2;
				
				print(currentBoard);
			}
				
	}
	
	
	void print(int currentBoard) {
		
		wholeBoard.print(currentBoard);
	}
	

	boolean GAMEOVER() {
		
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

	//LinkedList<Integer> wonBoards = new LinkedList<Integer>();
	
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
		int count = 0;
		for (int col = 0; col < this.gameColSize; col++) {
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol()) || wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())){
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
			
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol()) || wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())) {
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
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol()) || wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())) {
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
			if (wholeBoard.boards[smallBoard].getMark(row, col).equals(ai.getSymbol()) || wholeBoard.boards[smallBoard].getMark(row, col).equals(human.getSymbol())) {
				count++;
			}
			
			if(count == this.gameScoreToWin) {
				return true;
			}
		}
		return false;
	}
	
}
