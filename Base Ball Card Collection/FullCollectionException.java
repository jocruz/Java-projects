/**
* The <code>FullCollectionException</code> is a subclass of Exception and is thrown when the user tries to
* add a BaseballCard to a CardCollection that is full.  The exception is handled by allowing the program to continue, 
* but displaying an error message followed by "-- The collection is full." 
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/
public class FullCollectionException extends Exception {

	public FullCollectionException() {
		System.out.print(" -- The collection is full. ");
	}
}
