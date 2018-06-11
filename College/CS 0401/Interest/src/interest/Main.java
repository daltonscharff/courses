/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interest;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static double interestRate;
    private static double principle;
    private static double time;
    private static String type;
    public static void main(String[] args) throws InterruptedException{
        Scanner reader = new Scanner(System.in);
        System.out.println("Hello, I understand that you would like to open a new checking account.\n"
                + "I have a few basic questions to get you started.\n");
        type = generateInterest();
        System.out.print("\nWhat will be your beginning deposit (must be upwards of $5.00): ");
        double temp = reader.nextDouble();
        while(true){
            if (temp < 5){
                System.out.print("Please deposit more than $5.00: ");
                temp = reader.nextDouble();
            }else{
                principle = temp;
                break;
            }
        }
        System.out.print("\nGreat! Now how long, in years, will you be keeping your money with us: ");
        temp = reader.nextDouble();
        while(true){
            if (temp < 5){
                System.out.print("Please enter a number higher than 0: ");
                temp = reader.nextDouble();
            }else{
                time = temp;
                break;
            }
        }
        
        if (type.equalsIgnoreCase("simple")){
            Simple account = new Simple(interestRate, principle, time);
            TimeTravel t = new TimeTravel(time);
            t.execute();
            System.out.println(account);
        }else{
            Continuous account = new Continuous(interestRate, principle, time);
            TimeTravel t = new TimeTravel(time);
            t.execute();
            System.out.println(account);
        }       
    }
    
    public static String generateInterest(){
        Random gen = new Random();
        Scanner reader = new Scanner(System.in);
        double a = gen.nextInt(1000)/10000.0;
        double b = gen.nextInt(1000)/10000.0;
        System.out.println("Today's Interest Rates:");
        if (a < b){
            double temp = a;
            a = b;
            b = temp;
        }
        System.out.printf("%16s %5.2f%%\n","Simple:",a*100);
        System.out.printf("%16s %5.2f%%\n\n","Compound:",b*100);
        System.out.print("Which type of account would you like: ");
        String input;
        while(true){
            input = reader.next();
            if (input.equalsIgnoreCase("simple")){
                interestRate = a;
                break;
            }else if (input.equalsIgnoreCase("compound")){
                interestRate = b;
                break;
            }else{
                System.out.print("Please enter either \"Simple\" or \"Compound\": ");
            }
        }
        return input;
    }
    
}
