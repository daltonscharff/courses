/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_7;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Project5_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double picAmount;
        JOptionPane.showInputDialog("How many pictures would you like to see? (1, 2, or 4)");
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Project 5-7");
        theGUI.setSize(300,300);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
    }
}
