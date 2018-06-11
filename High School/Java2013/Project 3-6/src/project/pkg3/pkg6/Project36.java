/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.pkg6;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class Project36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Müller-Lyer Illusion   ಠ_ಠ");
        theGUI.setSize(400,300);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        ArrowPanel panel1 = new ArrowPanel();
        pane.add(panel1);        
        theGUI.setVisible(true);
        
        
    }
}
