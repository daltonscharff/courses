/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg9.pkg5;
import java.math.BigInteger;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(pow(1000,5));
    }
    
    public static BigInteger pow(int x, int n){
        BigInteger int1 = BigInteger.valueOf(1);
        BigInteger bigX = BigInteger.valueOf(x);
        if(n==0) return int1;
        BigInteger t = pow(x,n/2);
        BigInteger int2 = t.multiply(t);
        BigInteger int3 = int2.multiply(bigX);
        if(n%2==0){
            return int2;
        }else{
            return int3;
        }
    }
}
