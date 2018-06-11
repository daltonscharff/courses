/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg5_8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author 14dscharff
 */
public class Rectangle {
    private int width, height, leftMargin, topMargin, hCenter, wCenter;
    private Color c;
    
    public Rectangle() {
        width = 0; height = 0; leftMargin = 0; topMargin = 0; hCenter = 0; wCenter = 0;
    }
    
    public Rectangle(int left, int top, int w, int h, Color col){
        width = w; height = h; leftMargin = left; topMargin = top;
        wCenter = getHorizontalCenter(leftMargin, width);
        hCenter = getVerticalCenter(topMargin, height);
        c = col;
    }
    
    public int getHorizontalCenter(int lm, int w){
        int result = lm + (w/2);
        return result;
    }
    
    public int getVerticalCenter(int tM, int h){
        int result = tM + (h/2);
        return result;
    }
    
    public void drawRectangle(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(c);
        g.fillRect(leftMargin, topMargin, width, height);
        g.setColor(oldColor);
    }
    
    public void fill(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(c);
        g.fillRect(leftMargin, topMargin, width, height);
        g.setColor(oldColor);
    }
    
    public boolean containsPoint(int x, int y){
        boolean result;
        if(x > leftMargin && x < (leftMargin + width) && y > topMargin && y <(topMargin + height)){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
    
    public void move(int xAmount, int yAmount){
        leftMargin += xAmount;
        topMargin += yAmount;
    }
}
