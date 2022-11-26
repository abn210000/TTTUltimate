public class BoardUlt{ // package visibility / default
    private int boardRowSize = 0;
    private int boardColSize = 0;
    public BoxUlt[] boxes;
    private String name;
    private int currentBoard = 0;
    int currentRow = 0;
	int currentCol = 0;
	static int counter = 0;
  
    // custom constructor
    BoardUlt(int rowSize, int colSize, String name, int currentBoard){
        this.setName(name);
        this.setSize(rowSize,colSize);
        this.setBoard(currentBoard);
 
        
    }
    private void setBoard(int currentBoard) {
    	this.currentBoard = currentBoard;
    }
    private void setSize(int row, int col)  {
    	
            this.boardColSize = col;
            this.boardRowSize = row;
            init();
    }
   
    
    private void init() {
    	// declare new box object of size of board
        boxes = new BoxUlt[boardColSize * boardRowSize];
        // initialize each individual box
        for (int i = 0; i < boxes.length; i++)  {
            BoxUlt b = new BoxUlt(i/boardColSize, i%boardRowSize);
            boxes[i] = b;
        }
       
    }
   
    	
    // this method will print the current board and status of the game
    public void printRow0(int currentBoard) {
    	
		for (int i = 0; i < 3; i++) {
        	// print individual boxes
        	
        	boxes[i].print(currentBoard);
        }
       
	}
    
    public void printRow1(int currentBoard) {
    	for (int i = 3; i < 6; i++) {
        	// print individual boxes
        	
        	boxes[i].print(currentBoard);
        }
       
    }
    
    public void printRow2(int currentBoard) {
    	for (int i = 6; i < 9; i++) {
        	// print individual boxes
        	boxes[i].print(currentBoard);
        }
       
    }
		
    // this method will set a place holder on the desired box
    boolean makeMove(String mark,int board, int row, int col, int flag) {
    
    	return boxes[row * this.boardRowSize + col].setPlaceHolder(mark, flag);
    }
   
    
    // this method determines if the boxes are full or empty
    public boolean isFull(int flag) {
    	for(BoxUlt b : boxes) {
    		if (b.isAvailable(flag)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    // getters and setters
    public String getMark(int row, int col) {
    	return boxes[row * this.boardRowSize + col].getPlaceHolder();
    	
    }
    	
    // is available if the board isn't full
    boolean isAvailable(int flag) {
    	int counter = 0;
    	// go through each box in the specific board
    	for(int i = 0; i < 9; i++) {
    		// increase counter if box is full
    		if(!boxes[i].isAvailable(flag)) {
    			counter++;
    		}
    	}
    	// if board is completely full, return false
		if(counter == 9) {
			return false;
		}
		
		return true;
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
