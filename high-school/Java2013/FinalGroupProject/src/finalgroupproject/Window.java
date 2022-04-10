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
import java.io.*;
/**
 *
 * 
 */
public class Window extends JFrame{
    JMenuBar menuBar                = new JMenuBar();
    JMenu files                     = new JMenu("File");
    JMenuItem newGame               = new JMenuItem("New Game");
    JMenuItem credits               = new JMenuItem("Credits");
    JMenuItem close                 = new JMenuItem("Close");
    JSlider red                     = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
    JSlider green                   = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
    JSlider blue                    = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
    JLabel turn                     = new JLabel("Turn:");
    JLabel xOrO                     = new JLabel("Bitch tits");
    JLabel quest                    = new JLabel("Question:");
    JTextArea  questT               = new JTextArea("[Insert Question Here]");
    ButtonGroup radios              = new ButtonGroup();
    static JRadioButton a           = new JRadioButton("A");
    static JRadioButton b           = new JRadioButton("B");
    static JRadioButton c           = new JRadioButton("C");
    static JRadioButton d           = new JRadioButton("D");
    JLabel ansA                     = new JLabel("[Insert Question]");
    JLabel ansB                     = new JLabel("[Insert Question]");
    JLabel ansC                     = new JLabel("[Insert Question]");
    JLabel ansD                     = new JLabel("[Insert Question]");
    JLabel re                       = new JLabel("R");
    JLabel gr                       = new JLabel("G");
    JLabel bl                       = new JLabel("B");
    JLabel blank182                 = new JLabel("");// Keeps shit from getting fucked.
    JButton submit                  = new JButton("Submit");
    JSeparator s1                   = new JSeparator(JSeparator.HORIZONTAL);
    JSeparator s2                   = new JSeparator(JSeparator.HORIZONTAL);
    JSeparator s3                   = new JSeparator(JSeparator.VERTICAL);
    JSeparator s4                   = new JSeparator(JSeparator.VERTICAL);    
    Color co                        = new Color(red.getValue(), green.getValue(), blue.getValue());
    Font ravie                      = new Font("Ravie", Font.PLAIN, 60);
    Font courier                    = new Font("Courier", Font.BOLD, 80);
    
    
//    static ArrayList<Square> s = new ArrayList<>();
    
    public Window(){
        
//        File file = new File("BASIC1Prac");
//        try{
//            Scanner reader = new Scanner(file);
//            while (reader.hasNext()){
//                String line = reader.nextLine();
//                String q1 = piece(line);
//                String a1 = piece(line);
//                String a2 = piece(line);
//                String a3 = piece(line);
//                String a4 = piece(line);
//                String a5 = piece(line);
//                char ga = a5.charAt(0);
//                iter = 0;
//                Question eee = new Question(q1, a1, a2, a3, a4, ga);
//                q.add(eee);
//            }
//        }catch(FileNotFoundException e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
//        while (s.size() < 10){
//            int yy = gen.nextInt(q.size());
//            if (Question.goodToGo(yy)){
//                Square squar = new Square(q.get(yy));
//                s.add(squar);
//            }
//        }
    
        setJMenuBar(menuBar);
        menuBar.add(files);
        files.add(newGame);
        files.add(credits);
        files.add(close);
        add(red);
        add(green);
        add(blue);
        add(turn);
        add(xOrO);
        add(quest);
        add(questT);
        radios.add(a);
        radios.add(b);
        radios.add(c);
        radios.add(d);
        add(a);
        add(b);
        add(c);
        add(d);
        add(ansA);
        add(ansB);
        add(ansC);
        add(ansD);
        add(submit);
        add(re);
        add(gr);
        add(bl);
        add(s1);
        add(s2);
        add(s3);
        add(s4);
//        add(s.get(0));
//        add(s.get(1));
//        add(s.get(2));
//        add(s.get(3));
//        add(s.get(4));
//        add(s.get(5));
//        add(s.get(6));
//        add(s.get(7));
//        add(s.get(8));
        add(blank182);//Keep this last
        
        xOrO.setFont(courier);
        
        turn.setBounds(400, 10, 100, 100);
        xOrO.setBounds(435, 10, 100, 100);
        quest.setBounds(400, 160, 100, 20);
        questT.setBounds(400, 180, 200, 100);
        a.setBounds(400, 280, 40, 15);
        b.setBounds(400, 300, 40, 15);
        c.setBounds(400, 320, 40, 15);
        d.setBounds(400, 340, 40, 15);
        ansA.setBounds(440, 280, 200, 15);
        ansB.setBounds(440, 300, 200, 15);
        ansC.setBounds(440, 320, 200, 15);
        ansD.setBounds(440, 340, 200, 15);
        red.setBounds(60, 300, 255, 20);
        green.setBounds(60, 330, 255, 20);
        blue.setBounds(60, 360, 255, 20);
        submit.setBounds(400, 360, 200, 30);
        re.setBounds(40, 297, 20, 20);
        gr.setBounds(40, 327, 20, 20);
        bl.setBounds(40, 357, 20, 20);
        s1.setBounds(40, 100, 280, 5);
        s2.setBounds(40, 200, 280, 5);
        s3.setBounds(130, 20, 5, 260);
        s4.setBounds(230, 20, 5, 260);
//        s.get(0).setBounds(40, 20, 80, 80);
//        s.get(1).setBounds(140, 20, 80, 80);
//        s.get(2).setBounds(240, 20, 80, 80);
//        s.get(3).setBounds(40, 120, 80, 80);
//        s.get(4).setBounds(140, 120, 80, 80);
//        s.get(5).setBounds(240, 120, 80, 80);
//        s.get(6).setBounds(40, 220, 80, 80);
//        s.get(7).setBounds(140, 220, 80, 80);
//        s.get(8).setBounds(240, 220, 80, 80);
        
        questT.setBackground(null);
        questT.setEditable(false);
        questT.setBorder(null);
        questT.setColumns(5);
        questT.setLineWrap(true);
        questT.setWrapStyleWord(true);
        
        credits.addActionListener(new CreditsListener());
        close.addActionListener(new CloseListener());
        
        Random gen = new Random();
        int temp = gen.nextInt(2);
        if (temp == 0){
            xOrO.setText("O");
        }else if (temp == 1){
            xOrO.setText("X");
        }
        
    }
    
    private class CreditsListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JTextArea credits = new JTextArea("Created By: WangMan, SourMilkInABagWhoFeelsSunlightInHisPores, DwhatDscharff, \n"
                    + "                      TinyYimms, TwoSecondFinish, Ctrl-Alt-House, & DowntownGageBrown");
            add(credits);
            credits.setBounds(5,392,630,80);
            credits.setBackground(null);
            credits.setEditable(false);
            credits.setBorder(null);
            credits.setColumns(5);
            credits.setLineWrap(true);
            credits.setWrapStyleWord(true);
            add(blank182);
        }
    }
    
    private class CloseListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
}
