package by.epam.task01.exception;

public class TriangleException extends Exception {

	private static final long serialVersionUID = 1L;

	public TriangleException() {
		super();
	}

	public TriangleException(String message) {
		super(message);
	}

	public TriangleException(String message, Throwable cause) {
		super(message, cause);
	}

	public TriangleException(Throwable cause) {
		super(cause);
	}

}
