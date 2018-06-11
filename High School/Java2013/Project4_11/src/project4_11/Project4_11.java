/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_11;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Project4_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Checkerboard");
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
        Container pane = theGUI.getContentPane();
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Please input the amount of rows."));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Please input the amount of columns."));
        pane.setLayout(new GridLayout(rows,cols));
        Color color;
        color = Color.red;
        for (int x = 1; x <= rows; x++){
            for (int y = 1; y <= cols; y++){
                ColorPanel panel = new ColorPanel(color, 50, 50);
                pane.add(panel);
                    if (color == Color.red){
                        color = Color.black;
                    }else{
                        color = Color.red;
                    }
            }
            if (cols % 2 == 0){
                if (color == Color.red){
                    color = Color.black;
                }else{
                    color = Color.red;
                }
            }
        }
        theGUI.pack();            
    }
}
