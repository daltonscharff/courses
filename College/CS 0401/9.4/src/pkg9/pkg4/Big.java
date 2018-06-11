/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg9.pkg4;
import java.math.BigInteger;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Big {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int count = 1; count <= 30; count++){
            System.out.println(count + " : " + factorial(count));
        }
    }
        
    public static BigInteger factorial(int a){
        BigInteger int1 = BigInteger.valueOf(a);
        BigInteger toBeReturned = BigInteger.valueOf(1);
        for (int i = a; i > 1; i--){
            BigInteger int2 = BigInteger.valueOf(i);
            toBeReturned = toBeReturned.multiply(int2);
        }
        return toBeReturned;
    }
    
}
