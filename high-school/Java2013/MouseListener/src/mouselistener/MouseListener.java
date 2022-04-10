/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mouselistener;
import javax.swing.*;
import java.awt.*;

public class MouseListener {

    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Circle Example");
        theGUI.setSize(500,500);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ColorPanel panel = new ColorPanel(Color.lightGray);
        Container Pane = theGUI.getContentPane();
        Pane.add(panel);
        theGUI.setVisible(true);
    }
}
