/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package popgrowth;

import javax.swing.JOptionPane;

public class PopGrowth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String inputStr = JOptionPane.showInputDialog("Enter the initial number of organisms", "0");
        if(inputStr == null){
            return;
    }
        double initial = Double.parseDouble(inputStr);
        inputStr = JOptionPane.showInputDialog("Enter the rate of growth (greater than 0)", "0");
        if(inputStr == null){
            return;
        }
        double growth = Double.parseDouble(inputStr);
        inputStr = JOptionPane.showInputDialog("Enter the number of hours it takes to achieve this rate", "0");
        if(inputStr == null){
            return;
        }
        double hours = Double.parseDouble(inputStr);
        inputStr = JOptionPane.showInputDialog("How many hours will they grow", "0");
        if(inputStr == null){
            return;
        }
        double population = Double.parseDouble(inputStr);
        double expo = Math.pow(growth,hours);
        double expo2 = initial
        JOptionPane.showMessageDialog(null,"At these rates, the population after " + hours + " hours of growth is " + total);
}
}

