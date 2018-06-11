/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg6_5;
import javax.swing.*;
import java.awt.*;

public class Project6_5 {

    public static void main(String[] args) {
        int highNumber = 0, lowNumber = 0, temp;
        boolean a = true;
        while (a == true){
        highNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter your first integer."));
        lowNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter your second integer."));
        if (lowNumber < 0 || highNumber < 0){
            JOptionPane.showMessageDialog(null,"Please enter positive integers.");
        }else{
            a = false;
            //break;
        }
        }
        
        // Find which is actually the largest number
        if (lowNumber > highNumber){
            temp = lowNumber;
            lowNumber = highNumber;
            highNumber = temp;
        }
        
        // Creating backup variables
        int originalLow, originalHigh;
        originalLow = lowNumber;
        originalHigh = highNumber;
                
        // Algorithm
        a = true;
        while (a == true){
        JOptionPane.showMessageDialog(null,"High Number: " + highNumber + "     Low Number: " + lowNumber);
        int remainder = highNumber % lowNumber;
        highNumber = lowNumber;
        lowNumber = remainder;
        if (lowNumber <= 0){
            a = false;
            JOptionPane.showMessageDialog(null,"The greatest commmon divisor of " + 
                    originalHigh + " and " + originalLow + " is " + highNumber + ".");
            //break;
        }
        }
    }
}
