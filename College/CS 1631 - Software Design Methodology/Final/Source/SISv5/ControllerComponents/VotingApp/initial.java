private static final String USERNAME = "PittPosterCompetition@outlook.com";
private static final String PASSWORD = "VirginiaButter";
private static final String SERVER_ADDR = "imap-mail.outlook.com";

private static String validPasscode = "1234";
private static boolean votingIsOpen = false;
private static IMAPFolder folder = null;
private static Store store = null;
private static ArrayList<String> voterList = new ArrayList<>();
private static HashMap<Integer, Integer> tallyTable = new HashMap<>();
private static String report = null;
private static String reportString = null;
private static boolean tallyTableInitialized = false;
