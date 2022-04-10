/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgraphics;
import javax.swing.*;
import java.awt.*;



public class RectPanel extends JPanel{
    public RectPanel(){
        setBackground(Color.red);       
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.drawRect(50,50,300,300);
                
    }
}

