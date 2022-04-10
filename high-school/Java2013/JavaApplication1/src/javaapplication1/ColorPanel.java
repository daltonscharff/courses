/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.util.*;



public class ColorPanel extends JPanel{
    public ColorPanel(String i){
        setBackground(Color.blue);
        setInput(i);
        setXY();
    }
     
int x = 50;
int y = 50;
String input = null;

public void setXY(){
    if (input.equalsIgnoreCase("d")){
    x += 10;
    }
    if (input.equalsIgnoreCase("a")){
    x -= 10;
    }
    if (input.equalsIgnoreCase("s")){
    y += 10;
    }
    if (input.equalsIgnoreCase("w")){
    y -= 10;
    }
}
     
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.yellow);
    g.fillOval(wantX(), wantY(), 50, 50);   
}

public int wantX(){
    return x;
}


public int wantY(){
    return y;
}

public void setInput(String i){
    input = i;
}

}
