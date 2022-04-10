



package project9_10;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class Project9_10 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random rGen = new Random();
        Random cGen = new Random();
        PitchModel model = new PitchModel();
        model.InitializeGrid();
        model.DrawGrid();
        
        int row = 0; int col = 0;
        for (int pitch = 1; pitch <= 5; pitch ++){
            System.out.println("Press ENTER to throw a penny.");
            String stuff = reader.nextLine();
            if(pitch == 1){
                while(row == 0 || col == 0){
                    row = rGen.nextInt(6);
                    col = cGen.nextInt(6);
                }
                model.setPitch(row,col);
                row = 0; col = 0;
            }else{
                while(row == 0 || col == 0){
                    row = rGen.nextInt(6);
                    col = cGen.nextInt(6);
                    if (row > 0 && col > 0 && model.getAvail(row,col) == true){
                        model.setPitch(row,col);
                    }else{
                        row = 0; col = 0;
                    }
                }
            }
            row = 0; col = 0;
            System.out.println();
            System.out.println();
            model.DrawGrid();
        }
        System.out.println();
        System.out.println("Your total score for 5 pitches is " + model.GetSum());
    }
}
