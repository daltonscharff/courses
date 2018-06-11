/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project9_1;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 *
 * @author 14dscharff
 */
public class Project9_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] inputs = new String[10];
        int count;
        String negative = "", even = "", odd = "";
        for (count = 0; count < inputs.length; count ++){
            System.out.println("Please enter an integer:");
            inputs[count] = reader.next();
            double thisInput = Double.parseDouble(inputs[count]);
            if (thisInput >= 0){
                double EoO = thisInput % 2;
                if (EoO == 0){
                    even = even + " " + inputs[count];
                }if (EoO != 0){
                    odd = odd + " " + inputs[count];
                }
            }else{
                negative = negative + " " + inputs[count];
            }
        }
        System.out.println("Negative Numbers: " + negative);
        System.out.println("Even Numbers: " + even);
        System.out.println("Odd Numbers: " + odd);
        
    }
}
