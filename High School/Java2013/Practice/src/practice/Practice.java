/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author 14dscharff
 */
public class Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double x = 4.5; int y = 2;
        String name = "Dalton Scharff";
        System.out.println((int)(x*y));
        System.out.println((int)x*y);
        System.out.println("He said I was \"cool\".\n"+"I think I am.");
        System.out.println("Dalton's name is " + name.length() + " characters long.");
        x = subtract2(10);
        System.out.println(x);
    }
    
    public static double subtract2(double d){
        double result = d - 2;
        return result;
    }
}
