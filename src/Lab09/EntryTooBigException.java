package Lab09;

@SuppressWarnings("serial")
public class EntryTooBigException extends Exception {
    public EntryTooBigException(String format) {
        super(format);
    }
}
