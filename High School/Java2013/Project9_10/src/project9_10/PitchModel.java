



package project9_10;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class PitchModel {
    static int sum = 0;
    Grid [][] g = new Grid[6][6];
    public PitchModel(){
        
    }
    
    public void DrawGrid(){
        for(int r = 1; r < 6; r++){
            for(int c = 1; c < 6; c++){
                if (c < 5){
                    if (g[r][c].getAvailable() == true){
                        System.out.print("[" + g[r][c].returnVal() + "] ");
                    }else{
                        System.out.print("[P] ");
                    }
                }else{
                    if (g[r][c].getAvailable() == true){
                        System.out.print("[" + g[r][c].returnVal() + "] \n");
                    }else{
                        System.out.print("[P] \n");
                    }
                }
            }
        }
    }
    
    public void InitializeGrid(){
        for(int r = 1; r < 6; r++){
            for(int c = 1; c < 6; c++){
                if (r == 1 || c == 1 || c == 5 || r == 5){
                g[r][c] = new Grid(1,true);
                }else{
                    if (c == 2 || r == 2 || c == 4 || r == 4){
                        g[r][c] = new Grid (2,true);
                    }else{
                        g[r][c] = new Grid (3,true);
                    }
                }
            }
        }
    }
    
    public void setPitch(int r, int c){
        sum += g[r][c].returnVal();
        g[r][c].setVal(0);
        g[r][c].setAvailable(false);
    }
    
    public int GetSum(){
        return sum;
    }
    
    public int GetVal(int r, int c){
        return g[r][c].returnVal();
    }
    
    public boolean getAvail(int r, int c){
       return g[r][c].getAvailable();
    }
}
