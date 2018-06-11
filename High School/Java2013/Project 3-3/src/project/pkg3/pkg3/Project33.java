/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.pkg3;
import java.util.Scanner;

/**
 *
 * @author 14dscharff
 */
public class Project33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double mass, velocity, momentum, kineticEnergy;
        System.out.print("Please input the mass in kg: ");
        mass = reader.nextDouble();
        System.out.print("Please input the velocity in m/s^2: ");
        velocity = reader.nextDouble();
        momentum = mass * velocity;
        kineticEnergy = 0.5 * mass * (velocity * velocity);
        System.out.println("The momentum of the object in question is: " 
        + momentum + " kg*m/s^2" + "\n" + "The kinetic energy of the object is: " 
        + kineticEnergy + " joules");
        
    }
}
