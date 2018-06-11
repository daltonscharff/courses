public static void driver() {
    try {
        while (true) {
            KeyValueList kvl = decoder.getMsg();
            parseEmails(getNewEmails());
            ProcessMsg(kvl);
            Thread.sleep(1000);
        }
    } catch (Exception e) {
        e.printStackTrace();
        driver();
    }
}

private static ArrayList<Message> getNewEmails() throws MessagingException, IOException {
    ArrayList<Message> messages = new ArrayList<>();
    Properties properties = new Properties();
    properties.setProperty("mail.store.protocol", "imaps");
    Session session = Session.getDefaultInstance(properties, null);
    store = session.getStore("imaps");
    store.connect(SERVER_ADDR, USERNAME, PASSWORD);
    folder = (IMAPFolder) store.getFolder("inbox");
    if (!folder.isOpen()) {
        folder.open(Folder.READ_WRITE);
    }
    Message[] msgs = folder.getMessages();
    for (Message message : msgs) {
        if (!message.getFlags().contains(Flags.Flag.SEEN)){
            messages.add(message);
        }
    }
    folder.setFlags(msgs, new Flags(Flags.Flag.SEEN), true);
    System.out.println("Received " + messages.size() + " new messages.");
    return messages;
}

private static void sendEmail(String emailAddr, String subject, String msg) throws MessagingException{
    Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp-mail.outlook.com");
	props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new javax.mail.PasswordAuthentication(USERNAME, PASSWORD);
		}
	});

    Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress(USERNAME));
	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddr));
	message.setSubject(subject);
	message.setContent(msg, "text/html");
	Transport.send(message);
    System.out.println("Sent email to " + emailAddr + ".");
}

public static void parseEmails(ArrayList<Message> emailList) throws MessagingException, IOException {
    for (Message email : emailList) {
        String senderEmail = email.getFrom()[0].toString().substring(email.getFrom()[0].toString().indexOf("<") + 1, email.getFrom()[0].toString().length() - 1);  // strips from field to just email address
        String emailText = (String)((Multipart)email.getContent()).getBodyPart(0).getContent();     // gets body of email in text format
        Scanner reader = new Scanner(emailText);
        String line1 = reader.nextLine().trim();
        String line2 = "";
        if (reader.hasNextLine() && (line2 = reader.nextLine()).trim().length() > 0) {
            if (line2.charAt(0) == 'N' || line2.charAt(0) == 'n') {
                try {
                    String passcode = line1;
                    int n = Integer.parseInt(line2.substring(1));
                    int errorCode = requestReport(passcode, n);
                    switch (errorCode) {
                        case 0:
                            sendEmail(senderEmail, "Voting Report", report);
                            System.out.println("Voting report sent to " + senderEmail + ".");
                            break;
                        case 1:
                            sendEmail(senderEmail, "Error - Voting Report", "The tally table was never initialized.");
                            System.out.println("Tally table error sent to " + senderEmail + ".");
                            break;
                        case 2:
                            sendEmail(senderEmail, "Error - Voting Report", "The passcode sent was incorrect.");
                            System.out.println("Passcode error sent to " + senderEmail + ".");
                            break;
                    }
                } catch (Exception e) {

                }
            } else {
                try {
                    String passcode = line1;
                    ArrayList<Integer> candidateList = new ArrayList<>();
                    for (String c : line2.split(";")) {
                        candidateList.add(Integer.parseInt(c));
                    }
                    int errorCode = initTallyTable(passcode, candidateList);
                    switch (errorCode) {
                        case 0:
                            sendEmail(senderEmail, "Tally Table", "The tally table has been successfully initialized.");
                            System.out.println("Tally table initialization success sent to " + senderEmail + ".");
                            break;
                        case 1:
                            sendEmail(senderEmail, "Error - Tally Table", "The tally table was alread initialized.");
                            System.out.println("Tally table already initialized error sent to " + senderEmail + ".");
                            break;
                        case 2:
                            sendEmail(senderEmail, "Error - Tally Table", "The passcode sent was incorrect.");
                            System.out.println("Passcode error sent to " + senderEmail + ".");
                            break;
                    }
                } catch (Exception e) {

                }
            }
        } else {
            try {
                String voterEmailAddr = senderEmail;
                int candidateID = Integer.parseInt(line1);
                int errorCode = castVote(voterEmailAddr, candidateID);
                switch (errorCode) {
                    case 0:
                        sendEmail(senderEmail, "Cast Vote", "Your vote for candidate #" + candidateID + " has been received and recorded.");
                        System.out.println("Cast vote success sent to " + senderEmail + ".");
                        break;
                    case 1:
                        sendEmail(senderEmail, "Error - Cast Vote", "The tally table was never initialized.");
                        System.out.println("Tally table error sent to " + senderEmail + ".");
                        break;
                    case 2:
                        sendEmail(senderEmail, "Error - Cast Vote", "Candidate #" + candidateID + " does not exist.");
                        System.out.println("Invalid candidate ID error sent to " + senderEmail + ".");
                        break;
                    case 3:
                        sendEmail(senderEmail, "Error - Cast Vote", "A vote has already been received from " + voterEmailAddr + ".");
                        System.out.println("Duplicate vote error sent to " + senderEmail + ".");
                        break;
                }
            } catch (Exception e) {

            }
        }
    }
}

public static int initTallyTable(String passcode, ArrayList<Integer> candidateList) {
    if (tallyTableInitialized) {
        return 1;
    } else {
        if (!passcode.equals(validPasscode)) {
            return 2;
        } else {
            tallyTable = new HashMap<>();
            for (Integer i : candidateList) {
                tallyTable.put(i, 0);
            }
            tallyTableInitialized = true;
        }
    }
    return 0;
}

public static int castVote(String voterEmailAddr, int candidateID) {
    if (!tallyTableInitialized) {
        return 1;
    } else {
        if (!tallyTable.containsKey(candidateID)) {
            return 2;
        } else if (voterList.contains(voterEmailAddr)) {
            return 3;
        } else {
            tallyTable.put(candidateID, tallyTable.get(candidateID) + 1);
            voterList.add(voterEmailAddr);
        }
    }
    return 0;
}

public static int requestReport(String passcode, int n) {
    if (!tallyTableInitialized) {
        return 1;
    } else {
        if (!passcode.equals(validPasscode)) {
            return 2;
        } else {
            int max = -1;
            for (Integer votes : tallyTable.values()) {
                if (votes > max) {
                    max = votes;
                }
            }
            int count = 1;
            int altCount = 1;
            report = "<style>table{ border-collapse: collapse; } table,th,td{ border: 1px solid black; }</style>";
            report += "<table><tr><td>#</td><td>ID</td><td>#ofVotes</td></tr>";
            reportString = String.format("%3s. | %10s | %15s %n", "#", "ID", "#ofVotes");
            int oldMax = max;
            while (count <= n && max >= 0) {
                for (Integer key : tallyTable.keySet()) {
                    if (tallyTable.get(key) == max) {
                        if(oldMax == max) {
                        } else {
                            oldMax = max;
                            altCount++;
                        }
                        reportString +=String.format("%3d. | %10d | %15d %n", altCount, key, tallyTable.get(key));
                        report += String.format("<tr><td>%3d.</td><td>%10d</td><td>%10d</td></tr>", altCount, key, tallyTable.get(key));
                        count++;
                    }
                }
                max--;
            }
            report += "</table>";
        }
    }
    return 0;
}
