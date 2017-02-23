/**
* The <code>CollectionManager</code> class runs a menu-driven application in which the user can create and manipulate BaseballCard objects. 
* These BaseballCard objects are stored in two different collections (using the CardCollection data structure), each of which having a max 
* capacity of 100 cards (can be changed by modifying the MAX_CARDS final variable in the CardCollection class.  The program continues until 
* the user selects "Q" as a menu choice, then the program closes--without saving user data.
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/
import java.util.Scanner;

public class CollectionManager {

	static CardCollection A = new CardCollection();
	static CardCollection B = new CardCollection();
	
	/**
	 * 
	 * 
	 * A method that adds a card to the card collection depending on what card collection you want to put it in. 
	 * If the user inputs A for the first menu option then the user will be prompt 
	 * to enter :
	 * • A name
	 * • The Manufacturer 
	 * • The Year
	 * • The Size
	 * • The Price
	 * • The Position
	 * 
	 * 	When it is done it will print you out all the information you entered in a String and that is the Baseball Card you have entered
	 *  into the collection.
	 *  
	 *  
	 *  
	 *  
	 */
	public static void add() {
		try {
			Scanner input4 = new Scanner(System.in);
			System.out.print("\nEnter the collection: "); 
			String coll = input4.nextLine().toUpperCase();
			if(!coll.equals("A") && !coll.equals("B"))  //user enters a collection other than A or B
				throw new IllegalArgumentException();
			System.out.print("Enter the name: ");
			String name = input4.nextLine();
			System.out.print("Enter the manufacturer: ");
			String manu = input4.nextLine();
			System.out.print("Enter the year: ");
			int year = input4.nextInt();
			System.out.print("Enter the size: ");
			int x = input4.nextInt();
			int y = input4.nextInt();
			System.out.print("Enter the price: ");
			double price = input4.nextDouble();
			System.out.print("Enter the position: ");
			int pos = input4.nextInt();

			BaseballCard temp = new BaseballCard(name,manu,year,price,x,y); //creates a BaseballCard with user inputted values.
		
			if(coll.equals("A"))
				A.addCard(temp,pos); //add card to collection A 
			else
				B.addCard(temp,pos); //add card to collection B
			String priceFormatted = String.format("%.2f", price);
			System.out.print("\nAdded " + name + ", " + manu + " " + year + ", " + x + "x" + y + ", $" + priceFormatted + " at position " + pos + " of collection " + coll + "\n\n");
		} 
		catch (IllegalArgumentException | FullCollectionException e) {
			if(e instanceof FullCollectionException)
				System.out.println("\nFailed to add card.  The collection is full.\n");
			else
				System.out.println("\nFailed to add card.  Invalid input.\n");
		}
	}
	
	
	/**
	 * This is the copy method :
	 * This allows the user to enter a Collection either from A or B; Then allows you to 
	 * copy a card into another position into another Collection
	 */
	public static void copy() {
		try {
			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter the collection to copy from: ");
			String coll = input2.next().toUpperCase();
			if(!coll.equals("A") && !coll.equals("B")) //user enters collection other than A or B for first coll1.
				throw new IllegalArgumentException();
			System.out.print("Enter the position of the card to copy: ");
			int pos = input2.nextInt();
			System.out.print("Enter the collection to copy to: ");
			String coll2 = input2.next().toUpperCase();
			if(!coll2.equals("A") && !coll2.equals("B")) //user enters collection other than A or B for coll2.
				throw new IllegalArgumentException();
			
			if(coll2.equals("A") && coll.equals("A")) {
				A.addCard((BaseballCard)A.getCard(pos).clone());
				BaseballCard bbc = A.getCard(pos);
				String priceFormatted = String.format("%.2f", bbc.getPrice());
				System.out.println("\nCopied " + bbc.getPlayerName() + ", " + bbc.getCardManufacturer() + " " + bbc.getYear() + ", " + bbc.getSizeX() + "x" + bbc.getSizeY() 
						+ ", $" + priceFormatted + " into position " + A.cards_in_list + " of collection A\n");
			}	
			else if(coll2.equals("A") && coll.equals("B")) {
				A.addCard((BaseballCard)B.getCard(pos).clone());
				BaseballCard bbc = A.getCard(pos);
				String priceFormatted = String.format("%.2f", bbc.getPrice());
				System.out.println("\nCopied " + bbc.getPlayerName() + ", " + bbc.getCardManufacturer() + " " + bbc.getYear() + ", " + bbc.getSizeX() + "x" + bbc.getSizeY() 
						+ ", $" + priceFormatted + " into position " + A.cards_in_list + " of collection A\n");
			}
			else if(coll2.equals("B") && coll.equals("A")) {
				B.addCard((BaseballCard)A.getCard(pos).clone());
				BaseballCard bbc = B.getCard(pos);
				String priceFormatted = String.format("%.2f", bbc.getPrice());
				System.out.println("\nCopied " + bbc.getPlayerName() + ", " + bbc.getCardManufacturer() + " " + bbc.getYear() + ", " + bbc.getSizeX() + "x" + bbc.getSizeY() 
						+ ", $" + priceFormatted + " into position " + B.cards_in_list + " of collection B\n");
			}
			else if(coll2.equals("B") && coll.equals("B")) {
				B.addCard((BaseballCard)B.getCard(pos).clone());
				BaseballCard bbc = B.getCard(pos);
				String priceFormatted = String.format("%.2f", bbc.getPrice());
				System.out.println("\nCopied " + bbc.getPlayerName() + ", " + bbc.getCardManufacturer() + " " + bbc.getYear() + ", " + bbc.getSizeX() + "x" + bbc.getSizeY() 
						+ ", $" + priceFormatted + " into position " + B.cards_in_list + " of collection B\n");
			}
			else
				System.out.println("Failed to update name.  Invalid collection.\n\n");
		}
		
		catch (IllegalArgumentException | FullCollectionException e) {
			if(e instanceof FullCollectionException)
				System.out.println("\nFailed to add card.  The collection is full.\n\n");
			else
				System.out.println("\nFailed to add card.  Invalid input.\n\n");
		}
	}
	
	/**
	 * This updates the price of a card, the method will prompt the user to enter the collection of which the user
	 * wishes to updated, then it asks the position of the card in which you want to update, finally it prompts the user to 
	 * enter the price, and it updated the Price.
	 */
	public static void updatePrice() {
		Scanner input2 = new Scanner(System.in); //gather user input
		System.out.print("Enter the collection: ");
		String coll = input2.nextLine().toUpperCase();
		System.out.print("Enter the position: ");
		int pos = input2.nextInt();
		System.out.print("Enter the new price: ");
		double prc = input2.nextDouble();
		
		if(coll.equals("A")) { //update price
			String oldPrcF = String.format("%.2f", A.getCard(pos).getPrice());
			String newPrcF = String.format("%.2f", prc);
			System.out.println("\nChanged price for " + A.getCard(pos).getPlayerName() + " in collection A (position " + pos + ") from $" + oldPrcF + " to $"
					+ newPrcF + "\n");
			A.getCard(pos).setPrice(prc);
		}
		else if(coll.equals("B")) { //update price
			String oldPrcF = String.format("%.2f", B.getCard(pos).getPrice());
			String newPrcF = String.format("%.2f", prc);
			System.out.println("\nChanged price for " + B.getCard(pos).getPlayerName() + " in collection B (position " + pos + ") from $" + oldPrcF + " to $"
					+ newPrcF + "\n");
			B.getCard(pos).setPrice(prc);
		}
		else
			System.out.println("\nFailed to update price.  Invalid collection \"" + coll + "\"\n");
	}
	
	/**
	 * Prints out the name, manufacturer, year, and price of the card at the specified position in the indicated collection.
	 */
	public static void getCard() {
		Scanner input2 = new Scanner(System.in);
		System.out.print("Enter the collection: ");
		String coll = input2.nextLine().toUpperCase();
		System.out.print("Enter the position: ");
		int pos = input2.nextInt();
		
		if(coll.equals("A")) {
			BaseballCard c = A.getCard(pos);
			System.out.printf("%-25s%-25s%-6s%-8s%-12s","\nName","Manufacturer","Year","Price","Size\n");
			System.out.printf("%-25s%-25s%-6d%-8.2f%-12s",c.getPlayerName(),c.getCardManufacturer(),c.getYear(),c.getPrice(),c.getSizeX() + "X" + c.getSizeY());
		}
		else if(coll.equals("B")) {
			BaseballCard c = B.getCard(pos);
			System.out.printf("%-25s%-25s%-6s%-8s%-12s","\nName","Manufacturer","Year","Price","Size\n");
			System.out.printf("%-25s%-25s%-6d%-8.2f%-12s",c.getPlayerName(),c.getCardManufacturer(),c.getYear(),c.getPrice(),c.getSizeX() + "X" + c.getSizeY());
		}
		else
			System.out.print("\nFailed to get card.  Invalid collection \"" + coll + "\"");
		
		System.out.println("\n");
	}
	
	/**
	 * 
	 * This looks for the card
	 * It prompts the user to enter the name, manufacturer, year, size(s)
	 * 
	 * if the card exists with the same parameters then it will tell you so
	 * if not then it will proof false.
	 * 
	 */
	public static void lookForCard() {
		Scanner input2 = new Scanner(System.in);
		System.out.print("Enter the name: ");
		String name = input2.nextLine();
		System.out.print("Enter the manufacturer:  ");
		String manu = input2.nextLine();
		System.out.print("Enter the year: ");
		int year = input2.nextInt();
		System.out.print("Enter the size: ");
		int x = input2.nextInt();
		int y = input2.nextInt();
		System.out.print("Enter the price: ");
		double price = input2.nextDouble();
		
		BaseballCard newCard = new BaseballCard(name,manu,year,price,x,y);
		
		if(A.exists(newCard))
			System.out.print("\nThe card is in collection A.  ");
		else
			System.out.print("\nThe card is not in collection A.  ");
		
		if(B.exists(newCard))
			System.out.print("The card is in collection B.  ");
		else
			System.out.print("The card is not in collection B.  ");
		
		System.out.println("\n");
	}
	
	/**
	 * This updates the name of a player in a Collection
	 * The mehtod prompts the user to enter the collection, the position, and then the name of the player.
	 * 
	 */
	public static void updateName() {
		Scanner input3 = new Scanner(System.in);
		System.out.print("Enter the collection: ");
		String coll = input3.next().toUpperCase();
		System.out.print("Enter the position: ");
		int pos = input3.nextInt();
		input3.nextLine();
		System.out.print("Enter the new name: ");
		String name = input3.nextLine();
		
		try {
			if(coll.equals("A")) {
				System.out.println("\nChanged name of collection A position " + pos + " from " + A.getCard(pos).getPlayerName() + " to " + name + "\n");
				A.getCard(pos).setPlayerName(name);
			}
			else if(coll.equals("B")) {
				B.getCard(pos).setPlayerName(name);
				System.out.println("\nChanged name of collection B position " + pos + " from " + B.getCard(pos).getPlayerName() + " to " + name + "\n");
			}
			else
				System.out.println("Failed to update name.  Invalid collection \"" + coll + "\"\n");
		}
		catch(IllegalArgumentException e) {
			System.out.println("\nFailed to update name.  Invalid input.\n");
		}
	}
	
	/**
	 * This prints out the Collections from Collection A to Collection B.
	 */
	public static void printAll() {
		System.out.println("Collection A: ");
		A.printAllCards();
		System.out.println("\nCollection B: ");
		B.printAllCards();
		System.out.println("\n");
	}
	
	/**
	 * 
	 * 
	 * Remove the card at the specified position in the indicated collection
	 * 
	 */
	public static void removeCard() {
		Scanner input2 = new Scanner(System.in);
		System.out.print("Enter the collection to remove from: ");
		String coll = input2.next().toUpperCase();
		System.out.print("Enter the position to remove: ");
		int pos = input2.nextInt();
		try {
			if(coll.equals("A")) {
				BaseballCard temp = A.getCard(pos);
				A.removeCard(pos);
				String priceFormatted = String.format("%.2f", temp.getPrice());
				System.out.print("\nRemoved " + temp.getPlayerName() + ", " + temp.getCardManufacturer() + " " + temp.getYear() + ", " + temp.getSizeX() + "x" + temp.getSizeY() + ", $" 
						+ priceFormatted + " from collection A.\n\n");
			}
			else if(coll.equals("B")) {
				BaseballCard temp = B.getCard(pos);
				B.removeCard(pos);
				String priceFormatted = String.format("%.2f", temp.getPrice());
				System.out.print("\nRemoved " + temp.getPlayerName() + ", " + temp.getCardManufacturer() + " " + temp.getYear() + ", " + temp.getSizeX() + "x" + temp.getSizeY() + ", $" 
						+ priceFormatted + " from collection B.\n\n");
			}
			else
				throw new IllegalArgumentException();
		
		}
		catch(IllegalArgumentException e) {
			System.out.println("\nFailed to remove card.  Invalid input.\n\n");
		}
	}
	
	/**
	 * This just prints the number of cards in each collection
	 */
	public static void size() { 
		System.out.println("Collection A has " + A.size() + ((A.size() == 1) ? " card." : " cards.") + "  Collection B has " + B.size() + ((B.size() == 1) ? " card." : " cards.") + "\n\n");
	}
	
	/**
	 * Prints the total value of each collection
	 * This simply prints out the value of the entire collection separately. It will show the value of collection A and Collection B separately. 
	 */
	public static void value() {
		double aVal = 0, bVal = 0; //counter variables for prices of cards in collection A (aVal) and collection B (bVal)
		for(int i=1;i<=A.cards_in_list;i++)
			aVal += A.getCard(i).getPrice(); //increment aVal
		for(int i=1;i<=B.cards_in_list;i++)
			bVal += B.getCard(i).getPrice(); //increment bVal
		String aValFormat = String.format("%.2f", aVal);
		String bValFormat = String.format("%.2f", bVal);
		System.out.println("\nThe total value of collection A is $" + aValFormat + ".  The total value of collection B is $" + bValFormat + ".\n\n"); //print result
	}
	
	/**
	 * 
	 * This method trades a card from Collection A to Collection B. It prompts the user to enter the position of the card from Collection A
	 * Then the position of the card to trade from collection B.
	 * 
	 * It catches an exception if the user fails to enter a correct input.
	 * 
	 */
	public static void trade() {
		Scanner input2 = new Scanner(System.in);
		System.out.print("Enter the position of the card to trade from collection A: ");
		int pos1 = input2.nextInt();
		BaseballCard card1 = A.getCard(pos1);
		System.out.print("Enter the position of the card to trade from collection B: ");
		System.out.println();
		int pos2 = input2.nextInt();
		String priceFormatted = String.format("%.2f", card1.getPrice());
		BaseballCard card2 = B.getCard(pos2);
		String secondFormatted = String.format("%.2f", card2.getPrice());
		try {
			A.trade(B, pos1, pos2);
			System.out.println("Traded " + card2.getPlayerName() + ", " + card2.getCardManufacturer() + " " + card2.getYear() + ", " + card2.getSizeX() + "x" + 
			card2.getSizeY() + ", " + "$" + secondFormatted + " for " + card1.getPlayerName() + ", " + card1.getCardManufacturer() + " " + card1.getYear() + ", " + card1.getSizeX() + "x" + 
					card1.getSizeY() + ", " + "$"+ priceFormatted + "\n");
		}
		catch (IllegalArgumentException e) {
			
			System.out.println("Failed to trade cards.  Invalid input.\n");
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
			menuInput = input.next().toUpperCase(); //user's menu choice
			
			switch (menuInput) { //check menu choice
			case "A":
				add();
			break;	
			case "C":
				copy();	
			break;
			
			case "E":
				updatePrice();
			break;
			
			case "G":
				getCard();
			break;
			
			case "L":
				lookForCard();
			break;
			
			case "N":
				updateName();
			break;
			
			case "P":
				printAll();
			break;
			
			case "R":
				removeCard();
			break;
			
			case "S":
				size();
			break;
			
			case "V":
				value();
			break;
			
			case "T":
				trade();
			break;
			}
		} while(!menuInput.equals("Q")); //end the loop if the user inputs Q (quit)
		
		System.out.print("\n\nQuitting.");
		
		System.exit(0); //exit program
		
		
	}
	
	/**
	 * This prints out the menu in which the user has the option from Adding a card to the collection by choosing A
	 * Copy the card by choosing C
	 * Update price by choosing E
	 * Get a card from a collection by choosing G
	 * Locate a card by choosing L
	 * Update the name  by choosing N
	 * Print all cards by choosing P
	 * Remove the card by choosing R
	 * Show the Size of the Collections by choosing S
	 * Trade cards in the collection by choosing T
	 * Shows the Value of both Collections by choosing V
	 * Terminate the program by choosing Q
	 * 
	 */
	public static void printMenu() {
		System.out.print("A) Add Card\nC) Copy\nE) Update price\nG) Get Card\nL) Locate Card\nN) Update name\nP) Print All Cards\n"
				+ "R) Remove Card\nS) Size\nT) Trade\n" + "V) Value"
				+ "\nQ) Quit\n\nSelect an operation: ");
	}

}
