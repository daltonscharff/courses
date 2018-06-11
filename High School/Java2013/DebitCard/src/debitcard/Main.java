/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debitcard;
import javax.swing.*;
import java.util.Random;

public class Main {

    
    public static void main(String[] args) {
        int expenditure, cash, purchase = 0;
        Random generator = new Random();
        String ccn = JOptionPane.showInputDialog("Please enter your Credit Card number:");
        cash = Integer.parseInt(JOptionPane.showInputDialog("Please enter your cash on hand:"));
        Buyer b1 = new Buyer(ccn, cash);
        
        while(cash > 0){
            expenditure = 0;
            while (expenditure == 0 || b1.getCash() - expenditure < 0){
                expenditure = generator.nextInt(21);
            }
            b1.changeCash(expenditure, ccn);
            JOptionPane.showMessageDialog(null, b1);
        }
    }
}
