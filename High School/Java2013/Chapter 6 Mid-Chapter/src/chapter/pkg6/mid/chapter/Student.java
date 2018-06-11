/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter.pkg6.mid.chapter;
import javax.swing.*;
import java.awt.*;

public class Student {
    String sn, letterGrade, toString, a = "an A", b = " a B", c = "a C", d = "a D", f = "an F", error = "#ERROR#";
    int grade, category;
    
    public Student(){
        sn = null;
        grade = 0;
        category = 0;
    }
    
    public Student(String x, int y, int z){
        sn = x;
        grade = y;
        category = z;
    }
    
    private void getLetterGrade(){
        if (category == 1){
            if (grade >= 0 && grade <= 80){
                letterGrade = f;
            }if (grade > 80 && grade <= 85){
                letterGrade = d;
            }if (grade > 85 && grade <= 90){
                letterGrade = c;
            }if (grade > 90 && grade <= 95){
                letterGrade = b;
            }if (grade > 95 && grade <= 100){
                letterGrade = a;
            }
        }if (category == 2){
            if (grade >= 0 && grade <= 65){
                letterGrade = f;
            }if (grade > 65 && grade <= 69){
                letterGrade = d;
            }if (grade > 69 && grade <= 79){
                letterGrade = c;
            }if (grade > 79 && grade <= 89){
                letterGrade = b;
            }if (grade > 89 && grade <= 100){
                letterGrade = a;
            }
        }if (category == 3){
            if (grade >= 0 && grade <= 50){
                letterGrade = f;
            }if (grade > 50 && grade <= 59){
                letterGrade = d;
            }if (grade > 59 && grade <= 69){
                letterGrade = c;
            }if (grade > 69 && grade <= 79){
                letterGrade = b;
            }if (grade > 80 && grade <= 100){
                letterGrade = a;
            }
        }
        if ((category != 1 && category != 2 && category !=3) || grade < 0 || grade > 100) {
                letterGrade = error;
        }
    }
    
    public String toString(){
        getLetterGrade();
                       
        toString = (sn + " is in level " + category + " with a grade percentage of " + grade + ". \n"
                + "Therefore, " + sn + " will receive " + letterGrade + ".");
        return toString;
    }
}
