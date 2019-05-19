package game;
/**
 * This is the class Item. Items are used in the game. Food and MedicalItem are the two types of Item.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
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
	 * @return		A String. The item's name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name			A String. The name for the item.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return		A Double object. The item's price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price			A Double object. The price for the item.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Turns the Item object into a String object.
	 * @return		A String. The name of the item.
	 */
	public String toString() {  
		return name;
	}

}
