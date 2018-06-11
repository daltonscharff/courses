            /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pkg6;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
/**
 *
 * @author 14dscharff
 */
public class Project26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame france = new JFrame();
        france.setTitle("Flag of France");
        france.setSize(300,200);
        france.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel blue = new JPanel();
        JPanel white = new JPanel();
        JPanel red = new JPanel();
        blue.setBackground(Color.blue);
        white.setBackground(Color.white);
        red.setBackground(Color.red);
        Container flag = france.getContentPane();
        flag.setLayout(new GridLayout(1,3));
        flag.add(blue);
        flag.add(white);
        flag.add(red);
        france.setVisible(true);
        
        
    }
}
