import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VotingGUI extends JFrame{

    JPanel mainPanel, inputPanel, buttonPanel, checkPanel, upperCheckPanel, midCheckPanel, lowerCheckPanel, controlPanel;
    JLabel emailLbl, passLbl, candidateIDLbl, customLbl;
    JTextField emailTF, passTF, candidateIDTF, customTF;
    JButton m701Btn, m702Btn, m703Btn, m704Btn, submitBtn, repeatBtn, clearBtn, exitBtn;
    JCheckBox m701cbo, m702cbo, m703cbo, m704cbo;

    boolean clicked, emailBln, passBln, candidateIDBln;
    String emailStr, passStr, candidateIDStr, customStr;

    public VotingGUI() throws IOException, InterruptedException{
        super("Voting Application");
        
//      startScript("start notepad");
        
        setLocation(200, 150);

        mainPanel = new JPanel();
        mainPanel.setLocation(0, 0);
        mainPanel.setPreferredSize(new Dimension(550, 650));
        mainPanel.setLayout(new GridLayout(2,2));
        mainPanel.setBackground(new Color(255, 255, 255));

        inputPanel = new JPanel();
        inputPanel.setLocation(0, 0);
        inputPanel.setSize(550, 20);
        inputPanel.setLayout(new GridLayout(8, 1));
        inputPanel.setBackground(new Color(167, 240, 197));

        buttonPanel = new JPanel();
        buttonPanel.setLocation(10, 200);
        buttonPanel.setSize(530, 400);
        buttonPanel.setLayout(new GridLayout(2,2));
        buttonPanel.setBackground(new Color(167, 240, 197));

        checkPanel = new JPanel();
        checkPanel.setLocation(10, 150);
        checkPanel.setSize(530, 200);
        checkPanel.setLayout(new GridLayout(3,1));
        checkPanel.setBackground(new Color(167, 240, 197));

        upperCheckPanel = new JPanel();
        upperCheckPanel.setLocation(10, 150);
        upperCheckPanel.setSize(530, 75);
        upperCheckPanel.setLayout(new GridLayout(1,2));
        upperCheckPanel.setBackground(new Color(167, 240, 197));

        midCheckPanel = new JPanel();
        midCheckPanel.setLocation(10, 150);
        midCheckPanel.setSize(530, 75);
        midCheckPanel.setLayout(new GridLayout(1,2));
        midCheckPanel.setBackground(new Color(167, 240, 197));

        lowerCheckPanel = new JPanel();
        lowerCheckPanel.setLocation(10, 150);
        lowerCheckPanel.setSize(530, 75);
        lowerCheckPanel.setLayout(new GridLayout(2,1));
        lowerCheckPanel.setBackground(new Color(167, 240, 197));

        controlPanel = new JPanel();
        controlPanel.setLocation(10, 150);
        controlPanel.setSize(530, 50);
        controlPanel.setLayout(new GridLayout(2,2));
        controlPanel.setBackground(new Color(167, 240, 197));

        emailLbl = new JLabel("<html>&nbsp;&nbsp;Enter email to sign in:</html>");
        emailLbl.setForeground(new Color(145, 68, 68));
        passLbl = new JLabel("<html>&nbsp;&nbsp;Enter pass code:</html>");
        passLbl.setForeground(new Color(145, 68, 68));
        candidateIDLbl = new JLabel("<html>&nbsp;&nbsp;Enter candidate ID:</html>");
        candidateIDLbl.setForeground(new Color(145, 68, 68));
        customLbl = new JLabel("<html>&nbsp;&nbsp;Enter custom Command or name of Batch File<br/>&nbsp;&nbsp;E.g. \"start notepad\" or \"batchFile.bat\":</html>");
        customLbl.setForeground(new Color(145, 68, 68));
        customLbl.setVisible(false);

        emailTF = new JTextField(25);
        emailTF.setPreferredSize(new Dimension(50, 80));
        emailTF.setLocation(10, 50);
        emailTF.setEnabled(true);
        emailTF.setVisible(true);
        emailTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        passTF = new JTextField(25);
        passTF.setPreferredSize(new Dimension(50, 80));
        passTF.setLocation(10, 50);
        passTF.setEnabled(true);
        passTF.setVisible(true);
        passTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        candidateIDTF = new JTextField(25);
        candidateIDTF.setPreferredSize(new Dimension(50, 80));
        candidateIDTF.setLocation(10, 50);
        candidateIDTF.setEnabled(true);
        candidateIDTF.setVisible(true);
        candidateIDTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        customTF = new JTextField(25);
        customTF.setPreferredSize(new Dimension(50, 80));
        customTF.setLocation(10, 50);
        customTF.setEnabled(true);
        customTF.setVisible(false);
        customTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        m701cbo = new JCheckBox("<html><div align='center'>701<br/>cast a Vote</div></html>");
        m702cbo = new JCheckBox("<html><div align='center'>702<br/>Request a Report</div></html>");
        m703cbo = new JCheckBox("<html><div align='center'>703<br/>Initialize Tally Table</div></html>");
        m704cbo = new JCheckBox("<html><div align='center'>704<br/>Custom Script</div></html>");
        
        m701cbo.setOpaque(false);
        m701cbo.setForeground(new Color(11, 44, 142));
        m702cbo.setOpaque(false);
        m702cbo.setForeground(new Color(11, 44, 142));
        m703cbo.setOpaque(false);
        m703cbo.setForeground(new Color(11, 44, 142));
        m704cbo.setOpaque(false);
        m704cbo.setForeground(new Color(11, 44, 142));

        m701Btn = new JButton("<html><div align='center' vertical-align='middle'>701<br/>Cast a Vote</div></html>");
        m701Btn.setToolTipText("CastVote with attributes VoterPhoneNo, CandidateID");
        m701Btn.setForeground(new Color(11, 44, 142));
        m701Btn.setBackground(new Color(80, 92, 182));
        m701Btn.setOpaque(false);
        m701Btn.setPreferredSize(new Dimension(100, 100));
        m701Btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    startApp();
                    m701cbo.setSelected(true);
                    m702cbo.setSelected(false);
                    m703cbo.setSelected(false);
                    m704cbo.setSelected(false);
                    submitBtn.doClick();
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                } catch (InterruptedException iEx) {
                    iEx.printStackTrace();
                }
            }
        });

        m702Btn = new JButton("<html><div align='center' vertical-align='middle'>702<br/>Request a Report</div></html>");
        m702Btn.setToolTipText("RequestReport with attributes Passcode,N");
        m702Btn.setForeground(new Color(11, 44, 142));
        m702Btn.setBackground(new Color(80, 92, 182));
        m702Btn.setOpaque(false);
        m702Btn.setPreferredSize(new Dimension(100, 100));
        m702Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m701cbo.setSelected(false);
                m702cbo.setSelected(true);
                m703cbo.setSelected(false);
                m704cbo.setSelected(false);
                submitBtn.doClick();
            }
        });

        m703Btn = new JButton("<html><div align='center' vertical-align='middle'>703<br/>Initialize Tally Table</div></html>");
        m703Btn.setToolTipText("Initialize TallyTable with attributes Passcode,CandidateList");
        m703Btn.setForeground(new Color(11, 44, 142));
        m703Btn.setBackground(new Color(80, 92, 182));
        m703Btn.setOpaque(false);
        m703Btn.setPreferredSize(new Dimension(100, 100));
        m703Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m701cbo.setSelected(false);
                m702cbo.setSelected(false);
                m703cbo.setSelected(true);
                m704cbo.setSelected(false);
                submitBtn.doClick();
            }
        });

        m704Btn = new JButton("<html><div align='center' vertical-align='middle'>704<br/>Enter Custom Script</div></html>");
        m704Btn.setPreferredSize(new Dimension(100, 100));
        m704Btn.setForeground(new Color(11, 44, 142));
        m704Btn.setBackground(new Color(80, 92, 182));
        m704Btn.setOpaque(false);
        m704Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m701cbo.setSelected(false);
                m702cbo.setSelected(false);
                m703cbo.setSelected(false);
                if(m704cbo.isSelected() && customTF.getText().length() >= 1) {
                    submitBtn.doClick();
                } else {
                    m704cbo.setSelected(false);
                    m704cbo.doClick();
                    customTF.requestFocusInWindow();
                }
            }
        });

        m704cbo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(m704cbo.isSelected()) {
                    customTF.setVisible(true);
                    customLbl.setVisible(true);
                    customStr = "";
                    customTF.setText("");
                } else {
                    customTF.setVisible(false);
                    customLbl.setVisible(false);
                    customStr = "";
                    customTF.setText("");
                }
            }
        });

        submitBtn = new JButton("<html><div align='center' vertical-align='middle'>Submit</div></html>\"");
        submitBtn.setPreferredSize(new Dimension(100, 100));
        submitBtn.setForeground(new Color(11, 44, 142));
        submitBtn.setBackground(new Color(80, 92, 182));
        submitBtn.setOpaque(false);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern VALID_EMAIL_ADDRESS_REGEX =
                        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailTF.getText());

                clicked = true;
                emailBln = true;
                passBln = true;
                candidateIDBln = true;

                while(!matcher.matches() && clicked) {
                    clicked = false;
                    emailBln = false;
                    JOptionPane.showMessageDialog(null, "\"" + emailTF.getText() + "\" is not a valid Email");
                    emailTF.requestFocusInWindow();
                    emailTF.setText("");
                }

                emailStr = emailTF.getText();

                clicked = true;

                while(passTF.getText().length() < 1 && clicked && emailBln) {
                    clicked = false;
                    passBln = false;
                    JOptionPane.showMessageDialog(null, "Pass code can not be blank");
                    passTF.requestFocusInWindow();
                    passTF.setText("");
                }

                passStr = passTF.getText();

                clicked = true;

                while(candidateIDTF.getText().length() < 1 && clicked && emailBln && passBln) {
                    clicked = false;
                    candidateIDBln = false;
                    JOptionPane.showMessageDialog(null, "Candidate ID can not be blank");
                    candidateIDTF.requestFocusInWindow();
                    candidateIDTF.setText("");
                }

                candidateIDStr = candidateIDTF.getText();

                if(emailBln && passBln && candidateIDBln) {
                    if(m701cbo.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Message 701 has been sent");
                    }

                    if(m702cbo.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Message 702 has been sent");
                    }

                    if(m703cbo.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Message 703 has been sent");
                    }

                    if(m704cbo.isSelected()) {
                        customStr = customTF.getText();
                        if(customStr.length() > 0) {
                            try {
                                startScript(customStr);
                            } catch (IOException ex) {
                                Logger.getLogger(VotingGUI.class.getName()).log(Level.SEVERE, ex.toString(), ex);
                                JOptionPane.showMessageDialog(null, ex.toString());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(VotingGUI.class.getName()).log(Level.SEVERE, ex.toString(), ex);
                                JOptionPane.showMessageDialog(null, ex.toString());
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Message 704 has been sent");
                    }
                }
            }
        });

        repeatBtn = new JButton("<html><div align='center' vertical-align='middle'>New Request</div></html>\"");
        repeatBtn.setPreferredSize(new Dimension(100, 100));
        repeatBtn.setForeground(new Color(11, 44, 142));
        repeatBtn.setBackground(new Color(80, 92, 182));
        repeatBtn.setOpaque(false);
        repeatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customTF.setText("");
                customTF.setVisible(false);
                customLbl.setVisible(false);
                m701cbo.setSelected(false);
                m702cbo.setSelected(false);
                m703cbo.setSelected(false);
                m704cbo.setSelected(false);
            }
        });

        clearBtn = new JButton("<html><div align='center'>Clear</div></html>\"");
        clearBtn.setPreferredSize(new Dimension(100, 100));
        clearBtn.setForeground(new Color(11, 44, 142));
        clearBtn.setBackground(new Color(80, 92, 182));
        clearBtn.setOpaque(false);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emailTF.setText("");
                passTF.setText("");
                candidateIDTF.setText("");
                customTF.setText("");
                customTF.setVisible(false);
                customLbl.setVisible(false);
                m701cbo.setSelected(false);
                m702cbo.setSelected(false);
                m703cbo.setSelected(false);
                m704cbo.setSelected(false);
                emailTF.requestFocusInWindow();
                emailStr = "";
                passStr = "";
                candidateIDStr = "";
                customStr = "";
            }
        });

        exitBtn = new JButton("<html><div align='center' vertical-align='middle'>Exit</div></html>\"");
        exitBtn.setSize(250, 150);
        exitBtn.setForeground(new Color(11, 44, 142));
        exitBtn.setBackground(new Color(80, 92, 182));
        exitBtn.setOpaque(false);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        inputPanel.add(emailLbl);
        inputPanel.add(emailTF);

        inputPanel.add(new JLabel());

        inputPanel.add(passLbl);
        inputPanel.add(passTF);

        inputPanel.add(new JLabel());

        inputPanel.add(candidateIDLbl);
        inputPanel.add(candidateIDTF);

        buttonPanel.add(m701Btn);
        buttonPanel.add(m702Btn);
        buttonPanel.add(m703Btn);
        buttonPanel.add(m704Btn);

        upperCheckPanel.add(m701cbo);
        upperCheckPanel.add(m702cbo);
        midCheckPanel.add(m703cbo);
        midCheckPanel.add(m704cbo);
        lowerCheckPanel.add(customLbl);
        lowerCheckPanel.add(customTF);

        checkPanel.add(upperCheckPanel);
        checkPanel.add(midCheckPanel);
        checkPanel.add(lowerCheckPanel);

        controlPanel.add(submitBtn);
        controlPanel.add(repeatBtn);
        controlPanel.add(clearBtn);
        controlPanel.add(exitBtn);

        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(checkPanel);
        mainPanel.add(controlPanel);
        add(mainPanel);
