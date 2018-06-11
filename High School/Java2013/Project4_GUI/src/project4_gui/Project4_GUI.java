/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_gui;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Project4_GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setSize(800,400);
        theGUI.setTitle("Induced Contrast");
        theGUI.setResizable(false);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
        Container pane = theGUI.getContentPane();
        Color color;
        color = Color.black;
        ColorPanel panel = new ColorPanel(color, 400, 400);
        color = Color.white;
        ColorPanel panel2 = new ColorPanel(color, 400, 400);
        pane.setLayout(new GridLayout(1,2));
        pane.add(panel);
        pane.add(panel2);
        
        
    }
}
