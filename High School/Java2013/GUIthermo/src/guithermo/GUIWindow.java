/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guithermo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JFrame{
    private Thermometer thermo = new Thermometer();
    
    private JLabel fahrLabel = new JLabel("Degrees Fahrenheit");
    private JLabel celsiusLabel = new JLabel("Degrees Celsius");
    private JTextField fahrField = new JTextField("32.0");
    private JTextField celsiusField = new JTextField("0.0");
    private JButton fahrButton = new JButton("Convert >>");
    private JButton celsiusButton = new JButton("<< Convert");
    
    public GUIWindow(){
        JPanel dataPanel = new JPanel(new GridLayout(2,2,12,6));
        dataPanel.add(fahrLabel);
        dataPanel.add(celsiusLabel);
        dataPanel.add(fahrField);
        dataPanel.add(celsiusField);
        JPanel buttonPanel = new JPanel(new GridLayout(1,2,12,6));
        buttonPanel.add(fahrButton);
        buttonPanel.add(celsiusButton);
        Container container = getContentPane();
        container.add(dataPanel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
        fahrButton.addActionListener(new FahrenheitListener());
        celsiusButton.addActionListener(new CelsiusListener());
        
    }
    
    private class FahrenheitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        double fahr = 0;
        String input = fahrField.getText();
        try{
        fahr = Double.parseDouble(input);
        thermo.setFahrenheit(fahr);
        double celsius = thermo.getCelsius();
        celsiusField.setText("" + String.format("%.3f", celsius));
    }catch(Exception k){
        JOptionPane.showMessageDialog(null,"Improper data entry");
    }
    }
}
    private class CelsiusListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        double celsius = 0;
        String input = celsiusField.getText();
        try{
        celsius = Double.parseDouble(input);
        thermo.setCelsius(celsius);
        double fahr = thermo.getFahrenheit();
        fahrField.setText("" + String.format("%.3f", fahr));
    }catch(Exception k){
        JOptionPane.showMessageDialog(null,"Improper data entry");
    
}
}
}
}