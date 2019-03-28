/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exam1.pkg2;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 * Project 2
 */
public class Exam12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random generator = new Random();
        Scanner reader = new Scanner(System.in);
        double userInput = -1;
        int randomNum = generator.nextInt(100);
        //System.out.println(randomNum); Will reveal the computer's randomly generated number. Do not uncomment.
        
        System.out.println("In this program, you will try to guess a positive number less than 100.\n");
        
        while (randomNum != userInput){
            System.out.print("Please input your guess: "); //Gets user's guess as an integer.
            userInput = reader.nextInt();
            
            if (userInput > randomNum){ //Checks if user's number is too high.
                System.out.println("Too high, try again."); 
            }
            if (userInput < randomNum){ //Checks if user's number is too low.
                System.out.println("Too low, try again.");
            }
            if (userInput == randomNum){ //Tells user that they have successfully guessed the random number.
                System.out.printf("\nGreat job! You successfully found that %d was the random number.\n", randomNum);
            }
        }
        
    }
    
}
