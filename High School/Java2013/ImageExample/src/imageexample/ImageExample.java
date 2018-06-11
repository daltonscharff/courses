/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageexample;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ImageExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Picture Image Example");
        theGUI.setSize(300,300);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("pics\\miniSplash.jpg");
        ColorPanel panel = new ColorPanel(Color.black, image);
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
        
    }
}
