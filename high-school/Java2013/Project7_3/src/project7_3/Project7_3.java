/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project7_3;
import java.util.Scanner;

public class Project7_3 {

    public static void main(String[] args) {
        double interestRate, principal;
        double beginningP = 0, interestEarned = 0, endP = 0, try1, try2, try3, try4;
        int yearsInvested, realYear;
        Scanner reader = new Scanner(System.in);
        
        System.out.println("What is the interest rate?");
        interestRate = reader.nextDouble();
        System.out.println("How much will you be investing?");
        System.out.print("$");
        principal = reader.nextDouble();
        System.out.println("How many years will you invest?");
        yearsInvested = reader.nextInt();
        System.out.println("");
        System.out.printf("%-10s %20s %20s %20s %n", "Year", "Beginning Principal", "Average Qtrly Earned", "Ending Principal");
        System.out.println("");
                
        beginningP = principal;
        for (int year = 1; year <= yearsInvested; year++){
            realYear = year;
            try1 = beginningP * (1 + interestRate/400);
            try2 = try1 * (1 + interestRate/400);
            try3 = try2 * (1 + interestRate/400);
            try4 = try3 * (1 + interestRate/400);
            endP = try4;
            interestEarned = (endP - beginningP) / 4;
            System.out.printf("%-12d$%-24.2f$%-19.2f$%.2f%n", realYear, beginningP, interestEarned, endP);
            beginningP = endP;
        }
        
    }
}
