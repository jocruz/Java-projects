/** The <code>Stackotaire</code> class will contain a main method that presents a menu that allows the user interact with the game UI.
 *  This class runs a non-menu base game of the popular game Solitaire. I will imitate a game of Solitaire, called Stackotaire. 
 *  Solitaire a popular 'Patience' game was coded for CSE 214 homework. This game can also refer to the game as  Klondike or patience 
 *  General rules the game enforces:
 *  • In the tableau piles, all faced up cards can be placed under another faced up card that has a value of exactly 1 more than itself with an opposite colored suit, or a faced down card.
 *  • When the player draws from the stock pile, draw 1 card at a time.
 *  • In the tableau piles, you can only move a 'K' to an empty pile.
 *  • After moving card(s) from a tableau pile, flip the top card face up if it is not.
 *  • In the foundation piles, cards should start at 'A', and subsequently stack cards with the same suits in order of value.
 *  • In addition, include a main stack that initially contains all 52 cards of a deck.
 * 
 *  @author John Cruz
 *    e-mail: john.cruz@stonybrook.edu		
 *    Stony Brook ID: 108605747
 * 
 * 
 */

import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Stackotaire {

	static CardStack[] tableau = new CardStack[7];
	static CardStack[] foundation = new CardStack[4];
	static CardStack stock = new CardStack('s');
	static CardStack waste = new CardStack('w');
	static CardStack deckStack = new CardStack('m');
	static Card[] shallowList = new Card[52];
	
	
	/**
	 * 
	 * The player is able to interact with your game via a command line - like interface. When prompted for a move, the player can 
	 * supply the move in any one of the following formats:
	 * 
	 * draw: Removes the top card from the stock pile and places it face up in the waste pile. Once it reaches 0, you can draw again, unused cards in waste should recycle back to the stock with order not changed!
	 * 
	 * move W1 T2: Removes the top card from the waste pile, and places it on top of tableau pile #2. The third argument of this command can range from T1-T7, and F1-F4.
	 * 
	 * move F1 T5: Removes the top card from foundation pile #1, and places it on top of tableau pile #5. The second argument of this command can range from F1-14. The third argument of this command can range from T1-T7.
	 * 
	 * move T1 F1: Removes the top card from the tableau pile #1, and places it on top of foundation pile #1. The second argument of this command can range from T1-T7. The third argument of this command can range from F1-F4.
	 * 
	 * moveN T3 T2 3 Removes the top n cards, where n is the value of the fourth argument, from the tableau pile #3, and places them on top of tableau pile #2. The second and third arguments of this command can range from T1-T7.
	 * 
	 * NOTE: The player can do from T1-T7 and F1-F4 and from W1 to T1-T7 and F1-F4.
	 * 
	 * restart: Prompts the player to end the game and start a new one. If the player chooses yes, initialize a new game board, else, continue with the current
	 * 
	 * *** Extra Credit *** 
	 * automove: The program should recognize all available cards that can be moved to a foundation pile. Automatically move these cards to the appropriate 
	 * foundation pile without the user having to enter the "move" command. Display the commands for all cards that have been moved.
	 * NOTE: If the player inputs automove and there is no automatic move the code can do, then it will not perform any action.
	 * 
	 * *** Extra Credit *** 
	 * 
	 * 
	 * quit: Prints a loss message and terminate the program.
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		for(int i=0;i<tableau.length;i++) {
			if(i < 4)
				foundation[i] = new CardStack('f');
			tableau[i] = new CardStack('t');
		}
		
		/*
		for(int i=1;i<=13;i++)
			for(int j=1;j<=4;j++)
				shallowList[4*(i-1)+j-1] = deckStack.push(new Card(j,i,false));
				*/
			
		Scanner input = new Scanner(System.in);
		initialize();
		String command;
		
		
		l1: do {//BEGIN MAIN LOOP
			displayGameBoard();	
			System.out.print("Enter a command: ");
			String userInput = input.nextLine();
			System.out.println();
			StringTokenizer userInputTokenizer = new StringTokenizer(userInput);
			String[] arguments = new String[4];
			
			for(int i=0;i<arguments.length;i++) {
				if(userInputTokenizer.hasMoreElements())
					arguments[i] = ((String)userInputTokenizer.nextElement()).toUpperCase();
			}
			command = arguments[0];
			if(command.equals("AUTOMOVE")) {
				int suit1=0, suit2=0, suit3=0, suit4=0;
				CardStack temp = new CardStack('t');
				if(!foundation[0].isEmpty())
					suit1 = foundation[0].peek().getSuit();
				if(!foundation[1].isEmpty())
					suit2 = foundation[1].peek().getSuit();
				if(!foundation[2].isEmpty())
					suit3 = foundation[2].peek().getSuit();
				if(!foundation[3].isEmpty())
					suit4 = foundation[3].peek().getSuit();
				for(int i=0;i<shallowList.length;i++) {
					if(foundation[0].contains(shallowList[i]) || foundation[1].contains(shallowList[i]) || foundation[2].contains(shallowList[i]) || foundation[3].contains(shallowList[i])) {
						continue;
					}
					if(shallowList[i].isFaceUp()) {
					if(shallowList[i].getValue() == 1) {
						if(suit1 == 0) {
							foundation[0].push(shallowList[i]);
							temp.push(shallowList[i]);
						}
						else if(suit2 == 0) {
							foundation[1].push(shallowList[i]);
							temp.push(shallowList[i]);
						}
						else if(suit3 == 0) {
							foundation[2].push(shallowList[i]);
							temp.push(shallowList[i]);
						}
						else if(suit4 == 0) {
							foundation[3].push(shallowList[i]);
							temp.push(shallowList[i]);
						}
						
						
					}
					else if(!foundation[0].isEmpty() && shallowList[i].getValue() == foundation[0].peek().getValue() + 1  && shallowList[i].getSuit() == suit1) {
						foundation[0].push(shallowList[i]);
						temp.push(shallowList[i]);
					}
					else if(!foundation[1].isEmpty() && shallowList[i].getValue() == foundation[1].peek().getValue() + 1 &&  shallowList[i].getSuit() == suit2) {
						foundation[1].push(shallowList[i]);
						temp.push(shallowList[i]);
					}
					else if(!foundation[2].isEmpty() && shallowList[i].getValue() == foundation[2].peek().getValue() + 1 &&  shallowList[i].getSuit() == suit3) {
						foundation[2].push(shallowList[i]);
						temp.push(shallowList[i]);
					}
					else if(!foundation[3].isEmpty() && shallowList[i].getValue() == foundation[3].peek().getValue() + 1 &&  shallowList[i].getSuit() == suit4) {
						foundation[3].push(shallowList[i]);
						temp.push(shallowList[i]);
					}
				}
				}
					
					while(!temp.isEmpty()) {
						if(!waste.isEmpty() && waste.peek() == temp.peek()) {
							temp.pop();
							waste.pop();
							if(temp.isEmpty())
								continue l1;
						}
						for(int j=0;j<tableau.length;j++) {
							if(!tableau[j].isEmpty() && tableau[j].peek() == temp.peek()) {
								tableau[j].pop();
								if(!tableau[j].isEmpty())
									tableau[j].peek().setFaceUp(true);
								temp.pop();
								if(temp.isEmpty())
									continue l1;
							}
							
						}
					}
					continue l1;
					
				
			} //end automove case, begin draw case
			else if(command.equals("DRAW")) {
				if(stock.isEmpty()) {
					if(waste.isEmpty()) {
						System.out.println("There are no cards to draw.\n");
						continue l1;
					}
					while(!waste.isEmpty()) {
						stock.push(waste.pop());
					}
					if(!waste.isEmpty())
						waste.peek().setFaceUp(false);
					waste.push(stock.pop());
					waste.peek().setFaceUp(true);
					
				}
				else {
					if(!waste.isEmpty())
						waste.peek().setFaceUp(false);
					waste.push(stock.pop());
					waste.peek().setFaceUp(true);
				}
					
			}
			else if(command.equals("RESTART")) {
				System.out.print("Do you want to start a new game? (Y/N): ");
				String choice = input.nextLine();
				if(choice.toUpperCase().equals("Y")) {
					System.out.println("\n\nSorry, you lose.  Starting new game.\n\n");
					initialize();
				}
				else
					System.out.println("\n\nContinuing the current game...\n\n");	
			}
			else if(command.equals("MOVE")) {
				
				if(arguments[1] == null || arguments[2] == null) {
					System.out.println("\nInvalid input\n");
					continue;
					
				}
				String from = arguments[1].substring(0,1).toUpperCase(); //The first letter in the second argument
				String to = arguments[2].substring(0,1).toUpperCase(); //The first letter in the third argument
				if(from.equals("W") && to.equals("T")) {
					if(waste.isEmpty())
						System.out.println("The waste pile is empty. Invalid move.\n");
					else {
						int tab = 0;
						try {
							tab = Integer.parseInt(arguments[2].substring(1,2));
						}
						catch(Exception e) {
							System.out.println("\nInvalid Input.\n");
							continue l1;
						}
						
						if(tableau[tab-1].isEmpty() && waste.peek().getValue() == 13) {
							//move card from waste to tableau
							tableau[tab-1].push(waste.pop());
						}
						else if(!tableau[tab-1].isEmpty()) {
						
						if((waste.peek().getValue() == tableau[tab-1].peek().getValue() - 1)) { // IF VALUE IS 1 LESS
							
							if(waste.peek().oppositeColors(tableau[tab-1].peek())) //IF THEY ARE OPPOSITE COLORS
									tableau[tab-1].push(waste.pop());
								else
									System.out.println("Invalid move.\n");
						}
						else
							System.out.println("Invalid move.\n");
					}
				}}
			
				else if(from.equals("W") && to.equals("F")) {
					if(waste.isEmpty())
						System.out.println("The waste pile is empty. Invalid move.\n");
					else {
						int found = Integer.parseInt(arguments[2].substring(1,2));
						if(waste.isEmpty() || foundation[found-1].isEmpty()) {
							if(!waste.isEmpty() && waste.peek().getValue() == 1 && foundation[found-1].isEmpty()) { //if its an ace and found is empty
								//move card from waste to tableau
								foundation[found-1].push(waste.pop());
							}
							else {
								System.out.println("Invalid move\n");
								continue l1;
							}
						}
						
						else if(foundation[found-1].peek().getValue() == waste.peek().getValue() - 1) { //if waste is 1 higher than found
							if(foundation[found-1].peek().getSuit() == waste.peek().getSuit()) { //and the suits are the same
								foundation[found-1].push(waste.pop()); //add the card to foundation from waste
							}
						}
						else
							System.out.println("Invalid move.\n");
					}
				}
				else if(from.equals("F") && to.equals("T")) {
					int fpile = 0;
					int tpile = 0;
					try{
					 fpile = Integer.parseInt(arguments[1].substring(1,2)) - 1;
					 tpile = Integer.parseInt(arguments[2].substring(1,2)) - 1;}
					catch(Exception e)
					{
						System.out.println("Invalid input.\n");
						continue l1;
					}
					if(foundation[fpile].isEmpty()){
						System.out.println("Invalid move.\n");
						continue;
					}
					if(tableau[tpile].isEmpty()){
						System.out.println("Invalid move.\n");
						continue;
					}
					Card topOfFound = foundation[fpile].peek();
					Card topOfTab = tableau[tpile].peek();
					
					if(topOfFound.getValue() == topOfTab.getValue() - 1 && topOfFound.oppositeColors(topOfTab))  { //IF FOUNDATION CARD IS 
						tableau[tpile].push(foundation[fpile].pop());
						foundation[fpile].peek().setFaceUp(true);
						displayGameBoard();// TODO
						if(tableau[tpile].isEmpty()) {
							
						} 
					/*	else {
										//??
						}*/
					}
					else
						System.out.println("Invalid move.\n");
				}
				else if(from.equals("T") && to.equals("F")) {
					int tpile = Integer.parseInt(arguments[1].substring(1)) - 1;
					int fpile = Integer.parseInt(arguments[2].substring(1)) - 1;
					
					if(tableau[tpile].isEmpty()){
						System.out.println("Invalid move.\n");
						continue;
					}
					
					Card topOfFound = null;
					Card topOfTab = null;
					
					try {
						if(foundation[fpile].isEmpty())
							topOfFound = null;
						else 
							topOfFound = foundation[fpile].peek();
					
						if(tableau[tpile].isEmpty())
							topOfTab = null;
					else
						topOfTab = tableau[tpile].peek();}
						catch(Exception e)
					{
						System.out.println("invalid input \n");
						continue l1;
					}
						
					
					
			/*		if(!(foundation[fpile].isEmpty() && tableau[tpile].isEmpty())) {
						topOfFound = foundation[fpile].peek();
						topOfTab = tableau[tpile].peek();
					} else {
						if(foundation[fpile].isEmpty()) {
							
						}
						
					}*/
					
					if(topOfFound == null) { //there is nothing in that foundation pile
						if(topOfTab.getValue() == 1) { //the card is an ace
							foundation[fpile].push(tableau[tpile].pop());
							if(!tableau[tpile].isEmpty())
								tableau[tpile].peek().setFaceUp(true);
						}
					}
					else if( (topOfFound.getValue() == topOfTab.getValue() - 1) //if the highest foundation card is 1 lower than the tab card to be added
							&& topOfFound.getSuit() == topOfTab.getSuit()) { 
						foundation[fpile].push(tableau[tpile].pop());
						if(tableau[tpile] != null && !tableau[tpile].isEmpty()) //set the next card face up, if there is one
							tableau[tpile].peek().setFaceUp(true); // ^
						
					}
					else
						System.out.println("Invalid move.\n");
				}
				else if(from.equals("T") && to.equals("T")) {
					
					int tpile1 = Integer.parseInt(arguments[1].substring(1,2)) - 1;
					int tpile2 = Integer.parseInt(arguments[2].substring(1,2)) - 1;
					if(tableau[tpile2].isEmpty()
							&& tableau[tpile1].isEmpty() == false
							&& tableau[tpile1].peek().getValue() == 13) {
						tableau[tpile2].push(tableau[tpile1].pop());
						if(tableau[tpile1].isEmpty() == false) //set the next one face up, if there is one
							tableau[tpile1].peek().setFaceUp(true);
						continue;
					}
			
					if(tableau[tpile2].isEmpty() && tableau[tpile1].isEmpty()){
						System.out.println("Invalid move.\n");
						continue;
					}
					Card topOfTab1;
					Card topOfTab2;
					
					if(tableau[tpile1].isEmpty() == false) {
					 topOfTab1 = tableau[tpile1].peek();
					}
					else {
						topOfTab1 = null;
					}
					if(tableau[tpile2].isEmpty() == false) {
					topOfTab2 = tableau[tpile2].peek();
					} else {
						topOfTab2 = null;
						
					}
					
					if((topOfTab1 != null && topOfTab2 != null) && topOfTab1.getValue() == topOfTab2.getValue() - 1) { // if both stacks are not null, and the new card is 1 less than the old
						if(topOfTab1.oppositeColors(topOfTab2)) {
							tableau[tpile2].push(tableau[tpile1].pop()); //move the cards
							if(!(tableau[tpile1].isEmpty())) {// checks if tableau is empty before peeking
								tableau[tpile1].peek().setFaceUp(true);
							}
						//displayGameBoard();	
						}
						else {
							System.out.println("\nInvalid Move.\n");
							continue;
						}
							
					}
					else
						System.out.println("Invalid move.\n");
				}
				else
					System.out.println("Invalid move.\n");
			}
			
			// ----------- MOVE N is next ---------------
			
			else if(command.equals("MOVEN") && command.substring(4,5) != null) {
				if(arguments[1] == null || arguments[2] == null || arguments[3] == null) {
					System.out.println("\nInvalid input\n");
					continue l1;
					}
				
				
				String from = arguments[1].substring(0,1).toUpperCase(); //The first letter in the second argument
				String to = arguments[2].substring(0,1).toUpperCase(); //The first letter in the third argument
				int nCards = 0;
				try {
					nCards = Integer.parseInt(arguments[3]);
				}
				catch(Exception e) {
					System.out.println("\nInvalid Input.\n");
					continue l1;
				}
				
				int tpile1 = Integer.parseInt(arguments[1].substring(1,2)) - 1;
				int tpile2 = Integer.parseInt(arguments[2].substring(1,2)) - 1;
				if(tableau[tpile1].isEmpty() && tableau[tpile2].isEmpty()) {
					System.out.println("Invalid move.\n");
					continue;
				}
			/*	if(tableau[tpile2].isEmpty() &&) {
					System.out.println("Invalid move.\n");
					continue;
				}*/
				CardStack tempStack = new CardStack('T');
				for(int i=0;i<nCards;i++) {
					if(tableau[tpile1].isEmpty() /*|| !tableau[tpile1].peek().isFaceUp()*/) {
						System.out.println("Invalid move");
						while(!tempStack.isEmpty())
							tableau[tpile1].push(tempStack.pop());
						continue l1;
					}
					tempStack.push(tableau[tpile1].pop());
				}
			/*	if(!tempStack.peek().isFaceUp()) { 
					System.out.println("Invalid move like jagger\n");  // moving the king into an empty pile...
					while(!tempStack.isEmpty())
						tableau[tpile1].push(tempStack.pop());
					continue;
				} */
				if(tableau[tpile2].isEmpty() && tempStack.peek().getValue() == 13) {
					while(!tempStack.isEmpty())
						tableau[tpile2].push(tempStack.pop());
				}
				else if(tableau[tpile2].isEmpty() && tempStack.peek().getValue() != 13) {
					System.out.println("Invalid move\n");
					while(!tempStack.isEmpty())
						tableau[tpile1].push(tempStack.pop());
					continue l1;
				}
				else if (((tempStack.peek().getValue() == tableau[tpile2].peek().getValue() - 1) && tempStack.peek().oppositeColors(tableau[tpile2].peek()))
						|| tableau[tpile2].isEmpty() && tempStack.peek().getValue() == 13) {
					while(!tempStack.isEmpty())
						tableau[tpile2].push(tempStack.pop());
				}
				else {
					System.out.println("Invalid move \n");
					while(!tempStack.isEmpty())
						tableau[tpile1].push(tempStack.pop());
				}
			//	else if(tempStack.peek().getValue() == 13 && tableau[tpile2].isEmpty()) { // MOVING KING TO EMPTY
			//		for(int i=0;i<nCards;i++) {
			//			tempStack.push(tableau[tpile1].pop()); 
			//		}
					
			//	}
				if(!tableau[tpile1].isEmpty())
					tableau[tpile1].peek().setFaceUp(true);
				
				
			} 
			
			if(isWinningBoard() == true) {
				System.out.println("Winner!");
			}
			
		} while(!command.equals("QUIT"));
		
		System.out.println("Sorry, You Lose\nTerminating Program...");
		
		
		
	}
	
	/**
	 * Initializes the game by distributing all cards into the proper stacks. First, 
	 * move all 52 cards from the game stacks into the deck stack. Then, shuffle the deck by using the static method shuffle() 
	 * in the Collections class (or you can implement your own). Finally, distribute the correct number of cards into the tableau and stock piles.
	 */
	public static void initialize() {
		for(int i=0;i<tableau.length;i++) {
			if(i < 3)
				foundation[i] = new CardStack('f');
			tableau[i] = new CardStack('t');
		}
		stock = new CardStack('s');
		waste = new CardStack('w');
		deckStack = new CardStack('m');
		
		for(int i=1;i<=13;i++)
			for(int j=1;j<=4;j++)
				shallowList[4*(i-1)+j-1] = deckStack.push(new Card(j,i,false));
		
		Collections.shuffle(deckStack);
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<i+1;j++) {
				tableau[i].push(deckStack.pop());
				if(i==j) {
					tableau[i].peek().setFaceUp(true);
				}
				else
					tableau[i].peek().setFaceUp(false);
			}
		}
		
		while(!deckStack.isEmpty()) {
			stock.push(deckStack.pop());
		}
		
	}
	
	/**
	 * Returns an neatly printed game board so the player can start playing the game:
	 * 
	 * Renders all stacks to produce an image of the game board. Use the print stack method you have written to render each stack.
	 *  The foundation stacks should be displayed on the top-left of the board; the waste stack should be displayed on the next to the foundation stacks on their right; 
	 *  the stock stack should be places right next to it on its right; a number should be displayed next to the stock stack that represents total cards left in the stack;
	 *  the tableau stacks should be displayed horizontally under the previous stacks. Check the sample input/output for a visual understanding.
	 * 
	 * 
	 * 
	 * 
	 */
	public static void displayGameBoard() {
		for(int i=0;i<foundation.length;i++) {
			if(foundation[i] == null || foundation[i].isEmpty())
				System.out.print("[F" + (i + 1) + "]");
			else {
				foundation[i].printStack('F');
				//System.out.print(i + "]");
			}
		}
		System.out.print("     W1 ");
		waste.printStack('W');
		System.out.print("    ");
		stock.printStack('S');
		System.out.println(" " + stock.size() + "\n");
		
		for(int i=tableau.length-1;i>=0;i--) {
			System.out.print("T" + (i+1) + " ");
			tableau[i].printStack('T');
			System.out.println();
		}
		System.out.println();
	}
	
	/**	Once every card are in the foundation pile are face up then the player wins 
	 * 
	 * If all cards are faced up in the board, the player has the ability to manually move all cards to the foundation stacks.
	 *  In other words, this is a guaranteed win. Iterate through the games stacks 
	 * to determine the face value of all the cards. If all cards are faced up, display a win message, and prompt 
	 * the user to play again.
	 * 
	 * 
	 * @return
	 * 	Returns true if you win
	 */
	public static boolean isWinningBoard() {
		
		for(int i=0;i<shallowList.length;i++)
			if(!shallowList[i].isFaceUp())
				return false;
		return true;
		
	}
	
	
	
}



