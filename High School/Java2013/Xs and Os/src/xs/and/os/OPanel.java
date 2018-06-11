/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xs.and.os;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class OPanel extends JPanel {
    public OPanel()  {
       setBackground(Color.white);
       } 
    
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.green);
    g.drawOval(0,0,180,180);
    
}
}