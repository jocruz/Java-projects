/**
* The <code>EmptyListException</code> is a subclass of Exception and is thrown when the user tries to do anything with the List
* but the list is empty. The the user tries to move the cursor backwards, forward, display the current node, jump to a node when there isn't
*  it will cause an EmptyListException.
* 
*Appropriate messages are with in the other classes...
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/

/**
 * Exception thrown when attempting to perform an operation on an empty list.
 * This exception helps in identifying actions that are invalid due to the absence of elements in the list.
 */
public class EmptyListException extends Exception {

    /**
     * Constructs an EmptyListException with the default message.
     */
    public EmptyListException() {
        super("The list is empty.");
    }

    /**
     * Constructs an EmptyListException with a custom message.
     *
     * @param message The message that details the exception cause
     */
    public EmptyListException(String message) {
        super(message);
    }
}
