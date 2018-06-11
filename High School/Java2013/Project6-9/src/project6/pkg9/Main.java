/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project6.pkg9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Project 6-8");
        theGUI.setPreferredSize(new Dimension(800,800));
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        ColorPanel panel = new ColorPanel(Color.black);
        pane.add(panel);
        theGUI.pack();
        theGUI.setVisible(true);
    }
}
