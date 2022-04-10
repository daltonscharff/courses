/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pkg5;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class Project25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double mass;
        double velocity;
        double momentum;
        System.out.print("Input object's mass in kilograms: ");
        mass = reader.nextDouble();
        System.out.print("Input object's velocity in meters/second: ");
        velocity = reader.nextDouble();
        momentum = mass * velocity;
        System.out.print("The object's momentum is ");
        System.out.println(momentum + " kg*m/s");
        System.out.print("");
        
    }
}
