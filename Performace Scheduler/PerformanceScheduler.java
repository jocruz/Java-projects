/**
 * 
* The <code>PerformanceScheduler</code> class runs a menu-driven application in which the user can create and manipulate Nodes in the linked list that were coded. 
* These nodes can be altered even when the program is running to demonstrate the usage and efficiency of Linked Lists...  
* In this example, I store all of the performances in the form of a LinkedList.
* The program continues until the user selects "Q" as a menu choice, then the program closes--without saving user data.
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
*    
*    																
 */																																																																																															

import java.util.*;
public class PerformanceScheduler {

	static PerformanceList list = new PerformanceList ();
	static Scanner input = new Scanner (System.in);
	
	
	/**This method adds a new node into the linked list
	 * 
	 * Upon further reading, the method also prompts the user to enter information on the node. 
	 *
	 * 
	 * If the user inputs A for the first menu option then the user will be prompt 
	 * to enter :
	 * • A name of the performance
	 * • The name of the lead performer
	 * • The number of participants
	 * • The duration of the performance
	 *  
	 * @throws IllegalArgumentException
	 * It also throws an illegal argument exception if the number of participants are less than 0, and the duration is less than 0...
	 *  Also an  InputMismatchException is caught in case the user inputs anything that isn't part of the function.
	 */
	public static void add () throws IllegalArgumentException
	{		
		try{
		System.out.print("\nPlease enter the name of the performance: " );
		String perName = input.nextLine();
		System.out.print("Please enter the name of the lead performer: ");
		String leadPre = input.nextLine();
		System.out.print("Please enter the number of participants: ");
		int parti = input.nextInt();
		if (parti < 0)
		{
			throw new IllegalArgumentException ();
		}
		input.nextLine();
		System.out.print("Please enter the duration of the performance: ");
		int dur = input.nextInt();
		if (dur < 0)
		{
			throw new IllegalArgumentException ();
		}
		input.nextLine();
		PerformanceNode temp = new PerformanceNode (perName, leadPre, parti, dur);
		
		list.addToEnd(temp);
		if(temp.getPrev() != null)
			temp.setStartTime(temp.getPrev().getStartTime() + temp.getPrev().getDuration());
		
		System.out.println("\nNew performance " + perName + " was added to the end of the list.\n");
		}
		catch (IllegalArgumentException | InputMismatchException  e)
		{
			input.nextLine();
			System.out.println("\nSorry you've entered an incorrect function. Please try again!\n");
		}
		
		
		
	}
	
	
	/**
	 * This method allows you to insert a node, at any position, it also throws an exception just like the last method if the participants
	 * are less than 0, and the duration is less than zero. 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @throws IllegalArgumentException
	 */
	public static void insert () throws IllegalArgumentException
	{
		try{
		System.out.print("\nPlease enter the name of the performance: ");
		
		String perName = input.nextLine();
		System.out.print("Please enter the name of the lead preformer: ");
		String leadPre = input.nextLine();
		System.out.print("Please enter the number of participants: ");
		int parti = input.nextInt();
		if (parti < 0)
		{
			throw new IllegalArgumentException ();
		}
		input.nextLine();
		System.out.print("Please enter the duration of the performance: ");
		int dur = input.nextInt();
		if (dur < 0)
		{
			throw new IllegalArgumentException ();
		}
		input.nextLine();
		
		PerformanceNode temp = new PerformanceNode (perName, leadPre, parti, dur);
		
		list.addAfterCurrent(temp);

		while(temp.getNext() != null) {
			temp = temp.getNext();
			temp.setStartTime(temp.getStartTime() + dur);
		}
		
		System.out.println("\nNew performance " + perName + " was added after the current performance.\n");
		}
		catch(IllegalArgumentException | InputMismatchException  e)
		{
			input.nextLine();
			System.out.println("\nSorry you've entered an incorrect function. Please try again!\n");
			
		}
	}
	
	/**
	 * This removes a node from the linked list depending where the cursor is pointing to and what is the current Node
	 *  It also catches an Empty List Exception if the list is found to be empty. 
	 */
	public static void remove ()
	{
		try {
			list.removeCurrentNode();
			System.out.println("\nSuccessfully removed the current performance.\n");
		}
		catch (EmptyListException e) {
			System.out.println("\nCannot remove the current performance.  The list is empty.\n");
		}
	}
	
	/**
	 * This displays the current node, this is not to be confused with the displayAll method.
	 * 
	 * This will only print if the cursor is pointing to the current node, then it will print it out.
	 * If the list is empty then, it will catch the EmptyListException and will display a message saying that the list was found to be
	 * empty...
	 */
	public static void displayCurrent ()
	{
		try {
			System.out.println("\nCurrent Node:\n");
			list.displayCurrentPerformance();
		} catch (EmptyListException e) {
			
			System.out.println("\nCannot display current performance.  The list is empty.\n");
		}
		
	}
	
	
	
