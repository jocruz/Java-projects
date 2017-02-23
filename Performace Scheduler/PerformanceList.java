/**
* The <code>PerformanceList</code> class is a data structure which implements the manipulation of the data and nodes, it fully demonstrates
* how Linked list should work and how they are fully functional and practical in the real world. 
* The class contains the following methods which can be used to manipulate the data structure :
* • addToEnd() -- Automatically adds a new performance at the end of the list.
* • addAfterCurrent() -- This is to insert a new data depending where the current node is.
* • removeCurrentNode() -- used to remove a node [performance] from the linked list.
* • displayCurrentPerformance() -- This method is used to display the current performance, basically where the current node is pointing to.
* • moveCursorForward() -- This basically moves the cursor forward as long as it proves true, once it proves false, that means it can no longer move forward
* • moveCursorBackward() --This basically moves the cursor backwards as long as it proves true, once it proves false, that means it can no longer move backwards
* • jumpToPosition() -- This makes the cursor jump to any node in the linked list.
* • toString() -- generates a String representation of this PerformanceList
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/

public class PerformanceList {

	private PerformanceNode head, tail, cursor;
	
	/**
	 * An empty constructor.
	 */
	public PerformanceList()
	{
		
	}
	
	
	/** This methods inserts the new performance at the end of the PerformanceList. The current node should now be the newly created node.
	 * This method may still be used even when the list is empty. This means we don't really need an exception to handle anything...
	 *  
	 * @param newPerformance
	 * newPerformance is a parameter helped to add nodes at the end of the list
	 */
	public void addToEnd(PerformanceNode newPerformance)
	{
		if(head == null) {
			head = newPerformance;
			tail = newPerformance;
			cursor = newPerformance;
		}
		else {
			tail.setNext(newPerformance);
			newPerformance.setPrev(tail);
			tail = newPerformance;
			cursor = newPerformance;
		}
	}
	
	/**This method basically adds a node while following the current node, it other words:
	 * 
	 * Inserts the new data into the PerformanceList such that the new node directly follows the current node, if it exists.
	 *  If there is no current node it simply inserts the node at the end of the list...
	 * 
	 * @param newPerformance
	 * Once again we use the parameter newPerformance to help us add a new node into the linked list...
	 */
	public void addAfterCurrent(PerformanceNode newPerformance)
	{
		if(cursor == null) { //list is empty.  add the new performance as head, tail, and cursor.
			head = newPerformance;
			tail = newPerformance;
			cursor = newPerformance;
			return;
		}
		PerformanceNode temp = cursor.getNext();
		newPerformance.setPrev(cursor);
		cursor.setNext(newPerformance);
		newPerformance.setNext(temp);
		if(temp == null){     //this only will happen if cursor == tail
			tail = newPerformance;
			cursor = newPerformance;}
		
		else
			temp.setPrev(newPerformance);
		cursor = newPerformance;
		cursor.setStartTime(cursor.getPrev().getStartTime()+cursor.getPrev().getDuration());
	}
	
	/**This method removes the current node, 
	 * if it exists. It has a lot of conditions to it that must be accounted for.
	 * If there is no node after the one that was just removed, the current node should now be the node before the one that was just removed. If the node removed was the only one in the PerformanceList
		the current node should now be null. 
	 * There are a lot of conditions to take into account, but all are account for...
	 * @return
	 * The return value indicates whether or not any node was removed. 
	 * @throws EmptyListException
	 * The EmptyListException is thrown because in the event that the list is empty and we are trying to remove nothing
	 */
	public boolean removeCurrentNode() throws EmptyListException
	{
		if(cursor == null)		//there is no list
			throw new EmptyListException();		//nothing was deleted so return false
		
		PerformanceNode temp = cursor;
		PerformanceNode prev = cursor.getPrev();
		PerformanceNode next = cursor.getNext();
		
		if(next==null && prev == null) {	//cursor is only element
			head = null;
			tail = null;
			cursor = null;  //empty the list
			return true;	//an element (the only one) was removed so return true
			}
		else if(next == null) {		//cursor is tail
			tail = prev;	//change tail to previous before deleting it
			tail.setNext(null);
			cursor = tail;	//move cursor back
			return true;	//an element (the tail) was removed so return true
		}
		else if(prev == null) { //cursor is the first element
			while(temp != null) {
				temp.setStartTime(temp.getStartTime() - cursor.getDuration());
				temp = temp.getNext();
			} 
			cursor = cursor.getNext();
			head = cursor;
			cursor.setPrev(null);
			return true;
		}
		else {		//cursor is somewhere in the middle
			while(temp != null) {
				temp.setStartTime(temp.getStartTime() - cursor.getDuration());
				temp = temp.getNext();
			}
			prev.setNext(next);
			next.setPrev(prev);
			cursor = next;
			return true;
		}
	}
	
	/**This method displays the data in the current node, and also accounts if the list is empty. With in this method there also
	 * a String.format to neatly display the Current node with an asterisk, the number of performance [in order], 
	 * the Lead Performer Name, Participants, Duration, and Start time.
	 * @throws EmptyListException
	 * Throws the EmptyListException in the event that the list is empty...
	 */
	public void displayCurrentPerformance() throws EmptyListException
	{
		if(cursor == null)
		{
			throw new EmptyListException();
		}
		
		else
		{
			int count = 1;
			PerformanceNode temp = head;
			while(temp != cursor) {
				temp = temp.getNext();
				count++;
			}
			String str = String.format("%-8s%-4s%-26s%-26s%-13s%-9s%-10s","Current" , "No.", "Performance Name", "Lead Performer Name", "Participants", "Duration", "Start Time" );
			str += "\n------------------------------------------------------------------------------------------------\n";
			str += String.format("%-8s%-4d","*", count);
			str += cursor.toString();
			
			System.out.println(str + "\n");
		}
	}
	
	
	/**
	 *  This boolean method moves the node forward in the list by one position if a node exists after the current one then it returns true. 
	 *  If there is no next node, the current node should remain the same then it returns false
	 * @return
	 * This returns a boolean value depending on the situation
	 * @throws EmptyListException
	 * This throws an EmptyListException in the event that the list is empty...
	 */
	public boolean moveCursorForward() throws EmptyListException
	{
		if (cursor == null)
			throw new EmptyListException();
		if(cursor.getNext() != null) {
			cursor = cursor.getNext();
			return true;
		}

		return false;
	
	}
	
	/**
	 *  This boolean method moves the node backwards in the list by one position if a node exists before the current one then it returns true. 
	 *  If there is no previous node, the current node should remain the same then it returns false
	 * @return
	 * This returns a boolean value depending on the situation
	 * @throws EmptyListException
	 * This throws an EmptyListException in the event that the list is empty...
	 */
	public boolean moveCursorBackward() throws EmptyListException
	{
		if (cursor == null)
			throw new EmptyListException();
		if(cursor.getPrev() != null) {
			cursor = cursor.getPrev();
			return true;
		}

		return false;
	}
	
	
	/** Moves the current node to the given position in the PerformanceList.
	 *  If the given position doesn't exist in the list, leave the current node where it was
	 *  and return false [Making it a boolean method...]. Otherwise, set the current node to the correct position and return true.  
	 *  
	 *  <dt><b>Preconditions:</b> 
	 * <dd>Assume the first performance in the PerformanceList is position 1.
	 *  
	 *  
	 * @param position
	 * This accepts a parameter names position 
	 * @return
	 * returns a boolean value either true or false depending if the method proved to have jumped to the given position.
	 * @throws IllegalArgumentException
	 * This throws an IllegalArgumentException if the user enters a position less than 1, we must assume that the first position is always one.
	 * 
	 * @throws EmptyListException
	 * This throws an EmptyListException if the user tries to jump to a position when the List is empty
	 */
	public boolean jumpToPosition(int position) throws IllegalArgumentException, EmptyListException
	{
		if(cursor == null)		
			throw new EmptyListException();		
		
		if (position < 1)
			throw new IllegalArgumentException();
		
		PerformanceNode temp = cursor; //This is the original position that the cursor is at
		cursor = head; // Starting at position one...
		for(int i=1;i<position;i++) {  // keep jumping starting at position one...
			if(cursor.getNext() == null) {
				cursor = temp;  //If the cursor jumps to a position that isn't there just return to it's original position.
				return false;
			}
			
			cursor = cursor.getNext();
		}
		return true;	
	}
	
	/**
	 * Returns a neatly formatted table of all information for all the scheduled performances.
	 * This is similar to what was written in PerformanceNode, this returns the full content including the "---" bar to make it easier on the
	 * eye for the user
	 * This also makes it so that the asterisk follows the current node, as the user adds, inserts, removes, jumps the asterisk will follow
	 * so the user always know what is the current node
	 */
	public String toString()
	{
		
		String str = String.format("%-8s%-4s%-26s%-26s%-13s%-9s%-10s","Current" , "No.", "Performance Name", "Lead Performer Name", "Participants", "Duration", "Start Time" );
		str += "\n------------------------------------------------------------------------------------------------\n";
		
		int count = 1;
		
		
		PerformanceNode n = head;
		
		
		while (n != null)
		{
			String ast = "";
			if( n == cursor)
				ast = "*";
			
			str += String.format("%-8s%-4s",ast, count);
			str += n.toString() + "\n";
			//str += String.format("%5s%5d %90s", ast , count , n.toString());
			
			n = n.getNext();
			

			count ++;
		}
		str += "\n";
		return str;
	}
}
