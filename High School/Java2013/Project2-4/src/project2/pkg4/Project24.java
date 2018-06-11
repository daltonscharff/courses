/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pkg4;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class Project24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double year;
        double day;
        double hour;
        double minute;
        
        minute = 60;
        hour = minute * 60;
        day = hour * 24;
        year = day * 365;
        
        System.out.print("The number of seconds is ");
        System.out.println(year);
    }
}
