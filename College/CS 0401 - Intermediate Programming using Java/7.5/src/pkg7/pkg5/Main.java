/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg7.pkg5;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double x = 1; //is the power that e is being raised to: ie. e^x
        int n = 18; //adjusts the terms in the series
        System.out.println(x + "\t" + myexp(x,n) + "\t" + check(x) + "\n");
        System.out.println("-------------------------------\n");
        
        //Part 5
        x = 0.1;
        while (x <= 100){
            String temp1 = String.valueOf(myexp(x,n));
            String temp2 = String.valueOf(check(x));
            System.out.println(x + "\t" + temp1 + "\t" + temp2);
            System.out.println("These numbers have " + checkStrings(temp1,temp2) + " digit(s) in common.");
            x *= 10;
        }
        System.out.println("\n-------------------------------\n");
        
        //Part 6
        x = -0.1;
        while (x >= -100){
            String temp1 = String.valueOf(myexp(x,n));
            String temp2 = String.valueOf(check(x));
            System.out.println(x + "\t" + myexp(x,n) + "\t" + check(x));
            System.out.println("These numbers have " + checkStrings(temp1,temp2) + " digit(s) in common.");
            x *= 10;
        }
    }
    
    public static double myexp(double x, int n){
        double i = 1;
        double exp = 1;
        double numer = 1, denom = 1;
        while(i < n){
            numer *= x;
            denom *= i;
            exp += numer/denom;
            i++; 
        }
        return exp;
    }
    
    public static double factorial(double a){
        double toBeReturned = a;
        for (double i = a-1; i > 1; i--){
            toBeReturned *= i;
        }
        return toBeReturned;
    }
    
    public static double check (double x){
        return Math.exp(x);
    }
    
    public static int checkStrings(String temp1, String temp2){
        int temp3 = 0;
        for (int count = 0; count < temp2.length() && count < temp1.length(); count ++){
            if (temp1.charAt(count) == temp2.charAt(count)){
                temp3 += 1;
            }else{
                break;
            }
        }
        return temp3;
    }
}
