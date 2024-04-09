/**
* The <code>NoCursorException</code> is a subclass of Exception and is thrown when there is no cursor. Appropriate messages are with in
* the other classes.
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/

/**
 * Exception thrown when attempting to perform an operation that requires a cursor,
 * but no cursor is set or the cursor is out of bounds.
 */
public class NoCursorException extends Exception {

    /**
     * Constructs a NoCursorException with the default message.
     */
    public NoCursorException() {
        super("No cursor is set or the cursor is out of bounds.");
    }

    /**
     * Constructs a NoCursorException with a custom message.
     *
     * @param message The message that details the exception cause
     */
    public NoCursorException(String message) {
        super(message);
    }
}
