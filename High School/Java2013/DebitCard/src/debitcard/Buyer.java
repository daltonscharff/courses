/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debitcard;

public class Buyer {
    int cashOnHand, cardNumber, purch = 0, spent = 0;
    String cCardNumber, cardType = "", results;
    char firstNum;
    
    public Buyer(){
        cashOnHand = 0;
        cCardNumber = null;
    }
    
    public Buyer(String c, int csh){
        cashOnHand = csh;
        cCardNumber = c;
    }
    public void changeCash(int m, String c){
        cashOnHand -= m;
        spent = m;
        purch += 1;
        cCardNumber = c;
    }
    
    public int getCash(){
        return cashOnHand;
    }
    
    private int getPurchases(){
        return purch;
    }
    
    private String getCardNumber(){
        return cCardNumber;
    }
    
    private int getSpent(){
        return spent;
    }
    
    private String getCardType(){
        firstNum = cCardNumber.charAt(0);
        
        if (firstNum == '3'){
            cardType = "American Express";
        }
        if (firstNum == '4'){
            cardType = "Visa";
        }
        if (firstNum == '5'){
            cardType = "Mastercard";
        }
        if (firstNum == '6'){
            cardType = "Discover";
        }
        return cardType;
    }
            
    public String toString(){
        results = "Credit Card #" + getCardNumber() + "\n" +
                "has $" + getCash() + " remaining " + "\n" +
                "with a purchase of $" + getSpent() + " and" + "\n" +
                "after making " + getPurchases() + " purchases " + "\n" +
                "on your " + getCardType() + ".";
        return results;
    }
}
