/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballscoreboard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dalton Scharff
 */
public class GUI extends JFrame implements KeyListener, ActionListener{

    String[] colors = {};
    JLabel label1 = new JLabel("Home Team Name:");
    JLabel label2 = new JLabel("Home Team Color:");
    JLabel label3 = new JLabel("Away Team Name:");
    JLabel label4 = new JLabel("Away Team Color:");
    JTextField field1 = new JTextField("");
    JTextField field2 = new JTextField("");
    JTextField field3 = new JTextField("");
    JComboBox box1 = new JComboBox();
    JComboBox box2 = new JComboBox();
    JButton button1 = new JButton("Create");
    JLabel label6 = new JLabel("");
    JLabel label7 = new JLabel("");
    JLabel label8 = new JLabel("");
    JLabel label9 = new JLabel("");
    JLabel label10 = new JLabel("");
    JLabel label11 = new JLabel("");
    JLabel label12 = new JLabel("");
    JLabel label13 = new JLabel("");
    JLabel label14 = new JLabel("");
    JLabel label15 = new JLabel("");
    JLabel label16 = new JLabel("");
    JLabel label17 = new JLabel("");
    JLabel label18 = new JLabel("");
    JLabel label19 = new JLabel("");
    JLabel label20 = new JLabel("");
    JLabel label21 = new JLabel("");
    JLabel label22 = new JLabel("");
    JLabel label23 = new JLabel("");
    JLabel label24 = new JLabel("Increment Inning on 3 Outs?");
    ButtonGroup group = new ButtonGroup();
    JRadioButton yesRad = new JRadioButton("Yes", true);
    JRadioButton noRad = new JRadioButton("No");
    
    Boolean buttonPressed = false;
    Boolean setDefaults = false;
    int homeColor = -1;
    int awayColor = -1;
    
