/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author 14dscharff
 */
public class Project5_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Project 5-9");
        theGUI.setSize(400,400);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(8,8));
        for (int x = 0; x < 64; x++){
            ColorPanel panel = new ColorPanel(Color.white);
            pane.add(panel);
        }
        theGUI.setVisible(true);
        
    }
}
