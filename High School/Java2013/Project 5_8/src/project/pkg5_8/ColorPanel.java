/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg5_8;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ColorPanel extends JPanel{
    private Rectangle r1, r2;
    private Rectangle selectedRectangle;
    int x,y;
    
    public ColorPanel(Color backColor, int x1, int y1, int x2, int y2){
        setBackground(backColor);
        r1 = new Rectangle(200, 100, x1, y1, Color.darkGray);
        r2 = new Rectangle(100, 100, x2, y2, Color.black);
        selectedRectangle = null;
        addMouseListener(new PanelListener());
        addMouseMotionListener(new PanelMotionListener());
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        r1.fill(g);
        r2.drawRectangle(g);
    }
    
    private class PanelListener extends MouseAdapter{
        
        public void mousePressed(MouseEvent e){
            x = e.getX();
            y = e.getY();
            if(r1.containsPoint(x,y)){
                selectedRectangle = r1;
            }else if (r2.containsPoint(x,y)){
                selectedRectangle = r2;
            }
        }
        
        public void mouseReleased(MouseEvent e){
            x = e.getX();
            y = e.getY();
            selectedRectangle = null;
        }
    }
    
    private class PanelMotionListener extends MouseMotionAdapter{
        
        public void mouseDragged(MouseEvent e){
            int newX = e.getX();
            int newY = e.getY();
            int dx = newX - x;
            int dy = newY - y;
            if(selectedRectangle != null){
                selectedRectangle.move(dx,dy);
        }
            x = newX; y = newY;
            repaint();
        }
    }
}
