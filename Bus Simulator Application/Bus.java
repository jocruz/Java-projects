import java.util.*;
public class Bus extends PassengerQueue{

	
	/*
	 * POSSIBLE STATES A BUS CAN BE IN:
	 * 1 - Waiting at south P: timeToRest > 0
	 * 						   toNextStop > 0
	 * 
	 * 2 - Arrived at a stop:  timeToRest == 0
	 * 						   toNextStop == 0
	 * 
	 * 3 - En route to a stop: timeToRest == 0
	 * 						   toNextStop > 0
	 * 
	 * If the state is 2, then that means the bus is prepared to pick up and/or drop off Passengers
	 * 
	 */
	private String route; //Type of bus
	public static int capacity; //Number of passengers bus can carry
	private String nextStop; //Name of the next bus stop
	private int toNextStop; //Time required to reach next bus stop
	private int timeToRest; //Minutes remaining for resting (bus is not operating if this is above 0)
	private String stops[]; //List of stops this bus will use -- (South P, West, SAC, Chapin) for In Route,
							//                                -- (South P, PathMart, Walmart, Target) for Out Route.
	
	
	private PassengerQueue passengers; //List that will keep track of the passengers
	
	public Bus (String route, int timeToRest)
	{
		this.route = route;
		
		if(route.equals("in")) //if the bus is an In Route bus, set the list of stops to the following
			stops = new String[] {"South P", "West", "SAC", "Chapin"};
		else //otherwise the bus is an Out Route bus, set the list of stops to:
			stops = new String[] {"South P", "PathMark", "Walmart", "Target"};
		
		this.timeToRest = timeToRest;
	}
	
	public int advance() { //THIS METHOD ADVANCES THE BUS BY 1 MIN AND RETURNS 1 IF THE BUS HAS JUST ARRIVED AT A STOP, 0 OTHERWISE
		int numToReturn = 0;
		if(timeToRest > 0) //if the bus is waiting at south p (state 1)
		{
			timeToRest--; //reduce resting time by 1 minute
			if(timeToRest == 0) //if the bus JUST finished resting, (state 2)
				numToReturn = 1;
		}
		else if(toNextStop > 1) //if the bus is en route to a stop (state 3)
		{
			toNextStop--;
			if(toNextStop == 0) //if the bus JUST arrived at a stop (state 2)
				numToReturn = 1;
		}
		
		return numToReturn;
	}
	
	
	  public String getRoute() {
		return route;
	}


	public void setRoute(String route) {
		this.route = route;
	}


	public static int getCapacity() {
		return capacity;
	}


	public static void setCapacity(int capacity) {
		Bus.capacity = capacity;
	}


	public String getNextStop() {
		return nextStop;
	}
	
	public void setNextStop(String nextStop) {
		this.nextStop = nextStop;
	}
	
	public int getToNextStop() {
		return this.toNextStop;
	}
	
	public void setToNextStop(int toNextStop) {
		this.toNextStop = toNextStop;
	}
	
	public int getTimeToRest() {
		return this.timeToRest;
	}


	public void setTimeToRest(int timeToRest) {
		this.timeToRest = timeToRest;
	}


	public PassengerQueue getPassengers() {
		return passengers;
	}

	public void setPassengers(PassengerQueue passengers) {
		this.passengers = passengers;
	}

	
	public int numPeople() {
		int total = 0; //the number of people on the bus
		  Iterator passengerIterator = passengers.iterator(); //iterator used to cycle through passengers on bus
		  while(passengerIterator.hasNext()) //cycle through all Passenger objects on this bus
			{
				Passenger p = (Passenger)passengerIterator.next();
				total += p.getGroupSize();
			}
			return total; //return the number of people on the bus
	}
	
	
	public int unload(int dest)
	  {
		  int total = 0; //the number of Passengers to remove from the bus
		  Iterator passengerIterator = passengers.iterator(); //iterator used to cycle through passengers on bus
		  while(passengerIterator.hasNext()) //cycle through all Passenger objects on this bus
			{
				Passenger p = (Passenger)passengerIterator.next();
				if (p.getDestination() == dest) //if the Passenger's destination is the bus's current stop
				{
					total++; //add 1 to total
					passengers.remove(p); //remove the Passenger from the bus
				}
				
			}
			return total; //return the number of Passengers who left the bus
	  }
	  
	  
	  

	
}
