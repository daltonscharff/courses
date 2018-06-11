/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exam2proj1;
import java.util.Scanner;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 * Project 1
 */
public class Exam2Proj1 {
    private static final double GRAVITY = 9.8;
    /**
     * Computes distance object fell in a user-specified time.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int time;
        time = getValidInt("Please enter the total number of seconds an object has been falling: ");
        for(int count = 0; count <= time; count ++){
            System.out.printf("At %d seconds, the object fell %.1f meters.\n", count, fallingDistance(count));
        }
    }
    /**
     * Computes and returns the formula for distance (d = 0.5*g*t^2) for a given
     * time.
     * @param time How long an object has been falling
     * @return The distance that the object has fallen in meters
     */
    public static double fallingDistance(double time){
        return (0.5*GRAVITY*Math.pow(time,2));
    }
    /**
     * Assures that an entered integer value is equal to zero or is positive. 
     * If the entered value is not positive, this method will repeatedly ask
     * until the input is positive.
     * @param message Prompt for the user so they know what to enter
     * @return A valid integer that is positive or equal to zero
     */
    public static int getValidInt(String message){
        Scanner reader = new Scanner(System.in);
        int input = -1;
        boolean repeater = true;
        while(repeater == true){
            System.out.print(message);
            input = reader.nextInt();
            if(input >= 0){
                repeater = false;
            }else{
                System.out.println("Please enter a valid, positive integer");
            }
        }
        return input;
    }
    
}
