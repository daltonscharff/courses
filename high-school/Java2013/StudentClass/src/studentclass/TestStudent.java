/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentclass;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class TestStudent {
    
    public static void main (String[] args){
        Student s1,s2,s3,s4;
        
        s1 = new Student();
        s1.setName("Bill");
        s1.setScore(1, 84);
        s1.setScore(2, 86);
        s1.setScore(3, 88);
        System.out.println("\nHere is student s1\n" + s1);
        s2 = s1;
        s2.setName("Ann");
        System.out.println("\nName of s1 is now: " + s1.getName());
        s3 = new Student("Harold");
        System.out.println("This is student 3's information: ");
        System.out.println(s3);
        s4 = new Student(88, 77, 99);
        System.out.println("This is student 4's information: ");
        System.out.println(s4);
    }
    
}
