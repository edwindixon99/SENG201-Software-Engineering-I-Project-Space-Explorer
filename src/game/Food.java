package game;
/**
 * This is the class for Food items, which is an extension of the Item class. It contains all variables and methods that are specifically for Food items alone
 *
 * @author  
 * @version 15/05/2019.
 */
public class Food extends Item{
	/**
	 * The amount of hunger that the food item will restore.
	 */
	private int hungerRemoved;
	
	/**
	 * A constructor for Food. It will set the name, price, and the hunger removed for all food items
	 * @param tempName		The name of the Food item.
	 * @param tempHungerRemoved		How much hunger the food item will restore
	 * @param tempPrice		The price of the Food item
	 * 
	 */
	public Food(String tempName, int tempHungerRemoved, double tempPrice) {
		setName(tempName);
		setHungerRemoved(tempHungerRemoved);
		setPrice(tempPrice);
	}

	/**
	 * Returns a food object in the form of a string. It was used for testing and is no longer used.
	 * @return		A string that contains all of the attributes of the food item
	 */
	public String toString() {	
		return "Food: " + getName() + "\nPrice: " + Double.toString(getPrice()) + "\nRemoved Hunger: " +  Integer.toString(hungerRemoved);
		}
	/**
	 * @return		The amount of hunger that is restored form eating the food object
	 */
	public int getHungerRemoved() {
		return hungerRemoved;
	}

	/**
	 * @param hungerRemoved 		The amount of hunger that is restored from eating the food object
	 */
	public void setHungerRemoved(int hungerRemoved) {
		this.hungerRemoved = hungerRemoved;
	}

}
