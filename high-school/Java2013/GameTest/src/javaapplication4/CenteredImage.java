/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Dalton Scharff
 */
public class CenteredImage extends JPanel{
    private ImageIcon image;
    public CenteredImage(Color backColor, ImageIcon i){
        setBackground(backColor);
        image = i;
    }        
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x = (getWidth() - image.getIconWidth()) / 2;
        int y = (getHeight() - image.getIconHeight()) / 2;
        image.paintIcon(this, g, x, y);
    }
    }

