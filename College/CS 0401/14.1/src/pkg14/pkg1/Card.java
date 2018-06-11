/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg14.pkg1;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Card {
    public int rank, suit;
    public Card (int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public int getRank(){
        return rank;
    }
    
    public int getSuit(){
        return suit;
    }
    
    public int compareTo(Card a, Card b){
        if (a.getRank()< b.getRank()){
            return -1;
        }else if (a.getRank()> b.getRank()){
            return 1;
        }else{
            return 0;
        }
    }
    
    public String toString(){
        return suit + " : " + rank;
    }
}
