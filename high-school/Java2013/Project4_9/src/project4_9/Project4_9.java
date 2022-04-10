/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_9;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author 14dscharff
 */
public class Project4_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(new File("F:\\Java2013\\Project4_9\\numbers.txt"));
        String s = "";
        while (reader.hasNext()){
        double base = 1;
        base = reader.nextDouble();
        double exponent = reader.nextDouble();
        double answer = Math.pow(base, exponent);
        s += (base + " rasied to the power of " + exponent + " = " + answer + "\n");
     }
        JOptionPane.showMessageDialog(null, s);
     }
}
