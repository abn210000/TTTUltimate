public class BoxUlt{
    private int row;
    private int col;
 
    //private final static String DASH = "-";
    //private String placeHolder = BoxUlt.DASH;
    private String placeHolder = "";
    
    BoxUlt(int row, int col)   {
        this.row = row;
        this.col = col;
        
        // initialize boxes with corresponding numbers
        if(row == 0 && col == 0) {
        	placeHolder = "0";
        }
        else if (row == 0 && col == 1) {
        	placeHolder = "1";
        }
        else if (row == 0 && col == 2) {
        	placeHolder = "2";
        }
        else if (row == 1 && col == 0) {
        	placeHolder = "3";
        }
        else if (row == 1 && col == 1) {
        	placeHolder = "4";
        }
        else if (row == 1 && col == 2) {
        	placeHolder = "5";
        }
        else if (row == 2 && col == 0) {
        	placeHolder = "6";
        }
        else if (row == 2 && col == 1) {
        	placeHolder = "7";
        }
        else if (row == 2 && col == 2) {
        	placeHolder = "8";
        
        }
    }
    
    
    String getPlaceHolder() {
    	return placeHolder;
    }
    
    boolean setPlaceHolder(String placeHolder) {
    	if(isAvailable()) {
    		this.placeHolder = placeHolder;
    		return true;
    	}
    	return false;
    	
    }
    
    // check if string is numeric
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
    	
    
    boolean isAvailable() {
    	// return true if placeHolder is a number
    	if (isNumeric(placeHolder)) {
    		return true;
    	}
    	return false;
    }
    void print(){
    	// if col == 2, print both edges
    	if(col == 2) {
    		System.out.print("| " + placeHolder + " | ");
    	}
    	else {
    		System.out.print("| " + placeHolder + " ");
    	}
    		
    }
    /*
    // print
    void print() {
        if (Integer.valueOf(placeHolder) == 2 || Integer.valueOf(placeHolder) == 5 || Integer.valueOf(placeHolder) == 8)
            System.out.print("| "+placeHolder + " |");
        else
            System.out.print("| "+ placeHolder + " ");
    }*/
    

}
