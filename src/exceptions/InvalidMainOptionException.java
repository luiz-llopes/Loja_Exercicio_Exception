package exceptions;

public class InvalidMainOptionException extends RuntimeException {
    public InvalidMainOptionException(String message) {
        super(message);
    }
}
