import javax.mail.*;
import java.util.*;
import java.util.Properties;

class ReadEmail {
    public static final String USERNAME = "vigneshbaskaran2709@gmail.com";

    public static final String PASSWORD = "rvfuaglrqrbxokax";

    public static void func() throws Exception {

        Properties props = new Properties();
        props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.pop3.socketFactory.fallback", "false");
        props.put("mail.pop3.socketFactory.port", "995");
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.host", "pop.gmail.com");
        props.put("mail.pop3.user", ReadEmail.USERNAME);
        props.put("mail.store.protocol", "pop3");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ReadEmail.USERNAME, ReadEmail.PASSWORD);
            }
        };

        
        Session session = Session.getDefaultInstance(props, auth);

        Store store = session.getStore("pop3");
        store.connect("pop.gmail.com", ReadEmail.USERNAME, ReadEmail.PASSWORD);


        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        
        Scanner inp = new Scanner(System.in);
        int count = 0;
        Message[] messages = inbox.getMessages();
        
        for (Message message : messages) {
            if(count < 4)
            {
                count++;
                continue;
            }
            message.writeTo(System.out);
            System.out.print("\nDo you want to continue ?? ");
            String st = inp.nextLine();
            
            if (st.equalsIgnoreCase("no")) 
            	{
            		System.out.println("\n\nINBOX MESSAGES READ SUCCESSFULLY !!\n");
            		break;
            	}
        }

        // 7. Close folder and close store.
        inbox.close(false);
        store.close();
    }
}

public class POPImplementation{
	public static void main(String[] args) throws Exception {
	
		System.out.println("Welcome "+ReadEmail.USERNAME.split("@")[0]);
		
	System.out.println("\nReceiving Inbox Messages...\n");
		ReadEmail.func();
	}
}
