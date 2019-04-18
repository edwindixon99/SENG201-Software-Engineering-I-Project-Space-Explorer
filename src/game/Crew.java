package game;


import java.util.ArrayList;


public class Crew {
	private String name;
	private SpaceShip ship;
	private ArrayList<CrewMember> crewMemberList;
	private ArrayList<Food> foodItems;
	private ArrayList<MedicalItem> medicalItems;
	private float money = 0;
	
	
	
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

	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
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
	
	
	

}
