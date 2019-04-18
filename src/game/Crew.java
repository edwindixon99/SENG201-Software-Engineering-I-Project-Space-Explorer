package game;


import java.util.ArrayList;


public class Crew {
	private String name;
	private SpaceShip ship;
	private ArrayList<CrewMember> crewMemberList = new ArrayList<CrewMember>();
	//private ArrayList<Food> foodItems = new ArrayList<Food>();
	//private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<Item> Items = new ArrayList<Item>();    // I commented out the Food and medical items lists and the getters and setters. just testing with one list to see how it is. 
	private double money = 0;
	
	
	public Crew(String tempName) {
		name = tempName;
	}
	
	
	
	/* Getters and Setters for 
	 * name
	 * ship
	 * crewMemebrList
	 * foodItems
	 * MedicalItems
	 * money
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	/*public ArrayList<MedicalItem> getMedicalItems() {
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
	*/
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
