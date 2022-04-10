/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package income.tax.calculator;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class IncomeTaxCalculator {

    
    public static void main(String[] args) {
        double grossIncome, numDependents, taxableIncome, incomeTax;
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the gross income: ");
        grossIncome = reader.nextDouble();
        System.out.print("Enter the number of dependents: ");
        numDependents = reader.nextDouble();
        taxableIncome = getTaxable(grossIncome, numDependents);
        incomeTax = taxableIncome * 0.20;
        System.out.println("The income tax is $" + incomeTax + ".");
        
    }
    public static double getTaxable(double gross, double dep) {
        double taxable;
        taxable = gross - 10000 - (2000 * dep);
        return taxable;
    
    }
}
