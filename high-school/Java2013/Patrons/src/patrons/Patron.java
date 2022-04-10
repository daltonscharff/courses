/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patrons;

/**
 *
 * @author 14dscharff
 */
public class Patron {
    
    String name = null, book1 = null, book2 = null, book3 = null;
    
    public Patron(){
        name = "";
        book1 = "";
        book2 = "";
        book3 = "";
    }
    
    public Patron(String n){
        name = n;
        book1 = null;
        book2 = null; 
        book3 = null;
    }
    
    public boolean searchBook(String b){
        boolean isFound = false;
        if(b.equals(book1)){
            isFound = true;
        }
        if(b.equals(book2)){
            isFound = true;
        }
        if(b.equals(book3)){
            isFound = true;
        }
        return isFound;
    }
        
    public void returnBook(String b){
        if(b.equals(book1)){
            book1 = null;
        }
        if(b.equals(book2)){
            book2 = null;
        }
        if(b.equals(book3)){
            book3 = null;
        }
    }
    
    public boolean takeBook(String b){
        boolean tookBook = false;
        for(int x = 1; x < 4; x++){
            if(x == 1){
                if(book1 == (null)){
                    book1 = b;
                    tookBook = true;
                    break;
                }
            }
            if(x == 2){
                if(book2 == (null)){
                    book2 = b;
                    tookBook = true;
                    break;
                }
            }
            if(x == 3){
                if(book3 == (null)){
                    book3 = b;
                    tookBook = true;
                    break;
                }
            }
        }
        return tookBook;
    }
    
    public String toString(){
        String patronStuff = null;
        String b1, b2, b3;
        if (book1 == (null)){
            b1 = "Not borrowed";
        }else{
            b1 = book1;
        }
        if (book2 == (null)){
            b2 = "Not borrowed";
        }else{
            b2 = book2;
        }
        if (book3 == (null)){
            b3 = "Not borrowed";
        }else{
            b3 = book3;
        }
        patronStuff = "Patron Name: " + name + "\n" +
                "Book 1: " + b1 + "\n" +
                "Book 2: " + b2 + "\n" + 
                "Book 3: " + b3;
        return patronStuff;
    }
    
}
