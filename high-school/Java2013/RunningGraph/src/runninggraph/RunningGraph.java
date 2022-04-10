/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runninggraph;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Dalton Scharff
 */
public class RunningGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setSize(700, 550);
        theGUI.setTitle("Chapter 4 Project");
        theGUI.setResizable(true);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        double quarter = 1, oneFifty = 0.02, xCord = 1, yCord = 1;
        double t11 = 0,t12 = 0,t13 = 0,t14 = 0,t21 = 0,t22 = 0,t23 = 0,t24 = 0;
        int y = 1, x = 1, z = 1, xCordinate, yCordinate;
        String position = "und.";
        String inputStr = "und.";
               
        for (x = 1; x <= 2; x++){
            for (y = 1; y <= 4; y++){
                if (x == 1){
                if (y == 1){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner one's first quarter?", "1");
                    t11 = Double.parseDouble(inputStr);
                }
                if (y == 2){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner one's second quarter?", "1");
                    t12 = Double.parseDouble(inputStr);
                }
                if (y == 3){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner one's third quarter?", "1");
                    t13 = Double.parseDouble(inputStr);
                }
                if (y == 4){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner one's forth quarter?", "1");
                    t14 = Double.parseDouble(inputStr);
                }
                }else{
                 if (y == 1){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner two's first quarter?", "1");
                    t21 = Double.parseDouble(inputStr);
                }
                if (y == 2){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner two's second quarter?", "1");
                    t22 = Double.parseDouble(inputStr);
                }
                if (y == 3){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner two's third quarter?", "1");
                    t23 = Double.parseDouble(inputStr);
                }
                if (y == 4){
                    inputStr = JOptionPane.showInputDialog("Time (in minutes) of runner two's fourth quarter?", "1");
                    t24 = Double.parseDouble(inputStr);
                }   
                }
                
            }
        }
        
        ColorPanel panel1 = new ColorPanel(Color.white,t11,t12,t13,t14,t21,t22,t23,t24);
        Container pane = theGUI.getContentPane();
        pane.add(panel1);
        theGUI.setVisible(true);
    }
}
