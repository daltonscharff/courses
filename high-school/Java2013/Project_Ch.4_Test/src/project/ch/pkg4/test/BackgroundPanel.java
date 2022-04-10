/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ch.pkg4.test;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dalton Scharff
 */
public class BackgroundPanel extends JPanel{
    
    public BackgroundPanel(Color backColor){
        setBackground(backColor);
        }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        
        
        
        Font minionBold56 = new Font("Minion Pro", Font.BOLD, 56);
        Font timesBoldItalic12 = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 12);
        Font timesBold12 = new Font("Times New Roman", Font.BOLD, 12);
        Font times12 = new Font("Times New Roman", Font.PLAIN, 12);
        String titleM = "Race Times";
        String titleYa = "T";
        String titleYb = "I";
        String titleYc = "M";
        String titleYd = "E";
        String titleX = "DISTANCE";
        String sixM = "6 Min.";
        String fourM = "4 Min.";
        String twoM = "2 Min.";
        String oneF = "1st Quarter";
        String twoF = "2nd Quarter";
        String threeF = "3rd Quarter";
        String fourF = "4th Quarter";
        String racers = "Racers";
        String racer1 = "First Runner";
        String racer2 = "Second Runner";
        
        g.setColor(Color.blue);
        g.setFont(minionBold56);
        g.drawString(titleM, 200, 70);
        g.setColor(Color.gray);
        g.setFont(timesBoldItalic12);
        g.drawString(titleYa, 21, 200);
        g.drawString(titleYb, 23, 215);
        g.drawString(titleYc, 20, 230);
        g.drawString(titleYd, 20, 245);
        g.drawString(titleX, 275, 480);
        g.setColor(Color.black);
        g.setFont(times12);
        g.drawString(sixM, 55, 102);
        g.drawString(fourM, 55, 202);
        g.drawString(twoM, 55, 302);
        g.drawString(oneF, 172, 435);
        g.drawString(twoF, 272, 435);
        g.drawString(threeF, 372, 435);
        g.drawString(fourF, 472, 435);
        g.drawString(racer1, 555, 140);
        g.drawString(racer2, 555, 160);
        g.setFont(timesBold12);
        g.drawString(racers, 550, 100);
               
        g.setColor(Color.lightGray);
        g.drawLine(100, 100, 100, 400);
        g.drawLine(100, 400, 500, 400);
        g.drawLine(90, 100, 100, 100);
        g.drawLine(90, 200, 100, 200);
        g.drawLine(90, 300, 100, 300);
        g.drawLine(200, 400, 200, 420);
        g.drawLine(300, 400, 300, 420);
        g.drawLine(400, 400, 400, 420);
        g.drawLine(500, 400, 500, 420);
        
        g.setColor(Color.green);
        g.drawLine(510,135,550,135);
        g.setColor(Color.red);
        g.drawLine(510,156,550,156);
        
        
                
            }
        }
    

