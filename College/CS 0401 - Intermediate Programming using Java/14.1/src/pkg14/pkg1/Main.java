/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg14.pkg1;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int hasFlush = 0;
        int hasTOC = 0;
        int hasPair = 0;
        int has2Pair = 0;
        int hasStraight = 0;
        int hasFH = 0;
        int hasFOC = 0;
        int hasStraightFlush = 0;
        double testAmount = 1000000;
        for (int count = 0; count < testAmount; count++){
            ArrayList<Card> hand = makeHand(5);
            if (isFlush(hand)==true){
                hasFlush++;
            }
            if (isThreeKind(hand)==true){
                hasTOC ++;
            }
            if (isPair(hand)==true){
                hasPair ++;
            }
            if (is2Pair(hand)==true){
                has2Pair ++;
            }
            if (isStraight(hand)==true){
                hasStraight ++;
            }
            if (isFH(hand)==true){
                hasFH ++;
            }
            if (isFOC(hand)==true){
                hasFOC ++;
            }
            if (isStraightFlush(hand)==true){
                hasStraightFlush ++;
            }
        }
        System.out.println("Probabilities");
        System.out.printf("%-20s %.3f%%\n", "Flush:",hasFlush/testAmount*100);
        System.out.printf("%-20s %.3f%%\n", "Three of a Kind:",hasTOC/testAmount*100);
        System.out.printf("%-20s %.3f%%\n", "Pair:",hasPair/testAmount*100);
        System.out.printf("%-20s %.3f%%\n", "Two Pair:",has2Pair/testAmount*100);
        System.out.printf("%-20s %.3f%%\n", "Straight:",hasStraight/testAmount*100);
        System.out.printf("%-20s %.3f%%\n", "Full House:",hasFH/testAmount*100);
        System.out.printf("%-20s %.3f%%\n", "Four of a Kind:",hasFOC/testAmount*100);
        System.out.printf("%-20s %.3f%%\n", "Straight Flush:",hasStraightFlush/testAmount*100);
    }
    
    public static ArrayList<Card> makeHand(int amount){
        Random gen = new Random();
        ArrayList<Card> hand = new ArrayList<>();
//        hand.add(new Card(1,1));
//        hand.add(new Card(1,1));
//        hand.add(new Card(1,1));
//        hand.add(new Card(1,2));
//        hand.add(new Card(1,2));
        
        for(int count = 0; count < amount; count++){
            int temp1, temp2;
            do{
                temp1 = gen.nextInt(5);
                temp2 = gen.nextInt(14);
            }while (temp1 == 0 || temp2 == 0);
            hand.add(new Card(temp1, temp2));
        }
        
        return hand;
    }
    
    public static boolean isFlush(ArrayList<Card> hand){
        if (hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(1).getSuit() == hand.get(2).getSuit() && hand.get(2).getSuit() == hand.get(3).getSuit() && hand.get(3).getSuit() == hand.get(4).getSuit()){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isThreeKind(ArrayList<Card> hand){
        boolean temp1=false, temp2=false, temp3=false, temp4=false;
        if (hand.get(0).getRank() == hand.get(1).getRank()){
            temp1 = true;
        }
        if (hand.get(1).getRank() == hand.get(2).getRank()){
            temp2 = true;
        }
        if (hand.get(2).getRank() == hand.get(3).getRank()){
            temp3 = true;
        }
        if (hand.get(3).getRank() == hand.get(4).getRank()){
            temp4 = true;
        }
        if ((temp1 == true && temp2 == true) || (temp2 == true && temp3 == true) || (temp3 == true && temp4 == true) || (temp1 == true && temp3 == true) || (temp1 == true && temp4 == true) || (temp2 == true && temp4 == true)){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isPair(ArrayList<Card> hand){
        boolean toBeReturned = false;
        for (int count = 0; count < hand.size(); count++){
            for (int count2 = 0; count2 < hand.size(); count2++){
                if (count2 == count){
                    continue;
                }
                if (hand.get(count).getRank() == hand.get(count2).getRank()){
                    toBeReturned = true;
                    break;
                }
            }
        }
        return toBeReturned;   
    }
    
    public static boolean is2Pair(ArrayList<Card> hand){
        ArrayList<Card> hand2 = new ArrayList<Card>(hand);
        boolean toBeReturned = false;
        int temp = 0;
        for (int count = 0; count < hand2.size(); count++){
            for (int count2 = 0; count2 < hand2.size(); count2++){
                if (count2 == count){
                    continue;
                }
                if (hand2.get(count).getRank() == hand2.get(count2).getRank()){
                    temp ++;
                    hand2.set(count, new Card(0,0));
                    if (temp == 2){
                        toBeReturned = true;
                        break;
                    }
                }
            }
        }
        return toBeReturned;   
    }
    
    public static boolean isStraight(ArrayList<Card> hand){
        ArrayList<Integer> hand2 = new ArrayList<Integer>();
        for(int count = 0; count<hand.size(); count ++){
            hand2.add(hand.get(count).getRank());
        }
        Collections.sort(hand2);
        if(hand2.get(4)-1 == hand2.get(3) && hand2.get(3)-1 == hand2.get(2) && hand2.get(2)-1 == hand2.get(1) && hand2.get(1)-1 == hand2.get(0)){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isFH(ArrayList<Card> hand){
        ArrayList<Integer> hand2 = new ArrayList<Integer>();
        for(int count = 0; count<hand.size(); count ++){
            hand2.add(hand.get(count).getRank());
        }
        Collections.sort(hand2);
        if ((hand2.get(0) == hand2.get(1) && hand2.get(1) == hand2.get(2) && hand2.get(3) == hand2.get(4)) || (hand2.get(0) == hand2.get(1) && hand2.get(2) == hand2.get(3) && hand2.get(3) == hand2.get(4))){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isFOC(ArrayList<Card> hand){
        boolean temp1=false, temp2=false, temp3=false, temp4=false;
        if (hand.get(0).getRank() == hand.get(1).getRank()){
            temp1 = true;
        }
        if (hand.get(1).getRank() == hand.get(2).getRank()){
            temp2 = true;
        }
        if (hand.get(2).getRank() == hand.get(3).getRank()){
            temp3 = true;
        }
        if (hand.get(3).getRank() == hand.get(4).getRank()){
            temp4 = true;
        }
        if ((temp1 == true && temp2 == true && temp3 == true) || (temp2 == true && temp3 == true && temp4 == true) || (temp1 == true && temp3 == true && temp4 == true) || (temp1 == true && temp2 == true && temp4 == true)){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isStraightFlush(ArrayList<Card> hand){
        ArrayList<Integer> hand2 = new ArrayList<Integer>();
        for(int count = 0; count<hand.size(); count ++){
            hand2.add(hand.get(count).getRank());
        }
        Collections.sort(hand2);
        if((hand2.get(4)-1 == hand2.get(3) && hand2.get(3)-1 == hand2.get(2) && hand2.get(2)-1 == hand2.get(1) && hand2.get(1)-1 == hand2.get(0)) && isFlush(hand)){
            return true;
        }else{
            return false;
        }
    }
    
}
