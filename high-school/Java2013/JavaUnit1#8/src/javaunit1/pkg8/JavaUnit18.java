/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaunit1.pkg8;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class JavaUnit18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int width, height;
        System.out.print("Please input a width: ");
        width = reader.nextInt();
        System.out.print("Please input a height: ");
        height = reader.nextInt();
        
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Unit 1 Project 8");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setSize(width,height);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout (1,3));
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.blue);
        pane.add(panel1);
        pane.add(panel2);
        pane.add(panel3);
        theGUI.setVisible(true);
        
    }
}
