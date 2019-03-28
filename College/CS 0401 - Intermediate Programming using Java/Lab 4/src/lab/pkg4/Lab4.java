/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.pkg4;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Lab4 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat format3 = new DecimalFormat("0.000");
        int menuInput, squares, popPercent;
        double celsius, population;
        
        do {
            //Creates a simple menu allowing user to make a selection.
            //Sets menuInput variable equal to user selection.
            System.out.println("**** MENU ****");
            System.out.println("1. Chemistry: Celsius to Fahrenheit");
            System.out.println("2. Math: Compute Squares");
            System.out.println("3. Biology: Population Growth");
            System.out.println("4. Quit");
            System.out.print("\nPlease make a selection (1, 2, 3, or 4): ");
            menuInput = keyboard.nextInt();
            
            //Chemistry: Celsius to Fahrenheit
            if (menuInput == 1){
                System.out.println("\nI'm going to help you convert celsius to Fahrenheit!");
                System.out.print("Please enter your temperature (in Celsius): ");
                celsius = keyboard.nextDouble();
                while (celsius < -273.15 || celsius > 5506.85){ //Checks whether input is in bounds and repeats if necessary
                    System.out.print("Please enter a temperature between absolute zero (-213.15 C)"
                            + "\nand the temperature of the Sun (5506.85 C): ");
                    celsius = keyboard.nextDouble();
                }
                System.out.println("The temperature in Fahrenheit is: " + ((9.0/5.0) * celsius + 32 + ".\n"));
                
            }
            
            //Math: Compute Squares
            if (menuInput == 2){
                System.out.println("\nI'm going to calculate the squares of all integers between 0 and the number you give me!");
                System.out.print("Please enter an integer: ");
                squares = keyboard.nextInt();
                if (squares >= 0){ // Checks if squares is positive or negative.
                    for (int count = squares; count >= 0; count --){ //Sets a count variable so that square is never changed. Decrements count and squares it each run through the loop.
                        System.out.println("The square of " + count + " is " + count * count + ".");
                    }
                }else{
                    for (int count = squares; count <= 0; count ++){ //Sets a count variable so that square is never changed. Increments count and squares it each run through the loop.
                        System.out.println("The square of " + count + " is " + count * count + ".");
                    }
                }
                System.out.print("\n");
            }
            
            //Biology: Population Growth
            if (menuInput == 3){
                population = 2;
                System.out.println("\nI'm going to calculate population growth for you!");
                System.out.println("We'll start with a population of 2 and see how it grows over 10 days.");
                System.out.print("But first, what's the average percent increase per day (ex. 10% = 10)? ");
                popPercent = keyboard.nextInt();
                while (popPercent < 0){ //Assures that the percent is positive and asks again if necessary.
                    System.out.print("\nPercent increase must be positive. Please try again: ");
                    popPercent = keyboard.nextInt();
                }
                double dPopPercent = popPercent / 100.0; //Turns popPercent into a double and divides by 100 to make the percentage into a decmil.
                for (int day = 0; day <= 10; day++){ // Increments day, prints current day and formatted population to three decmil points.
                    System.out.println("On day " + day + ", the population will be : " + format3.format(population));
                    population += population * dPopPercent; // Finds the current population by multiplying the population by the growth percentage and adding it to the previous day's population.
                }
                System.out.print("\n");
            }
        } while (menuInput != 4); // If a user enters a "4" at the menu section, the program will exit.
    } 
}
