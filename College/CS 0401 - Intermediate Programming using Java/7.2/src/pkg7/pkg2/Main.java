/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg7.pkg2;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        squareroot(100);
    }
    
    public static void squareroot(int a){
        double oldX, x = 0;
        boolean equals = false;
        oldX = a/2;
        
        while(equals == false){
            x = (oldX + a/oldX)/2;
            if (oldX - x < 0.0001){
                equals = true;
            }
            oldX = x;            
        }
        System.out.println(x);
    }
}
