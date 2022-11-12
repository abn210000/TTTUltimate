public class BoxUlt{
    private int row;
    private int col;
    private final static String DASH = "-";
    private String placeHolder = BoxUlt.DASH;
    
    BoxUlt(int row, int col)   {
        this.row = row;
        this.col = col;
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
    boolean isAvailable() {
    	return this.placeHolder.equals(BoxUlt.DASH);
    }
    
    void print(){
        System.out.print(placeHolder + " ");
    }
}