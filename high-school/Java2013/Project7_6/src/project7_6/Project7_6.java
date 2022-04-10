/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project7_6;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Project7_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIWindow theGUI = new GUIWindow();
        theGUI.setTitle("Radius Calculator");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.pack();
        theGUI.setSize(400,250);
        theGUI.setVisible(true);
    }
}
