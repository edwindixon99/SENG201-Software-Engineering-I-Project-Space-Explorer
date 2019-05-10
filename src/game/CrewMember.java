package game;



import java.util.ArrayList;
import java.util.Random;

public class CrewMember {
	private String name;
	private int actionCounter = 200;
	private int healthLevel = 100;
	private int hungerLevel = 100;
	private int tiredness = 100;
	private boolean spacePlague;
	private int finalHealthDegrade;
	private int healthDegrade;
	private int hungerDegrade;
	private int tirednessDegrade;
	

	public void newDay() {
		tiredness -= tirednessDegrade;
		hungerLevel -= hungerDegrade;
		actionCounter = 2;
		if (hasSpacePlague() == true) {
			finalHealthDegrade += (getHealthLevel() / 5);
		}
		if (hungerLevel <= 0) {
			hungerLevel = 0;
			finalHealthDegrade += 30;
		}
		if (tiredness <= 0) {
			tiredness = 0;
			finalHealthDegrade += 30;
		}
		setHealthLevel(getHealthLevel() - (finalHealthDegrade / healthDegrade));
		finalHealthDegrade = 0;
	}
	
	public void eat(Food food) {
		hungerLevel = hungerLevel + food.getHungerRemoved();
		if (hungerLevel > 100){  //  Keeps hungerLevel above 0
			hungerLevel = 100;
		}
		if (hungerLevel < 0) {
			hungerLevel = 0;
		}
	}
	public int search(CrewMember memSearch) {
		Random rand = new Random();
		if (memSearch instanceof Type5) {
			int search = rand.nextInt(6);
			search += 1;
			if (search == 1 || search == 2 || search == 3 || search == 4) {
				return 2;}
			if (search == 5) {
				return 1;
			}
			else {
				return 3;
			}
		}
		else {
			int search = rand.nextInt(3);
			search += 1;
			if (search == 2) {
				return 2;}
			if (search == 3) {
				return 3;}
			else {
				return 1;}
		}
	}
	
	/*
	 * sleep function reduces the tiredness amount by a number
	 */
	
	public void sleep() {
		tiredness += 100000;
		if (tiredness > 100){    // Keeps tiredness above 0
			tiredness = 100;
		}
		actionCounter -= 1;
	}
	
	/*
	 * heal function increases the healthLevel by value associated with MedicalItem
	 * 
	 * NOT FINISHED YET Still need to: 
	 * delete the MedicalItem from Crew.medicalItems
	 * Done this in game environment, but could still add it here if you want to make it more 'modular'
	 */
	
	public void heal(MedicalItem medicine) {
		setHealthLevel(getHealthLevel() +  medicine.getHealingAmount());
		if (healthLevel > 100){  // Keeps healthLevel below a cap
			healthLevel = 100;
		}
		if (medicine.isSpacePlagueCure()) {
			setSpacePlague(false);  // Removes space plague 
		}
	}
	
	public String viewStatus() {
		return (name + "'s status: \nHealth level: " + healthLevel + "\nHunger level: " + hungerLevel + "\nTiredness: " + tiredness + "\nSpacePlague: " + spacePlague + "\nActions left: " + actionCounter + "\n");	
	}
	
	public boolean isDead() {
		if (healthLevel <= 0) {
			System.out.println(name + "  has died, due to their health level dropping to 0.\n");
			return true;
		}
		return false;
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
	public int getHungerDegrade() {
		return hungerDegrade;
	}

	public void setHungerDegrade(int hunger) {
		this.hungerDegrade = hunger;
	}
	public int getHealthDegrade() {
		return healthDegrade;
	}

	public void setHealthDegrade(int health) {
		this.healthDegrade = health;
	}
	public int getTirednessDegrade() {
		return tirednessDegrade;
	}

	public void setTirednessDegrade(int tired) {
		this.tirednessDegrade = tired;
	}
	

	

}
