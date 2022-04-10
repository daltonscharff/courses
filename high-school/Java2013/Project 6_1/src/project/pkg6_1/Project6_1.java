/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg6_1;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Project6_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "I'm thinking of a number... ");
        
        Random generator = new Random();
        int FinalNumber = 1;
        boolean t = true;
        while (t = true){
            FinalNumber = generator.nextInt(101);
            System.out.println(FinalNumber);
            if (FinalNumber > 0 && FinalNumber < 100){
                t = false;
                break;
            }
        }
        t = true;
        while (t = true){
            int guessedNumber = Integer.parseInt(JOptionPane.showInputDialog("What is your guess?"));
            if (guessedNumber > FinalNumber){
                JOptionPane.showMessageDialog(null, "Your guess of " + guessedNumber + " is too high! Guess again.");
            }if (guessedNumber < FinalNumber){
                JOptionPane.showMessageDialog(null, "Your guess of " + guessedNumber + " is too low! Guess again.");
            }if (guessedNumber == FinalNumber){
                JOptionPane.showMessageDialog(null, "Your guess of " + guessedNumber + " is right on! Well done!");
                t = false;
                break;
            }
        }
    }
}
