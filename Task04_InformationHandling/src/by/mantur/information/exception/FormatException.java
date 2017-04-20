package by.mantur.information.exception;

public class FormatException extends Exception{
	
	private static final long serialVersionUID =-9149338958624224563L;

	public FormatException() {
        super();
    }

    public FormatException(String message) {
        super(message);
    }

    public FormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatException(Throwable cause) {
        super(cause);
    }

}
