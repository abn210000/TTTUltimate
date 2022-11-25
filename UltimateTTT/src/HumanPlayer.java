import java.util.Scanner;

public class HumanPlayer {

	private String name;
	private String symbol;
	private int boardChoice;
	public int rowChoice;
	public int colChoice;
	public int flag = 0;
	
	  // constructor
	  HumanPlayer(String name, String symbol){
	    //this.setName(name);
	    this.setSymbol(symbol);
	  }
  
  	  public String getName() {
	    return name;
	  }
	  public void setName(String name) {
	    this.name = name;
	  }
	  public String getSymbol() {
	    return symbol;
	  }
	  public void setSymbol(String symbol) {
	    this.symbol = symbol;
	  }
		 
	  
	  Scanner input = new Scanner(System.in);
	  
	  public int getBoard(int count) {
		  
		  if(count == 0) {
			  System.out.println("Choose Board");
			  boardChoice = input.nextInt();
		  }
		 
		  return boardChoice;
	  }
	  
	  
	  public void setBoard(int boardChoice) {
		  this.boardChoice = boardChoice;
		  
	  }
	  
	  public int getRow() {

		  System.out.println("Choose Row");
		  rowChoice = input.nextInt();
		  
		  while(rowChoice < 0 || rowChoice > 2) {
			  System.out.println("Invalid Row Choice (Must Choose from 0 - 2");
			  rowChoice = input.nextInt();
		  }
		  
		  return rowChoice;
	  }
	  
	  public void setRow(int rowChoice) {
		  this.rowChoice = rowChoice;
		  
	  }
	  
	  public int getCol() {
		  System.out.println("Choose Col");
		  colChoice = input.nextInt();
		  
		  while(colChoice < 0 || colChoice > 2) {
			  System.out.println("Invalid Col Choice (Must Choose from 0 - 2");
			  colChoice = input.nextInt();
		  }
		  
		  return colChoice;
	  }
	  public void setCol(int colChoice) {
		  this.colChoice = colChoice;
	  }
}
