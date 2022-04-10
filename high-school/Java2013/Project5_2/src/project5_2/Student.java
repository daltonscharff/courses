/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_2;

/**
 *
 * @author 14dscharff
 */
public class Student {

    private String name; // create variables before first method
    private int test1;
    private int test2;
    private int test3;
     
    public Student(){
        this("",0,0,0);
    }
    
    public Student(String nm, int t1, int t2, int t3){
        name = nm;
        test1 = t1;
        test2 = t2;
        test3 = t3;
    }
     
    public Student (Student s){
        this(s.name,s.test1,s.test2,s.test3);
    }
    
    public Student (String n){
        this(n,0,0,0);
    }
    
    public Student (int s1, int s2, int s3){
        this("To Be Added", s1, s2, s3);
    }
    
    public String validateData(){
        String resultString = null;
        if(name.equals("")){
            resultString = "Please enter a name";
        }else if (test1 < 0 || test1 > 100 || test2 < 0 || test2 > 100 || test3 < 0 || test3 > 100){
            resultString = "A score is out of range";
        }else{
            resultString = null;
        }
        return resultString;
    }
    
    public void setName (String nm){
        name = nm;
    }
    
    public String getName (){
        return name;
    }
    
    public void setScore(int i, int score){
        if      (i == 1) test1 = score;
        else if (i == 2) test2 = score;
        else             test3 = score;
    }
    
    public int getScore (int i){
        if      (i == 1) return test1;
        else if (i == 2) return test2;
        else             return test3;
    }
    
    public int getAverage (){
        int average;
        average = (int) Math.round((test1 + test2 + test3) / 3.0);
        return average;
    }
    
    public int getHighScore(){
        int highScore;
        highScore = test1;
        if (test2 > highScore) highScore = test2;
        if (test3 > highScore) highScore = test3;
        return highScore;
    }
    
    public String toString(){
        String str;
        str = "Name:     " + name + "\n" + 
              "Test 1:   " + test1 + "\n" +
              "Test 2:   " + test2 + "\n" +
              "Test 3:   " + test3 + "\n" +
              "Average:  " + getAverage();
        return str;
    }
}
