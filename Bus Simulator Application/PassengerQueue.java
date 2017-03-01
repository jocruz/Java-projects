import java.util.*;
public class PassengerQueue extends PriorityQueue<Passenger>{

	
	public PassengerQueue() /*- constructor*/
	{
		
	}
	public void enqueue(Passenger p) /*a new group of passengers will join the line*/
	{
		add(p); // p being the passenger object, its going to move every other element from 0
	}
	public Passenger dequeue()/*  remove and return the group of passengers if the group is allowed on board*/
	{
		return super.remove();
	}
	public Passenger peek()  /*  return the first element of the queue without removing it*/
	{
		return super.peek();
		
	}
	public int size() /* returns the number of passengers (not groups) in the queue*/
	{
		return super.size(); // use the method from vector
	}
	public boolean isEmpty() /* determines if the queue is empty*/
	{
		return super.isEmpty();
	}
	
}
