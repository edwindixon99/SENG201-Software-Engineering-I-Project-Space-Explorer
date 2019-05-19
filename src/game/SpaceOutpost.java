package game;

import java.util.ArrayList;
/**
 * This is the class for the space outpost. It has items that are available for the crew to buy.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
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
	 * @return		A String that is the name of the outpost
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name		A String that is the name of the outpost
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return		An ArrayList of Items containing all of the items for sale at the outpost
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
