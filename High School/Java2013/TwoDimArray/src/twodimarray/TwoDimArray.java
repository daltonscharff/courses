/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twodimarray;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TwoDimArray {

    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double[][] grades = new double[2][3];
        String[] names = new String[2];
        
        for (int x = 0; x < 2; x++){
            System.out.print("Please enter a name: ");
            names[x] = reader.nextLine();
        }
        
        for (int r = 0; r < 2; r++){
            for (int c = 0; c < 3; c++){
                System.out.print("Please enter a grade for " + names[r] + ": ");
                grades[r][c] = reader.nextDouble();
            }
        }
        
        System.out.println("Name     Score 1     Score 2     Score 3");
        for (int r = 0; r < 2; r++){
            String nm = names[r];
            System.out.printf("%-9s%-12.2f%-12.2f%-12.2f%n", nm, grades[r][0], grades[r][1], grades[r][2]);
            
        }
    }
}
