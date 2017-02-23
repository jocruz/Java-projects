
/**
* The <code>Card</code> class is a representation of a Card which has the values and conditions of color, facing up, facing down
* 
* The card is to be stored in stacks which represent the card deck and the game it self with foundations and tableau.
* 
* This class includes certain methods such as a constructor for Card
* 
* 
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/






public class Card {

	private int suit;
	private int value;
	private boolean isFaceUp;
	
	static String values[] = {" ","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    static char suits[]    =   {' ', '\u2665', '\u2666','\u2663', '\u2660'};  // fix opposite color... {' ', 'H', 'D','C', 'S'};
    
	
	/**
	 * 	
	 * 	This is the constructor for card that holds the suit of the card, the value of the card, and whether the card is face up or not
	 * The parameters include:
	 * 
	 * Card that contains the suit of the card (int), value of the card (int), and a boolean value isFaceUp.
	 * 
	 * @param suit
	 * 	This is whether the card is a Heart, Diamond, Club, and Spades
	 * @param value
	 * 	The value of the card from 1-13
	 * @param isFaceUp
	 * 	Whether the card is face up or faced down
	 */
	public Card(int suit, int value, boolean isFaceUp)
	{
		
		this.suit = suit;
		this.value = value;
		this.isFaceUp= isFaceUp;
	}
	
	/**
	 * A Card constructor
	 */
	public Card()
	{
		
	}
	
	/** This sets a Suit and accepts an integer named suit as an argument. 
	 * @param suit
	 */
	public void setSuit(int suit)
	{
		this.suit = suit;
	}
	
	/**
	 * 	This boolean method checks if the cards are compatible in the game in other words the game
	 * 	has a rule that the same color cannot be on top of each other so we have to make a true or false check
	 * 	if the cards are compatible with each other, we have parameter of a card to check it.
	 * 
	 * NOTE: this was suppose to be isRed boolean method but I decided to name it something else, this was done by accident but was approved by the
	 * professor, I decided to keep the isRed boolean method anyways. 
	 * 
	 * @param c2
	 *  A card as a parameter
	 * @return
	 * 	We return a false statement at the end if the cards are not compatible. 
	 */
	public boolean oppositeColors(Card c2) {
		if((this.getSuit() == 1 || this.getSuit() == 2) && (c2.getSuit() == 3 || c2.getSuit() == 4))
			return true;
		else if((this.getSuit() == 3 || this.getSuit() == 4) && (c2.getSuit() == 1 || c2.getSuit() == 2))
			return true;
		return false;
	}
	
	public int getSuit ()
	{
		return suit;
	}
	
	/** This sets a Value and accepts an integer named value as an argument.
	 * @param value
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
	
	
	/** this gets the Value and returns value.
	 * @return
	 *  Returns value.
	 */
	public int getValue()
	{
		return value;
	}
	
	/** Returns a boolean to determine if the card is face up or not
	 * @return
	 * 	returns true if the card is face up, false if not.
	 */
	public boolean isFaceUp()
	{
		return this.isFaceUp;
	}
	
	/** This is another boolean that see if its set Face up and 
	 * @param faceUp
	 * @return
	 */
	public boolean setFaceUp(boolean faceUp)
	{
		this.isFaceUp = faceUp;
		return faceUp;
	}
	
	/** isRed method returns true if the suit is 1 or 2 (hearts or diamonds).
	 * @return
	 * 	returns true if the card is red, false otherwise.
	 */
	public boolean isRed() 
	{
		return (suit == 1 || suit == 2);
	}
	
/**
 * A toString method to print out the cards and their value 
 * 
 * 
 */
	public String toString()
	{
		if(isFaceUp)
			return "[" + values[value] + "" + suits[suit] + "]";
		else
			return "[XX]";
			
	}
}