//         setUndecorated(true);
        setSize(550, 650);
        setBackground(new Color (225, 225, 225));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void startApp() throws IOException, InterruptedException {
        String cmdMac = "ls -al";
        String cmdWin = "dir";
        String batchFile = "batchFile.bat";
        Runtime run;
        Process pr;
        BufferedReader buf;
        ProcessBuilder pb;
        File dir;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.charAt(0) == 'm') {
            run = Runtime.getRuntime();
//          pr = run.exec(batchFile);
            pr = run.exec(cmdMac);
            pr.waitFor();
            buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } else if (osName.charAt(0) == 'w') {
//          pb = new ProcessBuilder("cmd.exe", "/c", batchFile);
            pb = new ProcessBuilder("cmd.exe", "/c", cmdWin);
            pb.redirectErrorStream(true);
            pr = pb.start();
            pr.waitFor();
            buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    
    private void startScript(String script) throws IOException, InterruptedException {
        Runtime run;
        Process pr;
        BufferedReader buf;
        ProcessBuilder pb;
        File dir;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.charAt(0) == 'm') {
            run = Runtime.getRuntime();
//          pr = run.exec(batchFile);
            pr = run.exec(script);
            pr.waitFor();
            buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } else if (osName.charAt(0) == 'w') {
//          pb = new ProcessBuilder("cmd.exe", "/c", batchFile);
            pb = new ProcessBuilder("cmd.exe", "/c", script);
            pb.redirectErrorStream(true);
            pr = pb.start();
            pr.waitFor();
            buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException{
        new VotingGUI();
    }
}
