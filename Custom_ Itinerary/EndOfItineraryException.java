/**
 * 	  This class throw the exception if cursor is at the tail of the list.
 *
 */
public class EndOfItineraryException extends Exception {
	/**
	 * Constructor without argument.
	 */
	public EndOfItineraryException() {
		super();
	}
	/**
	 * Constructor send a message
	 * @param message the message be shown
	 */
	public EndOfItineraryException(String message) {
		super(message);
	}
	
}
