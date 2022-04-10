/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tempconverstion;
import javax.swing.JOptionPane;
/**
 *
 * @author 14dscharff
 */
public class TempConverstion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean boo = true;
        while (boo){
        String inputStr = JOptionPane.showInputDialog("Enter the temperature in Fahrenheit.", "0");
        if (inputStr == null){
            return;
        }
        double fahrenheit = Double.parseDouble(inputStr);
        if (fahrenheit < -459.67){
            JOptionPane.showMessageDialog (null, "The temperature cannot go below absolute zero.");
        }else{
        boo = false;
        double celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
        JOptionPane.showMessageDialog(null, "The temperature in Celsius is " + celsius + ".");
        
    }
        }
    }
}
