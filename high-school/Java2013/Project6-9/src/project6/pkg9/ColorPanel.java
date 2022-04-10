/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project6.pkg9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel{
    private Circle c1, c2;
    private javax.swing.Timer timer;
    private boolean timerGoing = true;
    private int c1Direction = 0, c2Direction = 0;
      
    public ColorPanel(){
        setBackground(Color.white);
        c1 = new Circle(100,400,50,Color.yellow);
        c2 = new Circle(700,400,50,Color.red);
        c1.setVelocity(20);
        c1Direction = 0;
        c1.setDirection(c1Direction);
        c2.setVelocity(20);
        c2Direction = 270;
        c2.setDirection(c2Direction);
        timer = new javax.swing.Timer(125, new MoveListener());
        timer.start();
        addMouseListener(new startStopListener());
    }
    
    public ColorPanel(Color backColor){
        setBackground(backColor);
        c1 = new Circle(400,400,50,Color.yellow);
        c2 = new Circle(400,400,50,Color.red);
        c1.setVelocity(100);
        c1Direction = 0;
        c1.setDirection(c1Direction);
        c2.setVelocity(100);
        c2Direction = 270;
        c2.setDirection(c2Direction);
        timer = new javax.swing.Timer(125, new MoveListener());
        timer.start();
        addMouseListener(new startStopListener());
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        c1.draw(g);
        c2.draw(g);
    }
    
    private class MoveListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            c1.move();
            c2.move();
            repaint();
            if(c1.atEnd()){
                c1.turn(180);
                c1.turn(10);
            }if(c2.atEnd()){
                c2.turn(180);
                c2.turn(10);
                
            }
        }
    }
    
    private class startStopListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            if(timer.isRunning()){
                timer.stop();
            }else{
                timer.start();
            }
        }
    }
}
