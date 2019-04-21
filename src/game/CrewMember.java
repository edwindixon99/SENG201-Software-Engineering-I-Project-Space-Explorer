package game;


public class CrewMember {
	private String name;
	private int actionCounter = 2;
	private int healthLevel = 100;
	private int hungerLevel;
	private int tiredness;
	private boolean spacePlague;
	
	/*
	 * eat function subtracts value associated with food from hunger level
	 * 
	 * NOT FINISHED YET Still need to: 
	 * delete the food from Crew.foodItems
	 */
	public void eat(Food food) {
		hungerLevel = hungerLevel - food.getHungerRemoved();
		if (hungerLevel < 0){  //  Keeps hungerLevel above 0
			hungerLevel = 0;
		}
	}
	
	/*
	 * sleep function reduces the tiredness amount by a number
	 */
	
	public void sleep() {
		tiredness -= 100000;
		if (tiredness < 0){    // Keeps tiredness above 0
			tiredness = 0;
		}
	}
	
	/*
	 * heal function increases the healthLevel by value associated with MedicalItem
	 * 
	 * NOT FINISHED YET Still need to: 
	 * delete the MedicalItem from Crew.medicalItems
	 */
	
	public void heal(MedicalItem medicine) {
		healthLevel += medicine.getHealingAmount();
		if (healthLevel > 100){  // Keeps healthLevel below a cap
			healthLevel = 100;
		}
		if (medicine.isSpacePlagueCure()) {
			setSpacePlague(false);  // Removes space plague 
		}
	}
	
	
	public void viewStatus() {
		System.out.println(name + "'s status:");
		System.out.println("Health level: " + healthLevel + "\nHunger level: " + hungerLevel + "\nTirdness: " + tiredness + "\nSpacePlague: " + spacePlague + "\nActions left: " + actionCounter + "\n");	
	}

public static void main(String[] args) {
	CrewMember toy = new CrewMember();
	toy.setName("toy");
	toy.viewStatus(); 
}
	
	/* Getters and Setters for 
	 * name
	 * actionCounter
	 * healthLevel
	 * hungerLevel
	 * tiredness
	 * spacePlague
	 */

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHealthLevel() {
		return healthLevel;
	}
	
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public void setHungerLevel(int hungerLevel) {
		this.hungerLevel = hungerLevel;
	}

	public int getTiredness() {
		return tiredness;
	}

	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	} 

	public boolean hasSpacePlague() {
		return spacePlague;
	}

	public void setSpacePlague(boolean spacePlague) {
		this.spacePlague = spacePlague;
	}

	public int getActionCounter() {
		return actionCounter;
	}

	public void setActionCounter(int actionCounter) {
		this.actionCounter = actionCounter;
	}
	

	
	

}
