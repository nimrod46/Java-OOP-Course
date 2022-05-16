package Lab09;

@SuppressWarnings("serial")
public class TooManyEntryException extends Exception {
    public TooManyEntryException(String format) {
        super(format);
    }
}
