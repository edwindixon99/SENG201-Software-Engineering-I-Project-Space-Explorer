package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomEvents {
	
	public String alienPirates(Crew crew) {
		String finalString = "";
		Random rand = new Random();
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Food> foods = crew.getFoodItems();
		ArrayList<MedicalItem> medicalItems = crew.getMedicalItems();
		items.addAll(medicalItems);					
		items.addAll(foods);								// combining food and medical items to items list
		if (items.size() > 0) {
			int n = rand.nextInt(items.size());				// RNG(
			Item randomItem = items.get(n);
			if (randomItem instanceof Food) {				// lines 19-24 is removing item from list it belongs to 
				foods.remove(randomItem);
				crew.setFoodItems(foods);
			}else {
				medicalItems.remove(randomItem);
				crew.setMedicalItems(medicalItems);
			}
			finalString += "Alien Pirates have boared the ship!\nThey have stolen the following item: " + randomItem.getName() + "\nThe Alien Pirates have disembarked.";
		}else {
			finalString += "Alien Pirates have boared the ship!\n\nThe alien Pirates have disembarked";  		// crew item lists empty
			
		}
		return finalString;
	}
		
		
	public String spacePlague(Crew crew) {
		String finalString = "";
		Random rand = new Random();
		int CrewMemberListSize = crew.getCrewMemberList().size();
		if (crew.getCrewMemberList().size() > 0) {
			int n = rand.nextInt(CrewMemberListSize);
			ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
			for(int i = 0; i < CrewMemberListSize; i++) {
				randomNumbers.add(new Integer(i));
			}
			Collections.shuffle(randomNumbers);
			finalString += "Members of the crew has been affected by Space Plague! \nCrew members affected will remain sick and loses more health each day until they take medicine for the space plague.\n"; // Change this 
			for (int i = 0; i<=n; i++) {
				CrewMember crewMember = crew.getCrewMemberList().get(i);
				if (!crewMember.hasSpacePlague()) {
					crewMember.setSpacePlague(true);  
					int healthLost = crewMember.getHealthLevel() / 5;			// 5 could be changed to different number depending on amount health lost
					crewMember.setHealthLevel(crewMember.getHealthLevel() - healthLost);
					finalString +=  crewMember.getName() + " has lost " + Integer.toString(healthLost) + "HP and has contracted Space Plague!\n";
				}
			}
		}
		return finalString;
	}
			
			
	public String asteroidBelt(SpaceShip ship) {
		int damageTaken;
		if (ship.getShieldHealth() < 25) {
			damageTaken = 10;
		}else {
			damageTaken = (int) (ship.getShieldHealth() / 2.5);
		}
		ship.setShieldHealth(ship.getShieldHealth() - damageTaken);
		return "Space Ship " + ship.getShipName() + " is going through an Asteroid Belt!\n" + ship.getShipName() + " suffered " + Integer.toString(damageTaken) + " damage to the shield health\nThe shield health is now " + Integer.toString(ship.getShieldHealth()) + "%\n";
	}
}
