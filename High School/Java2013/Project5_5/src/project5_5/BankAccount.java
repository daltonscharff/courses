/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_5;

/**
 *
 * @author 14dscharff
 */
public class BankAccount {
    int balance;
    String name;
    
    public BankAccount(){
        name = null;
        balance = 0;
    }
    public BankAccount(String nm, int bal){
        name = nm;
        balance = bal;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public void addToBalance(int add){
        balance += add;
    }
    
    public void subtractFromBalance(int sub){
        balance -= sub;
    }
    
    public String toString(){
        String result = "Name: " + name  + "\nBalance: $" + balance;
        return result;
    }
}
