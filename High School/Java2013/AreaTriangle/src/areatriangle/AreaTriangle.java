/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package areatriangle;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class AreaTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double length, height, area;
        Scanner reader = new Scanner(System.in);
        System.out.print("Please input the triangle's length: ");
        length = reader.nextDouble();
        System.out.print("Please input the triangle's height: ");
        height = reader.nextDouble();
        area = (length * height) / 2;
        System.out.println("The area of the triangle is " + area);
        
        
        
    }
}
