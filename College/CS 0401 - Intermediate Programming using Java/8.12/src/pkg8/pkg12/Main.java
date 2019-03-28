/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg8.pkg12;

/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
//    int a=0,b=1,c=2,d=3,e=4,f=5,g=6,h=7,i=8,j=9,k=10,l=11,m=12,n=13;
//    int o=14,p=15,q=16,r=17,s=18,t=19,u=20,v=21,w=22,x=23,y=24,z=25;
    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(encryptor13(input));
        System.out.println(encryptorAny(encryptor13(input), -13));
    }
    public static String encryptor13(String input){
        String toString = "";
        int newNum = 0;
        for (int count = 0; count < input.length(); count++){
            String temp = input.substring(count, count+1);
            int num = temp.compareTo("a");
            if (num >= 0 && num <= 25){
                newNum = num + 13;
                if (newNum > 25){
                    newNum -= 26;
                }
                newNum += 97;
                toString += Character.toString((char) newNum);
            }else if (num >= -32 && num <= -7){
                newNum = num + 13;
                if (newNum > -7){
                    newNum -= 26;
                }
                newNum += 97;
                toString += Character.toString((char) newNum);
            }
        }
        return toString;
    }
    
    public static String encryptorAny(String input, int skew){
        String toString = "";
        int newNum = 0;
        for (int count = 0; count < input.length(); count++){
            String temp = input.substring(count, count+1);
            int num = temp.compareTo("a");
            if (num >= 0 && num <= 25){
                newNum = num + skew;
                if (newNum > 25){
                    newNum -= 26;
                }else if (newNum < 0){
                    newNum += 26;
                }
                newNum += 97;
                toString += Character.toString((char) newNum);
            }else if (num >= -32 && num <= -7){
                newNum = num + skew;
                if (newNum > -7){
                    newNum -= 26;
                }else if (newNum < -32){
                    newNum += 26;
                }
                newNum += 97;
                toString += Character.toString((char) newNum);
            }
        }
        return toString;
    }
}
