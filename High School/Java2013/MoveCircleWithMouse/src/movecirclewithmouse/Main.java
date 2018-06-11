/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movecirclewithmouse;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main {

    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Project 6-8");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        ColorPanel panel = new ColorPanel(Color.LIGHT_GRAY, 400,400);
        pane.add(panel);
        theGUI.pack();
        theGUI.setVisible(true);
    }
}
