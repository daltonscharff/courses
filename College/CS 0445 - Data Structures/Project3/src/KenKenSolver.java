/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class KenKenSolver {
    public static int size;
    public static int numOfCages;
    public static int[][] answer;
    public static Cage[] cageArray;
    public static ArrayList<Integer[]> permutations = new ArrayList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        JFrame frame = new JFrame();
        Scanner reader = new Scanner(System.in);
        String filename = "puzzle_files/";
        String fileContents;
        
        
        
        System.out.print("Please insert the filename: ");
        filename += reader.next();
//        filename += "8x8_2.txt";
        KenKenComponent kc = new KenKenComponent(filename,frame);
        Scanner parser = new Scanner(new File(filename));
        
        
        size = parser.nextInt();
//        System.out.println("Size: " + size);
        numOfCages = parser.nextInt();
//        System.out.println("Cages: " + numOfCages);
        answer = new int[size][size];
        twoDimArrayFiller(answer);
        cageArray = new Cage[numOfCages];
        parser.nextLine();
        
        int j = 0;
        while(parser.hasNext()){
            String temp = parser.nextLine();
            String[] header = temp.split(",");
            int goal = Integer.parseInt(header[0]);
            String operator = header[1];
            int cageSize = Integer.parseInt(header[2]);
            int[] locationRow = new int[cageSize];
            int[] locationCol = new int[cageSize];
            for(int i = 0; i < cageSize; i ++){
                temp = parser.nextLine();
                header = temp.split(",");
                locationRow[i] = Integer.parseInt(header[0]);
                locationCol[i] = Integer.parseInt(header[1]);
            }
            Cage current = new Cage(goal, locationRow, locationCol, operator);
            cageArray[j] = current;
            j++;
        }
        
        try{
            recursive(0,0);
        }catch (IllegalArgumentException e){
            
//        }catch (StackOverflowError s){
        
        }

        kc.setNumber(answer);
        
    }
    
    private static void recursive(int row, int col){
        //twoDimArrayDisplay(answer);

        answer[row][col] = answer[row][col] + 1;
        
        if(answer[row][col] > size){
            answer[row][col] = 0;
            if(row == 0){
                row = size-1; col -= 1;
            }else{
                row -= 1;
            }
            recursive(row,col);
        }
        
        if(row == size-1 && col == size-1 && cageChecker() == true && rowChecker() == true && colChecker() == true){
            System.out.println("Success");
            throw new IllegalArgumentException();
        }else{
            if(cageChecker() == true && rowChecker() == true && colChecker() == true){
                if(row < size - 1){
                    row++;
                }else{
                    row = 0; col += 1;
                }
                recursive(row,col);
            }else{
                if(answer[row][col] == size){
                    answer[row][col] = 0;
                    if(row == 0){
                        row = size-1; col -= 1;
                    }else{
                        row = row-1;
                    }
                }
                recursive(row,col);
            }
        }
    }
 
    
    private static void twoDimArrayDisplay(int[][] array){
        String temp = "";
        for(int a = 0; a < array.length; a++){
            for(int b = 0; b < array.length; b++){
                temp += answer[a][b] + " ";
            }
            temp += "\n";
        }
        System.out.println(temp);
    }
    
    private static void twoDimArrayFiller(int[][] array){
        for(int a = 0; a < array.length; a++){
            for(int b = 0; b < array.length; b++){
                answer[a][b] = 0;
            }
        }
    }
    
    private static boolean cageChecker(){
        int tempGoal = 0;
        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        
        for(int a = 0; a < cageArray.length; a++){
            tempArray.clear();
            for(int b = 0; b < cageArray[a].locationRow.length; b++){
                tempArray.add(answer[cageArray[a].locationRow[b]][cageArray[a].locationCol[b]]);
            }
            Collections.sort(tempArray, Collections.reverseOrder());
            if(!tempArray.contains(0)){
                if(cageArray[a].operator.equals(" ")){
                    tempGoal = tempArray.get(0);
                }
                if(cageArray[a].operator.equals("+")){
                    tempGoal = tempArray.get(0);
                    for(int c = 1; c < tempArray.size(); c++){
                        tempGoal += tempArray.get(c);
                    }
                }
                if(cageArray[a].operator.equals("*")){
                    tempGoal = tempArray.get(0);
                    for(int c = 1; c < tempArray.size(); c++){
                        tempGoal *= tempArray.get(c);
                    }
                }
                if(cageArray[a].operator.equals("-")){
                    tempGoal = tempArray.get(0);
                    for(int c = 1; c < tempArray.size(); c++){
                        tempGoal -= tempArray.get(c);
                    }
                }
                if(cageArray[a].operator.equals("/")){
                    tempGoal = tempArray.get(0);
                    for(int c = 1; c < tempArray.size(); c++){
                        tempGoal /= tempArray.get(c);
                    }
                }
            }
            if(!tempArray.contains(0)){
                if(tempGoal != cageArray[a].goal){
                    return false;
                }
            }
        }        
        return true;
    }
    
    private static boolean rowChecker(){
        int[] temp = new int[size];
        for(int a = 0; a < size; a++){
            for(int b = 0; b < size; b++){
                temp[b] = answer[a][b];
                if(duplicate(temp) == true){
                    return false;
                }
            }
            temp = new int[size];
        }
        return true;
    }
    
    private static boolean colChecker(){
        int[] temp = new int[size];
        for(int a = 0; a < size; a++){
            for(int b = 0; b < size; b++){
                temp[b] = answer[b][a];
                if(duplicate(temp) == true){
                    return false;
                }
            }
            temp = new int[size];
        }
           return true;
    }
    
    private static boolean duplicate(int[] array){
        boolean z = false;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                if((array[i] == array[j]) && (i != j) && (array[i] != 0)){
                    z = true;
                }
            }
        }
        return z;
    }

    

    
}
