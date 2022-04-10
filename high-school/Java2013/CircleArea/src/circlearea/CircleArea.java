/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circlearea;
import javax.swing.JOptionPane;

/**
 *
 * @author 14dscharff
 */
public class CircleArea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean isNotOK = true;
    while(isNotOK){
        String inputStr = JOptionPane.showInputDialog("What is love?", "Baby don't hurt me!");
        if (inputStr == null){
            return;
        }
        double radius = Double.parseDouble(inputStr);
        if (radius < 0){
            JOptionPane.showMessageDialog(null, "Error: Radius must be positive!");
        }else{
            isNotOK = false;
            double area = Math.PI * Math.pow(radius,2);
            JOptionPane.showMessageDialog(null, "The Area is " + area + ".");            
            }
        }
    }
}
