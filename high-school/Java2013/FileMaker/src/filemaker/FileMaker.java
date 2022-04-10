/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemaker;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author 14dscharff
 */
public class FileMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new File("E:\\Java2013\\FileMaker\\numbers.txt"));
        double num;
        for(int x = 1; x <= 5; x++){
            System.out.print("Please input a number: ");
            num = reader.nextDouble();
            writer.println(num);
        }
        writer.close(); //Transfers data from buffer to actual file
    }
}
