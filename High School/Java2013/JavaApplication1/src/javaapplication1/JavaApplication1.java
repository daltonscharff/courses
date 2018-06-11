/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author Dalton
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         JFrame theGUI = new JFrame();
         theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         theGUI.setTitle("Game Test");
         theGUI.setSize(1000,300);
         theGUI.setVisible(true);
         
         Scanner reader = new Scanner(System.in);
         System.out.println("Please input WASD direction: ");
         String input = reader.nextLine();
         
         Container pane = theGUI.getContentPane();
         ColorPanel panel1 = new ColorPanel(input);
         pane.add(panel1);
         
         
    }
    
}
