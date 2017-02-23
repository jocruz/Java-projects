/**
* The <code>CardCollection</code> class is a data structure which implements an array of <code>BaseballCard</code>
* objects. The size of this array is fixed to MAX_CARDS, which is set to 100 by default.  The class contains the following 
* methods which can be used to manipulate the data structure.:
* • size() -- returns the number of elements in the array (cards_in_list)
* • addCard() -- used to add a BaseballCard to the structure
* • removeCard() -- used to remove a BaseballCard from the structure
* • trade() -- used to trade a BaseballCard from this CardCollection to another CardCollection
* • getCard() -- used to retrieve a BaseballCard from this CardCollection
* • toString() -- generates a String representation of this CardCollection
* • printAllCards() -- prints the generated toString representation of this CardCollection.
*    
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/

public class CardCollection {

	final int MAX_CARDS = 100;
	BaseballCard[] cardList = new BaseballCard[MAX_CARDS+1];
	int cards_in_list = 0;
	
	/**
	    * Returns an instance of <code>CardCollection</code>.
	    *
	    **/
	
	public CardCollection() {
		
	}
	
	/**
	    * Returns the current number of BaseballCards in the Collection.
	    *
	    * @return
	    *   Returns the number of BaseballCards in the Collection as an int.
	    **/
	
	public int size() {
		return cards_in_list;
	}
	
	 /**
	    * Adds a card to the card collection.
	    *
	    * @param Baseballcard newCard
	    *    The first baseballCard
	    * @param position
	    *    The position of the BaseballCard you want to add.
	    *
	    * <dt>Preconditions:
	    *    <dd> The position is between 1 and cards_in_list
	    *
	    * <dt>Postconditions:
	    *    <dd>The positions of the two items indicate that a card has been added into the collection.
	    *    
	    *    
	    *    Increment The number of cards by one.
	    *    
	    * @exception FullCollectionException
	    * 		Thrown when the collection is full.
	    * @exception IllegalArgumentException
	    * 		Thrown when the position is invalid. (Lower than 1 or greater than cards_in_list)
	    **/
	
	public void addCard(BaseballCard newCard, int position) throws FullCollectionException, IllegalArgumentException {
		if(cards_in_list == 100)
			throw new FullCollectionException();
		if(position < 1 || position > cards_in_list + 1 || position >= MAX_CARDS) {
			throw new IllegalArgumentException();
		
			
		}
		if(position == cards_in_list+1) {
			cardList[cards_in_list+1] = newCard;
		}
		else {
			for(int i=cards_in_list;i>=position;i--) {
				cardList[i+1] = cardList[i];
			}
			cardList[position] = newCard;
		}
		
		cards_in_list++;
			
		
		
	}
	
	
	/**
	    *  Adds a new card and increases the size of the collection by 1.
	    *
	    * @param Baseballcard newCard
	    *    A BaseballCard
	    * 
	    * 
	    *
	    *    
	    * @exception FullCollectionException
	    * 		Thrown when the collection is full.
	    * @exception IllegalArgumentException
	    * 		Thrown when the position is invalid. (Lower than 1 or greater than cards_in_list)
	    **/
	
	public void addCard(BaseballCard newCard) throws FullCollectionException, IllegalArgumentException
	{
		addCard(newCard,size()+1);
	}
	
	
	
	
	/**
	    * Removes a card to the card collection.
	    *
	    * @param Baseballcard newCard
	    *    The first BaseballCard
	    * @param position
	    *    The position of the BaseballCard you want to add.
	    *
	    * <dt>Preconditions:
	    *    <dd> The position is between 1 and cards_in_list
	    *
	    * <dt>Postconditions:
	    *    <dd>The positions of the two items indicate that a card has been added into the collection.
	    *    
	    *    Decreases the number of cards in the list by one.
	    * @exception FullCollectionException
	    * 		Thrown when the collection is full.
	    * @exception IllegalArgumentException
	    * 		Thrown when the position is invalid. (Lower than 1 or greater than cards_in_list)
	    **/
	
	public void removeCard(int position) throws IllegalArgumentException {
		if(position < 1 || position > cards_in_list) 
			throw new IllegalArgumentException();
		
		for(int i=position;i<cards_in_list;i++) {
			cardList[i] = cardList[i+1];
		}

		cardList[cards_in_list] = null;
		cards_in_list--;
		
		
		
		
	}
	
	
	/**
	    * Retrieves card from the collection telling you its position. 
	    * 
	    * @param position
	    *    The position of the BaseballCard you want to add.
	    *
	    *    
	    * 
	    * @exception FullCollectionException
	    * 		Thrown when the collection is full.
	    * @exception IllegalArgumentException
	    * 		Thrown when the position is invalid. (Lower than 1 or greater than cards_in_list)
	    * 
	    * 
	    * @return
	    * 	returns the position of the card from the cardList.
	    **/
	
	
	public BaseballCard getCard(int position) throws IllegalArgumentException {
		if(position < 1 || position > cards_in_list)
			throw new IllegalArgumentException();
		
		return cardList[position];
		
		
	}
	
	
	
	
	/** This method trades the card from Collection A to Collection B while asking you what position you want the 
	 * BaseballCard to be.
	 * 
	 * @param other
	 * Since there are two Collections, this represents the other Collection, in this case, Colleciton B.
	 * @param myPosition
	 * The position of the first BaseballCard you want to trade in
	 * @param theirPosition
	 * The position of the second BaseballCard you want to trade in 
	 * @throws IllegalArgumentException
	 * An exception in case the Card list is full for both Collections. 
	 */
	public void trade(CardCollection other, int myPosition, int theirPosition) throws IllegalArgumentException {
		if(myPosition < 1 || myPosition > cards_in_list)
			throw new IllegalArgumentException();
		if(theirPosition < 1 || theirPosition > other.cards_in_list)
			throw new IllegalArgumentException();
		BaseballCard temp = cardList[myPosition];
		
		cardList[myPosition] = other.cardList[theirPosition];
		other.cardList[theirPosition] = temp;
	}
	
	/**
	 * @param card
	 * This is the BaseballCard
	 * @return
	 * Returns True if the BaseballCard exists in that cardList position.
	 * returns false otherwise.
	 */
	public boolean exists(BaseballCard card) {
		for(int i=1;i<=cards_in_list;i++) 
			if(card.equals(cardList[i]))
				return true;
		
		
		return false;
	}
	
	/**
	 * This makes sure all the printed cards remain as a String.
	 * 
	 */
	public void printAllCards() {
		System.out.print(this.toString());
		
	}
	

	/**
	 * Returns a formatted string of each BaseballCard on a table-like String
	 * 
	 * <dt><b>Preconditions:</b> 
	 * <dd>This Menu object has been instantiated
	 * 
	 * <dt><b>Postcondition:</b> 
	 * <dd>A neatly formatted String of each BaseballCard in the Table with it's own discription
	 * 
	 * returns Results  
	 *  it returns the formatted table with everything that the user has inputed about the BaseballCard
	 * 
	 */
	
	public String toString() {
		String results = "";

		results += String.format("%-3s%-25s%-25s%-6s%-8s%-12s","#","Name","Manufacturer","Year","Price","Size");
		results += "\n";
		results += String.format("%-3s%-25s%-25s%-6s%-8s%-12s","--","----","------------","----","-----","----");
		results += "\n";
		
		for(int i=1;i<=cards_in_list;i++) {
			results += String.format("%-3d%-25s%-25s%-6d%-1s%-7.2f%-12s",i,cardList[i].getPlayerName(),cardList[i].getCardManufacturer(),cardList[i].getYear(),"$",cardList[i].getPrice(),cardList[i].getSizeX() + "x" + cardList[i].getSizeY());
			results += "\n";
		
		}
		return results;
		
	}
}
