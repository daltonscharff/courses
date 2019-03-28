/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg14.pkg1;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Deck {
    ArrayList<Card> cards = new ArrayList<>();
    
    public Deck(){
        for (int suit = 1; suit < 5; suit ++){
            for (int rank = 1; rank <= 13; rank ++){
                Card temp = new Card(suit,rank);
                cards.add(temp);
            }
        }
    }    
}
