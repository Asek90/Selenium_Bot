package mail;

import com.google.common.base.Strings;
import com.sun.mail.imap.SortTerm;

import java.io.IOException;
import java.util.*;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

public class MailExctractor {

    private final static String mailPassword = System.getProperty("mailPassword");

        private static Session createSession(

            final String host,
            final String username,
            final String password) {
        // create properties
//        final String mailPassword = System.getProperty("mailPassword");
        Properties properties = new Properties();
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.starttls.enable", "true");
        properties.put("mail.imap.ssl.trust", host);
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");


        final Session emailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return emailSession;
    }

    public static String getMailBodyByTitle(String title) {

//        final String mailPassword = System.getProperty("mailPassword");
        try {
            // final String host = "imap.poczta.onet.pl"; <-- tylko do odczytu nowych maili (nie widzi odczytanych)
            final String host = "pop3.poczta.onet.pl";
            final String user = "johndoe-do-testowania@op.pl";

            if(Strings.isNullOrEmpty(mailPassword) || Strings.isNullOrEmpty(user)){
                throw new IllegalArgumentException("password or login is empty");
            }

            final Session emailSession = createSession(host, user, mailPassword);
            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, mailPassword);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            List<Message> messages;
            // retrieve the messages from the folder in an array and print it
            if (Strings.isNullOrEmpty(title)) {
                messages = Arrays.asList(inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false)));
                System.out.println("messages.length---" + messages.size());
            } else {
                SearchTerm searchTerm = new SubjectTerm(title);
                messages = Arrays.asList(inbox.search(searchTerm));
            }
            Collections.reverse(messages);
            for (int i = 0, n = messages.size(); i < n; i++) {
                Message message = messages.get(i);
                message.setFlag(Flags.Flag.SEEN, true);
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                final Object content = message.getContent();
                if (content instanceof MimeMultipart) {
                    return getMailBody((MimeMultipart) content);
                }
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            throw new FailedMailExctractionExcepction(e);
        } finally {

        }
        throw new FailedMailExctractionExcepction();
    }

    public static String getLastEmailBody() {
        return getMailBodyByTitle(null);
    }

    public static String getMailBody(final MimeMultipart multipart) throws MessagingException, IOException {
        for (int partIndex = 0; partIndex < multipart.getCount(); partIndex++) {

            final BodyPart bodyPart = multipart.getBodyPart(partIndex);

            if (bodyPart.getContentType().contains("html") || bodyPart.getContentType().contains("plain")) {
                return (String) bodyPart.getContent();
            }

            if (bodyPart.getContent() instanceof MimeMultipart) {
                return getMailBody((MimeMultipart) bodyPart.getContent());
            }
        }
        return null;
    }

}
