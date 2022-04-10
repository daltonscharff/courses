/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3.pkg5;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class Project35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double hours, OTHours, enteredHours, enteredOT, totalHours, totalPay;
        hours = 0; OTHours = 0;
        System.out.print("Please enter the regular hours worked Monday: ");
        enteredHours = reader.nextDouble();
        hours = incrementHours(hours,enteredHours);
        System.out.print("Please enter the OT hours for Monday: ");
        enteredOT = reader.nextDouble();
        OTHours = incrementHours(OTHours, enteredOT);
        
        System.out.print("Please enter the regular hours worked Tuesday: ");
        enteredHours = reader.nextDouble();
        hours = incrementHours(hours,enteredHours);
        System.out.print("Please enter the OT hours for Tuesday: ");
        enteredOT = reader.nextDouble();
        OTHours = incrementHours(OTHours, enteredOT);
        
        System.out.print("Please enter the regular hours worked Wednesday: ");
        enteredHours = reader.nextDouble();
        hours = incrementHours(hours,enteredHours);
        System.out.print("Please enter the OT hours for Wednesday: ");
        enteredOT = reader.nextDouble();
        OTHours = incrementHours(OTHours, enteredOT);
        
        System.out.print("Please enter the regular hours worked Thursday: ");
        enteredHours = reader.nextDouble();
        hours = incrementHours(hours,enteredHours);
        System.out.print("Please enter the OT hours for Thursday: ");
        enteredOT = reader.nextDouble();
        OTHours = incrementHours(OTHours, enteredOT);
        
        System.out.print("Please enter the regular hours worked Friday: ");
        enteredHours = reader.nextDouble();
        hours = incrementHours(hours,enteredHours);
        OTHours = incrementHours(OTHours, enteredOT);
        
        System.out.print("Please enter the OT hours for Friday: ");
        enteredOT = reader.nextDouble();
        System.out.println(" ");
        System.out.println("Regular Hours: " + hours + "\n" + "OT Hours: " + OTHours);
        System.out.println(" ");
        System.out.print("Please enter your hourly wage: $");
        double wage = reader.nextDouble();
        double regWage = hours * wage;
        double OTWage = OTHours * (wage*1.5);
        System.out.println("Your regular wage is $" + regWage);
        System.out.println("Your OT wage is $" + OTWage);
        System.out.println("Your gross pay this week is $" + (regWage + OTWage));
        
        
        
    }
    public static double incrementHours(double h, double entH){
        h += entH;
        return h;
    }
}
