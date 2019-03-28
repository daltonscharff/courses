/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.pkg2;
import javax.swing.*;
import java.util.Scanner;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name, fName = "";
        char space = ' ';
        double cRadius, cCircumference, cArea, tSide1, tSide2, tRadians;
        double tSide3, tSemiPerimeter, tArea;
        Scanner reader = new Scanner(System.in);
        
        //Name input
        System.out.print("Please enter your first and last name (separated by a space): ");
        
        //Parses name to find space character and differentiates the first name
        name = reader.nextLine(); 
        for (int x = 0; x < name.length(); x++){
            char text = name.charAt(x);
            if (text == space){
                break;
            }else{
                fName += text;
            }
        }

        //Circle input
        System.out.print("\nPlease enter the radius of a circle: ");
        cRadius = reader.nextDouble();
        
        //Circle math
        cArea = Math.PI * Math.pow(cRadius, 2); //Finds area of circle
        cCircumference = 2 * Math.PI * cRadius; //Finds circumference of circle
        System.out.printf("Its area is %.2f.\nIts circumference is %.2f.\n", cArea, cCircumference);
        
        //Triangle input
        System.out.print("\nPlease enter one side of a triangle: ");
        tSide1 = reader.nextDouble();
        System.out.print("Please enter a second side of the triangle: ");
        tSide2 = reader.nextDouble();
        System.out.print("Please enter the angle (in radians) between those two sides: ");
        tRadians = reader.nextDouble();
        
        //Triangle math
        tSide3 = Math.sqrt(Math.pow(tSide1, 2) + Math.pow(tSide2, 2) - 2 * tSide1 * tSide2 * Math.cos(tRadians)); //Finds the third triangle side length
        tSemiPerimeter = 0.5 * (tSide1 + tSide2 + tSide3); //Finds the permieter of triangle and halves it
        tArea = Math.sqrt(tSemiPerimeter * (tSemiPerimeter - tSide1) * (tSemiPerimeter - tSide2) * (tSemiPerimeter - tSide3)); //Finds the final area of the triangle
        System.out.printf("The area of that triangle is %.2f.", tArea);
        
        //Ending output
        System.out.printf("\n\n%s, the program is ending now.\n", fName);
        
        /*Lab Questions
        1.  When a user enters a character other than a number into the circle 
            or triangle input, the program crashes because it searching for 
            double data types. If no input is entered into these (other than for
            the name), the program fails because it will only continue once it
            receives a number. These can be taken care of via while loops or via
            try/catch statements.
        2.  Radians are used because java.Math's class 'cos' looks for an angle 
            in radians as its argument. If the class used degrees instead as its
            parameters, that is what we would want to use as the argument.
        */
    }
    
}
