/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patrons;

/**
 *
 * @author 14dscharff
 */
public class Book {
    
    String title, author, stuff;
    
    public Book(){
        title = null;
        author = null;
    }
    
    public Book(String t, String a){
        title = t;
        author = a;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String toString(){
        stuff = null;
        stuff = "Title: " + title + "\n" + "Author: " + author;
        return stuff;
    }
}