    public GUI(){
        JFrame GUI = new JFrame();
        GUI.setTitle("Scoreboard");
        GUI.setSize(600,420);
        GUI.setResizable(false);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        loadDefaults();
        
        group.add(yesRad);
        group.add(noRad);
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1,2));
        panel4.add(yesRad);
        panel4.add(noRad);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5,2,0,10));
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(label2);
        panel1.add(box1);
        panel1.add(label3);
        panel1.add(field2);
        panel1.add(label4);
        panel1.add(box2);
        panel1.add(label24);
        panel1.add(panel4);
        
        JPanel panel2 = new JPanel();
        button1.addActionListener(this);
        panel2.add(button1);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(9,2));
        panel3.add(label6);
        panel3.add(label7);
        panel3.add(label8);
        panel3.add(label9);
        panel3.add(label10);
        panel3.add(label11);
        panel3.add(label12);
        panel3.add(label13);
        panel3.add(label14);
        panel3.add(label15);
        panel3.add(label16);
        panel3.add(label17);
        panel3.add(label18);
        panel3.add(label19);
        panel3.add(label20);
        panel3.add(label21);
        panel3.add(label22);
        panel3.add(label23);
        
        JPanel finalPanel = new JPanel();
        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);
        field3.addKeyListener(this);
        finalPanel.add(field3);
        finalPanel.setLayout(new BoxLayout(finalPanel,BoxLayout.Y_AXIS));
        GUI.add(finalPanel);
        
        GUI.setVisible(true);
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(buttonPressed){
            BaseballScoreboard.Input = e.getKeyChar();
            BaseballScoreboard.Demux(BaseballScoreboard.Input);
            BaseballScoreboard.ThreeOuts = yesRad.isSelected();
            writeFile();
            update();
        }else{
            label6.setText("Press Create!");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        BaseballScoreboard.HomeTeamName = field1.getText();
        BaseballScoreboard.AwayTeamName = field2.getText();
        
        if(setDefaults){
            writeDefaults(BaseballScoreboard.HomeTeamName, Integer.toString(box1.getSelectedIndex()), "Away", "1", yesRad.isSelected(), BaseballScoreboard.FileName, false);
            setDefaults = false;
        }
        
        label6.setText(BaseballScoreboard.HomeTeamName);
        label7.setText(Integer.toString(BaseballScoreboard.HomeScore));
        label8.setText(BaseballScoreboard.AwayTeamName);
        label9.setText(Integer.toString(BaseballScoreboard.AwayScore));
        label10.setText("Inning");
        if(BaseballScoreboard.TopOfInning){
            label11.setText("▲" + BaseballScoreboard.Inning);
        }else{
            label11.setText("▼" + BaseballScoreboard.Inning);
        }
        label12.setText("Balls");
        label13.setText(Integer.toString(BaseballScoreboard.Balls));
        label14.setText("Strikes");
        label15.setText(Integer.toString(BaseballScoreboard.Strikes));
        label16.setText("Outs");
        label17.setText(Integer.toString(BaseballScoreboard.Outs));
        label18.setText("On First?");
        label19.setText(Boolean.toString(BaseballScoreboard.OnFirst));
        label20.setText("On Second?");
        label21.setText(Boolean.toString(BaseballScoreboard.OnSecond));
        label22.setText("On Third?");
        label23.setText(Boolean.toString(BaseballScoreboard.OnThird));
        
        writeFile();
               
        buttonPressed = true;
    }
    
    public void update(){
        label7.setText(Integer.toString(BaseballScoreboard.HomeScore));
        label9.setText(Integer.toString(BaseballScoreboard.AwayScore));
        if(BaseballScoreboard.TopOfInning){
            label11.setText("▲" + BaseballScoreboard.Inning);
        }else{
            label11.setText("▼" + BaseballScoreboard.Inning);
        }
        label13.setText(Integer.toString(BaseballScoreboard.Balls));
        label15.setText(Integer.toString(BaseballScoreboard.Strikes));
        label17.setText(Integer.toString(BaseballScoreboard.Outs));
        label19.setText(Boolean.toString(BaseballScoreboard.OnFirst));
        label21.setText(Boolean.toString(BaseballScoreboard.OnSecond));
        label23.setText(Boolean.toString(BaseballScoreboard.OnThird));        
    }
    
    public void writeFile(){
        try{
            PrintWriter writer = new PrintWriter(BaseballScoreboard.FileName);
            writer.println("HomeTeamName,HomeScore,HomeColor,AwayTeamName,AwayScore,AwayColor,Inning,TopOrBottom,#ofBalls,#ofStrikes,#ofOuts,OutOrOuts,BasesOccupied");
            writer.println(csvString());
            writer.close();
        }catch (Exception f){

        } 
    }
    
    public void loadDefaults(){
        try{
            Scanner reader = new Scanner(new File("defaults.txt"));
            BaseballScoreboard.HomeTeamName = reader.next();
            homeColor = reader.nextInt();
            BaseballScoreboard.AwayTeamName = reader.next();
            awayColor = reader.nextInt();
            Boolean temp = reader.nextBoolean();
            BaseballScoreboard.FileName = reader.nextLine();
            BaseballScoreboard.FileName += reader.nextLine();
            
            getColorBars();
            
            if(temp){
                yesRad.setSelected(true);
            }else{
                noRad.setSelected(true);
            }
            
            field1.setText(BaseballScoreboard.HomeTeamName);
            field2.setText(BaseballScoreboard.AwayTeamName);
            if(homeColor >= -1 && homeColor < colors.length){
                box1.setSelectedIndex(homeColor);
            }else{
                box1.setSelectedIndex(-1);
            }
            if(awayColor >= -1 && awayColor < colors.length){
                box2.setSelectedIndex(awayColor);
            }else{
                box2.setSelectedIndex(-1);
            }  
        }catch (Exception f){
            writeDefaults("Home", "0", "Away", "1", true, "scoreboard.csv", true);
        }
    }
    
    public void writeDefaults(String home, String homeColor, String away, String awayColor, Boolean threeOuts, String saveLocation, Boolean loadDefault){
        try{
            PrintWriter writer = new PrintWriter("defaults.txt");
            writer.println(home);
            writer.println(homeColor);
            writer.println(away);
            writer.println(awayColor);
            writer.println(threeOuts);
            writer.println(saveLocation);
            writer.close();
            if(loadDefault){
                loadDefaults();
            }
            setDefaults = true;
        }catch (Exception f){
            
        }
    }
    
    public String csvString(){
        String toBeReturned;
        //HomeTeamName,HomeScore,HomeColor,AwayTeamName,AwayScore,AwayColor,Inning,TopOrBottom,#ofBalls,#ofStrikes,#ofOuts,OutOrOuts,BasesOccupied
        toBeReturned = BaseballScoreboard.HomeTeamName + "," + BaseballScoreboard.HomeScore + "," + BaseballScoreboard.FileLocation + "images\\colorBars\\" + box1.getSelectedItem() + ".png,";
        toBeReturned += BaseballScoreboard.AwayTeamName + "," + BaseballScoreboard.AwayScore + "," + BaseballScoreboard.FileLocation + "images\\colorBars\\" + box2.getSelectedItem() + ".png,";
        toBeReturned += BaseballScoreboard.Inning + ",";
        
        if(BaseballScoreboard.TopOfInning){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "topInning.png,";
        }else{
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "bottomInning.png,";
        }
        toBeReturned += BaseballScoreboard.Balls + ",";
        toBeReturned += BaseballScoreboard.Strikes + ",";
        toBeReturned += BaseballScoreboard.Outs + ",";
        
        if(BaseballScoreboard.Outs == 1){
            toBeReturned += "Out,";
        }else{
            toBeReturned += "Outs,";
        }
        
        if(BaseballScoreboard.OnFirst && BaseballScoreboard.OnSecond && BaseballScoreboard.OnThird){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "123.png";
        }else if(BaseballScoreboard.OnFirst == false && BaseballScoreboard.OnSecond && BaseballScoreboard.OnThird){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "x23.png";
        }else if(BaseballScoreboard.OnFirst && BaseballScoreboard.OnSecond == false && BaseballScoreboard.OnThird){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "1x3.png";
        }else if(BaseballScoreboard.OnFirst && BaseballScoreboard.OnSecond && BaseballScoreboard.OnThird == false){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "12x.png";
        }else if(BaseballScoreboard.OnFirst == false && BaseballScoreboard.OnSecond == false && BaseballScoreboard.OnThird){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "xx3.png";
        }else if(BaseballScoreboard.OnFirst == false && BaseballScoreboard.OnSecond && BaseballScoreboard.OnThird == false){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "x2x.png";
        }else if(BaseballScoreboard.OnFirst && BaseballScoreboard.OnSecond == false && BaseballScoreboard.OnThird == false){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "1xx.png";
        }else if(BaseballScoreboard.OnFirst == false && BaseballScoreboard.OnSecond == false && BaseballScoreboard.OnThird == false){
            toBeReturned += BaseballScoreboard.FileLocation + "images\\assets\\" + "xxx.png";
        }
        
        return toBeReturned;
    }
    
    public void getColorBars(){
        File temp = new File(BaseballScoreboard.FileName);
        BaseballScoreboard.FileLocation = temp.getAbsolutePath();
        BaseballScoreboard.FileLocation = BaseballScoreboard.FileLocation.substring(0, BaseballScoreboard.FileLocation.indexOf(BaseballScoreboard.FileName));
        
        File folder = new File(BaseballScoreboard.FileLocation + "images\\colorBars");
        File[] files = folder.listFiles();
        colors = new String[files.length];
        for(int z = 0; z < files.length; z++){
            colors[z] = files[z].getName().substring(0, files[z].getName().indexOf("."));
        }
        box1 = new JComboBox(colors);
        box2 = new JComboBox(colors);
    }
}
