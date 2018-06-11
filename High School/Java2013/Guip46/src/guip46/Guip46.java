/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guip46;

import javax.swing.*; //Access JFrame and JPanel


/**
 *
 * @author 14dscharff
 */
public class Guip46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //Know these next five lines
        JFrame theGUI = new JFrame(); //theGUI can be any variable
        theGUI.setTitle("First GUI Program"); //Title of program
        theGUI.setSize (300,200); //300 pixels wide, 200 pixels high
        theGUI.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);//What x does
        theGUI.setVisible(true); //Makes your window visible
        
    }
}
