/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_6;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 14dscharff
 */
public class Project4_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double pop = 1;
        double gR = 1;
        double gP = 1;
        double fP = 1;
        double multiplier = 1;
        double total = 1;
        String population = JOptionPane.showInputDialog("What is your starting population?", "500");
        if (population == null){
            return;
        }
        String growthRate = JOptionPane.showInputDialog("What is your growth rate?", "2");
        if (growthRate == null){
            return;
        }
        String growthPeriod = JOptionPane.showInputDialog("What is your growth period (in hours)?", "6");
        if (growthPeriod == null){
            return;
        }
        String finalPeriod = JOptionPane.showInputDialog("How far in the future should I predict?", "12");
        if (finalPeriod == null){
            return;
        }
        pop = Double.parseDouble(population);
        gR = Double.parseDouble(growthRate);
        gP = Double.parseDouble(growthPeriod);
        fP = Double.parseDouble(finalPeriod);
        total = pop * Math.pow(fP, fP)
        
        JOptionPane.showMessageDialog(null, "The population after " + fP + " hours is " + total + ".");
        
    }
}
