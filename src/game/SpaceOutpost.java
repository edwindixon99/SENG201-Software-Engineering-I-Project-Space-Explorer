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

	public void view(Item item){
		String name = item.getName();
		double price = item.getPrice();
		if (item instanceof Food) {                    // Creates a println for Food
			Food foodItem = (Food) item;				// casts item to food to use Food's methods
			int hungerRemoved = foodItem.getHungerRemoved();
			System.out.println("Food: " + name + "\nPrice: " + Double.toString(price) + "\nRemoved Hunger: " +  Integer.toString(hungerRemoved));
		}
		else {											// Creates a println for MedicalItem
			MedicalItem medicalItem = (MedicalItem) item;		// casts medicalItem to food to use MedicalItems's methods
			int healingAmount = medicalItem.getHealingAmount();
			String spacePlagueCure = "No";
			if (medicalItem.isSpacePlagueCure()) {
				spacePlagueCure = "Yes";
			}
			System.out.println("Medicine: " + name + "\nPrice: " + Double.toString(price) + "\nHealing Amount: " +  Integer.toString(healingAmount) + "\nSpace Plague Cure: " + spacePlagueCure);
		}
		
	}
	
	
	
	
	
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
		SpaceOutpost chch = new SpaceOutpost("chch", itemsForSale);
		chch.view(apple);
		chch.view(pills);
		team.buy(chch, apple);
		team.setMoney(10000000);
		System.out.println(chch.getItemsForSale());
		team.buy(chch, pills);
		team.buy(chch, apple);
		System.out.println(chch.getItemsForSale());
		System.out.println(team.getFoodItems());
		System.out.println(team.getMoney());
		
		
		
	}


}
