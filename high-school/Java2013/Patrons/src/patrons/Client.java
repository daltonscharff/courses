/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patrons;
import javax.swing.*;
import java.awt.*;

public class Client {
    
    public static void main(String[] args) {
        Book b1 = new Book("War and Peace","Tolstoy");
        Book b2 = new Book("Relic","Preston and Childs");
        Book b3 = new Book("Red Squirrel","Noecker");
        
        String p = JOptionPane.showInputDialog("Please name the patron:");
        Patron pat = new Patron(p);
        String bookList = "", thisBook = null;
        Boolean trueFalse = true;
        
        while(trueFalse = true){
        int menu = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do? \n 1) Borrow a book \n 2) Return a book \n 3) Search a book \n 4) End"));
        
        if (menu == 1){                 //Borrow a book
        for (int x = 1; x < 4; x++){
            if (x == 1){
                bookList += b1.toString() + "\n";
            }
            if (x == 2){
                bookList += b2.toString() + "\n";
            }
            if (x == 3){
                bookList += b3.toString();
            }
        }
        int bookSelection = Integer.parseInt(JOptionPane.showInputDialog("Please choose a book (1 - 3)" + "\n\n" + bookList + "\n "));
                
        if (bookSelection == 1){
            thisBook = b1.getTitle();
        }
        if (bookSelection == 2){
            thisBook = b2.getTitle();
        }
        if (bookSelection == 3){
            thisBook = b3.getTitle();
        }
        
        if(pat.takeBook(thisBook)){
            JOptionPane.showMessageDialog(null,"Your book has been borrowed.");
        }else{
            JOptionPane.showMessageDialog(null,"You already three books!");
        }
        
        JOptionPane.showMessageDialog(null,"Here are your borrowed books:\n" + pat);
        }
        
        if (menu == 2){                 //Return a book
            int returnThis = Integer.parseInt(JOptionPane.showInputDialog(null,"Here are your borrowed books:\n" + pat + "\nWhich would you like to return (1-3)?"));
            if (returnThis == 1){
                String returnThisString = "War and Peace";
                pat.returnBook(returnThisString);
            }
        }
        
        if (menu == 3){                 //Search a book
            
        }
        
        
        if (menu == 4){                 //End
        JOptionPane.showMessageDialog(null,"Here are your borrowed books:\n" + pat);
        trueFalse = false;
        break;
        }
        }
    }
}
