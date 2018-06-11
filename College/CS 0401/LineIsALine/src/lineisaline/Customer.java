/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lineisaline;
import java.util.Random;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Customer {
    private int number;
    private int minutes;
    
    public Customer(int number){
        Random generator = new Random();
        this.number = number;
        int genNum = generator.nextInt(100);
        if (genNum < 10){
            minutes = 1;            
        }else if (genNum >= 10 && genNum < 30){
            minutes = 2;            
        }else if (genNum >= 30 && genNum < 70){
            minutes = 3;            
        }else if (genNum >= 70 && genNum < 90){
            minutes = 4;            
        }else if (genNum >= 90 && genNum < 100){
            minutes = 5;            
        }
    }
    
    public Customer(int number, int minutes){
        this.number = number;
        this.minutes = minutes;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getMinutes(){
        return minutes;
    }
    
    public String toString(){
        return "c"+number+","+minutes;
    }
}
