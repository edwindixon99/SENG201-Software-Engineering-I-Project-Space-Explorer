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
	public String buy(Crew crew, Item item) {             // not finished yet
		if (item.getPrice() > crew.getMoney()) {
			return "Insufficient Funds";
		}else {	
			itemsForSale.remove(item);
			crew.setMoney(crew.getMoney() - item.getPrice());
			ArrayList<Item> crewItems = crew.getItems();
			crewItems.add(item);
			crew.setItems(crewItems);
			return "Success";
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
		ArrayList<Item> itemsForSale = new ArrayList<Item>();
		itemsForSale.add(apple);
		itemsForSale.add(bapple);
		SpaceOutpost chch = new SpaceOutpost("chch", itemsForSale);
		System.out.println(chch.buy(team, apple));
		team.setMoney(10000000);
		System.out.println(chch.buy(team, apple));
		
		
		
	}


}
