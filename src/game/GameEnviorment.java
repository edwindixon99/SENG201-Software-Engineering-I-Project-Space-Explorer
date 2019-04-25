package game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
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
	    	RandomEvent random = new RandomEvent();
	    	Crew crew1 = new Crew();
	    	SpaceShip ship = new SpaceShip();
	    	Scanner input = new Scanner(System.in);
	    	int days = getNumOfDays(input);
	    	requiredPieces = days * 2/3;
	    	ArrayList<CrewMember> crewList =  getCrewList(input);
	    	getShipName(ship, input, days);

	    	/*
	    	 * This is where the main game loop starts, obviously it is not done yet, there are still many features to add
	    	 * It starts by asking what the player wants to do, with the first option being to check the crews stats.
	    	 */
	    	Scanner input0 = new Scanner(System.in);
	    	while (crew1.getNumPieces() < requiredPieces) {
	    		String question = "Pick what you want to do: \n1. View the crew members status.\n2. View your space ships status\n3. Visit nearest outpost.\n4. Eat a food item.\n5. Heal a Crew Member\n6. Get a crew member to sleep\n7. Repair the ship\n8. Search the nearest planet.\n9. Pilot ship to another planet\n10. Next Day";
	        	String error = "You need to enter an integer between 1 and 10";
	        	int number = getValidInput(input0, 1, 10, question, error);
	        	if (number == 1) {
	        		for (CrewMember member: crewList) {
	        			member.viewStatus();
	        		}	
	        	}
	        	/*option 2 is to check the shields stats ie just the shield level
	        	 * 
	        	 */
	        	if (number == 2) {
	        		checkShipShield(ship);
	        	}
	        	boolean leaveOutPost = false;
	        	if (number == 3) {
	        		visitOutpost(leaveOutPost, input0, outpost, crew1);
	        	}
	        	/*
	        	 * This function allows the player to eat an item from foodlist.
	        	 */
	        	if (number == 4) {
	        		eat(input0);
	        	}
	        	/*
	        	 * This function allows a crew member to use a healing item from med list
	        	 */
	        	if (number == 5) {
	        		heal(input0);
	        	}
	        	/*
	        	 * This function allows a crew member to sleep, copletly replenishing their tirdness
	        	 */
	        	if (number == 6) {
	        		sleep(input0);
	        		
	        	}
	        	/*
	        	 * this function allows a crew member to repair the ships shield it max again
	        	 */
	        	if (number == 7) {
	        		repairShip(input0,ship);
	        	}
	        	/*
	        	 * this function is for searching the planet, where the player can either find money, an item or a missing piece.
	        	 * only one missing piece can be found per planet.
	        	 */
	        	if (number == 8) {
	        		searchPlanet(input0, crew1, outpost);
	        	}
	        	/*
	        	 * this allows the player to fly to a new planet, but only if two crew members do so
	        	 */
	        	if (number == 9) {
	        		flyToNewPlanet(input0, crew1, ship, random);
	        		
	        	}
	        	if (number == 10) {
	        		nextDay(crew1, random);
	        	}
	    	}
	        System.out.println("Game won/lost");
    }
		
	    
	    public static int getNumOfDays(Scanner input) {
			int days = 0;
			String question = "How many days would you like to play?";
			String errorMessage = "You need to enter a number between 3 and 10.";
			days = getValidInput(input, 3, 10, question, errorMessage);
			return days;
			}
		public static int getNumCrew(Scanner input) {
			int numCrew = 0;
			do {
				System.out.println("How many crew Members would you like?");
				try {
					numCrew = input.nextInt();
					if (numCrew < 2 || numCrew > 4) {
						System.out.println("You need to enter a number between 2 and 4.");
					}
				}
				catch (InputMismatchException e) {
					System.out.println("You need to enter a Integer between 2 and 4");
					input.next();
				}
			}
			while(numCrew < 2 || numCrew > 4);
			return numCrew;
			}
		public static ArrayList<CrewMember> getCrewList(Scanner input) {
			int numCrew = getNumCrew(input);
	    	for (int i=0; i < numCrew; i++) {
	    		System.out.println("What do you want to name your " + (i+1) + "st crewmember?");
	    		CrewMember newMember = new CrewMember();
	    		String name  = getInput();
	        	newMember.setName(name);
	        	crewList.add(newMember);
	    	}
	    	return crewList;
		}
		
		private static String getInput() {						// so can have more than 1 word in input 
		    Scanner scanner = new Scanner(System.in);
		    return scanner.nextLine();
		}
		public static void getShipName(SpaceShip ship, Scanner input, int days) {
			System.out.println("What would you like to name your Spaceship");
	    	String shipName = getInput();
	    	ship.setShipName(shipName);
	    	System.out.println("The game will now begin. To win, you will have to collect " + requiredPieces + " of your space ships missing pieces in " + days + " days.\n");
		}
		
		public static void checkShipShield(SpaceShip ship) {
			System.out.println("\n" + ship.getShipName() + "'s status:");
			System.out.println("Shield: " + ship.getShieldHealth() + "\n");
		}
        public static int getValidInput(Scanner input, int lowerBound, int upperBound, String question, String errorMessage) {
        	int inputedNumber = 0; 
			do {
				System.out.println(question);
				try {
					inputedNumber = input.nextInt();
					if (inputedNumber < lowerBound || inputedNumber > upperBound) {
						System.out.println(errorMessage);
					}
				}
				catch (InputMismatchException e) {
					System.out.println(errorMessage);
					input.next();
				}
			}
			while(inputedNumber < lowerBound || inputedNumber > upperBound);
        	return inputedNumber;
        }
        
        public static void visitOutpost(boolean leaveOutPost, Scanner input0, SpaceOutpost outpost, Crew crew1) {
        	while (leaveOutPost == false) {
    			String error1 = "You need to enter an integer between 1 and 3";
        		String question1 = ("Welcome to the space outpost, please choose what you would like to do: \n1. View owned items\n2. View Items for sale\n3. Go back\n");
        		int postNumber = getValidInput(input0, 1, 3, question1, error1);
        		if (postNumber == 1) {
        			if (foodList.isEmpty() == true) {
        				System.out.println("You have no Food items\n");
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
        			for (Item item: outpost.getItemsForSale()) {
        				i++;
        				outpost.view(item, i);
        			}
        			System.out.println("10. Go back to menu");
        			while (doneShopping == false) {
        				String question2 = ("Pick the number of the item that you want to buy.\nYou have $ " + crew1.getMoney() + " to spend");
        				String error2 = "You need to enter an integer between 1 and 10";
        				int num = getValidInput(input0, 1, 10, question2, error2);
            			if (num == 7) {
            				MedicalItem med = new MedicalItem("SmallHealing", false, 10, 5);
            				crew1.buy(foodList, medicalList, med);
            			}
            			if (num == 8) {
            				MedicalItem med = new MedicalItem("Big Healing", false, 40, 20);
            				crew1.buy(foodList, medicalList, med);
            			}
            			if (num == 9) {
            				MedicalItem med = new MedicalItem("Space plague cure", true, 0, 15);
            				crew1.buy(foodList, medicalList, med);
            			}
            			if (num == 6) {
            				Food food = new Food("Biscut", 10, 5);
            				crew1.buy(foodList, medicalList, food);
            			}
            			if (num == 1) {
            				Food food = new Food("Apple", 15, 7);
            				crew1.buy(foodList, medicalList, food);
            				
            			}
            			if (num == 2) {
            				Food food = new Food("Sandwich", 25, 12);
            				crew1.buy(foodList, medicalList, food);
            			}
            			if (num == 3) {
            				Food food = new Food("Pie", 30, 15);
            				crew1.buy(foodList, medicalList, food);
            			}
            			if (num == 4) {
            				Food food = new Food("Burger", 40, 20);
            				crew1.buy(foodList, medicalList, food);
            			}
            			if (num == 5) {
            				Food food = new Food("Pizza", 50, 25);
            				crew1.buy(foodList, medicalList, food);
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
        
        public static void eat(Scanner input0) {
        	boolean doneEating = false;
    		while (doneEating == false) {
    			int i = 0;
        		int i2 = 0;
        		CrewMember memEat; 
        		for (CrewMember member: crewList) {
        			i++;
        			System.out.println(i + ". " + member.getName());
        		}
        		System.out.println((i + 1) + ". Go back to menu.\n");
        		String question3 = "Type the number corresponding to the crewmember that you want to eat.\n";
        		String error3 = "Please enter an integer between 1 to " + (crewList.size()+1);
        		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question3, error3);
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
            				System.out.println("You have no Food items\n");
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
            	  			System.out.println((i2 + 1) + ". Go back to menu\n");
            	  			System.out.println("Select what food item you want " + memEat.getName() + " to eat.\n");
                    		int foodNum = input0.nextInt();
                    		if (foodNum == (i2+1)) {
                    			doneEating = true;
                    		}
                    		else {
                    			Food chosenFood;
                        		chosenFood = finalFoodList.get(foodNum - 1);
                        		memEat.eat(finalFoodList.get(foodNum - 1));
                        		foodList.remove(chosenFood);
                        		System.out.println(memEat.getName() + " ate a " + chosenFood.getName() + "\\n");
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
        public static void heal(Scanner input0) {
        	boolean doneHealing = false;
    		while (doneHealing == false) {
    			int i = 0;
        		int i2 = 0;
        		CrewMember memHeal; 
        		for (CrewMember member: crewList) {
        			i++;
        			System.out.println(i + ". " + member.getName());
        		}
        		System.out.println((i + 1) + ". Go back to menu.\n");
        		String question4 = "Type the number corresponding to the crewmember that you want to heal.\n";
        		String error4 = "You need to enter an integer between 1 and " + (crewList.size()+1);
        		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question4, error4);	            		if (crewNum == (i+1)) {
        			doneHealing = true;
        		}
        		else {
        			memHeal = crewList.get(crewNum - 1);
            		if (memHeal.getActionCounter() == 0) {
            			System.out.println("You don't have enough action counter points remaining!\n");
            		}
            		else {
            			if (medicalList.isEmpty() == true) {
            				System.out.println("You have no Healing items\n");
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
            	  			System.out.println((i2 + 1) + ". Go back to menu\n");
            	  			String question5 = "Select what medical item you want " + memHeal.getName() + " to use.\n";
    	            		String error5 = "You need to enter an integer between 1 and " + (finalHealList.size()+1);
    	            		int medNum = getValidInput(input0, 1, (finalHealList.size()+1), question4, error4);	
                    		if (medNum == (i2+1)) {
                    			doneHealing = true;
                    		}
                    		else {
                    			MedicalItem chosenMed;
                        		chosenMed = finalHealList.get(medNum - 1);
                        		memHeal.heal(finalHealList.get(medNum - 1));
                        		medicalList.remove(chosenMed);
                        		System.out.println(memHeal.getName() + " used a " + chosenMed.getName() + "\n");
                        		memHeal.setActionCounter((memHeal.getActionCounter() - 1));
                        		doneHealing = true;
                    		}
            			}
            		}
        		}
        		
    		}
        }
        
        public static void sleep(Scanner input0) {
        	boolean doneSleeping = false;
    		int i = 0;
    		while (doneSleeping == false){
    			CrewMember memSleep;
        		for (CrewMember member: crewList) {
        			i++;
        			System.out.println(i + ". " + member.getName());
        		}
        		System.out.println((i + 1) + ". Go back to menu.\n");
        		String question6 = "Pick the crew member you want to sleep.\n";
        		String error6 = "You need to enter an integer between 1 and " + (crewList.size()+1);
        		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question6, error6);	
        		if (crewNum == (i+1)) {
        			doneSleeping = true;
        		}
        		else {
        			memSleep = crewList.get(crewNum - 1);
        			if (memSleep.getActionCounter() == 0){
        				System.out.println("This crew member doesn't have enough action points to sleep\n");
        				doneSleeping = true;
        			}
        			else {
        				memSleep.sleep();
                		System.out.println(memSleep.getName() + " has gone to sleep.\n");
                		doneSleeping = true;
        			}
            		
        		}
    		}
        }
        
        public static void repairShip(Scanner input0, SpaceShip ship) {
        	boolean doneRepair = false;
    		int i = 0;
    		while (doneRepair == false){
    			CrewMember memRepair;
        		System.out.println("Pick the crew member you want to Repair the ship\n");
        		for (CrewMember member: crewList) {
        			i++;
        			System.out.println(i + ". " + member.getName());
        		}
        		System.out.println((i + 1) + ". Go back to menu.\n");
        		String question7 = "Pick the crew member you want to Repair the ship\n";
        		String error7 = "You need to enter an integer between 1 and " + (crewList.size()+1);
        		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question7, error7);	
        		if (crewNum == (i+1)) {
        			doneRepair = true;
        		}
        		else {
        			memRepair = crewList.get(crewNum - 1);
        			if (memRepair.getActionCounter() == 0){
        				System.out.println("This crew member doesn't have enough action points to repair the ship.\n");
        				doneRepair = true;
        			}
        			else {
        				ship.repairShip();
                		System.out.println(memRepair.getName() + " has repaired the ship.\n");
                		memRepair.setActionCounter(memRepair.getActionCounter() - 1);
                		doneRepair = true;
        			}
            		
        		}
    		}
        }
        
        public static void searchPlanet(Scanner input0, Crew crew1, SpaceOutpost outpost) {
        	boolean doneSearch = false;
    		int i = 0;
    		while (doneSearch == false){
    			if (planetPieces == 0) {
    				System.out.println("All the spaceship pieces on this planet have been found, your crew will need to fly to another planet to find more.\n");
    				doneSearch = true;
    			}
    			else {
    				CrewMember memSearch;
            		for (CrewMember member: crewList) {
            			i++;
            			System.out.println(i + ". " + member.getName());
            		}
            		System.out.println((i + 1) + ". Go back to menu.\n");
            		String question8 = "Pick the crew member you want to Search the nearest planet.\n";
            		String error8 = "You need to enter an integer between 1 and " + (crewList.size()+1);
            		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question8, error8);	
            		memSearch = crewList.get(crewNum - 1);
            		if (crewNum == (i+1)) {
            			doneSearch = true;
            		}
            		else {
            			if (memSearch.getActionCounter() == 0) {
            				System.out.println("This crewmember does not have enough action points to go searching\n");
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
                				System.out.println("You have found one of the missing pieces.\n");
                			}
                			if (search == 3) {
                				int randItem = rand.nextInt(outpost.getItemsForSale().size());
                				System.out.println("You have found a " + (outpost.getItemsForSale().get(randItem)).getName() + "\n");
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
        
        public static void flyToNewPlanet(Scanner input0, Crew crew1, SpaceShip ship, RandomEvent random) {
        	boolean donePilot = false;
    		int i = 0;
    		CrewMember memPilot;
    		System.out.println("Pick the crew member you want to pilot the ship to the next planet.\n");
    		for (CrewMember member: crewList) {
    			i++;
    			System.out.println(i + ". " + member.getName());
    		}
    		System.out.println((i + 1) + ". Go back to menu.\n");
    		String question9 = "Pick the crew member you want to pilot the ship to the next planet.\n";
    		String error9 = "You need to enter an integer between 1 and " + (crewList.size()+1);
    		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question9, error9);	
    		if (crewNum == (i+1)) {
    			donePilot = true;
    		}
    		else {
    			memPilot = crewList.get(crewNum - 1);
    			if (memPilot.getActionCounter() == 0){
    				System.out.println("This crew member does not have enough action points to pilot the ship!\n");
    				donePilot = true;
    			}
    			else {
    				if (pilotList.contains(memPilot)) {
						System.out.println("This crew member is already piloting the ship, to reach another planet you need one more crew member to pilot with them\n");
						donePilot = true;
    				}
    				else {
    					if (pilotList.size() == 1) {
    						Random randAsteroid = new Random();
    						int n = randAsteroid.nextInt(2);
    						n += 1;
    						if (n == 1) {
    						random.AsteroidBelt(ship);
    							if (ship.getShieldHealth() <= 0) {
    								System.out.println("The shield of your ship has depleted, and everyone on the crew has died!\n");
    								crew1.setNumPieces(100);
    								donePilot = true;
    							}
    						}
    						else {
    							System.out.println("You have sucessfully piloted the ship to a new planet.\n");
                				planetPieces = 1;
                				pilotList.clear();
                				memPilot.setActionCounter(memPilot.getActionCounter() - 1);
                				donePilot = true;
    							}
    					}
    					else {
    						pilotList.add(memPilot);
        					System.out.println("You now have one crew member ready to pilot the ship, but you'll need one more if you want to fly the ship to a new planet\n");
        					memPilot.setActionCounter(memPilot.getActionCounter() - 1);
        					donePilot = true;
    					}
    					
    				}
    			}
    		}
        }
        
        public static void nextDay(Crew crew1, RandomEvent random) {
        	ArrayList<CrewMember> crewList2 = new ArrayList<CrewMember>();
    		crew1.setCrewMemberList(crewList2);
    		crew1.setDays(crew1.getDays() + 1);
    		System.out.println("\nYou have moved on to day " + crew1.getDays() + "\n");
    		for (CrewMember member: crewList) {
    			crewList2.add(member);
    			member.newDay();
    		}
    		for (CrewMember member: crewList2) {
    			if (member.getHealthLevel() <= 0) {
    				System.out.println(member.getName() + "  has died, due to their health level dropping to 0.\n");
    				crewList.remove(member);
    				if (crewList.size() == 0) {
    					crew1.setNumPieces(100);
    				}
    			}
    		}
    		if (crewList.size() > 0) {
    			Random dayEvent = new Random();
        		int n = dayEvent.nextInt(3);
        		n += 1;
        		if (n == 1) {
        			random.alienPirates(crew1);
        		}
        		if (n == 2) {
        			random.spacePlague(crew1);
        		}
    		}
    		
    	}
}