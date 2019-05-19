package game;


import java.util.ArrayList;

/**
 * This class contains methods and variables that relate or affect the crew
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
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
	 * @param foodList		An ArrayList of Food. The list of food the crew owns
	 * @param item		The Food object that the crew bought
	 */
	public void buyFood(ArrayList<Food> foodList, Food item) {   
		foodList.add(item);
	}
	
	/**
	 * Adds the bought medical item to the crews Medical items list
	 *
	 * @param medList		An ArrayList of MedicalItems. The list of medicine the crew owns
	 * @param item		The MedicalItem object that the crew bought
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
	/**
	 * @return 			An Integer. The number of pieces that the crew have found
	 */
	 public int getRequiredPieces() {
		return requiredPieces;
	}
		/**
		 * @param pieces			An Integer. The number of pieces that crew have yet to find
		 */
	 public void setRequiredPieces(int pieces) {
	 	this.requiredPieces = pieces;
	}
		/**
		 * @return 			An Integer. The number of days the crew have been playing
		 */
	public int getDays() {
		return days;
	}
	/**
	 * @param day			An Integer. The number of days that the crew have been playing
	 */
	public void setDays(int day) {
		this.days = day;
	}
	/**
	 * @param pilotCount			An ArrayList of CrewMembers. Contains all of the crew members ready to fly the ship to a new planet
	 */
	public void setPilotCount(ArrayList<CrewMember> pilotCount) {
		this.pilotCount = pilotCount;
	}
	/**
	 * @return 			An ArrayList of CrewMembers. crew members that are ready to pilot the ship
	 */
	public ArrayList<CrewMember> getPilotCount() {
		return pilotCount;
	}
	/**
	 * @return 			An Integer. The number of pieces that the crew have found
	 */
	public int getNumPieces() {
		return numPieces;
	}
	/**
	 * @param pieces			An Integer. The number of pieces the crew has already found
	 */
	public void setNumPieces(int pieces) {
		this.numPieces = pieces;
	}
	/**
	 * @return 			A Double object. The amount of money that the crew has
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money 			A Double object. The amount of money the crew has as a double
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	/**
	 * @return 			An ArrayList of MedicalItems containing all of the crews medical items
	 */
	public ArrayList<MedicalItem> getMedicalItems() {
		return medicalItems;
	}
	/**
	 * @param medicalItems 			An ArrayList of MedicalItems. Contains all the crews medical items
	 */
	public void setMedicalItems(ArrayList<MedicalItem> medicalItems) {
		this.medicalItems = medicalItems;
	}
	/**
	 * @return 			An ArrayList of Food containing all of the crews food items
	 */
	public ArrayList<Food> getFoodItems() {
		return foodItems;
	}
	/**
	 * @param foodItems			An ArrayList of Food. Contains the crews food items
	 */
	public void setFoodItems(ArrayList<Food> foodItems) {
		this.foodItems = foodItems;
	}
	/**
	 * @return 			An ArrayList of CrewMembers that are in the crew, and still alive
	 */
	public ArrayList<CrewMember> getCrewMemberList() {
		return crewMemberList;
	}
	/**
	 * @param crewMemberList			An ArrayList of CrewMembers containing all of the alive crew members in the crew
	 */
	public void setCrewMemberList(ArrayList<CrewMember> crewMemberList) {
		this.crewMemberList = crewMemberList;
	}

	
	
	

}
