package mail;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {

    private final static String DOCUMENT_LINK_TITLE_SIGN = "Twojego podpisu na Platformie Autenti";
    private final static String DOCUMENT_LINK_TITLE = "Dokument demo z ACME Polska S.A.";

    public static void main(String[] args) {
    }

    public String getLastLink() {
        return getLink(MailExctractor.getLastEmailBody());
    }

    public String getLastDocLink() {
        return getLink(MailExctractor.getMailBodyByTitle(DOCUMENT_LINK_TITLE));
    }

    private String getLink(String mailBody) {
        final Pattern pattern = Pattern.compile("http.+");
        final Matcher matcher = pattern.matcher(mailBody);
        String link = null;
        if (matcher.find()) {
            link = matcher.group(0);
        }
        System.out.println("This is authorization link " + link);
        return link;
    }
}

