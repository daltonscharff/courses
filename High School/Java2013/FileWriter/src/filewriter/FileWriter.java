/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filewriter;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author 14dscharff
 */
public class FileWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new File("E:\\Java2013\\FileReader\\data.txt"));
        double number;
        int x = 0;
        System.out.println("Enter your numbers. Enter 0 to end.");
        while (x == 0){
            System.out.print("Please input a number: ");
            number = reader.nextDouble();
            if (number == 0){
                x = 1;
            }
            writer.println(number);
        }
        writer.close();
    }
}
