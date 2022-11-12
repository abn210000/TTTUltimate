public class BoardUlt{ // package visibility / default
    private int boardRowSize;
    private int boardColSize;
    private BoxUlt[] boxes;
    private String name;
    private int currentBoard;
    // default constructor
    BoardUlt(){
        this(3,3,"3x3 board");
    }
    
    // custom constructor
    BoardUlt(int rowSize, int colSize, String name){
        this.setName(name);
        this.setSize(rowSize,colSize);
 
        
    }
    
    private void setSize(int row, int col)  {
    	// check if board dimensions are valid
    	/*if (row < 3 || col < 3) {
            System.out.println("min board size is 3!");
           
        }
        else{*/
            this.boardColSize = col;
            this.boardRowSize = row;
            init();
        }
   // }
    
    private void init() {
    	// declare new box object of size of board
        boxes = new BoxUlt[boardColSize * boardRowSize];
        // initialize each individual box
        for (int i = 0; i < boxes.length; i++)  {
            BoxUlt b = new BoxUlt(i/boardColSize, i%boardRowSize);
            boxes[i] = b;
        }
        // print the empty, initialized board
        
        //print();
    }
   
    // return current board
    public int getCurrentBoard(int row, int col) {
    	if(row == 0 && col == 0) {
        	currentBoard = 0;
        }
        else if (row == 0 && col == 1) {
        	currentBoard = 1;
        }
        else if (row == 0 && col == 2) {
        	currentBoard = 2;
        }
        else if (row == 1 && col == 0) {
        	currentBoard = 3;
        }
        else if (row == 1 && col == 1) {
        	currentBoard = 4;
        }
        else if (row == 1 && col == 2) {
        	currentBoard = 5;
        }
        else if (row == 2 && col == 0) {
        	currentBoard = 6;
        }
        else if (row == 2 && col == 1) {
        	currentBoard = 7;
        }
        else if (row == 2 && col == 2) {
        	currentBoard = 8;
        }
    	return currentBoard;
    }
    
    // this method will print the current board and status of the game
    void print(){
    	//currentBoard = i;
    	currentBoard = getCurrentBoard(boardRowSize, boardColSize);
    	System.out.print("printing Board " + currentBoard + " ");
    	
        // for loop will print the board and the current markers
        for (int i = 0; i < boxes.length; i++) {
        	boxes[i].print();
        }
        if(currentBoard == 2 || currentBoard == 5 || currentBoard == 8) {
        	System.out.println("");
        }
    }
    
    // this method will set a place holder on the desired box
    boolean makeMove(String mark, int row, int col) {
    	return boxes[row * this.boardRowSize + col].setPlaceHolder(mark);
    }
    
    // this method determines if the boxes are full or empty
    public boolean isFull() {
    	for(BoxUlt b : boxes) {
    		if (b.isAvailable()) {
    			return false;
    		}
    	}
    	return true;
    }
    
    // getters and setters
    public String getMark(int row, int col) {
    	return boxes[row * this.boardRowSize + col].getPlaceHolder();
    	
    }
    
    
    int getRow()    {
        return boardRowSize;
    }
        
    void setRow(int row) {
        this.boardRowSize = row;
    }
        
    int getCol()    {
        return boardColSize;
    }
        
    void setCol(int col) {
        this.boardColSize = col;
    }
        
    String getName()    {
        return name;
    }
        
    void setName(String name){
        this.name = name;
    }
    
}
