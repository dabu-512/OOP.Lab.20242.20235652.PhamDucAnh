package hust.soict.hedspi.aims.exception;

public class LimitExceededException extends Exception {
	private static final long serialVersionUID = 1L;

	public LimitExceededException() {
        super();
    }

    public LimitExceededException(String message) {
        super(message);
    }

    public LimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimitExceededException(Throwable cause) {
        super(cause);
    }
}