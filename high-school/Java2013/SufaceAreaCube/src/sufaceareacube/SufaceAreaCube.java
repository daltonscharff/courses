/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sufaceareacube;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 *
 * @author 14dscharff
 */
public class SufaceAreaCube {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sideLength, sideArea, surfaceArea;
        System.out.print("Please input a side length:");
        sideLength = reader.nextInt();
        sideArea = sideLength * sideLength;
        surfaceArea = sideArea * 6;
        System.out.println("The surface area of the cube is " + surfaceArea + " units squared");
        
        
    }
}
