package game;

import java.util.ArrayList;

public class SpaceOutpost {
	private String name;
	private ArrayList<Item> itemsForSale  = new ArrayList<Item>();

	
	
	
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
	
	public static void main(String[] args) {    // random testing
		
		Crew team = new Crew();
		System.out.println(team.getMoney());
		System.out.println(team.getItems());
		SpaceShip rocket = new SpaceShip();
		System.out.println(rocket.getShieldHealth());
		team.setShip(rocket);
		Food apple = new Food("apple", 10, 2.5);
		Food bapple = new Food("bapple", 22, 2.3);
		MedicalItem pills = new MedicalItem("pills", true, 60, 30);
		ArrayList<Item> itemsForSale = new ArrayList<Item>();
		itemsForSale.add(pills);
		itemsForSale.add(apple);
		itemsForSale.add(bapple);
	}


}
