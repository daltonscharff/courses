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
public class XPanel extends JPanel {
    public XPanel()  {
       setBackground(Color.white);
       } 
    
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.red);
    g.drawLine(0,0,200,200);
    g.drawLine(200,0,0,200);
    
}
}