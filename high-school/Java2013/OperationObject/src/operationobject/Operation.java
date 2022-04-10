/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operationobject;
import javax.swing.*;
import java.awt.*;

public class Operation {
    
    int num1, num2, multiplied;
    String category, toString;
            
    public Operation(){
        num1 = 0;
        num2 = 0;
    }
    
    public Operation(int a, int b){
        num1 = a;
        num2 = b;
    }
    
    private void multiplyer(){
        multiplied = num1 * num2;
    }
    
    private void categorize(){
        if (multiplied  <= 20 && multiplied > 0){
            category = "Small";
        }if (multiplied > 20 && multiplied <= 50){
            category = "Medium";
        }if (multiplied > 50){
            category = "Large";
        }
    }
    
    public String toString(){
        multiplyer();
        categorize();
               
        toString = "The numbers you entered were " + num1 + " and " + num2 + ".\n"
                + "The product of these numbers is " + multiplied + ".\n"
                + "It is in the \"" + category + "\" category.";
        return toString;
    }
}
