
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class CharacterFrequency {
    private static String allLetters = "";
    
    public static void main(String[] args) throws FileNotFoundException{
        FrequencyBag<String> bag = new FrequencyBag();
        File input = new File("letter1.txt");
        Scanner reader = new Scanner(input);
                
        while(reader.hasNext()){
            allLetters += reader.next().toLowerCase();
        }
        for(int count = 0; count < allLetters.length()-1; count++){
            bag.add(allLetters.substring(count, count+1));
        }
        System.out.println("Character: Frequency\n====================");
        for(int count = 97; count <= 122; count++){
            System.out.println(Character.toString((char)count) + ": " + bag.getFrequencyOf(Character.toString((char)count)));
        }
    }
}
