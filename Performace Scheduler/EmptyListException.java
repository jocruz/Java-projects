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
public class EmptyListException extends Exception {

	public EmptyListException() 
	{
	}
}
