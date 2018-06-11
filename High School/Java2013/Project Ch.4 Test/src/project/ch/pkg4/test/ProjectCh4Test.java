/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ch.pkg4.test;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ProjectCh4Test {

    /** Input two runner's times 4 times each. Then graph
     * @param args the command line arguments
     */
    public static void main(String[] args){
             
        JFrame theGUI = new JFrame();
        theGUI.setSize(640, 520);
        theGUI.setTitle("Chapter 4 Project");
        theGUI.setResizable(false);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BackgroundPanel panel1 = new BackgroundPanel(Color.white);
        Container pane = theGUI.getContentPane();
        pane.add(panel1);
        theGUI.setVisible(true);
        
    }
}
