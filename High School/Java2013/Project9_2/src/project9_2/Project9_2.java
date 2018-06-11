/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project9_2;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class Project9_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double[] input = new double[10];
        double runningTotal = 0, average;
        
        for (int count = 0; count < input.length; count ++){
            System.out.println("Please enter a number:");
            input[count] = reader.nextDouble();
            runningTotal += input[count];
        }
        
        average = runningTotal / 10;
        System.out.println("\nThe average is: " + average + ".");
        System.out.println("The numbers greater than the average include: ");
        for (int count = 0; count < input.length; count ++){
            if (input[count] > average){
                System.out.print(input[count] + " ; ");
            } 
        }
    }
}
