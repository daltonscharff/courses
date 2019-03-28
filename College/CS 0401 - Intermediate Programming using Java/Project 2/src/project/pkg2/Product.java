/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.pkg2;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Product {
    private String name;
    private int quantity;
    private double price;
    /**
     * Sets defaults
     */
    public Product(){
        name = "Not entered.";
        quantity = 0;
        price = 0;
    }
    /**
     * Sets all fields with information
     * @param name Name of product
     * @param quantity Quantity in stock
     * @param price Price of product
     */
    public Product(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    /**
     * Checks if string is blank before setting the name field to it.
     * @param name Name of product
     * @return If name field was set correctly
     */
    public boolean setName(String name){
        if (name.equals("") || name.equals(" ") || name.contains("  ")){
            return false;
        }else{
            this.name = name;
            return true;
        }
    }
    /**
     * Does not check anything because quantity can be positive or negative
     * (if you sell too many)
     * @param quantity Quantity in stock
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    /**
     * Makes sure double is greater than zero before setting price
     * @param price Price of product
     * @return If price field was set correctly
     */
    public boolean setPrice(double price){
        if (price < 0){
            return false;
        }else{
            this.price = price;
            return true;
        }
    }
    /**
     * Allows other classes to access name field
     * @return Name field as a string
     */
    public String getName(){
        return name;
    }
    /**
     * Allows other classes to access quantity field
     * @return Quantity field as an integer
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * Allows other classes to access double field
     * @return Price field as a double
     */
    public double getPrice(){
        return price;
    }
    /**
     * Takes a String, parses it into the corresponding name, quantity, and price fields.
     * @param s String that is read from input file
     * @return Product to be added to the ArrayList of products
     */
    public Product setFromLine(String s){
        Product p = new Product();
        Scanner reader = new Scanner(s);
        if (s.contains("<") && s.contains(">")){
            //I was not sure if the input file would be formatted with brackets
            //or just spaces like from project 1
        }else if (s.equals("") || s.equals(" ") || s.contains("  ") || s.isEmpty()){
            //Do nothing
        }else{
            String tempItem  = reader.next();
            while (reader.hasNextDouble() == false && reader.hasNextInt() == false){
                tempItem += " " + reader.next();
            }
            if (p.setName(tempItem) == false){
                System.out.println("There has been a problem reading the name.");
            }else{
                p.setName(tempItem);
            }
            //System.out.println(tempItem);
             
            double tempDouble = reader.nextDouble();
            if (p.setPrice(tempDouble) == false){
                System.out.println("There has been a problem reading the price.");
            }else{
                p.setPrice(tempDouble);
            }
            //System.out.println(tempDouble);
            
            int tempInt = reader.nextInt();
            p.setQuantity(tempInt);
            //System.out.println(p.getQuantity());
        }
        return p;
    }
}
