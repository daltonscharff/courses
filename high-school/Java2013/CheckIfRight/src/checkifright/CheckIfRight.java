/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkifright;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class CheckIfRight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x,y,z;
        String inputStr = JOptionPane.showInputDialog("Enter the length of one side", "1");
        if (inputStr == null){
            return;
        }
        x = Integer.parseInt(inputStr);
        String inputStri = JOptionPane.showInputDialog("Enter the length of another side", "1");
        if (inputStri == null){
            return;
        }
        y = Integer.parseInt(inputStri);
        String inputStrin = JOptionPane.showInputDialog("Enter the length of a third side", "1");
        if (inputStrin == null){
            return;
        }
        z = Integer.parseInt(inputStrin);
        int lar = Math.max(x,y);
        int larg = Math.max (y,z);
        int large = Math.max (lar,larg);
        if (large == x){
            int hypotenuse = (y*y) + (z*z);
            if (hypotenuse == (x*x)){
                JOptionPane.showMessageDialog(null, "The triangle is right!");
            }else{
                JOptionPane.showMessageDialog(null, "The triangle is not right!");
            }
        }
        if (large == y){
            int hypotenuse = (x*x) + (z*z);
            if (hypotenuse == (y*y)){
                JOptionPane.showMessageDialog(null, "The triangle is right!");
            }else{
                JOptionPane.showMessageDialog(null, "The triangle is not right!");
            }
        }
        if (large == z){
            int hypotenuse = (y*y) + (x*x);
            if (hypotenuse == (z*z)){
                JOptionPane.showMessageDialog(null, "The triangle is right!");
            }else{
                JOptionPane.showMessageDialog(null, "The triangle is not right!");
            }
        }
        
    }
}
