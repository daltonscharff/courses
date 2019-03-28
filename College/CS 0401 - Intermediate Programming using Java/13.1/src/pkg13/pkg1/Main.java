/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg13.pkg1;
import java.util.ArrayList;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<>();
        deck = makeDeck();
        int x = 0;
        int y = 1;
        int z = 2;
        System.out.println(deck.get(x));
        System.out.println(deck.get(y));
        System.out.println(compareCard(deck.get(x), deck.get(y)));
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(deck.get(x));
        hand.add(deck.get(y));
        hand.add(deck.get(z));
        System.out.println(handScore(hand));
        System.out.println(hasFlush(suitHist(hand)));
    }
    
    public static int compareCard(Card c1, Card c2){
        if (c1.rank == 1){
            c1.rank = 14;
        }
        if (c2.rank == 1){
            c2.rank = 14;
        }
        if (c1.suit > c2.suit) return 1;
        else if (c1.suit < c2.suit) return -1;
        else{
            if (c1.rank > c2.rank) return 1;
            else if (c1.rank < c2.rank) return -1;
        }
        return 0;
    }
    
    public static ArrayList<Card> makeDeck(){
        int index = 0;
        ArrayList<Card> deck = new ArrayList<>();
        for (int suit = 0; suit <= 3; suit++){
            for (int rank = 1; rank <= 13; rank++){
                deck.add(new Card(suit,rank));
            }
        }
        return deck;
    }
    
    public static int handScore(ArrayList<Card> hand){
        int score = 0;
        for (int count = 0; count < hand.size(); count++){
            score += hand.get(count).rank;
        }
        return score;
    }
    
    public static ArrayList<Integer> suitHist(ArrayList<Card> hand){
        ArrayList<Integer> histogram = new ArrayList<>();
        for (int count = 0; count < hand.size(); count++){
            histogram.add(hand.get(count).suit);
        }
        return histogram;
    }
    
    public static boolean hasFlush(ArrayList<Integer> histogram){
        boolean isFlush = true;
        for (int count = 0; count < histogram.size()-1; count++){
            if(histogram.get(count) == histogram.get(count+1)){
                isFlush = true;
            }else{
                isFlush = false;
                break;
            }
        }
        return isFlush;
    }
}
