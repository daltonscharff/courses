/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg13.pkg1;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Card {
    public int suit, rank;
    public Card(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    public String toString(){
        String suit = "";
        String rank = "";
        if(this.suit == 0){
            suit = "Clubs";
        }
        if(this.suit == 1){
            suit = "Diamonds";
        }
        if(this.suit == 2){
            suit = "Hearts";
        }
        if(this.suit == 3){
            suit = "Spades";
        }
        if(this.rank == 1){
            this.rank = 14;
            rank = "Ace";
        }
        if(this.rank == 2){
            rank = "2";
        }
        if(this.rank == 3){
            rank = "3";
        }
        if(this.rank == 4){
            rank = "4";
        }
        if(this.rank == 5){
            rank = "5";
        }
        if(this.rank == 6){
            rank = "6";
        }
        if(this.rank == 7){
            rank = "7";
        }
        if(this.rank == 8){
            rank = "8";
        }
        if(this.rank == 9){
            rank = "9";
        }
        if(this.rank == 10){
            rank = "10";
        }
        if(this.rank == 11){
            rank = "Jack";
        }
        if(this.rank == 12){
            rank = "Queen";
        }
        if(this.rank == 13){
            rank = "King";
        }
        
        return rank + " of " + suit;
    }
    
}
