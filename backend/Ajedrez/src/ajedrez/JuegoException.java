package ajedrez;

public class JuegoException extends Exception {
	private static final long serialVersionUID = 1L;

	public JuegoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JuegoException(String message, Throwable cause) {
		super(message, cause);
	}

	public JuegoException(String message) {
		super(message);
	}

}
