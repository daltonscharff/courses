/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexample;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author 14dscharff
 */
public class FileExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(new File("E:\\Java2013\\FileMaker\\numbers.txt"));
        double number, sum = 0;
        int count = 0;
        while(reader.hasNext()){
            number = reader.nextDouble();
            System.out.println(number);
            sum += number;
            count ++;
        }
        if (count == 0){
            System.out.println("The file has no numbers.");
        }else{
            System.out.println("The average is " + sum / count);
            
        }
    }
}
