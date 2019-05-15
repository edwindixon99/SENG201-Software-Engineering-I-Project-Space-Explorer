package game;

import java.util.ArrayList;
/**
 * This is the class for the space outpost, which is where the crew can view their owned items, as well as buying new ones
 *
 * @author  
 * @version 15/05/2019.
 */
public class SpaceOutpost {
	/**
	 * The name of the outpost
	 */
	private String name;
	/**
	 * An array list containing the items for sale at the outpost
	 */
	private ArrayList<Item> itemsForSale  = new ArrayList<Item>();
	/**
	 * @return		The name of the outpost
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name		The name of the outpost
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return		An array list containing all of the items for sale at the outpost
	 */
	public ArrayList<Item> getItemsForSale() {
		return itemsForSale;
	}
	/**
	 * Creates and sets all of the possible items for sale at the outpost
	 */
	public void setItemsForSale(){
		Food Apple = new Food("Apple", 15, 7);
		itemsForSale.add(Apple);
		Food Sandwich = new Food("Sandwich", 25, 12);
		itemsForSale.add(Sandwich);
		Food Pie = new Food("Pie", 30, 15);
		itemsForSale.add(Pie);
		Food Burger = new Food("Burger", 40, 20);
		itemsForSale.add(Burger);
		Food Pizza = new Food("Pizza", 50, 25);
		itemsForSale.add(Pizza);
		Food Biscut = new Food("Biscut", 10, 5);
		itemsForSale.add(Biscut);
		Item SmallHealing = new MedicalItem("SmallHealing", false, 10, 5);
		itemsForSale.add(SmallHealing);
		Item BigHealing = new MedicalItem("Big Healing", false, 40, 20);
		itemsForSale.add(BigHealing);
		Item Spaceplaguecure = new MedicalItem("Space Plague Cure", true, 0, 15);
		itemsForSale.add(Spaceplaguecure);
	}


}
