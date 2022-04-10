/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg5_8;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author 14dscharff
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Circle Example");
        theGUI.setSize(500,500);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int w1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the width of the first rectangle:"));
        int h1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the height of the first rectangle:"));
        int w2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the width of the second rectangle:"));
        int h2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the height of the second rectangle:"));
        ColorPanel panel = new ColorPanel(Color.lightGray, w1, h1, w2, h2);
        Container Pane = theGUI.getContentPane();
        Pane.add(panel);
        theGUI.setVisible(true);
    }
}
