/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pkg3;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class Project23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double kilometers;
        double miles;
        
        System.out.print("Enter the number of kilometers: ");
        kilometers = reader.nextDouble();
        miles = kilometers * 5400 / 10000;
        System.out.print("The equivalent in nautical miles is ");
        System.out.println(miles);
        
    }
}
