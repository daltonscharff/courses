package lab.pkg6;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Lab6 {

    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        final int LOWER_BOUND = 0;
        final int UPPER_BOUND = 100;
        double num = getValidNumber(LOWER_BOUND,UPPER_BOUND);
        System.out.println("Your number, "+num+", is within bounds.\n");
        String filename = getFilename();
        ArrayList<String> lines = new ArrayList<String>();
        lines = (ArrayList<String>)getFileLines(filename);
        System.out.println("The file "+filename+" has the lines: "+lines);                
    }
    
    /**
     * 
     * User inputs number. Program checks if input is within parameters defined
     * in the main class.
     * 
     * @param lowerBound The lowest possible number within bounds
     * @param upperBound The highest possible number within bounds
     * @return The input that is within bounds is returned
     */
    public static double getValidNumber(int lowerBound, int upperBound){
        double input = 0;
        boolean repeater = true;
        Scanner reader = new Scanner(System.in);
        while (repeater == true){
            System.out.print("Please enter a number: ");
            input = reader.nextDouble();
            if (input > lowerBound && input < upperBound){
                repeater = false;
            }else{
                System.out.println("That number was not within the bounds.\nTry again.");
            }
        }
        return input;
    }
    
    /**
     * 
     * User inputs string. Program checks if a file has the same name as that
     * string.
     * 
     * @return The input string that is a valid filename.
     */
    public static String getFilename(){
        String input = "";
        boolean repeater = true;
        Scanner reader = new Scanner(System.in);
        while (repeater == true){
            System.out.print("Please enter a filename: ");
            input = reader.next();
            File temp = new File(input);
            if (temp.exists() == true){
                repeater = false;
            }else{
                System.out.println("That file was not found.\nTry again.");
            }
        }
        return input;
    }
    
    /**
     * 
     * Program parses file that user has entered in the main class and sets each
     * line equal to an ArrayList.
     * 
     * @param filename Name of a valid filename.
     * @return The ArrayList of lines within the file.
     * @throws IOException 
     */
    public static ArrayList getFileLines(String filename) throws IOException{
        ArrayList<String> lines = new ArrayList<String>();
        Scanner parse = new Scanner(new File(filename));
        while (parse.hasNext() == true){
            lines.add(parse.nextLine());
        }
        parse.close();
        return lines;
    }
}
