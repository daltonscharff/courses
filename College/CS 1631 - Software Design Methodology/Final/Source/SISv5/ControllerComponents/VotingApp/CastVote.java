String message = "";
try {
    message = kvList.getValue("Message").trim();
} catch (Exception ex) {

}

Random rand = new Random();
String voterEmailAddr = Integer.toString(rand.nextInt(100000));
int candidateID = -1;
int count = 0;
do {
    candidateID = rand.nextInt(100);
    count++;
    if (count > 100) {
        break;
    }
} while (!tallyTable.containsKey(candidateID));

if (message.length() != 0) {
    candidateID = Integer.parseInt(message);
}


int err1 = castVote(voterEmailAddr, candidateID);
switch (err1) {
    case 0:
        JOptionPane.showMessageDialog(null, "Vote cast successfully.");
        break;
    case 1:
        JOptionPane.showMessageDialog(null, "The tally table was never initialized.");
        break;
}
