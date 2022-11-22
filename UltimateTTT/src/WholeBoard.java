// entire board, composed of 9 individual games
public class WholeBoard {
	private int wholeRowSize;
	private int wholeColSize;
	BoardUlt[] boards;
	String name;
	int currentBoard;

	

	int lastRow = 0;
	int lastCol = 0;
	boolean tempMove;
	
	// default constructor
	WholeBoard(){
		this(3,3);
	}
	
	// custom constructor that creates whole board of size 3
	WholeBoard(int rowSize, int colSize){
		this.setSize(rowSize, colSize);
	}
	
	private void setSize(int row, int col)  {
    	// check if board dimensions are valid
        if (row < 3 || col < 3) {
            System.out.println("min board size is 3");
           
        }
        else{
            this.wholeColSize = col;
            this.wholeRowSize = row;
            init();
        }
    }
	public void setCol(int col) {
		  lastCol = col;
	}
	public void setRow(int row) {
		lastRow = row;
	}
	
	public int getCol() {
		return lastCol;
	}
	public int getRow() {
		return lastRow;
	}
	
	private void init() {
    	// declare new board object of size 9 of board
        boards = new BoardUlt[wholeColSize * wholeRowSize];
        // initialize each individual board for master board
        for (int i = 0; i < boards.length; i++)  {
        	currentBoard = i;
            BoardUlt b = new BoardUlt(wholeColSize, wholeRowSize, "Ultimate TTT", currentBoard);
            boards[i] = b;
         
        }
        // print the empty, initialized board
	        print(currentBoard);
	    }
	
	public String getMark(int row, int col) {
	    	return boards[row * 3 + col].getMark(row, col);
	
	}
	
	// this method returns the mandatory board based on the row and col
	int makeMove1(String mark, int randomRow, int randomCol) {
		int mandatoryBoard = 0;
		if(lastRow == 0 && randomCol == 0) {
			mandatoryBoard = 0;
        }
        else if (lastRow == 0 && lastCol == 1) {
        	mandatoryBoard = 1;
        }
        else if (lastRow == 0 && lastCol == 2) {
        	mandatoryBoard = 2;
        }
        else if (lastRow == 1 && lastCol == 0) {
        	mandatoryBoard = 3;
        }
        else if (lastRow == 1 && lastCol == 1) {
        	mandatoryBoard = 4;
        }
        else if (lastRow == 1 && lastCol == 2) {
        	mandatoryBoard = 5;
        }
        else if (lastRow == 2 && lastCol == 0) {
        	mandatoryBoard = 6;
        }
        else if (lastRow == 2 && lastCol == 1) {
        	mandatoryBoard = 7;
        }
        else if (lastRow == 2 && lastCol == 2) {
        	mandatoryBoard = 8;
        }
		
		return mandatoryBoard;
	}
	
	// this method makes a move for a specific board
	boolean makeMove(String mark, int boardChoice, int row, int col, int count) {
		setRow(row);
		setCol(col);
		// lastRow and lastCol is still previous
		if(count != 0) {
			// make mandatory board choice (reinitialized the randomized boardChoice based on previous move)
			boardChoice = makeMove1(mark, lastRow, lastCol);
			//System.out.println("Must Place On Board " + boardChoice);
		}
		
		tempMove = boards[boardChoice].makeMove(mark,boardChoice, row, col);
		
		// update last row and col
		lastRow = row;
		lastCol = col;
		
		return tempMove;
	}
	
	
	
	 // this method determines if the boxes are full or empty
	public boolean isFull() {
		for(BoardUlt b : boards) {
			if (b.isAvailable()) {
				return false;
			}
		}
		return true;
	}
	 
	 // this method prints the entire board
	void print(int currentBoard)    {
	        System.out.println("printing whole board");
	        
	        // printing boards 0-2
	        print3Boards(0,3);
	        // printing boards 3-6
	        print3Boards(3,6);
	        // printing boards 6-8
	        print3Boards(6,9);
	 }
	 
	// this method prints the rows in groups of 3 boards
	void print3Boards(int b1, int b2) {
		 // printing row 0 of boards b1-b2
		 	for(currentBoard = b1; currentBoard < b2; currentBoard++) {
		 		boards[currentBoard].printRow0(currentBoard);
	        }
	        System.out.println("");
	        // printing row 1 of boards b1-b2
	        for(currentBoard = b1; currentBoard < b2; currentBoard++) {
	        	boards[currentBoard].printRow1(currentBoard);
	        }
	        System.out.println("");
	        // printing row 2 of boards b1-b2
	        for(currentBoard = b1; currentBoard < b2; currentBoard++) {
	        	boards[currentBoard].printRow2(currentBoard);
	        }
	        System.out.println("");
	        System.out.println("");
	 }
 }