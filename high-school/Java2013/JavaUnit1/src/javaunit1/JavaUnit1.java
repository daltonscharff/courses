/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaunit1;
import java.util.Scanner;


/**
 *
 * @author 14dscharff
 */
public class JavaUnit1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String n1,n2; double age1,age2,average;
        System.out.print("Input name one: ");
        n1 = reader.nextLine();
        System.out.print("Input name two: ");
        n2 = reader.nextLine();
        System.out.print("Input age one: ");
        age1 = reader.nextDouble();
        System.out.print("Input age two: ");
        age2 = reader.nextDouble();
        average = (age1 + age2) / 2;
        System.out.println(n1 + " and " + n2 + ", your average age is " + average);
        
        
        
    }
}
