/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_11;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ColorPanel extends JPanel{
    public ColorPanel (Color backColor, int width, int height){
        setBackground(backColor);
        setPreferredSize(new Dimension(width, height));
    }
}
