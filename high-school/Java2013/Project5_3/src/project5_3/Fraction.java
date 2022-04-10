/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_3;

public class Fraction {
    
    int numerator, denominator;
    
    public Fraction(int n1, int d1){
        numerator = n1;
        denominator = d1;
    }
    public Fraction(){
        this(0,0);
    }
    public String validateData(){
        String resultString = null;
        if (denominator == 0){
            resultString = "Cannot divide by zero!";
        }
        return resultString;
    }
    public String toString(){
        String str;
        str = (numerator + "\n" + "-" + "\n" + denominator);
        return str;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
}
