package recipient;

public class Mail {

    private final String userName;
    private final String domain;
    private int number = 0;

    public Mail(
            final String userName,
            final String domain) {
        this.userName = userName;
        this.domain = domain;
    }

    public Mail(String userName, int number, String domain) {
        this.userName = userName;
        this.domain = domain;
        this.number = number;
    }

    public String getValue() {
        if (number > 0) {
            return String.format("%s+%d@%s", userName, number, domain);
        } else {
            return String.format("%s@%s", userName, domain);
        }
    }

    @Override
    public String toString() {
        return getValue();
    }

}
