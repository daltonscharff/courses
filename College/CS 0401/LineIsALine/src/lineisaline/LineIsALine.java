/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lineisaline;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class LineIsALine {
    private static ArrayList<String> aCustomers = new ArrayList<String>();
    private static ArrayList<String> bCustomers = new ArrayList<String>();
    private static ArrayList<Customer> cust = new ArrayList<Customer>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int count = 1; count < 13; count++){
            Customer c = new Customer(count);
            cust.add(c);
        }

        HandyAndys(cust);
        McBurgers(cust);
    }
    
    private static void HandyAndys(ArrayList<Customer> cust){
        for(int count = 0; count < 12; count ++){        
            if (HandyAndy.getWaitTimeA() <= HandyAndy.getWaitTimeB()){
                HandyAndy.setWaitTimeA(cust.get(count));
                aCustomers.add(cust.get(count).toString());
            }else if(HandyAndy.getWaitTimeA() > HandyAndy.getWaitTimeB()){
                HandyAndy.setWaitTimeB(cust.get(count));
                bCustomers.add(cust.get(count).toString());
            }else{
                Random gen = new Random();
                int random = gen.nextInt(2);
                if(random == 0){
                    HandyAndy.setWaitTimeA(cust.get(count));
                    aCustomers.add(cust.get(count).toString() + "\n");
                }else{
                    HandyAndy.setWaitTimeB(cust.get(count));
                    bCustomers.add(cust.get(count).toString() + "\n");
                }
            }

        }
        System.out.println("Handy Andy's");
        System.out.println("Cashier A:");
        for(int count = 0; count < aCustomers.size(); count++){
            System.out.println(aCustomers.get(count));
        }
        System.out.println("\nCashier B:");
        for(int count = 0; count < bCustomers.size(); count++){
            System.out.println(bCustomers.get(count));
        }
        HandyAndy.finisherA();
        HandyAndy.finisherB();
        

        
    }
    
    private static void McBurgers(ArrayList<Customer> cust){
        for(int count = 0; count < cust.size(); count++){
            if(McBurger.getMinutesWaitingA() < McBurger.getMinutesWaitingB()){
                McBurger.AddToQueueOne(cust.get(count));
            }else if(McBurger.getMinutesWaitingA() > McBurger.getMinutesWaitingB()){
                McBurger.AddToQueueTwo(cust.get(count));
            }else{
                Random gen = new Random();
                int random = gen.nextInt(2);
                if(random == 0){
                    McBurger.AddToQueueOne(cust.get(count));
                }else{
                    McBurger.AddToQueueTwo(cust.get(count));
                }
            }
        }
        System.out.println("\n\nMcBurger's");
        System.out.println("Line 1:");
        for (int count = 0; count < McBurger.line1.size(); count++){
            System.out.println(McBurger.line1.get(count));
        }
        System.out.println("\nLine 2:");
        for (int count = 0; count < McBurger.line2.size(); count++){
            System.out.println(McBurger.line2.get(count));
        }
    }
}
