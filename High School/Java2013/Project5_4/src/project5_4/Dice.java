/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_4;

import java.util.Random;

public class Dice {
    int value, t = 1;
    
    public Dice(){
        while (t == 1){
            Random generator = new Random();
            value = generator.nextInt(7);
            if (value == 0){
                t = 1;
            }else{
                t = 0;
            }
        }
    }
    
    public int getDice(){
        return value;
        
    }
}
