/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lineisaline;
import java.util.ArrayList;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class McBurger {
    public static ArrayList<Customer> line1 = new ArrayList<>();
    public static ArrayList<Customer> line2 = new ArrayList<>();
    private static int waitingA = 0;
    private static int waitingB = 0;
    
    public static void AddToQueueOne(Customer c){
        line1.add(c);
    }
    public static void AddToQueueTwo(Customer c){
        line2.add(c);
    }
    
    public static int getMinutesWaitingA(){
        int temp = 0;
        for (int count = 0; count < line1.size(); count ++){
            temp += line1.get(count).getMinutes();
        }
        waitingA = temp;
        return waitingA;
    }
    
    public static int getMinutesWaitingB(){
        int temp = 0;
        for (int count = 0; count < line2.size(); count ++){
            temp += line2.get(count).getMinutes();
        }
        waitingB = temp;
        return waitingB;
    }
    
    
}
