/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_3;
import javax.swing.*;
import java.awt.*;

public class Main {

   
    public static void main(String[] args) {
        int n1 = 1, n2 = 1, d1 = 1, d2 = 1;
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        String temp = "";
        String result = "";
        String message = "";
        
        // Creating First Fraction
        message = "Hold";
        while(!(message == null)){
            temp = JOptionPane.showInputDialog("Please enter a NUMERATOR of the first fraction", "1");
            n1 = Integer.parseInt(temp);
            temp = JOptionPane.showInputDialog("Please enter a DENOMINATOR of the first fraction", "1");
            d1 = Integer.parseInt(temp);
            f1 = new Fraction(n1,d1);
            temp = f1.toString();
            message = f1.validateData();
            if (message != null){
                JOptionPane.showMessageDialog(null, message);
            }
        }
        
        // Creating Second Fraction
        message = "Hold";
        while(!(message == null)){
            temp = JOptionPane.showInputDialog("Please enter a NUMERATOR of the second fraction", "1");
            n2 = Integer.parseInt(temp);
            temp = JOptionPane.showInputDialog("Please enter a DENOMINATOR of the second fraction", "1");
            d2 = Integer.parseInt(temp);
            f2 = new Fraction(n2,d2);
            message = f2.validateData();
            if (message != null){
                JOptionPane.showMessageDialog(null,message);
            }
        }
        
        Operations Op = new Operations();
             
        int choice = 5;
        while (choice < 1 || choice > 4){
        temp = JOptionPane.showInputDialog("Enter 1 to add, 2 to subtract, 3 to multiply, 4 to divide:", "1");
        choice = Integer.parseInt(temp);
        if (choice == 1){
            Op.setData(f1, f2, n1, d1, n2, d2);
            result = Op.Add();
        }
        if (choice == 2){
            Op.setData(f1, f2, n1, d1, n2, d2);
            result = Op.Subtract();
        }
        if (choice == 3){
            Op.setData(f1, f2, n1, d1, n2, d2);
            result = Op.Multiply();
        }
        if (choice == 4){
            Op.setData(f1, f2, n1, d1, n2, d2);
            result = Op.Divide();
        }
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
