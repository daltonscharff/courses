/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalexamproject1;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 * Program 1
 */
public class FinalExamProject1 {

    /** 
     * This program adds doubles to a list and returns how many were added.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userInput = "";
        Scanner reader = new Scanner(System.in);
        boolean repeater = true;
        ArrayList<Double> list = new ArrayList<Double>();
        System.out.println("This program adds doubles to a list and returns how many were added.\n");
        
        // Asks user for doubles until they enter 'stop'.
        do{
            System.out.print("Please enter a number (or \"stop\" to exit): ");
            userInput = reader.next();
            if(userInput.equalsIgnoreCase("stop")){
                repeater = false;
            }else{
                list.add(Double.parseDouble(userInput));
            }
        }while(repeater == true);
        
        if(list.size() == 1){
            System.out.println("You have entered " + list.size() + " number.");
        }else{
            System.out.println("You have entered " + list.size() + " numbers.");
        }
    }
    
}
