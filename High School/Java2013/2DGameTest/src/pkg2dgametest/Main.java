
package pkg2dgametest;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setVisible(true);
        theGUI.setSize(640,480);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setTitle("2D Game");
        theGUI.setResizable(false);
        theGUI.getContentPane().setBackground(Color.WHITE);
    }
    
}
