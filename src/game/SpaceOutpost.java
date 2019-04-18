package game;

import java.util.ArrayList;

public class SpaceOutpost {
	private String name;
	private ArrayList<Item> itemsForSale;

	
	// Constructor for SpaceOutpost
	public SpaceOutpost(String tempname, ArrayList<Item> tempItemsForSale) {
		name = tempname;
		setItemsForSale(tempItemsForSale);	
	}
	
	
	/*
	 * methods required include
	 * buy(Item item)
	 * view(Item item)
	 */
	
	
	
	
	
	/*
	 * Getter and Setters for 
	 * name
	 * itemsForSale
	 */
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Item> getItemsForSale() {
		return itemsForSale;
	}


	public void setItemsForSale(ArrayList<Item> itemsForSale) {
		this.itemsForSale = itemsForSale;
	}
	


}
