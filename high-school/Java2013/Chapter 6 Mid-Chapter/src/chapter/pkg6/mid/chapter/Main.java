/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter.pkg6.mid.chapter;
import javax.swing.*;
import java.awt.*;

public class Main {

    
    public static void main(String[] args) {
        String name, tryAgain;
        int category = 0, grade = 0;
        boolean a, again = true;
        
        while (again){
        name = JOptionPane.showInputDialog("Enter the name of a student:");
        a = true;
        while (a){ 
        grade = Integer.parseInt(JOptionPane.showInputDialog("Please enter " + name + "'s grade percentage:"));
        if (grade < 0 || grade > 100){
            JOptionPane.showMessageDialog(null,"Please enter a number between 0 and 100.");
        }else{
            a = false;
        }
        }
        a = true;
        while (a){
        category = Integer.parseInt(JOptionPane.showInputDialog("Please enter " + name + "'s learning level:\n"
                + "1. Advanced \n2. Standard \n3. Below Standard"));
        if (category == 1 || category == 2 || category == 3){
            a = false;
        }else{
            JOptionPane.showMessageDialog(null,"Please enter a 1, 2, or 3.");
        }
        }
        
        Student s1 = new Student(name, grade, category);
        JOptionPane.showMessageDialog(null, s1);
        
        a = true;
        while (a){  
        tryAgain = JOptionPane.showInputDialog("Would you like to create another student? (y/n)");
        if (tryAgain.equalsIgnoreCase("y") || tryAgain.equalsIgnoreCase("n")){
            again = true;
            a = false;
            if (tryAgain.equalsIgnoreCase("n")){
                again = false;
                a = false;
                }
        }else{
            JOptionPane.showMessageDialog(null,"Please enter a \"y\" for yes or an \"n\" for no.");
            }    
    }
    }   
    }
}
