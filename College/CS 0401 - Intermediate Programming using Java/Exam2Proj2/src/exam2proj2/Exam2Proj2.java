/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exam2proj2;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 * Project 2
 */
public class Exam2Proj2 {

    /**
     * Creates three retail items and prints the properties of item1.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RetailItem item1 = new RetailItem("Jacket", 12, 59.95);
        RetailItem item2 = new RetailItem("Designer Jeans", 40, 34.95);
        RetailItem item3 = new RetailItem("Shirt", 20, 24.95);
        
        System.out.println(item1.toString());
    }
    
}
