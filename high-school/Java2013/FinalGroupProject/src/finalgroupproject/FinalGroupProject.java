/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalgroupproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author Dalton
 */
public class FinalGroupProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Window gui = new Window();
        gui.setSize(640,480);
        gui.setResizable(false);
        gui.setVisible(true);
        gui.setName("Tic Tac Toe");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
    }
    
}
