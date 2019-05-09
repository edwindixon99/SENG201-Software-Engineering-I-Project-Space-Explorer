package game;

public class Food extends Item{
	private int hungerRemoved;
	
	// Constructor for Food
	public Food(String tempName, int tempHungerRemoved, double tempPrice) {
		setName(tempName);
		setHungerRemoved(tempHungerRemoved);
		setPrice(tempPrice);
	}
	
	public String toString() {	
		return "Food: " + getName() + "\nPrice: " + Double.toString(getPrice()) + "\nRemoved Hunger: " +  Integer.toString(hungerRemoved);
		}
	
	
	
	
	/* Getter and Setter for 
	 * hungerRemoved
	 */
	public int getHungerRemoved() {
		return hungerRemoved;
	}

	
	public void setHungerRemoved(int hungerRemoved) {
		this.hungerRemoved = hungerRemoved;
	}

}
