/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballscoreboard;
import java.util.*;
import java.io.File;
/**
 *
 * @author Dalton Scharff
 */
public class BaseballScoreboard{
static String HomeTeamName;
static String HomeTeamColor;
static String AwayTeamName;
static String AwayTeamColor;
static String FileLocation;
static String FileName;
static int HomeScore = 0;
static int AwayScore = 0;
static int Inning = 1;
static int Balls = 0;
static int Strikes = 0;
static int Outs = 0;
static boolean TopOfInning = true;
static boolean OnFirst = false;
static boolean OnSecond = false;
static boolean OnThird = false;
static boolean ThreeOuts = true;
static char Input = ' ';


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //ConsoleIO(); 
        GUI test = new GUI();
    }
    
    public static void ConsoleIO(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Home Team Name: \t");
        HomeTeamName = reader.next();
        System.out.print("Home Team Color: \t");
        HomeTeamColor = reader.next();
        System.out.print("Away Team Name: \t");
        AwayTeamName = reader.next();
        System.out.print("Away Team Color: \t");
        AwayTeamColor = reader.next();

        while(Input != 'q'){
            System.out.print("Input: ");
            Input = reader.next().charAt(0);
            
            Demux(Input);
            
            System.out.println("\n" + HomeTeamName + ": \t" + HomeScore);
            System.out.println(AwayTeamName + ": \t" + AwayScore);
            if(TopOfInning){
                System.out.println("Inning: \t▲" + Inning);
            }else{
                System.out.println("Inning: \t▼" + Inning);
            }
            System.out.println("Balls: \t\t" + Balls);
            System.out.println("Strikes: \t" + Strikes);
            System.out.println("Outs: \t\t" + Outs);
            System.out.println("On First?: \t" + OnFirst);
            System.out.println("On Second?: \t" + OnSecond);
            System.out.println("On Third?: \t" + OnThird + "\n");
        }
    } 
    
    public static void Demux(char input){
        if(input == '.'){
            CompleteReset();
        }else if(input == '1'){
            BallsChange();
        }else if(input == '2'){
            StrikesChange();
        }else if(input == '3'){
            OutsChange();
        }else if(input == '4'){
            OnThirdChange();
        }else if(input == '5'){
            OnSecondChange();
        }else if(input == '6'){
            OnFirstChange();
        }else if(input == '8'){
            HomeScoreChange(true);
        }else if(input == '9'){
            AwayScoreChange(true);
        }else if(input == '+'){
            InningChange(true);
        }else if(input == '/'){
            HomeScoreChange(false);
        }else if(input == '*'){
            AwayScoreChange(false);
        }else if(input == '-'){
            InningChange(false);
        }
    }
    
    public static void HomeScoreChange(boolean add){
        if(add){
            HomeScore ++;
        }else{
            HomeScore --;
        }
        if(HomeScore < 0){
            HomeScore = 0;
        }
    }
    
    public static void AwayScoreChange(boolean add){
        if(add){
            AwayScore ++;
        }else{
            AwayScore --;
        }
        if(AwayScore < 0){
            AwayScore = 0;
        }
    }
    
    public static void InningChange(boolean add){
        if(add){
            if(TopOfInning){
                TopOfInning = false;
            }else{
                Inning ++;
                TopOfInning = true;
            }
        }else{
            if(TopOfInning){
                Inning --;
                TopOfInning = false;
            }else{
                TopOfInning = true;
            }
        }
        if(Inning == 0){
            Inning = 1;
            TopOfInning = true;
        }
        Balls = 0;
        Strikes = 0;
        Outs = 0;
        OnFirst = false;
        OnSecond = false;
        OnThird = false;
    }
    
    public static void OnFirstChange(){
        if(OnFirst){
            OnFirst = false;
        }else{
            OnFirst = true;
        }
    }
    
    public static void OnSecondChange(){
        if(OnSecond){
            OnSecond = false;
        }else{
            OnSecond = true;
        }
    }
    
    public static void OnThirdChange(){
        if(OnThird){
            OnThird = false;
        }else{
            OnThird = true;
        }
    }
    
    public static void BallsChange(){
        if(Balls == 3){
            Balls = 0;
            Strikes = 0;
        }else{
            Balls ++;
        }
    }
    
    public static void StrikesChange(){
        if(Strikes == 2){
            Strikes = 0;
            Balls = 0;
        }else{
            Strikes ++;
        }
    }
    
    public static void OutsChange(){
        if(Outs == 2){
            Outs = 0;
            if(ThreeOuts){
                InningChange(true);
            }
            
        }else{
            Outs ++;
        }
        Balls = 0;
        Strikes = 0;
    }
    
    public static void CompleteReset(){
        HomeScore = 0;
        AwayScore = 0;
        Inning = 1;
        Balls = 0;
        Strikes = 0;
        Outs = 0;
        TopOfInning = true;
        OnFirst = false;
        OnSecond = false;
        OnThird = false;
    }
    
}
