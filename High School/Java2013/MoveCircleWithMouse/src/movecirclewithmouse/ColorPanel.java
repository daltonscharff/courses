/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movecirclewithmouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel{
    private Circle circle;
    private javax.swing.Timer timer;
    private boolean timerGoing = true;
    
    public ColorPanel(Color backColor, int width, int height){
        addMouseListener(new PanelListener());
        setBackground(backColor);
        setPreferredSize(new Dimension(width, height));
        circle = new Circle(width / 2, height / 2, 25, Color.DARK_GRAY);
        //circle.setFilled(true);
        circle.setVelocity(50);
        timer = new javax.swing.Timer(125, new MoveListener());
        timer.start();
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        circle.draw(g);
        circle.fill(g);
    }
    
    private class MoveListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            circle.move();
            circle.turn(45);
            repaint();
        }
    }
    
    private class PanelListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            if(timerGoing){
                timerGoing = false;
                timer.stop();
            }else{
                timerGoing= true;
                timer.start();
            }
        }
    }
}
