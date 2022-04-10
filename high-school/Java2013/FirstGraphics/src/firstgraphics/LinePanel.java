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
public class LinePanel extends JPanel {
    public void LinePanel(){
        setBackground(Color.WHITE);
    }
      public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(10,25,40,55);
        
    }
}
