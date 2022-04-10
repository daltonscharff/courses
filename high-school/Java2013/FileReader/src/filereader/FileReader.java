/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filereader;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author 14dscharff
 */
public class FileReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(new File("E:\\Java2013\\FileReader\\data.txt"));
        double number = 0, sum = 0;
        int count = 0;
        while (reader.hasNext()){
            number = reader.nextDouble();
            if (number == 0){
                break;
            }
            System.out.println(number);
            count++; sum += number;
        }
        if  (count == 0){
            System.out.println("There are no numbers is your data file.");
        } 
        System.out.println("The average is " + (sum / count) + ".");
    }
}
