import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.jdom2.*;

public class Remote {
    static final String validPasscode = "1234";
    static boolean serverIsRunning = false;
    static boolean votingAppIsRunning = false;
    static boolean tallyTableIsInitialized = false;
    static MsgEncoder encoder;
	static MsgDecoder decoder;
    static JButton runServerButton, runVotingAppButton, initTallyTableButton, requestReportButton, quitVotingAppButton, customScriptFileButton, castVoteButton;
    static JTextField adminPasscodeTextField, candidateListTextField, numberOfWinnersTextField, customScriptFileTextField, castVoteIdTextField;
    static JFrame guiFrame;
    static Process serverProcess, votingAppProcess;

    public static void main(String[] args) {
        JFrame guiFrame = initGUI();
        guiFrame.setVisible(true);

    }

    public static JFrame initGUI() {
        guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Voting App Remote");
        guiFrame.setSize(640,460);

        JPanel inputPanel = new JPanel();
        JLabel adminPasscodeLabel = new JLabel("Admin Passcode:");
        adminPasscodeTextField = new JTextField();
        JLabel candidateListLabel = new JLabel("Candidate List:");
        candidateListTextField = new JTextField();
        JLabel numberOfWinnersLabel = new JLabel("Number of Winners:");
        numberOfWinnersTextField = new JTextField();
        JLabel castVoteIdLabel = new JLabel("Cast Vote for ID#:");
        castVoteIdTextField = new JTextField();
        inputPanel.setLayout(new GridLayout(4,2,20,5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0,0,40,0));
        inputPanel.add(adminPasscodeLabel);
        inputPanel.add(adminPasscodeTextField);
        inputPanel.add(candidateListLabel);
        inputPanel.add(candidateListTextField);
        inputPanel.add(numberOfWinnersLabel);
        inputPanel.add(numberOfWinnersTextField);
        inputPanel.add(castVoteIdLabel);
        inputPanel.add(castVoteIdTextField);

        JPanel buttonPanel = new JPanel();
        runServerButton = new JButton("Run Server");
        runVotingAppButton = new JButton("Run Voting App");
        initTallyTableButton = new JButton("Initialize Tally Table");
        requestReportButton = new JButton("Request Report");
        quitVotingAppButton = new JButton("Quit Voting App");
        castVoteButton = new JButton("Cast Vote");
        buttonPanel.setLayout(new GridLayout(6,1,5,5));
        buttonPanel.add(runServerButton);
        buttonPanel.add(runVotingAppButton);
        buttonPanel.add(initTallyTableButton);
        buttonPanel.add(castVoteButton);
        buttonPanel.add(requestReportButton);
        buttonPanel.add(quitVotingAppButton);

        JPanel customPanel = new JPanel();
        JLabel customScriptFileLabel = new JLabel("Custom Script File:");
        customScriptFileTextField = new JTextField();
        customScriptFileButton = new JButton("Run Custom Script");
        JLabel blankCustomPanelLabel = new JLabel();
        customPanel.setLayout(new GridLayout(4,1,5,5));
        customPanel.add(customScriptFileLabel);
        customPanel.add(customScriptFileTextField);
        customPanel.add(customScriptFileButton);
        customPanel.add(blankCustomPanelLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2,20,5));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(customPanel);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(2,1,5,0));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        containerPanel.add(inputPanel);
        containerPanel.add(bottomPanel);

        guiFrame.add(containerPanel);

        addListeners();
        toggleButtons();
        return guiFrame;
    }

    public static void addListeners() {
        guiFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (votingAppProcess != null) {
                    try{
                        sendMessage("QuitApp", "");
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                } if (serverProcess != null) {
                    System.out.println(serverProcess.isAlive());
                    serverProcess.destroy();
                }
            }
        });

        runServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    serverProcess = Runtime.getRuntime().exec("cmd /c start \"\" runserver.bat", null, new File("../Scripts"));
                    Thread.sleep(500);
                    connect();
                    serverIsRunning = true;
                    toggleButtons();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        runVotingAppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!adminPasscodeTextField.getText().equals(validPasscode)) {
                        JOptionPane.showMessageDialog(null, "The entered admin passcode is incorrect.");
                        return;
                    }
                    Runtime.getRuntime().exec("cmd /c start runInitializer.bat", null, new File("../Scripts"));
                    Thread.sleep(1000);
                    votingAppProcess = Runtime.getRuntime().exec("cmd /c start runVotingApp.bat", null, new File("../Scripts/runIndividualComp"));
                    Thread.sleep(5000);
                    sendMessage("StartApp","");
                    votingAppIsRunning = true;
                    toggleButtons();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        initTallyTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!adminPasscodeTextField.getText().equals(validPasscode)) {
                        JOptionPane.showMessageDialog(null, "The entered admin passcode is incorrect.");
                        return;
                    }
                    if (candidateListTextField.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid candidate list.");
                        return;
                    }
                    sendMessage("InitTallyTable", candidateListTextField.getText());
                    tallyTableIsInitialized = true;
                    toggleButtons();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        castVoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (castVoteIdTextField.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid Candidate ID.");
                        return;
                    }
                    sendMessage("CastVote", castVoteIdTextField.getText());
                    toggleButtons();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        requestReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!adminPasscodeTextField.getText().equals(validPasscode)) {
                        JOptionPane.showMessageDialog(null, "The entered admin passcode is incorrect.");
                        return;
                    }
                    if (numberOfWinnersTextField.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a number of winners.");
                        return;
                    }
                    sendMessage("RequestReport", numberOfWinnersTextField.getText());

                    toggleButtons();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        quitVotingAppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    votingAppIsRunning = false;
                    tallyTableIsInitialized = false;
                    sendMessage("QuitApp", "");
                    toggleButtons();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        customScriptFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fileString = customScriptFileTextField.getText().trim();
                    File file = new File("../Scripts/" + fileString);
                    if (!file.exists() || file.isDirectory()) {
                        JOptionPane.showMessageDialog(null, "The entered file was not found. Please make sure the file exists in the 'Scripts' folder.");
                        return;
                    }

                    Scanner reader = new Scanner(file);
                    String line = "";
                    do {
                        line = reader.nextLine();
                        parseXML(new File("../Messages/" + line));
                    } while(reader.hasNextLine());

                    toggleButtons();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void connect() throws UnknownHostException, IOException {
        encoder = new MsgEncoder(new Socket("127.0.0.1", 53217).getOutputStream());
        decoder = new MsgDecoder(new Socket("127.0.0.1", 53217).getInputStream());

        KeyValueList conn = new KeyValueList();

        conn.putPair("Scope", "SIS");
        conn.putPair("MessageType", "Connect");
        conn.putPair("IncomingMessages", "IN\tConfirm|Setting:Kill||Alert:QuitApp|Alert:InitTallyTable|Alert:RequestReport");
        conn.putPair("OutgoingMessages", "OUT\t Connect|Emergency");
        conn.putPair("Role", "Controller");
        conn.putPair("Name", "Remote");
        encoder.sendMsg(conn);
    }

    public static void toggleButtons() {
        if (!serverIsRunning) {
            runServerButton.setEnabled(true);
            runVotingAppButton.setEnabled(false);
            initTallyTableButton.setEnabled(false);
            castVoteButton.setEnabled(false);
            requestReportButton.setEnabled(false);
            quitVotingAppButton.setEnabled(false);
            customScriptFileButton.setEnabled(false);
        } else if (!votingAppIsRunning) {
            runServerButton.setEnabled(true);
            runVotingAppButton.setEnabled(true);
            initTallyTableButton.setEnabled(false);
            castVoteButton.setEnabled(false);
            requestReportButton.setEnabled(false);
            quitVotingAppButton.setEnabled(false);
            customScriptFileButton.setEnabled(true);
        } else if (!tallyTableIsInitialized) {
            runServerButton.setEnabled(true);
            runVotingAppButton.setEnabled(true);
            initTallyTableButton.setEnabled(true);
            castVoteButton.setEnabled(false);
            requestReportButton.setEnabled(false);
            quitVotingAppButton.setEnabled(true);
            customScriptFileButton.setEnabled(true);
        } else {
            runServerButton.setEnabled(true);
            runVotingAppButton.setEnabled(true);
            initTallyTableButton.setEnabled(true);
            castVoteButton.setEnabled(true);
            requestReportButton.setEnabled(true);
            quitVotingAppButton.setEnabled(true);
            customScriptFileButton.setEnabled(true);
        }
    }

    public static void sendMessage(String purpose, String message) throws IOException {
        KeyValueList kvl = new KeyValueList();
        kvl.putPair("Scope", "SIS");
        kvl.putPair("MessageType", "Alert");
        kvl.putPair("Sender", "GUI");
        kvl.putPair("Purpose", purpose);
        kvl.putPair("Message", message);
        encoder.sendMsg(kvl);
    }

    public static void parseXML(File xmlFile) {
        try {
            KeyValueList kvl = new KeyValueList();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element elem = (org.w3c.dom.Element) nNode;
                    String key = elem.getElementsByTagName("Key").item(0).getTextContent();
                    String value = elem.getElementsByTagName("Value").item(0).getTextContent();
                    kvl.putPair(key, value);
                }
            }
            encoder.sendMsg(kvl);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
