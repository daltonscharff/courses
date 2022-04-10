/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIwindow extends JFrame{
    JLabel leftHeading = new JLabel("                Number");
    JLabel rightHeading = new JLabel("                  Result");
    JTextField leftField = new JTextField("");
    JTextField rightField = new JTextField("0.000");
    JButton topLeftB = new JButton("<<");
    JButton bottomLeftB = new JButton("Square Root");
    JButton topRightB = new JButton(">>");
    JButton bottomRightB = new JButton("Square");
    int count = 3;
    String numberF = null;
    
    
    public GUIwindow(){
        JPanel panel = new JPanel(new GridLayout(4,2,2,5));
        panel.add(leftHeading);
        panel.add(rightHeading);
        panel.add(leftField);
        panel.add(rightField);
        panel.add(topLeftB);
        panel.add(topRightB);
        panel.add(bottomLeftB);
        panel.add(bottomRightB);
        Container container = getContentPane();
        container.add(panel);
        topLeftB.addActionListener(new DecreaseListener());
        topRightB.addActionListener(new IncreaseListener());
        bottomLeftB.addActionListener(new SquareRootListener());
        bottomRightB.addActionListener(new SquareListener());
    }
    
    private class IncreaseListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        String number = rightField.getText();
        double numberD = Double.parseDouble(number);
        count ++;
        System.out.println(count);
        try{
            if (count <= 0){
                numberF = String.format("%.0f%n", numberD);
                rightField.setText(numberF); 
                count = 0;
            }
            if (count == 1){
                numberF = String.format("%.1f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count == 2){
                numberF = String.format("%.2f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count == 3){
                numberF = String.format("%.3f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count == 4){
                numberF = String.format("%.4f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count >= 5){
                numberF = String.format("%.5f%n", numberD);
                rightField.setText(numberF); 
                count = 5;
            }
                
        }catch(Exception k){
            JOptionPane.showMessageDialog(null,"Improper data entry.");
    }
    }
    }
    
    private class DecreaseListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        String number = rightField.getText();
        double numberD = Double.parseDouble(number);
        count --;
        System.out.println(count);
        try{
            if (count <= 0){
                numberF = String.format("%.0f%n", numberD);
                rightField.setText(numberF); 
                count = 0;
            }
            if (count == 1){
                numberF = String.format("%.1f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count == 2){
                numberF = String.format("%.2f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count == 3){
                numberF = String.format("%.3f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count == 4){
                numberF = String.format("%.4f%n", numberD);
                rightField.setText(numberF); 
            }
            if (count >= 5){
                numberF = String.format("%.5f%n", numberD);
                rightField.setText(numberF);
                count = 5;
            }   
                
        }catch(Exception k){
            JOptionPane.showMessageDialog(null,"Improper data entry.");
    }
    }
    }
    
    private class SquareListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        System.out.println(count);       
        try{
            if (count == 0){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = numberD * numberD;
            numberF = String.format("%.0f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 1){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = numberD * numberD;
            numberF = String.format("%.1f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 2){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = numberD * numberD;
            numberF = String.format("%.2f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 3){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = numberD * numberD;
            numberF = String.format("%.3f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 4){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = numberD * numberD;
            numberF = String.format("%.4f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 5){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = numberD * numberD;
            numberF = String.format("%.5f%n", numberSquared);
            rightField.setText(numberF);
            }
            
        }catch(Exception k){
            JOptionPane.showMessageDialog(null,"Improper data entry.");
    }
    }
    }
    
    private class SquareRootListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        System.out.println(count);
        try{
            if (count == 0){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = Math.sqrt(numberD);
            numberF = String.format("%.0f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 1){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = Math.sqrt(numberD);
            numberF = String.format("%.1f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 2){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = Math.sqrt(numberD);
            numberF = String.format("%.2f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 3){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = Math.sqrt(numberD);
            numberF = String.format("%.3f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 4){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = Math.sqrt(numberD);
            numberF = String.format("%.4f%n", numberSquared);
            rightField.setText(numberF);
            }
            if (count == 5){
            String number = leftField.getText();
            double numberD = Double.parseDouble(number);
            double numberSquared = Math.sqrt(numberD);
            numberF = String.format("%.5f%n", numberSquared);
            rightField.setText(numberF);
            }
            
        }catch(Exception k){
            JOptionPane.showMessageDialog(null,"Improper data entry.");
    }
    }
    }
}