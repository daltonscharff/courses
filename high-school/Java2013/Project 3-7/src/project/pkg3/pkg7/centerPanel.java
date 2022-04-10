/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.pkg7;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 14dscharff
 */
public class centerPanel extends JPanel{
    public centerPanel() {
        setBackground (Color.gray);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        Font thisFont = new Font("Courier", Font.BOLD, 12);
        int w = getWidth()/2;
        int h = getHeight()/2;
        int midWidth = w - 20;
        g.setFont (thisFont);
        String text = w + "," + h;
        g.drawString(text,midWidth,h);
     
}
}