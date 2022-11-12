class ComputerPlayer {
	
  private String name;
  private String symbol;
  
  // constructor
  ComputerPlayer(String name, String symbol){
    this.setName(name);
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
  
  public int randomNumber(int range) {
	  return (int)(Math.random() * range);
  }
}