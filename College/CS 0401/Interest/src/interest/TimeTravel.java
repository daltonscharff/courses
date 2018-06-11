/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interest;
import java.awt.Toolkit;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class TimeTravel{
    private double time;
    public TimeTravel(double t){
        time = t;
    }
    
    public void execute() throws InterruptedException{
        System.out.println("Awesome! I'll see you in " + time + " years.\n");
        Thread.sleep(500);
        System.out.println("Time travel commencing in: ");
        Thread.sleep(200);
        for (int i = 5; i > 0; i--){
            System.out.print(i);
            Thread.sleep(200);
            System.out.print(".");
            Thread.sleep(200);
            System.out.print(".");
            Thread.sleep(200);
            System.out.print(". ");
            Thread.sleep(400);
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
        
        System.out.println("\n");
        
        for (int x = 0; x < 20; x++){
            Thread.sleep(5);
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            Thread.sleep(5);
            System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            Thread.sleep(5);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Thread.sleep(5);
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"
                    + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            
        }
        
        System.out.println("\nWow! Has it been " + time + " years already!\n"
                + "Well, here's what happened:");
    }
}
