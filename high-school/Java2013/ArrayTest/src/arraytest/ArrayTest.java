/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraytest;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author 14dscharff
 */
public class ArrayTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] Array = new int[10];
            for (int x = 0; x>=9; x++){
                Array[x] = 2 + 2;
                System.out.println(Array[2]);
            }
        System.out.println(Array[2]);
        System.out.println(Array[9]);
    }
}
