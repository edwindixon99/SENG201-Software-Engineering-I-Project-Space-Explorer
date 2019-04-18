package game;


import java.util.ArrayList;


public class Crew {
	private SpaceShip ship;
	private ArrayList<CrewMember> crewMemberList = new ArrayList<CrewMember>();
	private ArrayList<Food> foodItems = new ArrayList<Food>();
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<Item> Items = new ArrayList<Item>();    // I made an item list and the getter and setter. just testing with one list to see how it is. 
	private double money = 0;
	
	
	public Crew() {
	}
	
	
	
	/* Getters and Setters for 
	 * ship
	 * crewMemebrList
	 * foodItems
	 * MedicalItems
	 * money
	 */
	
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
