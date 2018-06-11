/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgraphics;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class FirstGraphics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setSize (400,400);
        theGUI.setTitle ("First Shapes");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        StringPanel panel1 = new StringPanel();
        pane.add(panel1);
        theGUI.setVisible(true);
        
    }
}
