/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ch.pkg4.test;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class ProjectCh4Test {

    /** Input two runner's times 4 times each. Then graph
     * @param args the command line arguments
     */
    public static void main(String[] args){
             
        JFrame theGUI = new JFrame();
        theGUI.setSize(640, 520);
        theGUI.setTitle("Chapter 4 Project");
        theGUI.setResizable(false);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //MATH AND INPUT SECTION
        
        double quarter = 1, oneFifty = 0.02, xCord = 1, yCord = 1;
        int y = 1, x = 1, z = 1; 
        int xCordinate1, yCordinate1, xCordinate2, yCordinate2, xCordinate3, yCordinate3, xCordinate4, yCordinate4;
        int xCordinate5, yCordinate5, xCordinate6, yCordinate6, xCordinate7, yCordinate7, xCordinate8, yCordinate8;
        int lastX1, lastY1, lastX2, lastY2, lastX3, lastY3, lastX4, lastY4;
        int lastX5, lastY5, lastX6, lastY6, lastX7, lastY7, lastX8, lastY8;
        
               
        for (x = 1; x <= 2; x++){
            for (y = 1; y <= 4; y++){
                if (x == 1){
                if (y == 1){
                    String inputStr1 = JOptionPane.showInputDialog("Time (in minutes) of runner one's first quarter?", "1");
                    quarter = Double.parseDouble(inputStr1);
                    yCord = 400 - (quarter / oneFifty);
                    yCordinate1 = (int) yCord;
                    xCord = 100 + y * 100;
                    xCordinate1 = (int) xCord;
                    lastX1 = xCordinate1;
                    lastY1 = yCordinate1;
                    
                }
                if (y == 2){
                    String inputStr2 = JOptionPane.showInputDialog("Time (in minutes) of runner one's second quarter?", "1");
                    quarter = Double.parseDouble(inputStr2);
                    yCord = 400 - (quarter / oneFifty);
                    yCordinate2 = (int) yCord;
                    xCord = 100 + y * 100;
                    xCordinate2 = (int) xCord;
                    lastX2 = xCordinate1;
                    lastY2 = yCordinate1;
                    
                }
                if (y == 3){
                    String inputStr3 = JOptionPane.showInputDialog("Time (in minutes) of runner one's third quarter?", "1");
                    quarter = Double.parseDouble(inputStr3);
                    yCord = 400 - (quarter / oneFifty);
                    yCordinate3 = (int) yCord;
                    xCord = 100 + y * 100;
                    xCordinate3 = (int) xCord;
                    lastX3 = xCordinate2;
                    lastY3 = yCordinate2;
                    
                }
                if (y == 4){
                    String inputStr4 = JOptionPane.showInputDialog("Time (in minutes) of runner one's forth quarter?", "1");
                    quarter = Double.parseDouble(inputStr4);
                    yCord = 400 - (quarter / oneFifty);
                    yCordinate4 = (int) yCord;
                    xCord = 100 + y * 100;
                    xCordinate4 = (int) xCord;
                    lastX4 = xCordinate3;
                    lastY4 = yCordinate3;
                }
                }
                               
                
                System.out.println("y = " + y);
                System.out.println("x = " + x);
                
            }
        }
        
        BackgroundPanel panel1 = new BackgroundPanel(Color.white, xCordinate1, yCordinate1, xCordinate2, yCordinate2, xCordinate3, yCordinate3, xCordinate4, yCordinate4, xCordinate5, yCordinate5, xCordinate6, yCordinate6, xCordinate7, yCordinate7, xCordinate8, yCordinate8);
        Container pane = theGUI.getContentPane();
        pane.add(panel1);
        theGUI.setVisible(true);
        
   
    }
}

