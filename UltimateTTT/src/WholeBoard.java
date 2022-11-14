// entire board, composed of 9 individual games
public class WholeBoard {
	private int wholeRowSize;
	private int wholeColSize;
	BoardUlt[] boards;
	String name;
	int currentBoard;

	
	
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
	 
	 void print(int currentBoard)    {
	        System.out.println("printing whole board");
	        
	       
	        print3Boards(0,3);
	        print3Boards(3,6);
	        print3Boards(6,9);
	 }
	 
	 void print3Boards(int b1, int b2) {
		 for(currentBoard = b1; currentBoard < b2; currentBoard++) {
	        	boards[currentBoard].printRow0(currentBoard);
	        }
	        System.out.println("");
	        // printing row 1 of boards 7 - 9
	        for(currentBoard = b1; currentBoard < b2; currentBoard++) {
	        	boards[currentBoard].printRow1(currentBoard);
	        }
	        System.out.println("");
	        // printing row 2 of boards 7 - 9
	        for(currentBoard = b1; currentBoard < b2; currentBoard++) {
	        	boards[currentBoard].printRow2(currentBoard);
	        }
	        System.out.println("");
	        System.out.println("");
	 }
 }