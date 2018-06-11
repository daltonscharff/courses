/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lotsofpanels;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ColorPanel extends JPanel{
    public ColorPanel (Color backColor, int width, int height){
        setBackground(backColor);
        setPreferredSize(new Dimension(width, height)); //method that sets the size of each panel, like the setSize method for JFrame
        }
    public ColorPanel (Color backColor){
            setBackground(backColor);
        }
    }
