/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package screensize;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author 14dscharff
 */
public class ScreenSize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        JOptionPane.showMessageDialog(null, "The screen's width is " + width + " and height is " + height ".");
    }
}
