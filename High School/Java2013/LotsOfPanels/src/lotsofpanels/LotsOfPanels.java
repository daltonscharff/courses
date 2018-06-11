/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lotsofpanels;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
 *
 * @author 14dscharff
 */
public class LotsOfPanels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Lots of Panels");
        String inputStr = JOptionPane.showInputDialog("How many rows?","5"); //input dialog box
        if (inputStr == null){ //makes sure that the input is a number
            return;
        }
        int rows = Integer.parseInt(inputStr);
        inputStr = JOptionPane.showInputDialog("How many columns?", "5");
        if (inputStr == null){
            return;
        }
        int cols = Integer.parseInt(inputStr);
        theGUI.setSize(rows * 50,cols * 50);
        theGUI.setDefaultCloseOperation(theGUI.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        pane.setLayout (new GridLayout(rows, cols));
        Random gen = new Random(); //random generator created
        for(int i = 1; i <= rows * cols; i++){
            int red = gen.nextInt(256); //sets a color between 0 to 255 and sets it equal to red variable
            int green = gen.nextInt(256); 
            int blue = gen.nextInt(256);
            Color backColor = new Color(red,green,blue);
            ColorPanel panel = new ColorPanel(backColor,50,50); //sets width and height of panel or blocks, sends color and integers
            pane.add(panel);
        }
        theGUI.pack();
        theGUI.setVisible(true);
                
    }
}
