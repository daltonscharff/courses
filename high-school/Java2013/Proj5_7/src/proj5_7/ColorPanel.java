/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proj5_7;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ColorPanel extends JPanel{
    ImageIcon I; Color c;
    
    public ColorPanel(ImageIcon II, Color cl){
        I = II;
        c = cl;
        setBackground(c);
        setPreferredSize(new Dimension(480,480));
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x = (getWidth() - I.getIconWidth()) / 2;
        int y = (getHeight() - I.getIconHeight()) / 2;
        I.paintIcon(this, g, x, y);
    }
}
