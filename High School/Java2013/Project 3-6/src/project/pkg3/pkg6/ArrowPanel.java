/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.pkg6;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ArrowPanel extends JPanel{
    public ArrowPanel(){
        setBackground(Color.pink);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(10F));
        g.setColor(Color.white);
        g.drawLine(100,75,300,75);
        g.drawLine(100,75,120,50);
        g.drawLine(100,75,120,100);
        g.drawLine(300,75,280,50);
        g.drawLine(300,75,280,100);
        
        g.drawLine(100,175,300,175);
        g.drawLine(100,175,80,150);
        g.drawLine(100,175,80,200);
        g.drawLine(300,175,320,150);
        g.drawLine(300,175,320,200);

    }
}
