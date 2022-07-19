package exemples;

public class ExempleException extends Exception {
	public ExempleException(String msgException) {
		super("Exception: " + msgException);
	}
}
