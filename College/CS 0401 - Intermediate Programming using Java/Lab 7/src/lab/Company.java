/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Company {
    private String name;
    private String address;
    
    /**
     * Sets fields to generic value.
     */
    public Company(){
        name = "TBA";
        address = "None Listed";
    }
    
    /**
     * Duplicates company object.
     * @param c Company to be duplicated
     */
    public Company(Company c){
        name = c.getName();
        address = c.getAddress();
    }
    
    /**
     * Defines fields with a name and address of a company.
     * @param n Name of company
     * @param a Address of company
     */
    public Company(String n, String a){
        name = n;
        address = a;
    }
    
    /**
     * Defines name field.
     * @param n Name of company
     * @return Whether the name was filled with a non-empty string
     */
    public boolean setName(String n){
        if(n.equals(" ")){
            return false;
        }else{
            name = n;
            return true;
        }
    }
    
    /**
     * Sends name of company as a string
     * @return Name of the company
     */
    public String getName(){
        return name;
    }
    
    /**
     * Defines address field.
     * @param a Address of company
     * @return Whether the address was filled with a non-empty string
     */
    public boolean setAddress(String a){
        if(a.equals(" ")){
            return false;
        }else{
            address = a;
            return true;
        }
    }
    
    /**
     * Sends address of company as a string
     * @return Address of the company
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * Sends company information (name and address) as a string 
     * @return Name and address of company
     */
    public String toString(){
        return "Name:\t\t" + name + "\n"
                + "Address:\t" + address;
    }
}
