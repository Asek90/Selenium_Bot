package mail;

public class FailedMailExctractionExcepction extends RuntimeException {
    public FailedMailExctractionExcepction(Exception e) {
        super(e);
    }

    public FailedMailExctractionExcepction() {
    }
}
