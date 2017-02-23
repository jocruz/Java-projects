/**
* The <code>BaseballCard</code> class is a representation of a baseball card which has the values
* • playerName -- the name of the baseball player
* • cardManufacturer -- the manufacturer of the baseball card
* • year -- the year the card was made
* • price -- the price of the card
* • imageSize[] -- an array of two elements, the first being the X dimension and the second being the Y dimension, representing 
* 	the actual physical size of the baseball card.
*    
*    
* This BaseballCard object is to be stored in the CardCollection data structure.
*
* @author John Cruz
*    e-mail: john.cruz@stonybrook.edu		
*    Stony Brook ID: 108605747
**/

import java.util.*;

public class BaseballCard implements Cloneable  {

	private String playerName; //player’s name (String)
	private String cardManufacturer; // the card’s manufacturer (String)
	private int year; // year (int)
	private double price; // price (double)
	private int [] imageSize = new int [2];  // image size (int[], an integer array of size 2, representing the size along the x and y axes respectively)
	
	
	/**
	 * Creates an instance of the BaseballCard using parameters:
	 * 
	 * @param playerName
	 *  The name of the player's name
	 *  
	 * @param cardManufacturer
	 * 	The card's Manufacturer
	 * @param year
	 * 	The card's year
	 * @param price
	 * 	The card's price
	 * @param x
	 * 	The card's x size
	 * @param y
	 * 	The card's y size
	 * 
	 * <dt><b>Postcondition:</b> 
	 * <dd>BaseballCard has been initialized with given parameters 
	 * 
	 */
	public BaseballCard (String playerName, String cardManufacturer, int year, double price, int x, int y)
	{ 
		
		this.playerName = playerName;
		this.cardManufacturer = cardManufacturer;
		this.year = year;
		this.price = price;
		this.imageSize[0] = x;
		this.imageSize[1] = y;
		
	}
	
	
	/**
	 * Empty constructor
	 * Set all parameters to null. 
	 */
	
	public BaseballCard() {
		
		
	}

	

	@Override
	/**
	 *  Generate a copy of BaseballCard
	 *  
	 *  @return
	 *  This returns a copy of the BaseballCard but is named newCard
	 */
	public Object clone()
	{
		BaseballCard newCard = new BaseballCard();
		
		newCard.setPlayerName(this.getPlayerName());
		newCard.setCardManufacturer(this.getCardManufacturer());
		newCard.setYear(this.getYear());
		newCard.setPrice(this.getPrice());
		newCard.setSizeX(this.getSizeX());
		newCard.setSizeY(this.getSizeY());
		
		return newCard;
		
	}
	/**
	    * Compare this BaseballCard to another object for equality.
	    * 
	    * @param obj
	    * an object to which this BaseballCard is compared.
	    * 
	    * @return
	    * A return value of true indicates that obj refers to a 
	    * BaseballCard object with the same content
	    * 
	    * If the content is not the same, it will return false, other wise it will return true.
	    */
	
	 public boolean equals(Object obj)
	 {
		 //Typecast obj into BaseballCard
		 BaseballCard newCard = (BaseballCard)obj;
		 
		 
		 //Check attributes for equality
		 if(!newCard.getPlayerName().equals(this.getPlayerName()))
			 return false;
		 else if(!newCard.getCardManufacturer().equals(this.getCardManufacturer()))
			 return false;
		 else if(newCard.getYear() != this.getYear())
			 return false;
		 else if(newCard.getPrice() != this.getPrice())
			 return false;
		 else if(newCard.getSizeX() != this.getSizeX())
			 return false;
		 else if(newCard.getSizeY() != this.getSizeY())
			 return false;
		 
		 //All attributes are equal, return true
		 return true;
		 
	 }
	

		
		/**
		 * This gets the Player's name 
		 * 
		 * @return
		 * This returns the name of the player's name.
		 */
		public String getPlayerName ()
		{
				return playerName;
		}
		
		/**
		 * This gets the Card Manufacturer 
		 * 
		 * @return
		 * This returns the Card Manufacturer.
		 */
		public String getCardManufacturer ()
		{
			return cardManufacturer;
		}
		
		/**
		 * This gets the Year of the card
		 * 
		 * @return
		 * This returns the Year.
		 */
		
		public int getYear ()
		{
			return year;
		}
		
		/**
		 * This gets the Price of the card
		 * 
		 * @return
		 * This returns the Price.
		 */
		public double getPrice()
		{
			
			return price;
		}
		
		/**
		 * This gets the size of the card, but only the x size.
		 * 
		 * @return
		 * This returns SizeX.
		 */
		
		public int getSizeX()
		{
			return imageSize[0];
		}
		
		/**
		 * This gets the size of the card, but only the y size.
		 * 
		 * @return
		 * This returns SizeY.
		 */
		public int getSizeY()
		{
			return imageSize[1];
		}

		
	/**
	 * This sets the Player's Name.
	 * 
	 * @param pn
	 * The player's name to set to the card and menu.
	 */
	public void setPlayerName (String pn)
	{
		this.playerName = pn;
		
		
	}
	
	
	/**
	 * This sets the Card's Manufacturer.
	 * 
	 * @param cmf
	 * 
	 * This 
	 */
	public void setCardManufacturer(String cmf)
	{
		this.cardManufacturer = cmf;
	}
	
	public void setYear (int yr)
	{
		this.year = yr;
	}
	
	/**
	 * Sets the price of the BaseballCard.
	 * 
	 * @param price
	 * 		the price to set to BaseballCard.
	 *  
	 * <dt><b>Preconditions:</b> 
	 * <dd> Price is a non negative value 
	 * 
	 * @exception IllegalArgumentException
	 * 	Indicated that price parameter is negative
	 * 
	 */
	public void setPrice (double precio)
	{
		if (price < 0)
		{
		throw new IllegalArgumentException("Invalid price.");
		}
			
		
		this.price = precio;
	}
	
	
	/** This sets the size for the BaseballCard, it is named size X because it is one of the coordinates for the BaseballCard.
	 * 
	 * @param sizeX
	 * 	This size set to the BaseballCard
	 */
	public void setSizeX ( int sizeX)
	{
		this.imageSize[0] = sizeX;
	}
	
	/** This sets the size for the BaseballCard, it is named size Y because it is one of the coordinates for the BaseballCard.
	 * 
	 * @param sizeY
	 * 	This size set to the BaseballCard
	 */
	public void setSizeY ( int sizeY)
	{
		this.imageSize[1] = sizeY;
	}

	
}
