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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creates a product object that initializes all of the fields in
        //the class
        Company Apple = new Company("Apple", "1 Infinite Loop\n\t\tCupertino, CA 95014");
        Software item1 = new Software(500, "iMovie", "Video editing software.");
        item1.setCompany(Apple);
        
        //Prints out the product object just created (using the toString
        //method).
        System.out.println(item1.toString());
        
        //Duplicate that product object.
        Software item2 = new Software(item1);
        
        //In the duplicate object, change the software's name.
        item2.setName("Premiere Pro");
        
        //Get the company data field in the duplicate object using an
        //accessor method and call it companyInfo.
        Company companyInfo = item2.getCompany();
    
        //Change the companyInfo state to a new value.         
        companyInfo.setName("Adobe");
        companyInfo.setAddress("345 Park Avenue\n\t\tSan Jose, CA 95110");
  
        //Print out the duplicate, the original object, and the
        //companyInfo object.
        System.out.println("-----------------------------------------\n\n");
        System.out.println(item2 + "\n" + item1 + "\n" + companyInfo);
    }
    
}
