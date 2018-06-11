/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xs.and.os;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class XsAndOs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setSize (600,600);
        theGUI.setTitle ("Xs and Os");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        XPanel panel1 = new XPanel();
        
        XPanel panel2 = new XPanel();
        
        XPanel panel3 = new XPanel();
        
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.white);
        OPanel panel5 = new OPanel();
        
        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.white);
        OPanel panel7 = new OPanel();        
        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.white);
        OPanel panel9 = new OPanel();  
        
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(3,3));
        pane.add(panel1);
        pane.add(panel2);
        pane.add(panel3);
        pane.add(panel4);
        pane.add(panel5);
        pane.add(panel6);
        pane.add(panel7);
        pane.add(panel8);
        pane.add(panel9);
        theGUI.setVisible(true);
        
    }
}
