/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_7;
import javax.swing.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class Project4_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double base = 1;
        while (base != -1){
        System.out.print("Please input your base: ");
        base = reader.nextDouble();
        if (base == -1){
            return;
        }
        System.out.print("Please input your exponent: ");
        double exponent = reader.nextDouble();
        double answer = Math.pow(base, exponent);
        System.out.println("Your answer is " + answer);
    }
        
}
