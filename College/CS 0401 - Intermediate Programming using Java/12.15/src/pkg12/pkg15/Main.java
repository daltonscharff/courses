/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg12.pkg15;
/**
 *
 * @author Dalton Scharff <das227@pitt.edu>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Question Marks are WildCard tiles
        System.out.println(canSpell("quijibo?", "jib"));
    }
    
    public static boolean canSpell(String tiles, String word){
        boolean isTrue = true;
        boolean isLetterThere[] = new boolean[word.length()];
        int wildCard = 0;
        
        String[] wordArray = new String[word.length()];
        for (int count = 0; count < word.length(); count ++){
            wordArray[count] = word.substring(count, count+1);
            //System.out.print(wordArray[count]);
        }
        
        String[] tilesArray = new String[tiles.length()];
        for (int count = 0; count < tiles.length(); count ++){
            tilesArray[count] = tiles.substring(count, count+1);
            //System.out.print(tilesArray[count]);
            if (tilesArray[count].equals("?")){
                wildCard ++;
            }
        }
        
        for (int x = 0; x < wordArray.length; x ++){
            for (int y = 0; y < tilesArray.length-1; y ++){
                if (wordArray[x].equals(tilesArray[y])){
                    isLetterThere[x] = true;
                    tilesArray[y] = null;
                    break;
                }else{
                    isLetterThere[x] = false;      
                }
            }
        }
        
        for (int x = 0; x < wordArray.length; x ++){
            if (isLetterThere[x] == true){
                isTrue = true;
            }else{
                if (wildCard > 0){
                    isTrue = true;
                    wildCard--;
                }else{
                    isTrue = false;
                    break;
                }
            }
        }
        
        return isTrue;
    }
}
