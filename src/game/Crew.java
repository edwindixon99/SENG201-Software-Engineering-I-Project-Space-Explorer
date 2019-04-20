package game;


import java.util.ArrayList;


public class Crew {
	private SpaceShip ship;
	private ArrayList<CrewMember> crewMemberList = new ArrayList<CrewMember>();
	private ArrayList<Food> foodItems = new ArrayList<Food>();
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<Item> Items = new ArrayList<Item>();
	private double money = 0;
	private int numPieces = 0;
	private ArrayList<CrewMember> pilotCount = new ArrayList<CrewMember>();
	
	
	public void buy(SpaceOutpost spaceOutpost,Item item) {
		if (item.getPrice() > getMoney()) {
			System.out.println("Not enough money for purchase");
		}else {
			setMoney(getMoney() - item.getPrice());
			System.out.println("Successful Purchase of " + item.getName());
			if (item instanceof Food) {
				buyFood((Food) item);  		// casts item to food then calls buyFood() to add to foodList
			}else {
				buyMedicalItem((MedicalItem) item); 		// casts item to medicalItem "" "" "" "" "" medicalItemList
			}
	}}
	
	
	public void buyFood(Food item) {             
		ArrayList<Food> foodItems = getFoodItems();
		foodItems.add(item);
		setFoodItems(foodItems);
	}
	
	
	public void buyMedicalItem(MedicalItem item) {             
		ArrayList<MedicalItem> medicalItems = getMedicalItems();
		medicalItems.add(item);
		setMedicalItems(medicalItems);
		}
	
	
	 public static void main(String[] args) {  			// random testing
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
		team.buy(chch, apple);
		team.setMoney(10000000);
		System.out.println(chch.getItemsForSale());
		team.buy(chch, apple);
		System.out.println(chch.getItemsForSale());
		System.out.println(team.getFoodItems());
		System.out.println(team.getMoney());
	 }
		
		
		
			
			
	
	
	
	/* Getters and Setters for 
	 * ship
	 * crewMemebrList
	 * foodItems
	 * MedicalItems
	 * money
	 */
	public void setPilotCount(ArrayList<CrewMember> pilotCount) {
		this.pilotCount = pilotCount;
	}
	public ArrayList<CrewMember> getPilotCount() {
		return pilotCount;
	}
	public int getNumPieces() {
		return numPieces;
	}
	public void setNumPieces(int pieces) {
		this.numPieces = pieces;
	}
	
	public SpaceShip getShip() {
		return ship;
	}
	public void setShip(SpaceShip ship) {
		this.ship = ship;
	}

	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public ArrayList<MedicalItem> getMedicalItems() {
		return medicalItems;
	}
	public void setMedicalItems(ArrayList<MedicalItem> medicalItems) {
		this.medicalItems = medicalItems;
	}
	public ArrayList<Food> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(ArrayList<Food> foodItems) {
		this.foodItems = foodItems;
	}
	
	public ArrayList<CrewMember> getCrewMemberList() {
		return crewMemberList;
	}
	public void setCrewMemberList(ArrayList<CrewMember> crewMemberList) {
		this.crewMemberList = crewMemberList;
	}



	public ArrayList<Item> getItems() {
		return Items;
	}



	public void setItems(ArrayList<Item> items) {
		Items = items;
	}
	
	
	

}
