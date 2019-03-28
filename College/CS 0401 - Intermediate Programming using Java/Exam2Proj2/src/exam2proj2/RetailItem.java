/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exam2proj2;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class RetailItem {
    private String description;
    private int unitsOnHand;
    private double price;
    /**
     * Sets all fields to default values.
     */
    public RetailItem(){
        description = "N/A";
        unitsOnHand = 0;
        price = 0;
    }
    /**
     * Sets all fields to declared values given that the values are valid.
     * @param description The name of the retail item
     * @param unitsOnHand The amount of an item in stock
     * @param price The price of an item
     */
    public RetailItem(String description, int unitsOnHand, double price){
        boolean check1 = setDescription(description);
        boolean check2 = setUnitsOnHand(unitsOnHand);
        boolean check3 = setPrice(price);
        if (check1 == true && check2 == true && check3 == true){
            //Do nothing. Everything is good.
        }else{
            System.out.println("There has been a problem. Recheck you inputs.");
        }
        
    }
    /**
     * Checks to see if user input string is not empty or filled with a space.
     * @param description Name of retail item
     * @return True if description was set successfully and is valid
     */
    public boolean setDescription(String description){
        boolean isValid = false;
        if (description.isEmpty() || description.equals(" ")){
            System.out.println("Please enter a valid description.");
            isValid = false;
            this.description = "N/A";
        }else{
            isValid = true;
            this.description = description;
        }
        return isValid;
    }
    /**
     * Checks to see if user input integer is greater than or equal to zero.
     * @param unitsOnHand Amount of items in stock
     * @return True if unitsOnHand was set successfully and is valid
     */
    public boolean setUnitsOnHand(int unitsOnHand){
        boolean isValid = false;
        if (unitsOnHand < 0){
            System.out.println("Please enter a valid amount of units on hand.");
            isValid = false;
            this.unitsOnHand = 0;
        }else{
            isValid = true;
            this.unitsOnHand = unitsOnHand;
        }
        return isValid;
    }
    /**
     * Checks to see if user input double is greater than or equal to zero.
     * @param price Price of item
     * @return True if description was set successfully and is valid
     */
    public boolean setPrice(double price){
        boolean isValid = false;
        if (price < 0){
            System.out.println("Please enter a valid price.");
            isValid = false;
            this.price = 0.00;
        }else{
            isValid = true;
            this.price = price;
        }
        return isValid;
    }
    /**
     * Returns item's description
     * @return Item's name
     */
    public String getDescription(){
        return description;
    }
    /**
     * Returns item's quantity in stock
     * @return Item's quantity
     */
    public int getUnitsOnHand(){
        return unitsOnHand;
    }
    /**
     * Returns item's price
     * @return Price of item
     */
    public double getPrice(){
        return price;
    }
    /**
     * Usable and readable output.
     * @return String of readable output
     */
    public String toString(){
        return description + ": " + unitsOnHand + " units on hand, at $" + price + "."; 
    }
}
