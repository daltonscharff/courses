/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operationobject;
import javax.swing.*;
import java.awt.*;

public class Main {

    
    public static void main(String[] args) {
        
        int var1 = 0, var2 = 0;
        boolean a = true;
        while (a){
            var1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer less than 100:"));
            if (var1 < 0 || var1 > 100){
                JOptionPane.showMessageDialog(null, "Your number needs to be positive and less than 100.");
            }else{
                a = false;
            }
        }
        a = true;
        while (a){
            var2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter a second positive integer less than 100:"));
            if (var2 < 0 || var2 > 100){
                JOptionPane.showMessageDialog(null, "Your second number needs to be positive and less than 100.");
            }else{
                a = false;
            }
        }
        Operation o1 = new Operation(var1, var2);
        JOptionPane.showMessageDialog(null, o1);
    }
}
