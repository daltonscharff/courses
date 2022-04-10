/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg6_2;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
 *
 * @author 14dscharff
 */
public class Project6_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean finished = false;
        boolean lessThan100 = false;
        int inputVal = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number that I will try to guess (0-100):", ""));
        int computerGenVal = 0, count = 0;
        Random generator = new Random();
        computerGenVal = generator.nextInt(101);
        
        while(finished = false){
            if (computerGenVal = inputVal){
                
            }
        }
        
    }
}
