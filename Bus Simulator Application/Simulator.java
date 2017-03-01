import java.util.Iterator;

public class Simulator {

	private int numInBusses; //number of In Route busses
	private int numOutBusses; //number of Out Route busses
	private int minGroupSize; //the minimum amount of passengers in a group
	private int maxGroupSize; //the maximum amount of passengers in a group
	private int capacity; //the maximum number of passengers a Bus can hold
	private double arrivalProb; //the probability of a group of passengers lining up for a particular bus stop
	private final static int NUM_BUS_STOPS = 8; //Total number of bus stops in the simulation
	int groupsServed = 0; //the number of groups that successfully reached their destinations
	int totalTimeWaited = 0; //the total time groups spent waiting on a line
	String inRoute[] = { "South P", "West", "SAC", "Chapin" }; //String array representing the stops along the In Route line
	String outRoute[] = { "South P", "PathMart", "Walmart", "Target" }; //String array representing the stops along the Out Route line
	PassengerQueue[] busStops; //One queue for each bus stop, representing the passengers waiting at the stops.
	
	private Bus inBusses[]; //Array to hold the in-route busses
	private Bus outBusses[]; //Array to hold the out-route busses
	
	/*
	 Bus stop destination values
	 0 - South P
	 1 - In Route West
	 2 - In Route SAC
	 3 - In Route Chapin
	 4 - Out Route PathMart
	 5 - Out Route Walmart
	 6 - Out Route Target
	*/


	public int getDestNumber(String stopName) { //gets the destination number as an int for a bus's next stop (as a String)

		if(stopName.equals("South P"))
			return 0;
		else if(stopName.equals("West"))
			return 1;
		else if(stopName.equals("SAC"))
			return 2;
		else if(stopName.equals("Chapin"))
			return 3;
		else if(stopName.equals("PathMark"))
			return 4;
		else if(stopName.equals("Walmart"))
			return 5;
		else if(stopName.equals("Target"))
			return 6;
			
		return -1;
		
	}
	
	public String getDestName(int stopNum) { //gets the destination Name as an String for a bus's next stop (as a int)

		switch(stopNum) {
		case 0: return "South P";
		case 1: return "West";
		case 2: return "SAC";
		case 3: return "Chapin";
		case 4: return "PathMark";
		case 5: return "Walmart";
		case 6: return "Target";
		}
		return "";
			
	}
	
	public Bus[] initializeBusses(String route) { //This method is used to initialize the busses for either in or out routes.
		int numBusses = 0; //numBusses refers to the number of busses in the given route.
		
		if(route.equals("in")) //set numBusses appropriately for either in or out route.
			numBusses = inBusses.length;
		else //route must be "out"
			numBusses = outBusses.length;
		
		Bus[] busList = new Bus[numBusses]; //the array of busses to eventually be returned
		
		for(int i = 0; i < numBusses; i++)
		{
			int waitTime = 0; //the first bus does not wait
			busList[i] = new Bus(route, waitTime); //initialize bus
			waitTime += 30; //each bus waits 30 minutes longer than the previous
		}
		
		return busList;
	}
	
	public void advanceBusses() {
		for(int k=0; k<inBusses.length; k++) { //For each in-route bus...
			if(inBusses[k].advance() == 1) //Remember numToReturn in Bus class... if == 1, then the bus is rdy to pick up/drop off (Bus state 2)
			{ 
				int stopNumber = getDestNumber(inBusses[k].getNextStop());
				groupsServed += inBusses[k].unload(stopNumber); //unloads all passengers for this stop
				PassengerQueue passengersWaiting = busStops[stopNumber]; //a reference to the passengerQueue for this bus stop
				
				//TIME TO LOAD UP PASSENGERS:
				 Iterator passengerIterator = passengersWaiting.iterator(); //iterator used to cycle through passengers in line at this stop
				 while(passengerIterator.hasNext()) //cycle through all Passenger objects on this stop
				 {
						Passenger p = (Passenger)passengerIterator.next();
						if ((p.getDestination() > stopNumber && p.getDestination() < 4) || p.getDestination() == 0) //if the Passenger's destination is valid for this bus
						{
							if(inBusses[k].numPeople() + p.getGroupSize() <= capacity) { //if this will not overload the bus
								inBusses[k].enqueue(p); //finally, add this Passenger to the bus
								passengersWaiting.remove(p); //and now remove this Passenger from the line at the bus stop
							}
						}
						
				  }
				  //DONE LOADING PASSENGERS ONTO THE BUS, TIME TO SET THE NEXT STOP
				  if(inBusses[k].getNextStop().equals("Chapin")) { //the bus is at the last stop, about to go back to south P
					  inBusses[k].setNextStop("South P"); //set the bus's next stop to South P
					  inBusses[k].setToNextStop(20); //the bus is now 20 mins away from next destination
				  }
				  else if(inBusses[k].getNextStop().equals("South P")) { //the bus just arrived at south p.  time to rest!
					  inBusses[k].setNextStop("West"); //set the bus's next stop to West
					  inBusses[k].setToNextStop(0); //the bus is now waiting
					  inBusses[k].setTimeToRest(30);
				  }
				  else { //the bus is advancing to the next stop
					  int nextStop = getDestNumber(inBusses[k].getNextStop()) + 1;
					  inBusses[k].setNextStop(getDestName(nextStop));
					  inBusses[k].setToNextStop(20);
				  }
				  
				  
			}
		}
		
		for(int k=0; k<outBusses.length; k++) { //For each out-route bus...
			if(outBusses[k].advance() == 1) //Remember numToReturn in Bus class... if == 1, then the bus is rdy to pick up/drop off (Bus state 2)
			{ 
				int stopNumber = getDestNumber(outBusses[k].getNextStop());
				groupsServed += outBusses[k].unload(stopNumber); //unloads all passengers for this stop
				PassengerQueue passengersWaiting = busStops[stopNumber]; //a reference to the passengerQueue for this bus stop
				
				//TIME TO LOAD UP PASSENGERS:
				 Iterator passengerIterator = passengersWaiting.iterator(); //iterator used to cycle through passengers in line at this stop
				 while(passengerIterator.hasNext()) //cycle through all Passenger objects on this stop
				 {
						Passenger p = (Passenger)passengerIterator.next();
						if ((p.getDestination() > stopNumber && p.getDestination() < 4) || p.getDestination() == 0) //if the Passenger's destination is valid for this bus
						{
							if(outBusses[k].numPeople() + p.getGroupSize() <= capacity) { //if this will not overload the bus
								outBusses[k].enqueue(p); //finally, add this Passenger to the bus
								passengersWaiting.remove(p); //and now remove this Passenger from the line at the bus stop
							}
						}
						
				  }
				  //DONE LOADING PASSENGERS ONTO THE BUS, TIME TO SET THE NEXT STOP
				  if(outBusses[k].getNextStop().equals("Target")) { //the bus is at the last stop, about to go back to south P
					  outBusses[k].setNextStop("South P"); //set the bus's next stop to South P
					  outBusses[k].setToNextStop(20); //the bus is now 20 mins away from next destination
				  }
				  else if(outBusses[k].getNextStop().equals("South P")) { //the bus just arrived at south p.  time to rest!
					  outBusses[k].setNextStop("PathMark"); //set the bus's next stop to PathMark
					  outBusses[k].setToNextStop(0); //the bus is now waiting
					  outBusses[k].setTimeToRest(30);
				  }
				  else { //the bus is advancing to the next stop
					  int nextStop = getDestNumber(outBusses[k].getNextStop()) + 1;
					  outBusses[k].setNextStop(getDestName(nextStop));
					  outBusses[k].setToNextStop(20);
				  }
				  
				  
			}
		}
		
	}
	
