/**
 * The <code>CardStack</code> class that will represent a stack of cards in the game. The Stack API was implemented in this class. 
 *We can keep track of the different types of stacks using a char variable type. The following stack types are: 
 *• 's' - stock
 *• 'w' - waste
 *• 'f' - foundations
 *• 't' - tableau.
 *
 * The following class has the following methods:
 * • public CardStack(char type) -- Constructor for Card Class
 * • public void push(Card newCard) -- Adds a new card to the top of the Stack
 * • public Card pop() -- Removes the Card that is on top of the Stack
 * • public boolean isEmpty() -- Returns an indicator to whether the stack is empty or not
 * • public int size() -- Returns the number of cards in the stack
 * • public void printStack() --  Renders the stack visually, depending on the type of the stack.
 */

import java.util.Stack;



public class CardStack extends Stack<Card> {

	private char type;
	
	
	/** Constructor for CardStack and it accepts a char as an argument
	 * @param type
	 * 	type is a char that is an argument
	 */
	public CardStack(char type)
	{
	
		this.type = type;
	}
	
	/**
	 * Adds a new Card on top of the Stack.
	 */
	public Card push(Card newCard)				// it gives me the non java doc comment when java doc is generated...
	{
		return super.push(newCard);
	}
	
	/** 
	 * Removes the Card that is on top of the Stack
	 */
	public Card pop() 								// it gives me the non java doc comment when java doc is generated...
	{
		return super.pop();
	}
	
	public Card peek()
	{
		return (Card)super.peek();
	}
	/**
	 * Returns an indicator to whether the stack is empty or not
	 */
	
	public boolean isEmpty()										// it gives me the non java doc comment when java doc is generated...
	{
		return super.isEmpty();
	}
	
	/** 
	 * Returns the number of cards in the stack
	 * 
	 */
	public int size()									// it gives me the non java doc comment when java doc is generated...
	{
		return super.size();
	}
	
	/**Renders the stack visually, depending on the type of the stack.
	 * 
	 * Type 's': Print the top card of the stack facing down - [XX]
	 * Type 'w': Print the top card of the stack facing up - [9♠]
	 * Type 't': Print the whole stack on a line - [XX][XX][XX][4♠][3♥]
	 * Type 'f': Print the top card of the stack facing up - [A♥]
	 * 
	 * A switch case was used to satisfy these conditions...
	 * 
	 * @param type
	 * 	It accepts a character type as a parameter...
	 */
	public void printStack(char type)
	{
		switch (Character.toUpperCase(type)) { 
		case 'S':
			if(this.isEmpty()) {
				System.out.print("[ ]");
			}
			else {
				this.peek().setFaceUp(false);
				System.out.print(this.peek());
			}
			break;
		case 'W':
			if(this.isEmpty()) {
				System.out.print("[ ]");
			}
			else {
				this.peek().setFaceUp(true);
				System.out.print(this.peek());
			}
			break;
		case 'T':
			CardStack temp = new CardStack(this.type);
			if(this.isEmpty()){
				System.out.print("[ ]");
			}
			while(!this.isEmpty())
				temp.push(this.pop());
			while(!temp.isEmpty())
				System.out.print(this.push(temp.pop()));
			break;
		case 'F':
			this.peek().setFaceUp(true);
			System.out.print(this.peek());
			break;
		}
		
	}
	
	
	
}
