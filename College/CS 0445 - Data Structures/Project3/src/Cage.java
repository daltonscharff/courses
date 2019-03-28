/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Cage {
    int goal;
    String operator;
    int[] locationRow;
    int[] locationCol;
    
    public Cage(int goal, int[] locationRow, int[] locationCol, String operator){
        this.goal = goal;
        this.locationRow = locationRow;
        this.locationCol = locationCol;
        this.operator = operator;
        
    }
    
    private String arrayToString(int[] a){
        String temp = "";
        for(int z = 0; z < a.length; z++){
            temp += a[z];
            if(z != a.length-1){
                temp += ", ";
            }
        }
        return temp;
    }
    
    public String toString(){
        return "Goal: " + goal + "\nLocationRow: " + arrayToString(locationRow) + "\nLocationCol: " + arrayToString(locationCol);
    }
}
