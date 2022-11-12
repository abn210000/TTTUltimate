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
	            BoardUlt b = new BoardUlt(i/wholeColSize, i%wholeRowSize, "Ultimate TTT");
	            boards[i] = b;
	            
	        }
	        // print the empty, initialized board
	        print();
	    }
	 
	 void print()    {
	        System.out.println("printing whole board");
	        // for loop will print the board and the current markers
	        for (int i = 0; i < boards.length; i++) {
	        	/*if (i != 0 && i%wholeColSize == 0) {
	        		System.out.println();
	        	}*/
	        	// 2 5 8
	        	if(i == 2 || i == 5 || i == 8) {
	        		System.out.println("Hello from board " + i + " ");
	        	}
	        	else {
	        		System.out.print("Hello from board " + i + " ");
	        	}
	        	//boards[i].print();
	        	
	        }
	        System.out.println("");
	    }
	
}
