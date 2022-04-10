/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project5_3;

/**
 *
 * @author 14dscharff
 */
public class Operations {
    int answerTop, answerBottom, n1, d1, n2, d2;
    Fraction fraction1, fraction2;
    String result;
    
    public void setData (Fraction f1, Fraction f2, int numerator1, int denominator1, int numerator2, int denominator2){
        fraction1 = f1;
        fraction2 = f2;
        n1 = numerator1;
        n2 = numerator2;
        d1 = denominator1;
        d2 = denominator2;
    }
    
    public String Add(){
        answerTop = (n1 * d2) + (n2 * d1);
        answerBottom = (d1 * d2);
        result = n1 + "/" + d1 + " + " + n2 + "/" + d2 + " = " + answerTop + "/" + answerBottom;                
        
        return result;
    }
    
        public String Subtract(){
        answerTop = (n1 * d2) - (n2 * d1);
        answerBottom = (d1 * d2);
        result = n1 + "/" + d1 + " + " + n2 + "/" + d2 + " = " + answerTop + "/" + answerBottom;                
        
        return result;
    }
        
        public String Multiply(){
        answerTop = (n1 * n2);
        answerBottom = (d1 * d2);
        result = n1 + "/" + d1 + " + " + n2 + "/" + d2 + " = " + answerTop + "/" + answerBottom;                
        
        return result;
    }
        
        public String Divide(){
        answerTop = (n1 * d2);
        answerBottom = (d1 * n2);
        result = n1 + "/" + d1 + " + " + n2 + "/" + d2 + " = " + answerTop + "/" + answerBottom;                
        
        return result;
    }    
}
