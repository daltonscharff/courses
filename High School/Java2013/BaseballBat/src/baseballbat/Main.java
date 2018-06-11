/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballbat;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        
        for(int x = 1; x <= 3; x++){
        String playerName = JOptionPane.showInputDialog("Please enter player " + x + "'s name:");
        if (x == 1){
            p1.getName(playerName);
        }if (x == 2){
            p2.getName(playerName);
        }if (x == 3){
            p3.getName(playerName);
        }
        int atBats = Integer.parseInt(JOptionPane.showInputDialog("Please enter the player's at bats:"));
        if (x == 1){
            p1.getAtBats(atBats);
        }if (x == 2){
            p2.getAtBats(atBats);
        }if (x == 3){
            p3.getAtBats(atBats);
        }
                
        int singles = Integer.parseInt(JOptionPane.showInputDialog("Please enter the singles:"));
        if (x == 1){
            p1.getSingles(singles);
        }if (x == 2){
            p2.getSingles(singles);
        }if (x == 3){
            p3.getSingles(singles);
        }       
        int doubles = Integer.parseInt(JOptionPane.showInputDialog("Please enter the doubles:"));
        if (x == 1){
            p1.getDoubles(doubles);
        }if (x == 2){
            p2.getDoubles(doubles);
        }if (x == 3){
            p3.getDoubles(doubles);
        }       
        int triples = Integer.parseInt(JOptionPane.showInputDialog("Please enter the triples:"));
        if (x == 1){
            p1.getTriples(triples);
        }if (x == 2){
            p2.getTriples(triples);
        }if (x == 3){
            p3.getTriples(triples);
        }
        int homeruns = Integer.parseInt(JOptionPane.showInputDialog("Please enter the homeruns:"));
        if (x == 1){
            p1.getHomeruns(homeruns);
        }if (x == 2){
            p2.getHomeruns(homeruns);
        }if (x == 3){
            p3.getHomeruns(homeruns);
        }
        }
        p1.hits();
        p1.totalBases();
        p1.battingAverage();
        p2.hits();
        p2.totalBases();
        p2.battingAverage();
        p3.hits();
        p3.totalBases();
        p3.battingAverage();
        
        System.out.println(p1.toString() + p2.toString() + p3.toString());
    }
}
