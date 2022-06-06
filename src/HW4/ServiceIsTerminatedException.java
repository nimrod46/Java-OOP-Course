package HW4;

public class ServiceIsTerminatedException extends RuntimeException {
    public ServiceIsTerminatedException(String message) {
        super(message);
    }
}
