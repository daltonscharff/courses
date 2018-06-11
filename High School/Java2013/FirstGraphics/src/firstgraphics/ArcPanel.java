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
public class ArcPanel extends JPanel{
    public ArcPanel() {
        setBackground(Color.white);
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g); // super means you're refrencing the JPanel
        g.setColor(Color.red);
        g.drawArc(50,50,300,300,45,90);
        g.setColor(Color.white);
        g.drawArc(50,51,300,301,45,90);
        g.setColor(Color.blue);
        g.drawArc(50,52,300,302,45,90);
        g.setColor(Color.white);
        g.drawArc(50,53,300,303,45,90);
        g.setColor(Color.red);
        g.drawArc(50,54,300,304,45,90);
        g.setColor(Color.white);
        g.drawArc(50,55,300,305,45,90);
        g.setColor(Color.blue);
        g.drawArc(50,56,300,306,45,90);
    }
}
