package game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


class GameEnvironment {
	public static int requiredPieces;
	public static int planetPieces = 1;
	public static ArrayList<Food> foodList = new ArrayList<Food>();
	public static ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
	public static ArrayList<MedicalItem> medicalList = new ArrayList<MedicalItem>();
	public static ArrayList<CrewMember> pilotList = new ArrayList<CrewMember>();
	
	
    public static void main(String[] args) {
    	SpaceOutpost outpost = new SpaceOutpost();
    	outpost.setItemsForSale();
    	Crew crew1 = new Crew();
    	SpaceShip ship = new SpaceShip();
    	crew1.setFoodItems(foodList);
    	crew1.setCrewMemberList(crewList);
    	crew1.setMedicalItems(medicalList);
    	crew1.setPilotCount(pilotList);
    	/*Asks how many days the player wants the game to go for and stores it in days.
    	 * It will only accept inputs between 3 and 10.
    	 * I HVAE NOT YET MADE EXCEPTIONS FOR IF THE PLAYER ENTERS DIFFERENT TYPES OF INPUT E.G. STRING.
    	 */
    	Scanner input = new Scanner(System.in);
    	System.out.println("How many days would you like to play?");
    	int days = input.nextInt();
    	while (days < 3 || days > 10) {
    		System.out.println("You need to enter a number between 3 and 10.\nHow many days would you like to play?");
        	int days1 = input.nextInt();
        	days = days1;
    	}
    	requiredPieces = days * 2/3;
    	/* Asks how many crew members the player wants, and will only except a number between 2 and 4.
    	 * Stores the value in numCrew. May not be the most efficient way of doing this
    	 * I HAVE NOT DONE THE DIFFERENT TYPES OF CHARACTERS YET.
    	 */
    	System.out.println("How many crew Members would you like?");
    	int numCrew = input.nextInt();
    	while (numCrew < 2 || numCrew > 4) {
    		System.out.println("You need to select a number between 2 and 4.\nHow many crew Members would you like?");
        	int numCrew1 = input.nextInt();
        	numCrew = numCrew1;
    	}
    	/*Creates as many crew members as the player inputs, and stores them in an ArrayList.
    	 * Also asks the player what they want to name each crew member.
    	 */
    	for (int i=0; i < numCrew; i++) {
    		System.out.println("What do you want to name your " + (i+1) + "st crewmember?");
    		CrewMember newMember = new CrewMember();
    		String name  = input.next();
        	newMember.setName(name);
        	crewList.add(newMember);
    	}
    	/*
    	 * This creates a new instance of ship, and gives it a name, through prompts to the player. Also acts as the end of the set up
    	 */
    	System.out.println("What would you like to name your Spaceship");
    	String shipName = input.next();
    	ship.setShipName(shipName);
    	System.out.println("The game will now begin. To win, you will have to collect " + requiredPieces + " of your space ships missing pieces in " + days + " days.\n");
    	
    	/*
    	 * This is where the main game loop starts, obviously it is not done yet, there are still many features to add
    	 * It starts by asking what the player wants to do, with the first option being to check the crews stats.
    	 */
    	Scanner input0 = new Scanner(System.in);
    	while (crew1.getNumPieces() < requiredPieces) {
        	System.out.print("Pick what you want to do: \n1. View the crew members status.\n2. View your space ships status\n3. Visit nearest outpost.\n4. Eat a food item.\n5. Heal a Crew Member\n6. Get a crew member to sleep\n7. Repair the ship\n8. Search the nearest planet.\n9. Pilot ship to another planet");
        	int number = input0.nextInt();
        	if (number == 1) {
        		for (CrewMember member: crewList) {
        			System.out.println(member.getName() + "'s status:");
            		System.out.println("Health level: " + member.getHealthLevel() + "\nHunger level: " + member.getHungerLevel() + "\nTirdness: " + member.getTiredness() + "\nSpacePlague: " + member.hasSpacePlague() + "\nActions left: " + member.getActionCounter() + "\n");	
        		}
        		
        	}
        	/*option 2 is to check the shields stats ie just the shield level
        	 * 
        	 */
        	if (number == 2) {
        		System.out.println("\n" + ship.getShipName() + "'s status:");
        		System.out.println("Shield: " + ship.getShieldHealth() + "\n");
        	}
        	/*
        	 * option 3 is to go to the outpost, where the player can buy items form the shop, or look at their own items
        	 * I did not use the items for sale list in the outpost class, but could easily do so, as it will probably make it more efficient
        	 */
        	boolean leaveOutPost = false;
        	if (number == 3) {
        		while (leaveOutPost == false) {
        			System.out.println("Welcome to the space outpost, please choose what you would like to do: \n1. View owned items\n2. View Items for sale\n3. Go back");
            		
            		int postNumber = input0.nextInt();
            		if (postNumber == 1) {
            			if (foodList.isEmpty() == true) {
            				System.out.println("You have no Food items");
            			}
            			else {
            				TreeSet<String> stringFood;
            				ArrayList<String> stringFoodList;
            				stringFoodList = new ArrayList<String>();
            				stringFood = new TreeSet<String>();
            				for (Food food: foodList) {
            					stringFood.add(food.getName());
            					stringFoodList.add(food.getName());
            				}
            				System.out.println("Your Food items are:");
            	  			for (String food: stringFood) {
                				System.out.println(food + "(" + (Collections.frequency(stringFoodList, food)) + ")");	
            	  			}
            			}
            			if (medicalList.isEmpty() == true) {
            				System.out.println("You have no medical items\n");
            			}
            			else {
            				TreeSet<String> stringMed;
            				ArrayList<String> stringMedList;
            				stringMedList = new ArrayList<String>();
            				stringMed = new TreeSet<String>();
            				for (MedicalItem med: medicalList) {
            					stringMed.add(med.getName());
            					stringMedList.add(med.getName());
            				}
            				System.out.println("Your medical items are:");
            	  			for (String med: stringMed) {
                				System.out.println(med + "(" + (Collections.frequency(stringMedList, med)) + ")");	
            	  			}
            			}
            		}
            		if (postNumber == 2) {
            			boolean doneShopping = false;
            			int i = 0;
            			System.out.println("Pick the nuber of the item that you want to buy.\nYou have $" + crew1.getMoney() +" to spend");
            			for (Item item: outpost.getItemsForSale()) {
            				i++;
            				outpost.view(item, i);
            			}
            			while (doneShopping == false) {
            				int num = input0.nextInt();
                			if (num == 1) {
                				MedicalItem med = new MedicalItem("SmallHealing", false, 10, 5);
                				crew1.buy(outpost, med);
                			}
                			if (num == 2) {
                				MedicalItem med = new MedicalItem("Big Healing", false, 40, 20);
                				crew1.buy(outpost, med);
                			}
                			if (num == 3) {
                				MedicalItem med = new MedicalItem("Space plague cure", true, 0, 15);
                				crew1.buy(outpost, med);
                			}
                			if (num == 4) {
                				Food food = new Food("Biscut", 10, 5);
                				crew1.buy(outpost, food);
                			}
                			if (num == 5) {
                				Food food = new Food("Apple", 15, 7);
                				crew1.buy(outpost, food);
                				
                			}
                			if (num == 6) {
                				Food food = new Food("Sandwich", 25, 12);
                				crew1.buy(outpost, food);
                			}
                			if (num == 7) {
                				Food food = new Food("Pie", 30, 15);
                				crew1.buy(outpost, food);
                			}
                			if (num == 8) {
                				Food food = new Food("Burger", 40, 20);
                				crew1.buy(outpost, food);
                			}
                			if (num == 9) {
                				Food food = new Food("Pizza", 50, 25);
                				crew1.buy(outpost, food);
                			}
                			if (num == 10) {
                				doneShopping = true;
                			}
            			}
            		}
            		if (postNumber == 3) {
            			leaveOutPost = true;
            		}
        		}
        	}
        	/*
        	 * This function allows the player to eat an item from foodlist.
        	 */
        	if (number == 4) {
        		boolean doneEating = false;
        		while (doneEating == false) {
        			int i = 0;
            		int i2 = 0;
            		CrewMember memEat; 
            		System.out.println("Type the number corresponding to the crewmember that you want to eat.");
            		for (CrewMember member: crewList) {
            			i++;
            			System.out.println(i + ". " + member.getName());
            		}
            		System.out.println((i + 1) + ". Go back to menu.");
            		int crewNum = input0.nextInt();
            		if (crewNum == (i+1)) {
            			doneEating = true;
            		}
            		else {
            			memEat = crewList.get(crewNum - 1);
                		if (memEat.getActionCounter() == 0) {
                			System.out.println("You don't have enough action counter points remaining!\n");
                		}
                		else {
                			if (foodList.isEmpty() == true) {
                				System.out.println("You have no Food items");
                			}
                			else {
                				ArrayList<String> stringFoodList2;
                				ArrayList<Food> finalFoodList;
                				ArrayList<String> finalFoodList2;
                				stringFoodList2 = new ArrayList<String>();
                				finalFoodList = new ArrayList<Food>();
                				finalFoodList2 = new ArrayList<String>();
                				for (Food food: foodList) {
                					stringFoodList2.add(food.getName());
                				}
                				System.out.println("Your Food items are:");
                				Set<Food> s = new LinkedHashSet<>(foodList);
                				for (Food set: s) {
                					if (finalFoodList2.contains(set.getName())) {}
                					else {
                						finalFoodList.add(set);
                						finalFoodList2.add(set.getName());
                					}
                				}
                	  			for (Food food: finalFoodList) {
                	  				i2++;
                    				System.out.println(i2 + ". " + food.getName() + "(" + (Collections.frequency(stringFoodList2, food.getName())) + ")");	
                	  			}
                	  			System.out.println((i2 + 1) + ". Go back to menu");
                	  			System.out.println("Select what food item you want " + memEat.getName() + " to eat.");
                        		int foodNum = input0.nextInt();
                        		if (foodNum == (i2+1)) {
                        			doneEating = true;
                        		}
                        		else {
                        			Food chosenFood;
                            		chosenFood = finalFoodList.get(foodNum - 1);
                            		memEat.eat(finalFoodList.get(foodNum - 1));
                            		foodList.remove(chosenFood);
                            		System.out.println(memEat.getName() + " ate a " + chosenFood.getName());
                            		int action;
                            		action = memEat.getActionCounter();
                            		memEat.setActionCounter(action -1);
                            		doneEating = true;
                        		}
                			}
                		}
            		}
            		
        		}
        	}
        	/*
        	 * This function allows a crew member to use a healing item from med list
        	 */
        	if (number == 5) {
        		boolean doneHealing = false;
        		while (doneHealing == false) {
        			int i = 0;
            		int i2 = 0;
            		CrewMember memHeal; 
            		System.out.println("Type the number corresponding to the crewmember that you want to heal.");
            		for (CrewMember member: crewList) {
            			i++;
            			System.out.println(i + ". " + member.getName());
            		}
            		System.out.println((i + 1) + ". Go back to menu.");
            		int crewNum = input0.nextInt();
            		if (crewNum == (i+1)) {
            			doneHealing = true;
            		}
            		else {
            			memHeal = crewList.get(crewNum - 1);
                		if (memHeal.getActionCounter() == 0) {
                			System.out.println("You don't have enough action counter points remaining!\n");
                		}
                		else {
                			if (medicalList.isEmpty() == true) {
                				System.out.println("You have no Healing items");
                			}
                			else {
                				ArrayList<String> stringHealList2;
                				ArrayList<MedicalItem> finalHealList;
                				ArrayList<String> finalHealList2;
                				stringHealList2 = new ArrayList<String>();
                				finalHealList = new ArrayList<MedicalItem>();
                				finalHealList2 = new ArrayList<String>();
                				for (MedicalItem med: medicalList) {
                					stringHealList2.add(med.getName());
                				}
                				System.out.println("Your medical items are:");
                				Set<MedicalItem> s = new LinkedHashSet<>(medicalList);
                				for (MedicalItem set: s) {
                					if (finalHealList2.contains(set.getName())) {}
                					else {
                						finalHealList.add(set);
                						finalHealList2.add(set.getName());
                					}
                				}
                	  			for (MedicalItem med: finalHealList) {
                	  				i2++;
                    				System.out.println(i2 + ". " + med.getName() + "(" + (Collections.frequency(stringHealList2, med.getName())) + ")");
                	  			}
                	  			System.out.println((i2 + 1) + ". Go back to menu");
                	  			System.out.println("Select what medical item you want " + memHeal.getName() + " to use.");
                        		int medNum = input0.nextInt();
                        		if (medNum == (i2+1)) {
                        			doneHealing = true;
                        		}
                        		else {
                        			MedicalItem chosenMed;
                            		chosenMed = finalHealList.get(medNum - 1);
                            		memHeal.heal(finalHealList.get(medNum - 1));
                            		medicalList.remove(chosenMed);
                            		System.out.println(memHeal.getName() + " used a " + chosenMed.getName());
                            		memHeal.setActionCounter((memHeal.getActionCounter() - 1));
                            		doneHealing = true;
                        		}
                			}
                		}
            		}
            		
        		}
        	}
        	/*
        	 * This function allows a crew member to sleep, copletly replenishing their tirdness
        	 */
        	if (number == 6) {
        		boolean doneSleeping = false;
        		int i = 0;
        		while (doneSleeping == false){
        			CrewMember memSleep;
            		System.out.println("Pick the crew member you want to sleep.");
            		for (CrewMember member: crewList) {
            			i++;
            			System.out.println(i + ". " + member.getName());
            		}
            		System.out.println((i + 1) + ". Go back to menu.");
            		int crewNum = input0.nextInt();
            		if (crewNum == (i+1)) {
            			doneSleeping = true;
            		}
            		else {
            			memSleep = crewList.get(crewNum - 1);
            			if (memSleep.getActionCounter() == 0){
            				System.out.println("This crew member doesn't have enough action points to sleep");
            				doneSleeping = true;
            			}
            			else {
            				memSleep.sleep();
                    		System.out.println(memSleep.getName() + " has gone to sleep.");
                    		doneSleeping = true;
            			}
                		
            		}
        		}
        	}
        	/*
        	 * this function allows a crew member to repair the ships shield it max again
        	 */
        	if (number == 7) {
        		boolean doneRepair = false;
        		int i = 0;
        		while (doneRepair == false){
        			CrewMember memRepair;
            		System.out.println("Pick the crew member you want to Repair the ship");
            		for (CrewMember member: crewList) {
            			i++;
            			System.out.println(i + ". " + member.getName());
            		}
            		System.out.println((i + 1) + ". Go back to menu.");
            		int crewNum = input0.nextInt();
            		if (crewNum == (i+1)) {
            			doneRepair = true;
            		}
            		else {
            			memRepair = crewList.get(crewNum - 1);
            			if (memRepair.getActionCounter() == 0){
            				System.out.println("This crew member doesn't have enough action points to repair the ship.");
            				doneRepair = true;
            			}
            			else {
            				ship.repairShip();
                    		System.out.println(memRepair.getName() + " has repaired the ship.");
                    		memRepair.setActionCounter(memRepair.getActionCounter() - 1);
                    		doneRepair = true;
            			}
                		
            		}
        		}
        	}
        	/*
        	 * this function is for searching the planet, where the player can either find money, an item or a missing piece.
        	 * only one missing piece can be found per planet.
        	 */
        	if (number == 8) {
        		boolean doneSearch = false;
        		int i = 0;
        		while (doneSearch == false){
        			if (planetPieces == 0) {
        				System.out.println("\nAll the spaceship pieces on this planet have been found, your crew will need to fly to another planet to find more.\n");
        				doneSearch = true;
        			}
        			else {
        				CrewMember memSearch;
                		System.out.println("Pick the crew member you want to Search the nearest planet.");
                		for (CrewMember member: crewList) {
                			i++;
                			System.out.println(i + ". " + member.getName());
                		}
                		System.out.println((i + 1) + ". Go back to menu.");
                		int crewNum = input0.nextInt();
                		memSearch = crewList.get(crewNum - 1);
                		if (crewNum == (i+1)) {
                			doneSearch = true;
                		}
                		else {
                			if (memSearch.getActionCounter() == 0) {
                				System.out.println("/nThis crewmember does not have enough action points to go searching/n");
                				doneSearch = true;
                			}
                			else {
                				Random rand = new Random();
                    			int search = rand.nextInt(3);
                    			search += 1;
                    			if (search == 1) {
                    				crew1.setMoney((crew1.getMoney() + 100));
                    				System.out.println("You have found $100.");
                    			}
                    			if (search == 2) {
                    				crew1.setNumPieces((crew1.getNumPieces() + 1));
                    				planetPieces -= 1;
                    				System.out.println("You have found one of the missing pieces.");
                    			}
                    			if (search == 3) {
                    				int randItem = rand.nextInt(outpost.getItemsForSale().size());
                    				System.out.println("You have found a " + (outpost.getItemsForSale().get(randItem)).getName());
                    				if ((outpost.getItemsForSale().get(randItem)) instanceof Food) {
                        				foodList.add((Food) outpost.getItemsForSale().get(randItem));
                    				}
                    				else {
                        				medicalList.add((MedicalItem) outpost.getItemsForSale().get(randItem));

                    				}
                    			}
                    			doneSearch = true;
                    			memSearch.setActionCounter(memSearch.getActionCounter() - 1);
                			}
                			
                		}
        			}
        		}
        	}
        	/*
        	 * this allows the player to fly to a new planet, but only if two crew members do so
        	 */
        	if (number == 9) {
        		boolean donePilot = false;
        		int i = 0;
        		CrewMember memPilot;
        		System.out.println("Pick the crew member you want to Search the nearest planet.");
        		for (CrewMember member: crewList) {
        			i++;
        			System.out.println(i + ". " + member.getName());
        		}
        		System.out.println((i + 1) + ". Go back to menu.");
        		int crewNum = input0.nextInt();
        		if (crewNum == (i+1)) {
        			donePilot = true;
        		}
        		else {
        			memPilot = crewList.get(crewNum - 1);
        			if (memPilot.getActionCounter() == 0){
        				System.out.println("This crew member does not have enough action points to pilot the ship!");
        				donePilot = true;
        			}
        			else {
        				if (pilotList.contains(memPilot)) {
    						System.out.println("This crew member is already piloting the ship, to reach another planet you need one more crew member to pilot with them");
    						donePilot = true;
        				}
        				else {
        					if (pilotList.size() == 1) {
            					System.out.println("You have sucessfully piloted the ship to a new planet.");
            					planetPieces = 1;
            					pilotList.clear();
            					memPilot.setActionCounter(memPilot.getActionCounter() - 1);
            					donePilot = true;
        					}
        					else {
        						pilotList.add(memPilot);
            					System.out.println("You now have one crew member ready to pilot the ship, but you'll need one more if you want to fly the ship to a new planet");
            					memPilot.setActionCounter(memPilot.getActionCounter() - 1);
            					donePilot = true;
        					}
        					
        				}
        			}
        		}
        		
        	}
    	}
    	System.out.println("Congratulations! Your crew have succesfully found all the missing space ship pieces, and you've won the game.");
    }
}

