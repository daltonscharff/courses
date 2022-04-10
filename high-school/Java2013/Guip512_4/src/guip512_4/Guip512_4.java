/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guip512_4;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Guip512_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame dalton = new JFrame();
        dalton.setTitle("Dalton's Grid");
        dalton.setSize(300,200);
        dalton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container christ = dalton.getContentPane();
        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        christ.add(panel);
        dalton.setVisible(true);
        
    }
}
