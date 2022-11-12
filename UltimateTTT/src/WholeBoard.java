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
	    	// declare new board object of size of board
	        boards = new BoardUlt[wholeColSize * wholeRowSize];
	        // initialize each individual board for master board
	        for (int i = 0; i < boards.length; i++)  {
	            BoardUlt b = new BoardUlt(i/wholeColSize, i%wholeRowSize, "Ultimate TTT");
	            boards[i] = b;
	        }
	        // print the empty, initialized board
	        print();
	    }
	 
	
}
