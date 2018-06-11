/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg12.pkg10;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        array = selectionSort(array);
        for (int count = 0; count < array.length; count++){
            System.out.print(array[count] + ",");
        }
    }
    
    public static int indexOfMaxInRange(int[] array, int begin){
        int highestNum = -999999;
        int highestIndex = 0;
        for (int count = begin; count < array.length; count++){
            if (array[count] > highestNum){
                highestIndex = count;
                highestNum = array[count];
            }
        }
        return highestIndex;
    }
    
    public static void swapElement(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    public static int[] selectionSort(int[] array){
        for (int count = 0; count < array.length; count ++){
            swapElement(array, count, indexOfMaxInRange(array, count));
        }
        return array;
    }
}
