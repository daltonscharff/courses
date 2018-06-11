package chapter.pkg3.pkg7;
import javax.swing.*;
import java.awt.*;


public class Chapter37 {

  
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle ("GUI Program");
        theGUI.setSize (300,200);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ColorPanel panel = new ColorPanel(Color.blue);
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
        
    }
        
}
