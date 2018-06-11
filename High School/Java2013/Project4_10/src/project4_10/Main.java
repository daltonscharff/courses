/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_10;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 *
 * @author 14dscharff
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double startingSalary, percentIncrease, years;
        Scanner reader = new Scanner(System.in);
        System.out.println("How many years will be in the schedule?");
        years = reader.nextDouble();
        System.out.println("What is the starting salary?");
        startingSalary = reader.nextDouble();
        double total = startingSalary;
        System.out.println("What is the percentage increase per year?");
        percentIncrease = reader.nextDouble();
        percentIncrease = (percentIncrease * 0.01) + 1;
        System.out.println("");
        System.out.println("Years ---------- Salary");
        System.out.println("0            $" + startingSalary);
        for (int x = 1; x <= years; x++){
            startingSalary = percentIncrease * startingSalary;
            System.out.println(x + "            $" + startingSalary);
        }
    }
}
