/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telephonecost;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class TelephoneCost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double twomin = 1.15;
        double addmin = .5;
        double total = 0;
        String inputStr = JOptionPane.showInputDialog("Enter the length of your phone call in minutes", "2");
        if (inputStr == null){
            return;
        }
        int callLength = Integer.parseInt(inputStr);
        if (callLength < 0){
            return;
        }
        if (callLength <= 2){
            total = callLength * (twomin / 2);
            JOptionPane.showMessageDialog(null, "Your total cost is: $" + total);
        }else{
            total = twomin + ((callLength - 2) * addmin);
            JOptionPane.showMessageDialog(null, "Your total cost is: $" + total);
        }
        
    }
}
