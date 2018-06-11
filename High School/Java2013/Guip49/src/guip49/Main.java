/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guip49;

import javax.swing.*;
import java.awt.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle ("Second GUI Program");
        theGUI.setSize(300,200);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);        
    }
}