	public int addTimeInLines(int time) {
		int total = 0;
		for(int i=0;i<busStops.length;i++) {
			Iterator passengerIterator = busStops[i].iterator(); //iterator used to cycle through passengers on line
			  while(passengerIterator.hasNext()) //cycle through all Passenger objects on this line				
			  {
				  Passenger p = (Passenger)passengerIterator.next();
				  if (p.getTimeBusStop() != time) //if the Passenger didn't JUST arrive
				  {
					  total += 1; //add one minute to total time waited
				  }
					
			  }
		}
		return total;
	}
	
	
	public double[] simulate(int duration)
	{
		busStops = new PassengerQueue[NUM_BUS_STOPS];  //One queue for each bus stop, representing the passengers waiting at the stops.
		groupsServed = 0; //The number of groups that successfully reached their destinations
		totalTimeWaited = 0; //The total time groups spent waiting on a line
		BooleanSource arrival = new BooleanSource(arrivalProb); //Random number generator based on arrival probability
		 	
		for(int i = 0; i < NUM_BUS_STOPS; i++) //initialize all 8 bus stops
		    busStops[i] = new PassengerQueue();
		
		
		inBusses = initializeBusses("in"); //initialize in and out busses!
		outBusses = initializeBusses("out");
		
		for (int time=0;time<duration;time++) //BEGIN SIMULATION!
		{
			for(int f=0; f<busStops.length; f++) //For each bus stop...
				if (arrival.occurs()) { //If a Passenger arrives...
					int grpsize = //generate random number from minGroupSize to maxGroupSize (final variables)
					int dest = //generate random number from 0 to 6.
					while(/*dest == f */)
						//generate a different random number from 0-6
					busStops[f].enqueue(new Passenger(grpsize,dest,timeArrived)); //Add the Passenger to that bus stop's queue.
					
				}

			
			advanceBusses(); //ADVANCE ALL BUSSES -- INCLUDE PICKING UP AND DROPPING OFF PASSENGERS AND RESETTING TIMERS!
			totalTimeWaited += addTimeInLines(time); //increment the number of total minutes waited in line by all groups collectively
			
			
			/* add print statements? */
			
		}
		//SIMULATION IS OVER, RETURN RESULTS
		double avgWaitTime = groupsServed / totalTimeWaited;
		return new double[] {avgWaitTime, groupsServed};
		
		 
	
		
		 
	}
	
	

	public void addPassengers() {
		for (int i = 0; i < NUM_BUS_STOPS; i++) {
			if (i < inRoute.length) {
				// math.random
			}

		}
		// for (int i = 0; i < NUM_BUS_STOPS; i++) {
		// System.out.println(i + " (" + ((i < inRoute.length) ? inRoute[i] :
		// outRoute[i - inRoute.length]) + ")");
	}

	
	
	public boolean occurs(double probability)  //passenger arrival [probability that the passenger will arrival 
	{
		
		return (Math.random() < probability);

	}
	
	public int groupSize(int min, int max)
	{
		
		return (int) (Math.random()* max+min);
		
		
		
	}
	public static void main(String[] args) {
		
		
		
		
	}

}
