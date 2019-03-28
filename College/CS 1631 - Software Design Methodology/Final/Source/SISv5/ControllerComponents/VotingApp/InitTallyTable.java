ArrayList<Integer> candidateList = new ArrayList<>();
for (String c : kvList.getValue("Message").split(";")) {
    candidateList.add(Integer.parseInt(c));
}

int err2 = initTallyTable(validPasscode, candidateList);
switch (err2) {
    case 0:
        JOptionPane.showMessageDialog(null, "Tally table created successfully.");
        break;
    case 1:
        JOptionPane.showMessageDialog(null, "Tally table already initialized.");
        break;
}
