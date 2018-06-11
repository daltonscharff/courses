/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project4_6;

import javax.swing.JOptionPane;


public class Project4_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String initial = JOptionPane.showInputDialog("Enter the initial number of organisms", "0");
        if(initial == null){
            return;
        }
        
        String growthRate = JOptionPane.showInputDialog("Enter the rate of growth (greater than 0)", "0");
        if(growthRate == null){
            return;
        }
        
        String hours = JOptionPane.showInputDialog("Enter the number of hours it takes to achieve this rate", "0");
        if(hours == null){
            return;
        }
        
        String hoursTotal = JOptionPane.showInputDialog("How many hours will they grow", "0");
        if(hoursTotal == null){
            return;
        }
        
        double iP = Double.parseDouble(initial);
        double gR = Double.parseDouble(growthRate);
        double h = Double.parseDouble(hours);
        double hT = Double.parseDouble(hoursTotal);
        
        double i = hT / h;
        while (i >= 1){
            iP = (iP * gR);
            i -= 1;            
        System.out.println("iP = " + iP);
        }
        iP += ((iP * gR) - iP) * i;
        JOptionPane.showMessageDialog(null, "The population after " + hT + " hours is " + iP);
        
      
}
}
