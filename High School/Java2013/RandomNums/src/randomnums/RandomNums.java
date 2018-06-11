/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnums;
import java.util.Random;
/**
 *
 * @author 14dscharff
 */
public class RandomNums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double total = 0.0000;
        double n = 0;
        int a = 0;
        double average = 0.0;
        Random generator = new Random();
        while (n < 10){
            n = generator.nextInt(11);
        if (n == 0){
            return;
        }
        if (n < 10){
            System.out.println("The generated number is: " + n);
            total += n;
            a += 1;
            System.out.println("The total so far is: " + total);
        }
        if (n == 10){
            average = total/a;
            System.out.println("The average is: " + average);
        }
        }       
}
