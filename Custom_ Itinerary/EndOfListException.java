/**
 * 	  This class throw the exception if cursor is null.

 */
public class EndOfListException extends Exception {
	/**
	 * Constructor without argument.
	 */
	public EndOfListException() {
	}
	/**
	 * Constructor send a message
	 * @param message the message be shown
	 */
	public EndOfListException(String message) {
		super(message);
	}
	
}
