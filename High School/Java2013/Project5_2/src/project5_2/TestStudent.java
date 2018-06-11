/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_2;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class TestStudent {
    
    public static void main (String[] args){
        
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        String tempScore = "";
        int sc1 = 0; int sc2 = 0; int sc3 = 0;
        
        String goodToGo = "Hold";
        
        for(int x = 1; x < 4; x++){
            if(x == 1){
                while(goodToGo != null){
                    String name1 = JOptionPane.showInputDialog("Student one's name:", "");
                    sc1 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 1 for student 1", "0"));
                    sc2 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 2 for student 1", "0"));
                    sc3 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 3 for student 1", "0"));
                    s1 = new Student(name1, sc1, sc2, sc3);
                    goodToGo = s1.validateData();
                    if(goodToGo != null){
                        JOptionPane.showMessageDialog(null, goodToGo);
                    }
                }
            }
            if(x == 2){
                goodToGo = "Hold";
                while(goodToGo != null){
                    String name1 = JOptionPane.showInputDialog("Student two's name:", "");
                    sc1 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 1 for student 2", "0"));
                    sc2 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 2 for student 2", "0"));
                    sc3 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 3 for student 2", "0"));
                    s2 = new Student(name1, sc1, sc2, sc3);
                    goodToGo = s2.validateData();
                    if(goodToGo != null){
                        JOptionPane.showMessageDialog(null, goodToGo);
                    }
            }
        }else if (x == 3){
               goodToGo = "Hold";
                while(goodToGo != null){
                    String name1 = JOptionPane.showInputDialog("Student three's name:", "");
                    sc1 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 1 for student 3", "0"));
                    sc2 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 2 for student 3", "0"));
                    sc3 = Integer.parseInt(JOptionPane.showInputDialog("Enter score 3 for student 3", "0"));
                    s3 = new Student(name1, sc1, sc2, sc3);
                    goodToGo = s3.validateData();
                    if(goodToGo != null){
                        JOptionPane.showMessageDialog(null, goodToGo);
                    }
            }
        }
    }
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
}
}
