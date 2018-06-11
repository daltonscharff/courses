/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiusconverted;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class RadiusConverted {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double radius, diameter, circumference, surfacearea, volume;
        final double PI = 3.14159265359;
        Scanner reader = new Scanner(System.in);
        System.out.print("Please input the radius of a circle: ");
        radius = reader.nextDouble();
        diameter = radius * 2;
        circumference = diameter * PI;
        volume = (4/3) * PI * (radius * radius * radius);
        surfacearea = 4 * PI * (radius * radius);
        System.out.println("Diameter: " + diameter + " units");
        System.out.println("Circumference: " + circumference + " units");
        System.out.println("Volume: " + volume + " units cubed");
        System.out.println("Surface Area: " + surfacearea + " units squared");
        
    }
}
