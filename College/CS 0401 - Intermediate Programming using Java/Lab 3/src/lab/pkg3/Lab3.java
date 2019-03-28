/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.pkg3;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String userPackage = "";
        int skipEnd = 0, keepGoing = 0;
        double userHours = 0, totalCharge, hoursRemain, totalCost = 0;
        
        System.out.println("Package A: For $9.95 per month, 10 hours of access are provided. Additional hours are $2.00 per hour.\n"
                + "Package B: For $13.95 per month, 20 hours of access are provided. Additional hours are $1.00 per hour.\n"
                + "Package C: For $19.95 per month, access is unlimited.\n");
        
        System.out.print("What package have you subscribed to? ");
        userPackage = reader.nextLine();
        if (userPackage.equalsIgnoreCase("a")|| userPackage.equalsIgnoreCase("b")|| userPackage.equalsIgnoreCase("c")){
            // Do nothing
        }else{
            System.out.println("Please enter an \"A\", \"B\", or \"C\"."); 
            keepGoing = 1;
        }
        
        if (keepGoing == 0){

            // Hours Input
            try{
                System.out.print("How many hours did you use? ");
                userHours = reader.nextDouble();
            }catch (Exception e){
                System.out.println("Please enter a number next time.");
                skipEnd = 1;
            }

            //Check If Negative
            if (userHours < 0){
                System.out.println("Please enter a positive number of hours next time.");
                skipEnd = 1;
            }

            // Package A
            if (userPackage.equalsIgnoreCase("a")){
                if (userHours >= 10){
                    hoursRemain = userHours - 10;
                    totalCost = 9.95 + (hoursRemain * 2);
                }else{
                    totalCost = 9.95;
                }
            }
            // Package B
            if (userPackage.equalsIgnoreCase("b")){
                if (userHours >= 20){
                    hoursRemain = userHours - 20;
                    totalCost = 13.95 + (hoursRemain * 1);
                }else{
                    totalCost = 13.95;
                }
            }
            // Package C
            if (userPackage.equalsIgnoreCase("c")){
                if (userHours >= 0){
                    totalCost = 19.95;
                }
            }

            // Final Output
            if (skipEnd == 0){ // Skips this line if user doesn't enter a positive number in the hours input
                System.out.printf("Your total charge is $%.2f\n", totalCost);
            }
        }  
    }
    
    /*  Question 1
            If the user enters anything other than an 'A', 'B', or 'C' (ignoring
            case), the program recognizes this, alerts the user and ends. If a 
	    letter is entered into the hours input, the program will
            alert the user as to what they did wrong and ends the program. If 
            the user enters a negative value of hours, the program tells the
            user and ends the program.
    */
}
