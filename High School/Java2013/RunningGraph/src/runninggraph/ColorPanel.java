/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runninggraph;

import java.awt.*;
import javax.swing.*;
import java.util.*;


public class ColorPanel extends JPanel{

    public ColorPanel(Color backColor, double t11, double t12, double t13, double t14, double t21, double t22, double t23, double t24){
        setBackground(backColor);
        
        double yCord11 = 400 - (t11 / 0.02);
        Globals.yCordinate11 = (int) yCord11;
        double yCord12 = 400 - (t12 / 0.02);
        Globals.yCordinate12 = (int) yCord12;
        double yCord13 = 400 - (t13 / 0.02);
        Globals.yCordinate13 = (int) yCord13;
        double yCord14 = 400 - (t14 / 0.02);
        Globals.yCordinate14 = (int) yCord14;
        double yCord21 = 400 - (t21 / 0.02);
        Globals.yCordinate21 = (int) yCord21;
        double yCord22 = 400 - (t22 / 0.02);
        Globals.yCordinate22 = (int) yCord22;
        double yCord23 = 400 - (t23 / 0.02);
        Globals.yCordinate23 = (int) yCord23;
        double yCord24 = 400 - (t24 / 0.02);
        Globals.yCordinate24 = (int) yCord24;
        
        double xCord11 = 100 + 1 * 100;
        Globals.xCordinate11 = (int) xCord11;
        double xCord12 = 100 + 2 * 100;
        Globals.xCordinate12 = (int) xCord12;
        double xCord13 = 100 + 3 * 100;
        Globals.xCordinate13 = (int) xCord13;
        double xCord14 = 100 + 4 * 100;
        Globals.xCordinate14 = (int) xCord14;
        double xCord21 = 100 + 1 * 100;
        Globals.xCordinate21 = (int) xCord21;
        double xCord22 = 100 + 2 * 100;
        Globals.xCordinate22 = (int) xCord22;
        double xCord23 = 100 + 3 * 100;
        Globals.xCordinate23 = (int) xCord23;
        double xCord24 = 100 + 4 * 100;
        Globals.xCordinate24 = (int) xCord24;
        
}
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        
                
        Font minionBold56 = new Font("Minion Pro", Font.BOLD, 56);
        Font timesBoldItalic12 = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 12);
        Font timesBold12 = new Font("Times New Roman", Font.BOLD, 12);
        Font timesBold18 = new Font("Times New Roman", Font.BOLD, 18);
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
        g.setFont(timesBold12);
        g.drawString(racer1, 555, 140);
        g.drawString(racer2, 555, 160);
        g.setFont(timesBold18);
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
        
        g.setColor(Color.red);
        g.drawLine(510,135,550,135);
        g.setColor(Color.green);
        g.drawLine(510,156,550,156);
        
        //Draws Lines and Dots
        
        g.setColor(Color.red);
        g.fillOval(Globals.xCordinate11-5, Globals.yCordinate11-5, 10, 10);
        g.drawLine(Globals.xCordinate11, Globals.yCordinate11, Globals.xCordinate12, Globals.yCordinate12);
        g.fillOval(Globals.xCordinate12-5, Globals.yCordinate12-5, 10, 10);
        g.drawLine(Globals.xCordinate12, Globals.yCordinate12, Globals.xCordinate13, Globals.yCordinate13);
        g.fillOval(Globals.xCordinate13-5, Globals.yCordinate13-5, 10, 10);
        g.drawLine(Globals.xCordinate13, Globals.yCordinate13, Globals.xCordinate14, Globals.yCordinate14);
        g.fillOval(Globals.xCordinate14-5, Globals.yCordinate14-5, 10, 10);
                
        g.setColor(Color.green);
        g.fillOval(Globals.xCordinate21-5, Globals.yCordinate21-5, 10, 10);
        g.drawLine(Globals.xCordinate21, Globals.yCordinate21, Globals.xCordinate22, Globals.yCordinate22);
        g.fillOval(Globals.xCordinate22-5, Globals.yCordinate22-5, 10, 10);
        g.drawLine(Globals.xCordinate22, Globals.yCordinate22, Globals.xCordinate23, Globals.yCordinate23);
        g.fillOval(Globals.xCordinate23-5, Globals.yCordinate23-5, 10, 10);
        g.drawLine(Globals.xCordinate23, Globals.yCordinate23, Globals.xCordinate24, Globals.yCordinate24);
        g.fillOval(Globals.xCordinate24-5, Globals.yCordinate24-5, 10, 10);
        
    }
}
