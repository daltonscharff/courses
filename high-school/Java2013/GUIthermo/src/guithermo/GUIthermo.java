/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guithermo;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class GUIthermo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIWindow theGUI = new GUIWindow();
        theGUI.setTitle("F to C Converter");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.pack();
        theGUI.setSize(400,150);
        theGUI.setVisible(true);
    }
}
