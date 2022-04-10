
package groupfinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JPanel{
    
    public String shape = "";
    public Question q;
    static Color c = Color.BLACK;
    boolean avail = true, permun = true;
    
    public Square(Question t){
        q = t;
        addMouseListener(new SquareListener());
        setSize(80,80);
        setBackground(new Color(225,225,225,250));
    }
    
    public void setX(){
        shape = "X";
    }
    
    public void setO(){
        shape = "O";
    }
    
    static public void setColor(Color f){
        c = f;
    }
    
    public String getC(){
        return q.C;
    }
    public String getD(){
        return q.D;
    }
    public char getAnswer(){
        return q.good;
    }
    
    public void setAvailable(boolean x){
        avail = x;
    }
    
    public void setPermUnavailable(){
        permun = false;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setColor(c);
        Font testFont = new Font("Ravie",Font.BOLD,70);
        g.setFont(testFont);
        g.drawString(shape, 5, 5);
    }
    
    private class SquareListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            if (avail && permun){
                Window.questT.setText(q.question);
                Window.ansA.setText(q.A);
                Window.ansB.setText(q.B);
                Window.ansC.setText(q.C);
                Window.ansD.setText(q.D);
                Window.checkQuestion(q);
            }
        }
    }
}