/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.pkg1;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variable Instantiation
        String name = "Dalton Scharff";
        String radiusS, areaS, circumferenceS;
        float radius = 5;
        double area = Math.pow(radius,2) * Math.PI;
        double circumference = 2 * Math.PI * radius;
        
        // Console
        System.out.printf("The area of a circle with the radius %.0f is %.2f.\n"
                + "Its circumference is %.2f.\n\n", radius, area, circumference);
        System.out.println(name + ", the program is ending now.");
    }
    
}
