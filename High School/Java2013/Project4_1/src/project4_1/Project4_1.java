/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_1;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author 14dscharff
 */
public class Project4_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x,y,temp;
        String inputStr = JOptionPane.showInputDialog("Enter a number.","1");
        if (inputStr == null){
            return;
        }
        x = Integer.parseInt(inputStr);
        String inputStri = JOptionPane.showInputDialog("Enter a second number.","1");
        if (inputStri == null){
            return;
        }
        y = Integer.parseInt(inputStri);
        if (y > x){
            temp = x;
            x = y;
            y = temp;
        }
        int z = (x/y);
        int zz = x % y;
        JOptionPane.showMessageDialog (null, "The quotient is " + z + " r " + zz);
        }
}
