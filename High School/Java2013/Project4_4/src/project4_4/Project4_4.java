/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_4;
import javax.swing.*;
/**
 *
 * @author 14dscharff
 */
public class Project4_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int factorial = 1;
        double total = 1;
        String inputStr = JOptionPane.showInputDialog("What would you like factorialed?", "3");
        if (inputStr == null){
            return;
        }
        factorial = Integer.parseInt(inputStr);
        int x = factorial;
        while (x > 1){
            total *= x;
            x = x - 1;
        }
        JOptionPane.showMessageDialog(null, "The factorial of " + factorial + " is " + total);
    }
}
