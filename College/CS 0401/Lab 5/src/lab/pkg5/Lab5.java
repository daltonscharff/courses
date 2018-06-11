/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.pkg5;
import java.io.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //Instantiates ArrayLists
        List<String> names = new ArrayList<String>();
        List<String> dates = new ArrayList<String>();
        int count = 0; //Variable later used to referece an index
        
        try {Scanner fileReader = new Scanner(new File("names.txt"));//Reads in "names.txt"
            while(fileReader.hasNextLine() == true && fileReader.hasNext()){ //Parses whole file and makes sure that a line has characters in it
                names.add(fileReader.next());
                dates.add(fileReader.next());
                if (names.get(count).equalsIgnoreCase("Frank")){//If ArrayList names at index count equals "Frank", it changes his birthday accordingly
                    dates.set(count, "2/3/91");
                }
                count++;
            }
            fileReader.close();
        }catch (IOException e){//Tells user if file is not found instead of crashing program
            System.out.println("Error! File not found!");
        }
        
        PrintWriter outFile = new PrintWriter("names.txt");//Replaces old names.txt file with following information
        for (int index = 0; index < count; index++){
           outFile.println(names.get(index) + "\t" + dates.get(index));//Writes new names and birthdays to file from arrays
        }
        outFile.close();
    }
    
}
