/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project6.pkg9;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

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
        g.fillOval(centerX - radius - 25, centerY - radius - 50, radius * 2, radius * 2);
        g.setColor(oldColor);
    }
    
    public boolean containsPoint(int x, int y){
        int xSquared = (x - centerX) * (x - centerX);
        int ySquared = (y - centerY) * (y - centerY);
        int radiusSquared = radius * radius;
        return xSquared + ySquared - radiusSquared <= 0;
    }
    
    public void move(){
        centerX += (int)(velocity * Math.cos(Math.toRadians(direction)));
        centerY += (int)(velocity * Math.sin(Math.toRadians(direction)));
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
    
    public boolean atEnd(){
        int n = this.centerY - radius;
        int e = this.centerX + radius;
        int s = this.centerY + radius;
        int w = this.centerX - radius;
        if(n <= 0 || e >= 800 || s >=800 || w <= 0){
            return true;
        }else{
            return false;
        }
    }
}
