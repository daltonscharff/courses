/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_5;
import javax.swing.*;
import java.awt.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = null;
        int balance = 0, choice = 0;
        
        name = JOptionPane.showInputDialog("Please enter the name: ");
        balance = Integer.parseInt(JOptionPane.showInputDialog("Please enter your starting balance: ", "0"));
        BankAccount b1 = new BankAccount(name,balance);
        
        while (choice == 0){
            choice = Integer.parseInt(JOptionPane.showInputDialog("Select a choice:\n\n1. Deposit \n2. Withdraw \n3. End \n ", "0"));
            
            if(choice == 1){
                int deposit = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to deposit?", "0"));
                b1.addToBalance(deposit);
                choice = 0;
            }
            
            if(choice == 2){
                int withdraw = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to withdraw?", "0"));
                b1.subtractFromBalance(withdraw);
                choice = 0;
            }
            JOptionPane.showMessageDialog(null,b1.toString());
        }
        
    }
}
