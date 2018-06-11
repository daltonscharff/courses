/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interest;
import java.text.DecimalFormat;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Account {
    protected double interestRate;
    protected double principle;
    protected double time;
    protected double finalAmount;
    
    public Account(){
        interestRate = 0;
        principle = 0;
        time = 0;
    }
    
    public void setInterestRate(double i){
        interestRate = i;
    }
    
    public void setPrinciple(double p){
        principle = p;
    }
    
    public void setTime(double t){
        time = t;
    }
    
    public double getInterestRate(){
        return interestRate;
    }
    
    public double getPrinciple(){
        return principle;
    }
    
    public double getTime(){
        return time;
    }
    
    public String toString(){
        String toBeReturned = String.format("\n$%.2f is deposited at an interest rate of %.2f%% per year.\n"
                + "The final balance after %.1f year(s) is $%.2f.", principle, interestRate*100, time, finalAmount);
        return toBeReturned;
    }
    
}
