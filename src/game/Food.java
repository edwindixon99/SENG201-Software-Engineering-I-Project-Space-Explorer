package game;

public class Food extends Item{
	private int hungerRemoved;
	
	// Constructor for Food
	public Food(String tempName, int tempHungerRemoved, float tempPrice) {
		setName(tempName);
		setHungerRemoved(tempHungerRemoved);
		setPrice(tempPrice);
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
