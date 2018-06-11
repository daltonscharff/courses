/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exam1.pkg1;
import java.util.Scanner;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 * Project 1
 */
public class Exam11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String animal = null;
        double distance = 0, time = 0;
        int cheetahSpeed = 100, dogSpeed = 63, humanSpeed = 45;
        boolean repeat = true;
        
        //Animal Input
        while(repeat == true){ //Repeats animal input until the animal is recognized
            System.out.print("Please enter \"Cheetah\", \"Dog\", or \"Human\": ");
            animal = reader.next();
            
            if (animal.equalsIgnoreCase("cheetah") || animal.equalsIgnoreCase("dog") || animal.equalsIgnoreCase("human")){ //Compares input to recognized animals
                repeat = false; //Breaks out of loop
            }else{
                System.out.println("Animal not recognized. Please try again.\n");
            }
        }
        
        //Distance Input
        repeat = true;
        while(repeat == true){ //Repeats distance input until the distance is greater than 0
            System.out.print("Please enter the distance that the " + animal + " will run (in Kilometers): ");
            distance = reader.nextDouble();
            
            if (distance > 0){
                repeat = false; //Breaks out of loop
            }else{
                System.out.println("Please enter a non-zero, positive number.\n");
            }
        }
        
        //Math Section
        if (animal.equalsIgnoreCase("cheetah")){
            time = distance / cheetahSpeed;
        }
        if (animal.equalsIgnoreCase("dog")){
            time = distance / dogSpeed;
        }
        if (animal.equalsIgnoreCase("human")){
            time = distance / humanSpeed;
        }
        
        //Final Output
        System.out.printf("The time in which the %s will run %.2f kilometers is %.2f hours.\n", animal, distance, time);
    }
    
}
