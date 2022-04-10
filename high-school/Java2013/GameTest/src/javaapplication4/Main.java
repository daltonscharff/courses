/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Dalton Scharff
 */
public class Main extends JFrame{

    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("The Adventures of Beowulf");
        if(false){
            theGUI.setUndecorated(false);
            theGUI.setExtendedState(theGUI.MAXIMIZED_BOTH);
        }else{
            theGUI.setSize(800, 600);
            theGUI.setLocation(1,1);
            theGUI.setLocationRelativeTo(null);
            theGUI.setResizable(true);
        }
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("dist\\beowulf.jpg");
        CenteredImage beo = new CenteredImage(Color.white, image);
        Container pane = theGUI.getContentPane();
        pane.add(beo);
        theGUI.setVisible(true);
        
        String input1 = JOptionPane.showInputDialog("This can be a question?", "");
        int x = Integer.parseInt(input1);
        JOptionPane.showMessageDialog(null, x);
        
        if (x == 1){
            ImageIcon image2 = new ImageIcon("dist\\bg2.jpg");
            CenteredImage beo2 = new CenteredImage(Color.white, image2);
            Container pane2 = theGUI.getContentPane();
            pane.remove(beo);
            pane.add(beo2);
            theGUI.revalidate();
            
            
        }
        
    }
}
