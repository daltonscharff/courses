/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project7_6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JFrame{
    private Converter converter = new Converter();
    private JLabel blankLabelL = new JLabel("");
    private JLabel titleLabelL = new JLabel("Please enter the radius to use in the calculations");
    private JLabel areaCircleL = new JLabel("Area of Circle = ");
    private JLabel surfaceAreaL = new JLabel("Surface Area of Sphere = ");
    private JLabel volumeSphereL = new JLabel("Volume of Sphere = ");
    private JTextField radiusField = new JTextField("");
    private JButton calculate = new JButton("Calculate");
    
    double areaCircle = 0;
    double surfaceArea = 0;
    double volumeSphere = 0;
    String areaCircleS = null;
    String surfaceAreaS = null;
    String volumeSphereS = null;
    
    public GUIWindow(){
        JPanel topPanel = new JPanel(new GridLayout(3,1,12,6));
        topPanel.add(blankLabelL);
        topPanel.add(titleLabelL);
        JPanel buttonPanel = new JPanel(new GridLayout(1,2,12,6));
        buttonPanel.add(calculate);
        buttonPanel.add(radiusField);
        JPanel bottomPanel = new JPanel (new GridLayout(3,1,12,6));
        bottomPanel.add(areaCircleL);
        bottomPanel.add(surfaceAreaL);
        bottomPanel.add(volumeSphereL);        
        Container container = getContentPane();
        container.add(topPanel, BorderLayout.NORTH);
        container.add(buttonPanel);
        container.add(bottomPanel, BorderLayout.SOUTH);
        calculate.addActionListener(new CalculateListener());
               
    }
    
    private class CalculateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        double radius = 0;
        String input = radiusField.getText();
        converter.setRadius(input);
        try{
        areaCircle = converter.getArea();
        areaCircleS = String.format("%.3f%n", areaCircle);
        areaCircleL.setText("Area of Circle = " + areaCircleS);
        surfaceArea = converter.getSurface();
        surfaceAreaS = String.format("%.3f%n", surfaceArea);
        surfaceAreaL.setText("Surface Area of Sphere = " + surfaceAreaS);
        volumeSphere = converter.getVolume();
        volumeSphereS = String.format("%.3f%n", volumeSphere);
        volumeSphereL.setText("Volume of Sphere = " + volumeSphereS);
        System.out.println(areaCircle);
        System.out.println(surfaceArea);
        System.out.println(volumeSphere);
        
    }catch(Exception k){
        JOptionPane.showMessageDialog(null,"Improper data entry");
    }
    }
}
}
