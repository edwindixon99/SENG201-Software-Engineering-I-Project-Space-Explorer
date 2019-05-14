package game;
/**
 * This is class Item. Items are used in the game. Food and MedicalItem are the two types of Item.
 *
 * @author  
 * @version 14/05/2019.
 */
public class Item {
	/**
	 * The name of the item.
	 */
	private String name;
	/**
	 * The price of the item in dollars.
	 */
	private double price;
	

	
	/**
	 * @return		The item's name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name			The name for the item.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return		The item's price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price			The price for the item.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Turns the Item object into a String object. It was used for testing and is no longer used.
	 * @return		The name of the item.
	 */
	public String toString() {   // For testing: printing out Items
		return name;
	}

}
