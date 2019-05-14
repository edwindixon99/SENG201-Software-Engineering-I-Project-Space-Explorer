package game;


import java.util.ArrayList;


public class Crew {
    /**
	 * An arrayList containing all the crew members
	 */
	private ArrayList<CrewMember> crewMemberList = new ArrayList<CrewMember>();
    /**
	 * An arrayList containing all the food items the crew owns
	 */
	private ArrayList<Food> foodItems = new ArrayList<Food>();
    /**
	 * An arrayList containing all of the crew medical items
	 */
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
    /**
	 * The crews money
	 */
	private double money = 0;
    /**
	 * The number of transporter pieces that the crew have found
	 */
	private int numPieces = 0;
    /**
	 * An arrayList containing all the crew members that are ready to pilot the ship to a new planet
	 */
	private ArrayList<CrewMember> pilotCount = new ArrayList<CrewMember>();
    /**
	 * The number of days the game has been going
	 */
	private int days = 1;
    /**
	 * The required number of pieces the player has to find to win the game
	 */
	private int requiredPieces;
	
	/**
	 * Checks whether the crew has enough money to buy an item, and if so buys it for them
	 *
	 * @param foodList		The list of food the crew owns
	 * @param medList		The list of medicine the crew owns
	 * @param item		The item that the crew wants to buy
	 * @return 			A message signifying whether the crews purchase was succesful or not
	 */
	public String buy(ArrayList<Food> foodList, ArrayList<MedicalItem> medList, Item item) {
		String finalString = "";
		if (item.getPrice() > getMoney()) {
			finalString += "Not enough money for purchase";
		}else {
			setMoney(getMoney() - item.getPrice());
			finalString += "Successful Purchase of " + item.getName();
			if (item instanceof Food) {
				buyFood(foodList, (Food) item);  		// casts item to food then calls buyFood() to add to foodList
			}else {
				buyMedicalItem(medList, (MedicalItem) item); 		// casts item to medicalItem "" "" "" "" "" medicalItemList
			}		
		}
		return finalString;
	}
	
	/**
	 * Adds the bought food item to the crews food list
	 *
	 * @param foodList		The list of food the crew owns
	 * @param item		The Food item that the crew bought
	 */
	public void buyFood(ArrayList<Food> foodList, Food item) {   
		foodList.add(item);
	}
	
	/**
	 * Adds the bought medical item to the crews Medical items list
	 *
	 * @param medList		The list of medicine the crew owns
	 * @param item		The Medical item that the crew bought
	 */
	public void buyMedicalItem(ArrayList<MedicalItem> medList, MedicalItem item) {             
		medList.add(item);
		}
	/* Getters and Setters for 
	 * ship
	 * crewMemebrList
	 * foodItems
	 * MedicalItems
	 * money
	 * days
	 */
	
	 public int getRequiredPieces() {
		return requiredPieces;
	}
	 public void setRequiredPieces(int pieces) {
	 	this.requiredPieces = pieces;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int day) {
		this.days = day;
	}
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

	
	
	

}
