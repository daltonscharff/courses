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
public class StringPanel extends JPanel {
    public StringPanel()  {
        setBackground(Color.red);
        
    } 
    
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.white);
    Font testFont = new Font("Courier", Font.BOLD, 30);
    g.setFont(testFont);
    g.drawString("This is text!",160,180);
    
}
}