	/**
	 * This is the displayAll method, where it will print out the entire schedule even if it is empty, this is not to be confused with the
	 * displayCurrent method.
	 */
	public static void displayAll ()
	{
		System.out.println("\nSchedule:\n\n\n" + list.toString() + "\n");
	}
	
	/**
	 * This is the forward method, and all it does is move the cursor forward...
	 * It catches an exception if the the list is empty and it cannot move forward anymore.
	 */
	public static void forward()
	{
		try {
			if(list.moveCursorForward())
				System.out.println("\nCursor has been moved forwards.\n");
			else
				System.out.println("\nCursor is already at the end of the list. Cursor cannot be moved forwards.\n");
		} catch (EmptyListException e) {
			
			System.out.println("\nThe list is empty.\n");
		}
	}
	/**
	 * This is the backward method, and all it does is move the cursor backwards...
	 * It catches an exception if the the list is empty and it cannot move backwards anymore.
	 */
	public static void backward ()
	{
		try {
			if(list.moveCursorBackward())
				System.out.println("\nCursor has been moved backwards.\n");
			else
				System.out.println("\nCursor is already at the front of the list. Cursor cannot be moved backwards.\n");
		} catch (EmptyListException e) {
			
			System.out.println("\nThe list is empty.\n");
		}
	}
	
	/**
	 * This is the jump method where it moves the cursor to a certain position, giving it the jump effect, it basically jumps to
	 * any position in the linked list. 
	 * 
	 * This catches three exceptions... it catches an Illegal Argument Exception, InputMismatchException and EmptyListException
	 * 
	 * All Three occur when the user tries to enter an invalid position, such as if there are only 3 elements in the linked list
	 * and you want to jump to position 4, you can't, also if you try to jump to any position while the list is empty, this will throw
	 * the empty list exception.
	 */
	
	public static void jump ()
	{
		System.out.println("\nPlease enter the position you want to jump to: ");
		int jump = input.nextInt();
		input.nextLine();
		try {
			if(list.jumpToPosition(jump))
				System.out.println("\nCursor has been moved to position " + jump + ".\n");
			else
				System.out.println("\nCursor cannot be moved.  Position " + jump + " does not contain a performance.\n");
		}
		catch (IllegalArgumentException | InputMismatchException | EmptyListException e) {
			System.out.println("\nError.  Position cannot be less than 1.\n");
		}
	}
	
	/**
	 * The main method, it has switch and cases to fully maximize the methods.
	 */
	
	public static void main(String[] args) {
		
				Scanner input = new Scanner(System.in);
				String menuInput = "";
				System.out.println("Main Menu:\n");
				
				do {
					printMenu(); //print menu 
					menuInput = input.nextLine().toUpperCase(); //user's menu choice
					
					switch (menuInput) { //check menu choice
					case "A":
						add();
					break;	
					case "B":
						backward();	
					break;
					
					case "R":
						remove();
					break;
					
					case "C":
						displayCurrent();
					break;
					
					case "D":
						displayAll();
					break;
					
					case "F":
						forward();
					break;
					
					case "I":
						insert();
					break;
					
					case "J":
						jump();
					break;
					
					case "Q":
						break;
					
					default : finalCase();
					}
				} while(!menuInput.equals("Q")); //end the loop if the user inputs Q (quit)
				
				
				System.out.print("\n\nQuitting.");
				
				System.exit(0); //exit program
				
				
			}
			

	/**
	 * This prints out the menu in which the user has the option to perform certion operations
	 * Add a new node to end by choosing A
	 * Move current node backward by choosing B
	 * Display current node by choosing C
	 * Display all nodes by choosing D
	 * Move current node forward by choosing F
	 * Insert after current node by choosing I
	 * Jump to position by choosing J
	 * Remove current node by choosing R
	 * Terminate the program by choosing Q
	 * 
	 */
	public static void printMenu() {
		System.out.print("A) Add to end\nB) Move current node backward\nC) Display current node\nD) Display all nodes\nF) Move current node forward\nI) Insert after current node\nJ) Jump to position\n"
				+ "R) Remove current node"
				+ "\nQ) Quit\n\nChoose an operation: ");
	}
	
	/**
	 * This method is the last case in which the user inputs an invalid menu option.
	 * it prints out a statement asking the user to input a valid input method.
	 */
	public static void finalCase()
	{
		System.out.println("\nInvalid menu option! Please choose one of the following valid menu options.\n");
	}
	}

	
	


