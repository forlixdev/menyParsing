package testJava;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestEmail {

	private static final Logger log = LogManager.getLogger(TestFiles.class.getName());

	public static String otpRetrieve(String emailAddress, String password, String imapHost, String imapPort, 
			                         String sender, String subjectPattern, String textPattern) {

		//String email_id = "hermionebot@gmail.com";
		//String password = "donnerundblitzen";

//		Properties properties = new Properties();
//		properties.put("mail.store.protocol", "imaps");
//		properties.put("mail.imaps.host", "imap.gmail.com");
//		properties.put("mail.imaps.port", "993");
//		properties.put("mail.imaps.timeout", "10000");

		Properties properties = new Properties();
		properties.put("mail.store.protocol", "imaps");
		properties.put("mail.imaps.host", imapHost);
		properties.put("mail.imaps.port", imapPort);
		properties.put("mail.imaps.timeout", "10000");
		
	
		String content = null;

		try {
			boolean res = false;
			int waitTime = 1000;
			int retries = 10;
			int counter = 0;
			while (!res && counter < retries) {
				
				Session session = Session.getDefaultInstance(properties, null);
				Store store = session.getStore("imaps");
				log.debug("Connection initiated");

				// Trying to connect IMAP server
				store.connect(emailAddress, password);
				log.debug("Connection is ready");
				
				// Get inbox folder
				Folder inbox = store.getFolder("inbox");
				inbox.open(Folder.READ_ONLY);
				int messageCount = inbox.getMessageCount();
				
				for (int i = 0; i < 10; i++) {
					Message message = inbox.getMessage(messageCount - i);
					String from = message.getFrom()[0].toString();
					
					if (from.equals(sender) && message.getSubject().equals(subjectPattern)) {
						content = message.getContent().toString();
						log.debug("found message with content {}", content);
						res = true;
						break;
						
					}
				}
				if (!res) {
					try {
						Thread.sleep(waitTime);
						if (counter - retries != 0)
							log.debug("not found. Waiting for {} ms for other {} times before fetching new emails",
									waitTime, retries - counter);
					} catch (Exception e) {
						log.error(e);
					}
				} else {
					break;
				}
				counter += 1;
				inbox.close(true);
				store.close();
			}
			return content;
		} catch (Exception e) {
			e.printStackTrace();
			return content;
		}
	}

	public static void main(String[] args) throws Exception {
	
		String pippo= otpRetrieve("hermionebot@gmail.com","donnerundblitzen","imap.gmail.com","993","testing_signrest@signicat.com","AAAAAHHHH",null);
		System.out.println(pippo);
		
	}

}
