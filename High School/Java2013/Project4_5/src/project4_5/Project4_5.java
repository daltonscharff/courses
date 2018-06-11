/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_5;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Project4_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double n = 3;
        double pi;
        double mul = 1;
        String inputStr = JOptionPane.showInputDialog("Input how many interations of Pi you would like.", "3");
        if (inputStr == null){
            return;
        }
        int i = Integer.parseInt(inputStr);
        int x = 0;
        pi = (1.0 - (1.0/3.0));
        for(int t = 1; t < i; t++){
            mul *= -1;
            n += 2;
            pi -= ((1.0/n) * mul);
        }
        pi *= 4;
        JOptionPane.showMessageDialog(null, "Pi = " + pi);
        
                
    }
}
