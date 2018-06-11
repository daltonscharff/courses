/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7test;
import javax.swing.*;
import java.awt.*;

public class Chapter7Test {

    public static void main(String[] args) {
        GUIwindow theGUI = new GUIwindow();
        theGUI.setTitle("Square and Square Roots");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.pack();
        theGUI.setSize(300,180);
        theGUI.setResizable(false);
        theGUI.setVisible(true);
        
    }
}
