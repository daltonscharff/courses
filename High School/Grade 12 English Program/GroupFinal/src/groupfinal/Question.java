
package groupfinal;

import java.util.ArrayList;

public class Question {
    public String question,A,B,C,D;
    public char good;
    static ArrayList<Integer> i = new ArrayList<>();
    
    public Question(String str1, String str2, String str3, String str4, String str5, char a){
        good = a;
        question = str1;
        A = str2;
        B = str3;
        C = str4;
        D = str5;
    }
    
    static public boolean goodToGo(int x){
        for (Integer y : i) {
            if (x == y) return false;
        }
        i.add(x);
        return true;
    }
}