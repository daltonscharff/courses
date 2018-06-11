/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radcircle;

import java.util.Scanner;

public class RadCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double radius;
        double area;
        double circumference;
        
        System.out.print("Please enter the radius of a circle: ");
        radius = reader.nextDouble();
        
        area = 3.14 * radius * radius;
        circumference = 2 * 3.14 * radius;
        
        System.out.println();
        System.out.print("The area of the circle is ");
        System.out.println(area);
        System.out.println();
        System.out.print("The circumference of the circle is ");
        System.out.println(circumference);
        
    }
}
