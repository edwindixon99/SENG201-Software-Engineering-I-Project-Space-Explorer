package game;



import java.util.ArrayList;
import java.util.Random;
/**
 * This class contains variables and methods that affect or concern individual crew members statistics
 *
 * @author  
 * @version 15/05/2019.
 */
public class CrewMember {
	/**
	 *The crew members name
	 */
	private String name;
	/**
	 * The number of actions the crew member has left
	 */
	private int actionCounter = 2;
	/**
	 * The health level of the crew member
	 */
	private int healthLevel = 100;
	/**
	 * The hunger level of the crew member
	 */
	private int hungerLevel = 100;
	/**
	 * The tiredness level for the crew member
	 */
	private int tiredness = 100;
	/**
	 * A boolean for if the crew member has space plague
	 */
	private boolean spacePlague;
	/**
	 * The final amount of health taken away at the start of each new day.
	 */
	private int finalHealthDegrade;
	/**
	 * Affects the rate that the crew members health goes down at the start of a new day
	 */
	private int healthDegrade;
	/**
	 * Affects the rate at which the crew members hunger level goes down at the start of a new day
	 */
	private int hungerDegrade;
	/**
	 * Affects the rate at which the crew members tiredness goes down at the start of a new day
	 */
	private int tirednessDegrade;
	/**
	 * Calculates the crew members health, hunger and tiredness level at the start of a new day. Also resets the action counter to 2.
	 */
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
	/**
	 * The crew member eats some food, which will increase their hunger level
	 * @param food	The food object that the crew member is eating	
	 */
	public void eat(Food food) {
		hungerLevel = hungerLevel + food.getHungerRemoved();
		if (hungerLevel > 100){ 
			hungerLevel = 100;
		}
		if (hungerLevel < 0) {
			hungerLevel = 0;
		}
	}
	/**
	 * Decides what the crew member will find while searching the nearest planet
	 *
	 * @param memSearch		The crew member searching the planet
	 * @return 			The number which will correspond to what the player will find on the planet.
	 */
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
	
	/**
	 * Makes a crew member go to sleep, which restores their tiredness level
	 *
	 */
	
	public void sleep() {
		tiredness += 100000;
		if (tiredness > 100){
			tiredness = 100;
		}
		actionCounter -= 1;
	}
	
	/**
	 * Heals the crew member.
	 *
	 * @param medicine		The medical item being used to heal the crew member
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
	/**
	 * Allows the player to view the stats of the crew member
	 *
	 * @return 			The stats or the crew member, in the form of a string
	 */
	public String viewStatus() {
		return (name + "'s status: \nHealth level: " + healthLevel + "\nHunger level: " + hungerLevel + "\nTiredness: " + tiredness + "\nSpacePlague: " + spacePlague + "\nActions left: " + actionCounter + "\n");	
	}
	/**
	 * Decides whether the crew member is dead, based on their health level
	 *
	 * @return 			A boolean, dictating whether they are dead or not
	 */
	public boolean isDead() {
		if (healthLevel <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return 			The crew members name as a string
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name		The name of the crew member
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return 			The crew members health level
	 */
	public int getHealthLevel() {
		return healthLevel;
	}
	/**
	 * @param healthLevel		The crew members health level
	 */
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}
	/**
	 * @return 			The crew members hunger level
	 */
	public int getHungerLevel() {
		return hungerLevel;
	}
	/**
	 * @param hungerLevel		The crew members hunger level
	 */
	public void setHungerLevel(int hungerLevel) {
		this.hungerLevel = hungerLevel;
	}
	/**
	 * @return 			The crew members tiredness level
	 */
	public int getTiredness() {
		return tiredness;
	}
	/**
	 * @param tiredness		The crew members tiredness
	 */
	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	} 
	/**
	 * @return 			A boolean dictating whether the crew member has space plague
	 */
	public boolean hasSpacePlague() {
		return spacePlague;
	}
	/**
	 * @param spacePlague		A boolean which is if the crew member has space plague
	 */
	public void setSpacePlague(boolean spacePlague) {
		this.spacePlague = spacePlague;
	}
	/**
	 * @return 			The number of actions the player has remaining
	 */
	public int getActionCounter() {
		return actionCounter;
	}
	/**
	 * @param actionCounter		The amount of actions the player can perform
	 */

	public void setActionCounter(int actionCounter) {
		this.actionCounter = actionCounter;
	}
	/**
	 * @return 			The rate of which the crew members hunger degrades
	 */
	public int getHungerDegrade() {
		return hungerDegrade;
	}
	/**
	 * @param hunger		The rate which the crew members hunger declines
	 */
	public void setHungerDegrade(int hunger) {
		this.hungerDegrade = hunger;
	}
	/**
	 * @return 			The rate of which the crew members health degrades
	 */
	public int getHealthDegrade() {
		return healthDegrade;
	}
	/**
	 * @param health		The rate which the crew members health level declines
	 */
	public void setHealthDegrade(int health) {
		this.healthDegrade = health;
	}
	/**
	 * @return 			The rate of which the crew members tiredness level degrades
	 */
	public int getTirednessDegrade() {
		return tirednessDegrade;
	}
	/**
	 * @param tiredness		The rate which the crew members tiredness declines
	 */
	public void setTirednessDegrade(int tired) {
		this.tirednessDegrade = tired;
	}
	

	

}
