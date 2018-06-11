/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 *
 * @author 14dscharff
 */
public class ColorPanel extends JPanel{
    int x,y;
    
    public ColorPanel(Color originalWhite){
        setBackground(originalWhite);
        addMouseListener(new PanelListener());
    }
    
private class PanelListener extends MouseAdapter{
        
        public void mousePressed(MouseEvent e){
            Random gen = new Random();
            int red = gen.nextInt(256); 
            int green = gen.nextInt(256); 
            int blue = gen.nextInt(256);
            Color newColor = new Color (red,green,blue);
            setBackground(newColor);
            repaint();
            }
        }
    }

