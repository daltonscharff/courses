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
public class HandyAndy {
    private static int minutesWaitingA = 0;
    private static int minutesWaitingB = 0;
    private static int minuteCounterA = 0;
    private static int minuteCounterB = 0;
    private static int index = 0;
    private static ArrayList<Integer> aMinutes = new ArrayList<Integer>();
    private static ArrayList<Integer> bMinutes = new ArrayList<Integer>();
    private static ArrayList<Customer> aCustomers = new ArrayList<Customer>();
    private static ArrayList<Customer> bCustomers = new ArrayList<Customer>();
    
    public static void setWaitTimeA(Customer c){
        int customerMinutes = c.getMinutes();
        aMinutes.add(c.getMinutes());
        aCustomers.add(c);
        minutesWaitingA += customerMinutes;
        minuteCounterA++;
        if (minuteCounterA == aMinutes.get(index)){
            minutesWaitingA -= aMinutes.get(index);
            minuteCounterA = 0;
            index++;
        }
        minutesWaitingA -= 1;
    }
    
    public static int getWaitTimeA(){
        return minutesWaitingA;
    }
    
    public static void finisherA(){
        while (index < aMinutes.size()){
            minuteCounterA++;
            if (minuteCounterA == aMinutes.get(index)){
                minutesWaitingA -= aMinutes.get(index);
                minuteCounterA = 0;
                index++;
            }
            minutesWaitingA -= 1;
            
        }
    }
    
    public static void setWaitTimeB(Customer c){
        int customerMinutes = c.getMinutes();
        bMinutes.add(c.getMinutes());
        bCustomers.add(c);
        minutesWaitingB += customerMinutes;
        minuteCounterB++;
        if (minuteCounterB == bMinutes.get(index)){
            minutesWaitingB -= bMinutes.get(index);
            minuteCounterB = 0;
            index++;
        }
        minutesWaitingB -= 1;
    }
    
    public static int getWaitTimeB(){
        return minutesWaitingB;
    }
    
    public static void finisherB(){
        while (index < bMinutes.size()){
            minuteCounterB++;
            if (minuteCounterB == bMinutes.get(index)){
                minutesWaitingB -= bMinutes.get(index);
                minuteCounterB = 0;
                index++;
            }
            minutesWaitingB -= 1;
            
        }
    }
}
