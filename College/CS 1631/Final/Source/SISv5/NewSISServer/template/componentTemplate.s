import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.imap.*;

import javax.swing.*;

public class Create!name! {

	// socket for connection to SISServer
	private static Socket universal;
	private static int port = 53217;
	// message writer
	private static MsgEncoder encoder;
	// message reader
	private static MsgDecoder decoder;

	// scope of this component
	private static final String SCOPE = "!scope!";
	// name of this component
	private static final String NAME = "!name!";
	// messages types that can be handled by this component
	private static final List<String> TYPES = new ArrayList<String>(
			Arrays.asList(new String[] { "Setting", "Alert", "Confirm" }));

	// summary for all incoming / outgoing messages
	private static final String incomingMessages = "IN\tConfirm|Setting:Kill|!incomingMessages!";
	private static final String outgoingMessages = "OUT\t Connect|Emergency";

	// shared by all kinds of emergencies that can be generated by this component
	private static KeyValueList emergency = new KeyValueList();

	!initialCode!

	/*
	 * Main program
	 */
	public static void main(String[] args) {
		while (true) {
			try {
				// try to establish a connection to SISServer
				universal = connect();

				// bind the message reader to inputstream of the socket
				decoder = new MsgDecoder(universal.getInputStream());
				// bind the message writer to outputstream of the socket
				encoder = new MsgEncoder(universal.getOutputStream());

				/*
				 * construct a Connect message to establish the connection
				 */
				KeyValueList conn = new KeyValueList();
				conn.putPair("Scope", SCOPE);
				conn.putPair("MessageType", "Connect");
				conn.putPair("IncomingMessages", incomingMessages);
                conn.putPair("OutgoingMessages", outgoingMessages);
				conn.putPair("Role", "Controller");
				conn.putPair("Name", NAME);
				encoder.sendMsg(conn);

				initRecord();

				// KeyValueList for inward messages, see KeyValueList for
				// details
				KeyValueList kvList;

				while (true) {
					// attempt to read and decode a message, see MsgDecoder for
					// details
					kvList = decoder.getMsg();

					// process that message
					ProcessMsg(kvList);
				}

			} catch (Exception e) {
				// if anything goes wrong, try to re-establish the connection
				try {
					// wait for 1 second to retry
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
				}
				System.out.println("Try to reconnect");
				try {
					universal = connect();
				} catch (IOException e1) {
				}
			}
		}
	}

	/*
	 * used for connect(reconnect) to SISServer
	 */
	static Socket connect() throws IOException {
		Socket socket = new Socket("127.0.0.1", port);
		return socket;
	}

	private static void initRecord() {

		emergency.putPair("Scope", SCOPE);
		emergency.putPair("MessageType", "Emergency");
		emergency.putPair("Sender", NAME);

		// Receiver may be different for each message, so it doesn't make sense
		// to set here
		// alert.putPair("Receiver", "RECEIVER");
	}

	/*
	 * process a certain message, execute corresponding actions
	 */
	static void ProcessMsg(KeyValueList kvList) throws IOException {

		String scope = kvList.getValue("Scope");

		String broadcast = kvList.getValue("Broadcast");
		String direction = kvList.getValue("Direction");

		if(broadcast!=null&&broadcast.equals("True")){

			if(direction!=null&&direction.equals("Up")){
				if(!scope.startsWith(SCOPE)){
					return;
				}
			}else if(direction!=null&&direction.equals("Down")){
				if(!SCOPE.startsWith(scope)){
					return;
				}
			}
		}else{
			if(!SCOPE.equals(scope)){
				return;
			}
		}

		String messageType = kvList.getValue("MessageType");
		if(!TYPES.contains(messageType)){
			return;
		}

		String sender = kvList.getValue("Sender");

		String receiver = kvList.getValue("Receiver");

		String purpose = kvList.getValue("Purpose");

		switch (messageType) {
		case "Alert":
			switch (sender) {
			!senderCases!
			}
			break;
		case "Confirm":
			System.out.println("Connect to SISServer successful.");
			break;
		case "Setting":
			if (receiver.equals(NAME)) {
				switch (purpose) {

				case "Kill":
					System.exit(0);
					break;
				}
			}
			break;
		}
	}


	!helperCode!
}

!helperClassCode!
