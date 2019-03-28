/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg11.pkg3;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Rational first = new Rational(40,20);
//        first.printRational(first);
//        first.invert();
//        System.out.println(first.toDouble());
//        first.reduce();

        Rational a = new Rational(2,13);
        Rational b = new Rational(2,26);
        Rational c = new Rational(5,5000);
        
        c.add(a,b);
        c.printRational(c);
    }
    
}
