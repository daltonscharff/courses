/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballbat;

/**
 *
 * @author 14dscharff
 */
public class Player {
    String playerName;
    int atBats = 0, singles = 0, doubles = 0, triples = 0, homeruns = 0;
    double hits = 0, totalBases = 0, battingAverages = 0;
    int hit, totalBase, battingAverage;
    
    public Player(){
        playerName = null;
        atBats = 0;
        singles = 0;
        doubles = 0;
        triples = 0;
        homeruns = 0;
        hits = 0;
        totalBases = 0;
        battingAverage = 0;
    }
    
    public Player(String pn){
        playerName = pn;
    }
    
    public void getName(String pn){
        playerName = pn;
    }
    
    public void getAtBats(int a){
        atBats = a;
    }
    
    public void getSingles(int b){
        singles = b;
    }
    
    public void getDoubles(int c){
        doubles = c;
    }
    
    public void getTriples(int d){
        triples = d;
    }
    
    public void getHomeruns(int e){
        homeruns = e;
    }
    
    public void hits(){
        hits = singles + doubles + triples + homeruns;
        hit = (int) hits;
    }
    
    public void totalBases(){
        totalBases = (homeruns * 4) + (triples * 3) + (doubles * 2) + singles;
        totalBase = (int) totalBases;
    }
    
    public void battingAverage(){
        battingAverages = (hits / atBats) * 1000;
        battingAverage = (int) battingAverages;
    }
    
    public String toString(){
        String playerInfo = "Information for " + playerName + 
                "\nAt Bats: " + atBats + 
                "\nHits: " + hit + 
                "\nTotal Bases: " + totalBase + 
                "\nBatting Average: " + battingAverage +
                "\n\n";
        return playerInfo;
    }
}
