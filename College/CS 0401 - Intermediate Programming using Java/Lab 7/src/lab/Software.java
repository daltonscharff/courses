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
public class Software {
    private int quantity;
    private Company distributor = new Company();
    private String name;
    private String description;
    
    /**
     * Sets fields to generic value.
     */
    public Software(){
        quantity = 0;
        distributor.setName("TBA");
        distributor.setAddress("None Listed");
        name = "TBA";
        description = "None Listed";
    }
    
    /**
     * Duplicates software object.
     * @param s Software to be duplicated
     */
    public Software(Software s){
        quantity = s.getQuantity();
        distributor.setName(s.distributor.getName());
        distributor.setAddress(s.distributor.getAddress());
        name = s.getName();
        description = s.getDescription();
    }
    
    /**
     * Defines fields with quantity, name, and description, giving the Company
     * object generic values.
     * @param q Quantity of software in stock
     * @param n Name of software
     * @param d Description of software
     */
    public Software(int q, String n, String d){
        quantity = q;
        distributor.setName("TBA");
        distributor.setAddress("None Listed");
        name = n;
        description = d;
    }
    
    /**
     * Defines quantity field.
     * @param q Quantity of software in stock
     * @return Whether quantity was filled with a valid value
     */
    public boolean setQuantity(int q){
        if (q >= 0){
            quantity = q;
            return true;
        }else{
            return false;
        }
    }
    /**
     * Sends quantity as an integer.
     * @return Quantity of software in stock
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * Defines name field.
     * @param n Name of software
     * @return Whether name was filled with a non-empty string
     */
    public boolean setName(String n){
        if (n.equals(" ")){
            return false;
        }else{
            name = n;
            return true;
        }
    }
    
    /**
     * Sends name of software as a string.
     * @return Name of software
     */
    public String getName(){
        return name;
    }
    
    /**
     * Defines description field.
     * @param d Description of software
     * @return Whether description was filled with a non-empty string
     */
    public boolean setDescription(String d){
        if(d.equals(" ")){
            return false;
        }else{
            description = d;
            return true;
        }
    }
    
    /**
     * Sends software description as a string.
     * @return Description of software
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Defines the name and address fields of the distributing company.
     * @param c Company created in main class
     * @return Whether the company's name and address were set
     */
    public boolean setCompany(Company c){
        if (c.getName().equals("") || c.getAddress().equals("")){
            return false;
        }else{
            distributor.setName(c.getName());
            distributor.setAddress(c.getAddress());
            return true;
        }
    }
    
    /**
     * Sends the company object that distributes the software.
     * @return Company information that created the software
     */
    public Company getCompany(){
        return distributor;
    }
    
    /**
     * Checks if two software names are the same.
     * @param s2 Software to be compared
     * @return Whether is the same (true) or is not the same (false)
     */
    public boolean equals(Software s2){
        if (s2.name.equalsIgnoreCase(name)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Sends software information (name, description, distributor, and quantity)
     * as a string.
     * @return Software information
     */
    public String toString(){
        return "Name: " + name + "\n"
                + "Description: " + description + "\n"
                + "Distributor: " + distributor.getName() + "\n"
                + "Quantity: " + quantity + "\n\n";
    }
}
