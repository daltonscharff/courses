/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.pkg4;
import java.util.Scanner;

/**
 *
 * @author 14dscharff
 */
public class Project34 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double totalHours, totalPay, overtime, regtime, totalMoney, wage;
        System.out.print("Please input the amout of normal hours worked this week: ");
        regtime = reader.nextDouble();
        System.out.print("Please input the amout of overtime hours worked this week: ");
        overtime = reader.nextDouble();
        totalHours = regtime + (overtime * 1.5);
        System.out.print("Please input your average wage: $");
        wage = reader.nextDouble();
        totalPay = totalHours * wage;
        System.out.println("Your paycheck for this week will be: $" + totalPay);
        
        
    }
}
