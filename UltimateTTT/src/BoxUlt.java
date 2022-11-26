public class BoxUlt{
    private int row;
    private int col;
    static int counter = 0;
 
    private String placeHolder = "";
    private int currentBox = 0;
    
    // custom constructor to set rows and set initial placeHolders
    BoxUlt(int row, int col)   {
        this.row = row;
        this.col = col;
        
        // initialize boxes with corresponding numbers
        if(row == 0 && col == 0) {
        	placeHolder = "0";
        	currentBox = 0;
        }
        else if (row == 0 && col == 1) {
        	placeHolder = "1";
        	currentBox = 1;
        }
        else if (row == 0 && col == 2) {
        	placeHolder = "2";
        	currentBox = 2;
        }
        else if (row == 1 && col == 0) {
        	placeHolder = "3";
        	currentBox = 3;
        }
        else if (row == 1 && col == 1) {
        	placeHolder = "4";
        	currentBox = 4;
        }
        else if (row == 1 && col == 2) {
        	placeHolder = "5";
        	currentBox = 5;
        }
        else if (row == 2 && col == 0) {
        	placeHolder = "6";
        	currentBox = 6;
        }
        else if (row == 2 && col == 1) {
        	placeHolder = "7";
        	currentBox = 7;
        }
        else if (row == 2 && col == 2) {
        	placeHolder = "8";
        	currentBox = 8;
        
        }
    }
    
    
    String getPlaceHolder() {
    	return placeHolder;
    }
    
    boolean setPlaceHolder(String placeHolder, int flag) {
    	if(isAvailable(flag)) {
    		this.placeHolder = placeHolder;
    		return true;
    	}
    	return false;
    	
    }
    
    // check if string is numeric (just for is available)
    public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    	
    // is available if there isnt a mark
    boolean isAvailable(int flag) {
    	// return true if placeHolder is a number
    	if (isNumeric(placeHolder)) {
    		return true;
    	}
    	
    	return false;
    }
    
    void print(int currentBoard){
    	
	    	if(col == 0) {
	    		System.out.print("Board #" + currentBoard + " ");
	    	}
	    	if(col == 2) {
	    		System.out.print("| " + placeHolder + " | ");
	    	}
	    	else {
	    		System.out.print("| " + placeHolder + " ");
	    	}
    		
    }

}
