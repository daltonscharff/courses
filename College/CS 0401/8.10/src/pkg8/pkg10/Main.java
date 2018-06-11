/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg8.pkg10;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "abcd";
        if (isAbecedarian(input) == true){
            System.out.println("The word "+input+" is abecedarian.");
        }else{
            System.out.println("\"The word "+input+" is not abecedarian.");
        }
    }
    
    public static boolean isAbecedarian(String input){
        boolean isAbecedarian = false;
        
        for (int count = 0; count < input.length()-1; count++){
            char temp1 = input.charAt(count);
            int tempA = (int)temp1;
            char temp2 = input.charAt(count+1);
            int tempB = (int)temp2;
            if (tempA <= tempB){
                isAbecedarian = true;
            }else{
                isAbecedarian = false;
                break;
            }
            
        }
        
        return isAbecedarian;
    }
    
}
