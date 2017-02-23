/**
* The <code>PerformanceNode</code> class is a representation of a Performance(Node) and it holds a lot of values such as :
* • performanceName -- 	A name of the performance
* • leadPerformer --  	The name of the lead performer
* • participants --		The number of participants
* • duration -- The duration of the performance
* • startTime -- The starting time of the performance which can vary depending on the adding, removing, and insertion of other performances [nodes]
* 
* This class also has a toString method which returns a neatly formated table to display all of the information of the performances.
* 
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/

public class PerformanceNode {

	private String performanceName, leadPerformer;
	private int participants, duration, startTime;
	
	PerformanceNode next;
	PerformanceNode prev;
	
	
	/**
	 * Creates an instance of the PerformaceNode using parameters
	 * 
	 * @param pn
	 * performanceName
	 * @param lp
	 * leadPerformer
	 * @param part
	 * participants
	 * @param dur
	 * duration 
	 * 
	 * 	<dt><b>Postcondition:</b> 
	 * <dd>PerformanceNode has been initialized with given parameters 
	 */
	public PerformanceNode(String pn, String lp, int part, int dur)
	{
		
		performanceName = pn;
		leadPerformer = lp;
		participants = part;
		duration = dur;
		startTime = 0;
		
	}
	
	/**
	 * Empty constructor
	 * Set all parameters to null. 
	 */
	public PerformanceNode()
	{
		
	}
	
	/**
	 * This sets the next node to the Next position...
	 * 
	 * @param node
	 * accepts a node as a parameter
	 */
	public void setNext(PerformanceNode node)
	{
		next = node;
	}
	/**
	 * This sets the previous node to the Prev position...
	 * 
	 * @param node
	 * accepts a node as a parameter
	 */
	public void setPrev(PerformanceNode node)
	{
		prev = node;
	}

	/**
	 * This retrieves the next node, in other words it gets the next node...
	 * 
	 * @return
	 * It returns next
	 */
	public PerformanceNode getNext()
	{
		return next;
	}
	
	
	/**
	 * This retrieves the previous node, in other words it gets the previous node...
	 * 
	 * @return
	 * It returns Prev
	 */
	public PerformanceNode getPrev()
	{
		return prev;
	}
	
	/**This sets the PerformanceName and accepts a String as an argument...
	 * 
	 * @param newName
	 * accepts newNAme as a parameter...
	 */
	public void setPerformanceName(String newName) {
		performanceName = newName;
	}
	
	/**This gets the PerformanceName 
	 * @return
	 * This simply returns performanceName
	 */
	public String getPerformanceName() {
		return performanceName;
	}
	
	
	/**This sets the lead performer and accepts newPerf as a String argument...
	 * @param newPerf
	 * newPerf is a parameter and leadPerformer is equal to newPerf
	 */
	public void setLeadPerformer(String newPerf) {
		leadPerformer = newPerf;
	}
	
	
	/**This gets LeadPerformer
	 * @return
	 * returns leadPerformer
	 */
	public String getLeadPerformer() {
		return leadPerformer;
	}
	/**This sets the Participants
	 * @param
	 * The parameter is part, and participants is equal to part
	 */
	public void setParticipants(int part) {
		participants = part;
	}
	
	/**This gets Participants
	 * @return
	 * returns participants
	 */
	public int getParticipants() {
		return participants;
	}
	
	
	/**This sets the duration of the play, or the node in this case, it also accepts an integer as an argument
	 * 
	 * @param time
	 * time is a parameter and duration is equal to time
	 */
	public void setDuration(int time) {
		duration = time;
	}
	
	/** This gets the duration of the play or node in this case
	 * @return
	 *  returns duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/** This sets the starting time of the performance or the node in this case
	 * it also accepts an integer for an argument
	 * @param time
	 * The parameter is time, and startTime is equal to time
	 */
	public void setStartTime(int time) {
		startTime = time;
	}
	
	/** This gets the StartTime of the performance or the node in this case
	 * it also accepts an integer for an argument
	 * @return
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns a formatted string of each node or performance on a table-like String
	 * 

	 * returns String.format 
	 *  it returns the formatted table with everything that the user has inputed about the BaseballCard
	 * 
	 */
public String toString() {
	
	return String.format("%-26s%-26s%-13s%-9s%-10s", performanceName, leadPerformer, participants + "", duration + "", startTime + "");

}
}

