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
    
    // check if string is numberic
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
    
    // print
    void print(){
        System.out.print(placeHolder + " ");
    }
    

}
