import java.util.*;
public class Passenger {

	private int groupSize;
	private int destination;
	private int timeBusStop;
	
	
	public Passenger (int groupSize, int destination, int timeBusStop)
	{
		this.groupSize = groupSize;
		this.destination = destination;
		this.timeBusStop = timeBusStop;
	}
	
	public Passenger ()
	{
		
	}
	
	
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public int getDestination() {
		return destination;
	}
	public void setDesitnation(int desitnation) {
		this.destination = desitnation;
	}
	public int getTimeBusStop() {
		return timeBusStop;
	}
	public void setTimeBusStop(int timeBusStop) {
		this.timeBusStop = timeBusStop;
	}
	
	
	

}
