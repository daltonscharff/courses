/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tempconv;

import java.util.Scanner;

public class TempConv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        double fahrenheit;
        double celsius;
        
        System.out.print("Enter degrees Fahrenheit: ");
        fahrenheit = reader.nextDouble();
        
        celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
        System.out.print("The equivalent in Celsius is ");
        System.out.println(celsius);
    }
}
