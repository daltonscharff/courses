/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_4;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int playAgain = 1;
        while (playAgain == 1){
        int cCash, maxCash = 0, maxRoll = 0, rolls = 0, roll1, roll2, sumRoll, counter, counter2 = 1, yourRolls = 0, yourCash = 0;
        String initialCash, play;    
        initialCash = JOptionPane.showInputDialog("How much cash do you start out with?", "10");
        cCash = Integer.parseInt(initialCash);
        maxCash = cCash;
        counter = cCash;
                         
        while(counter > 0){
            Dice d1 = new Dice();
            Dice d2 = new Dice();
            
            roll1 = d1.getDice();
            roll2 = d2.getDice();
            sumRoll = roll1 + roll2;
            rolls ++;
            
            if (sumRoll == 7){
                cCash += 4;
                if(cCash > maxCash){
                    maxCash = cCash;
                    maxRoll = rolls;
                }
            }else{
                cCash -= 1;
            }
            if (cCash == 0){
                counter = 0;
            }
        if (counter2 > 0 && counter > 0){    
            play = JOptionPane.showInputDialog("You are at " + rolls + " rolls with $" + cCash + ". \nWould you like to keep going? (Y/N)", "Y");
            if (play.equalsIgnoreCase("N")){
                counter2 = 0;
                yourRolls = rolls;
                yourCash = cCash;
                }
            }
        }       
        if (yourRolls != rolls && yourRolls != 0){
        JOptionPane.showMessageDialog(null,"You decided to stop at " + yourRolls + " rolls with $" + yourCash + ". \n" 
                + "You would have lasted " + rolls + " rolls. \n" + 
                "You should have quit at " + maxRoll + " rolls when you had $" + maxCash + ".");
        }else if (yourRolls == rolls && yourRolls != 0){
        JOptionPane.showMessageDialog(null,"You decided to stop at " + yourRolls + " rolls with $" + yourCash + ". \n" 
                + "You would have lasted " + rolls + " rolls. \n" + 
                "You quit at the right time! Well done.");    
        }else{
        JOptionPane.showMessageDialog(null,"You just didn't want to stop. \n" 
                + "You lasted " + rolls + " rolls. \n" + 
                "You should have quit at " + maxRoll + " rolls when you had $" + maxCash + ". \n" + 
                "You lost, but there's something to be said about your optimism.");    
        }
        
        play = JOptionPane.showInputDialog("Would you like to play again? (Y/N)", "Y");
        if (play.equalsIgnoreCase("N")){
            playAgain = 0;
        }
        }
    }
}
