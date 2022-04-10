/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movecirclewithmouse;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
/**
 *
 * @author 14dscharff
 */
public class Circle {
    
    private int centerX, centerY, radius;
    private int velocity, direction, move;
    private Color color;
    Graphics g;
    
    public Circle(int x, int y, int r, Color c){
        centerX = x;
        centerY = y;
        radius = r;
        color = c;
    }
    
    public void draw (Graphics g){
        Color oldColor = g.getColor();
        g.setColor(color);
        g.drawOval(centerX - radius - 25, centerY - radius - 50, radius * 2, radius * 2);
        g.setColor(oldColor);
    }
    
    public void fill (Graphics g){
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillOval(centerX - radius - 25, centerY - radius - 50, radius * 2, radius * 2);
        g.setColor(oldColor);
    }
    
    public void setFilled (boolean a){
        
        if (a){
            fill(g);
        }else{
            draw(g);
        }
    }
    
    public boolean containsPoint(int x, int y){
        int xSquared = (x - centerX) * (x - centerX);
        int ySquared = (y - centerY) * (y - centerY);
        int radiusSquared = radius * radius;
        return xSquared + ySquared - radiusSquared <= 0;
    }
    
    public void move(int xAmount, int yAmount){
        centerX = centerX + xAmount;
        centerY = centerY + yAmount;
    }
    
    public void setVelocity(int v){
        velocity = v;
    }
    
    public void setDirection(int degrees){
        direction = degrees % 360;
    }
    
    public void turn(int degrees){
        direction = (direction + degrees) % 360;
    }
    
    public void move(){
        move((int)(velocity * Math.cos(Math.toRadians(direction))),
        (int)(velocity * Math.sin(Math.toRadians(direction))));
        
    }
}
