/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guip51;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Guip51 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle ("Fourth GUI Program");
        theGUI.setSize (300,200);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.black);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.gray);
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.white);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(2,2));
        pane.add(panel1);
        pane.add(panel2);
        pane.add(panel3);
        pane.add(panel4);
        theGUI.setVisible(true);
                   
    }
}
