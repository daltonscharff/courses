/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gridflag;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class GridFlag {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("French Flag");
        theGUI.setSize(400,300);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
        Container pane = theGUI.getContentPane();
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.blue);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.red);
        pane.setLayout(new GridLayout(1,3));
        pane.add(panel1);
        pane.add(panel2);
        pane.add(panel3);
        
        
    }
}
