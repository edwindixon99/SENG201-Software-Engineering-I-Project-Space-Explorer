package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomEvent {
	
	
	public void alienPirates(Crew crew) {
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
		System.out.println("Alien Pirates have boared the ship!\nThey have stolen the following item: " + randomItem.getName() + "\nThe Alien Pirates have disembarked.");
		}else {
			System.out.println("Alien Pirates have boared the ship!\n\nThe alien Pirates have disembarked");  		// crew item lists empty
			
		}
	}
		
		
	public void spacePlague(Crew crew) {
		Random rand = new Random();
		int CrewMemberListSize = crew.getCrewMemberList().size();
		if (crew.getCrewMemberList().size() > 0) {
			int n = rand.nextInt(CrewMemberListSize);
			ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
			for(int i = 0; i < CrewMemberListSize; i++) {
				randomNumbers.add(new Integer(i));
			}
			Collections.shuffle(randomNumbers);
			System.out.println("Members of the crew has been affected by Space Plague! \nCrew members affected will remain sick and loses more health each day until they take medicine for the space plague."); // Change this 
			for (int i = 0; i<=n; i++) {
				CrewMember crewMember = crew.getCrewMemberList().get(i);
				crewMember.setSpacePlague(true);
				Double healthLost = (double) crewMember.getHealthLevel() / 5;  // 5 could be changed to different number depending on amount health lost
				int healthLostRounded = healthLost.intValue();
				crewMember.setHealthLevel(crewMember.getHealthLevel() - healthLostRounded);
				System.out.println(crewMember.getName() + " has lost " + Integer.toString(healthLostRounded) + "HP and has contracted Space Plague!");
		}}
	}
			
			
	public void AsteroidBelt(SpaceShip ship) {
		Double amountOfDamage = (double) ship.getShieldHealth() / 5;  // 5 could be changed to different number depending on amount damage dealt
		int amountOfDamageRounded = amountOfDamage.intValue();
		ship.setShieldHealth(ship.getShieldHealth() - amountOfDamageRounded);
		System.out.println("Space Ship " + ship.getShipName() + " is going through an Asteroid Belt!\n" + ship.getShipName() + " suffered damage and lost " + Integer.toString(amountOfDamageRounded) + "% of shield health\nThe shield health is now " + Integer.toString(ship.getShieldHealth()) + "%");
		}
		
		
		
		
		

	public static void main(String[] args) {    // random testing
		
		Crew team = new Crew();
		System.out.println(team.getMoney());
		System.out.println(team.getItems());
		SpaceShip rocket = new SpaceShip();
		System.out.println(rocket.getShieldHealth());
		team.setShip(rocket);
		Food apple = new Food("apple", 10, 2.5);
		Food bapple = new Food("bapple", 22, 2.3);
		MedicalItem pills = new MedicalItem("pills", true, 60, 30);
		SpaceOutpost chch = new SpaceOutpost();
		chch.setItemsForSale();
		chch.view(apple, 1);
		chch.view((Item) pills, 2);
		team.buy(chch, apple);
		team.setMoney(10000000);
		System.out.println(chch.getItemsForSale());
		team.buy(chch, pills);
		System.out.println(team.getFoodItems());
		System.out.println(team.getMoney());
		RandomEvent pirates = new RandomEvent();
		pirates.alienPirates(team);
		System.out.println(team.getFoodItems());
		System.out.println(team.getMedicalItems());
		RandomEvent belt = new RandomEvent();
		rocket.setShieldHealth(100);
		rocket.setShipName("Y8JK");
		belt.AsteroidBelt(rocket);
		RandomEvent plague = new RandomEvent();
		ArrayList<CrewMember> crewMembers = team.getCrewMemberList();
		CrewMember red = new CrewMember();
		red.setName("red");
		crewMembers.add(red);
		CrewMember blue = new CrewMember();
		blue.setName("blue");
		crewMembers.add(blue);
		team.setCrewMemberList(crewMembers);
		plague.spacePlague(team);
			

		
		
	}

}
