package by.mantur.task02.exception;

public class CreatingCarException extends Exception {

	private static final long serialVersionUID = 1L;

	public CreatingCarException() {
		super();
	}

	public CreatingCarException(String message) {
		super(message);
	}

	public CreatingCarException(
			String message, Throwable cause) {
		super(message, cause);
	}

	public CreatingCarException(Throwable cause) {
		super(cause);
	}

}
