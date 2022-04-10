/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proj5_7;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Proj5_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Setting Images Exercise");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String numPics = JOptionPane.showInputDialog("How many pictures would you like to display?", "1");
        int pics = Integer.parseInt(numPics);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new GridLayout(1,pics));
                
        for (int x = 1; x <= pics; x++){
            if (x == 1){
                ImageIcon II1 = new ImageIcon("picture1.jpg");
                ColorPanel cp1 = new ColorPanel(II1, Color.green);
                pane.add(cp1);
            }
            if (x == 2){
                ImageIcon II2 = new ImageIcon("picture2.jpg");
                ColorPanel cp2 = new ColorPanel(II2, Color.blue);
                pane.add(cp2);
            }
            if (x == 3){
                ImageIcon II3 = new ImageIcon("picture3.jpg");
                ColorPanel cp3 = new ColorPanel(II3, Color.red);
                pane.add(cp3);
            }
            if (x == 4){
                ImageIcon II4 = new ImageIcon("picture4.jpg");
                ColorPanel cp4 = new ColorPanel(II4, Color.orange);
                pane.add(cp4);
            }
        }
        theGUI.pack();
        theGUI.setVisible(true);
    }
}
