/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guip50;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Guip50 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle ("Figure 2-13 Page 50");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setSize(300,200);
        JPanel northPanel = new JPanel ();
        northPanel.setBackground(Color.red);
        JPanel eastPanel = new JPanel ();
        eastPanel.setBackground(Color.blue);
        JPanel southPanel = new JPanel ();
        southPanel.setBackground(Color.red);
        JPanel westPanel = new JPanel();
        westPanel.setBackground (Color.blue);
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground (Color.white);
        Container pane = theGUI.getContentPane();
        pane.add(northPanel,BorderLayout.NORTH);//BorderLayout is default
        pane.add(eastPanel,BorderLayout.EAST);
        pane.add(southPanel,BorderLayout.SOUTH);
        pane.add(westPanel,BorderLayout.WEST);
        pane.add(centerPanel,BorderLayout.CENTER);
        theGUI.setVisible(true);
        
    }
}
