import java.util.InputMismatchException;
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
	  
	  public int getBoard(int count, boolean flag) {
		  if(count == 0) {
			  flag = true;
		  }
		  if(flag == true) {
			  System.out.println("Choose Board");
				 
			  // input validate board choice if out of range OR incorrect type
			  boolean valid = false;
				while(!valid) 	{
					
					try {
						boardChoice = input.nextInt();
						
						// if gameMode is in range, return
						if(boardChoice >= 0 && boardChoice <= 8) {
							valid = true;
						}
						else {
							System.out.println("Invalid Board Choice (Must Choose from 0 - 8)");
						}
					}
					catch (InputMismatchException e){
						System.out.println("Invalid Board Choice (Must Choose from 0 - 8)");
						input.next();
						
					}
				}
		  }
		  return boardChoice;
				
	  }
		  
	  
	  
	  public void setBoard(int boardChoice) {
		  this.boardChoice = boardChoice;
		  
	  }
	  
	
	  public int getRow() {

		  System.out.println("Choose Row");
		  
		  // input validate row choice if out of range OR incorrect type
		  boolean valid = false;
			while(!valid) {
				
				try {
					rowChoice = input.nextInt();
					
					// if gameMode is in range, return
					if(rowChoice >= 0 && rowChoice <= 2) {
						valid = true;
					}
					else {
						System.out.println("Invalid Row Choice (Must Choose from 0 - 2)");
					}
				}
				catch (InputMismatchException e){
					System.out.println("Invalid Row Choice (Must Choose from 0 - 2)");
					input.next();
					
				}
			}
		 
		  
		  return rowChoice;
	  }
	  
	  public void setRow(int rowChoice) {
		  this.rowChoice = rowChoice;
		  
	  }
	  
	  public int getCol() {

		  System.out.println("Choose Col");
		  
		  // input validate row choice if out of range OR incorrect type
		  boolean valid = false;
			while(!valid) {
				
				try {
					colChoice = input.nextInt();
					
					// if gameMode is in range, return
					if(colChoice >= 0 && colChoice <= 2) {
						valid = true;
					}
					else {
						System.out.println("Invalid Col Choice (Must Choose from 0 - 2)");
					}
				}
				catch (InputMismatchException e){
					System.out.println("Invalid Col Choice (Must Choose from 0 - 2)");
					input.next();
					
				}
			}
		 
		  
		  return colChoice;
	  }
	  
	  public void setCol(int colChoice) {
		  this.colChoice = colChoice;
	  }
}