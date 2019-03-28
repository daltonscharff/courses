/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg15.pkg4;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Rational {
    
    private int numerator;
    private int denominator;
    private int lowestN;
    private int lowestD;
    
    public Rational(){
        numerator = 0;
        denominator = 1;
    }
    
    public Rational(int n, int d){
        numerator = n;
        denominator = d;
    }
    
    public void printRational(Rational o){
        System.out.println(o.numerator + "/" + o.denominator);
    }
    
    public void negate(){
        numerator *= -1;
    }
    
    public void invert(){
        int temp = numerator;
        numerator = denominator;
        denominator = temp;
    }
    
    public double toDouble(){
        double toReturn = (double)numerator / denominator;
        return toReturn;
    }
    
    public void reduce(){
        int a = numerator, b = denominator, r = 1;   
        while (r != 0){
            r = a%b;
            a = b;
            b = r;
        }
        lowestN = numerator / a;
        lowestD = denominator / a;
        System.out.println(lowestN + "/" + lowestD);
    }
    
    public Rational add (Rational a, Rational b){
        int newN1 = a.numerator * b.denominator;
        int newN2 = b.numerator * a.denominator;
        int newD = a.denominator * b.denominator;
        int newN = newN1 + newN2;
        Rational toReturn = new Rational(newN, newD);
        toReturn.reduce();
        return toReturn;
    }
}
