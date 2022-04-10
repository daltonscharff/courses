



package project9_10;

public class Grid {
    
    private int val;
    private boolean available;
    
    public Grid(int v, boolean b){
        setVal(v);
        setAvailable(b);
    }
    
    public Grid(int v){
        setVal(v);
        setAvailable(true);
    }
    
    public int returnVal(){
        return val;
    }
    
    public void setVal(int v){
        val = v;
    }
    
    public boolean getAvailable(){
        return available;
    }
    
    public void setAvailable(boolean b){
        available = b;
    }
    
}
