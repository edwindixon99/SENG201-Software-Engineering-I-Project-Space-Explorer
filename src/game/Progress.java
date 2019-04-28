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
	public static int daysProgressedThrough = 1;
	public static boolean gameIsOver = false; 
	
	 public static void main(String[] args) {
	    	SpaceOutpost outpost = new SpaceOutpost();
	    	outpost.setItemsForSale();
	    	RandomEvents random = new RandomEvents();
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
	    		String question = "\nPick what you want to do: \n1. View the crew members status.\n2. View your space ships status\n3. Visit nearest outpost.\n4. Eat a food item.\n5. Heal a Crew Member\n6. Get a crew member to sleep\n7. Repair the ship\n8. Search the nearest planet.\n9. Pilot ship to another planet\n10. Next Day";
	        	int number = getValidInput(input0, 1, 10, question);
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
	        	if (number == 3) {
	        		boolean leaveOutPost = false;
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
	        		nextDay(crew1, random, days);
	        	}}
    }
		public static int getNumOfDays(Scanner input) {
			int days = 0;
			String question = "How many days would you like to play?";
			days = getValidInput(input, 3, 10, question);
			return days;
			}
		public static int getNumCrew(Scanner input) {
			int numCrew = 0;
			String question = "How many crew Members would you like?";
			numCrew = getValidInput(input, 2, 4, question);
			return numCrew;
			}
		public static ArrayList<CrewMember> getCrewList(Scanner input) {
			Scanner scanner = new Scanner(System.in);
			int numCrew = getNumCrew(input);
			viewTypes();
	    	for (int i=0; i < numCrew; i++) {
	    		System.out.println("What do you want to name your " + (i+1) + "st crewmember?");
	    		String name  = getInput();
				String question10 = "Pick a type bewteen 1 and 6";
				int typeNum = getValidInput(scanner, 1, 6, question10);
				if (typeNum == 1) {
					Type1 newMember = new Type1(name, 40, 2, 10);
					crewList.add(newMember);}
				if (typeNum == 2) {
					Type2 newMember = new Type2(name, 10, 1, 25);
	        		crewList.add(newMember);}
				if (typeNum == 3) {
					Type3 newMember = new Type3(name, 25, 4, 40);
					crewList.add(newMember);}
				if (typeNum == 4) {
					Type4 newMember = new Type4(name, 25, 1, 25);
					crewList.add(newMember);}
				if (typeNum == 5) {
					Type5 newMember = new Type5(name, 25, 2, 40);
					crewList.add(newMember);}
				if (typeNum == 6) {
					Type6 newMember = new Type6(name, 40, 2, 25);
					crewList.add(newMember);}
				}
	    	return crewList;
	    }
		
		private static String getInput() {						// so can have more than 1 word in input 
		    Scanner input = new Scanner(System.in);
		    return input.nextLine();
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
        public static int getValidInput(Scanner input, int lowerBound, int upperBound, String question) {
        	int inputedNumber = 0; 
			do {
				System.out.println(question);
				try {
					inputedNumber = input.nextInt();
					if (inputedNumber < lowerBound || inputedNumber > upperBound) {
						System.out.println("You need to enter an integer between " + lowerBound + " and " + upperBound);
					}
				}
				catch (InputMismatchException e) {
					System.out.println("You need to enter an integer between " + lowerBound + " and " + upperBound);
					input.next();
				}
			}
			while(inputedNumber < lowerBound || inputedNumber > upperBound);
        	return inputedNumber;
        }
    	public static void viewTypes() {
    		System.out.println("Each of your crew members will need to be one of the following 6 types.");
    		System.out.println("Type 1:\nHunger degrade: high\nHealth degrade: medium\nTiredness Degrade: low\nSpecial ability: None\n");
    		System.out.println("Type 2:\nHunger degrade: low\nHealth degrade: high\nTiredness Degrade: medium\nSpecial ability: None\n");
    		System.out.println("Type 3:\nHunger degrade: medium\nHealth degrade: low\nTiredness Degrade: high\nSpecial ability: None\n");
    		System.out.println("Type 4:\nHunger degrade: medium\nHealth degrade: high\nTiredness Degrade: medium\nSpecial ability: Able to pilot the ship to a new planet by themselves\n");
    		System.out.println("Type 5:\nHunger degrade: medium\nHealth degrade: medium\nTiredness Degrade: high\nSpecial ability: Higher chance of finding a spaceship piece when searching a planet\n");
    		System.out.println("Type 6:\nHunger degrade: high\nHealth degrade: medium\nTiredness Degrade: medium\nSpecial ability: Fully repair the ships shield\n");
    	}	
    	
    	public static void nextDay(Crew crew1, RandomEvents random, int days) {
        	ArrayList<CrewMember> crewList2 = new ArrayList<CrewMember>();
    		crew1.setCrewMemberList(crewList2);
    		crew1.setDays(crew1.getDays() + 1);
    		daysProgressedThrough += 1;
    		if (days < daysProgressedThrough) {
    			gameIsOver = true;
    			crew1.setNumPieces(100);
    			System.out.println("Game Over!");
    		}
			for (CrewMember member: crewList) {
				crewList2.add(member);
				member.newDay();
			}
			if (!gameIsOver) {
				for (CrewMember member: crewList2) {
					if (member.isDead()) {
						crewList.remove(member);
						if (crewList.size() == 0) {
							gameIsOver = true;
							crew1.setNumPieces(100);
							System.out.println("Game Over!");
					}
				}
			}
			}
			if (!gameIsOver) {
				if (crewList.size() > 0) {
					getRandomEvent(crew1, random);
					System.out.println("\nYou have moved on to day " + crew1.getDays() + "\n*********************************************************** Day " + Integer.toString(daysProgressedThrough) + " ***********************************************************");
			}
    	}
    	}
    	
    	 public static void flyToNewPlanet(Scanner input0, Crew crew1, SpaceShip ship, RandomEvents random) {
    		boolean donePilot = true;
     		int i = 0;
     		CrewMember memPilot;
     		System.out.println("Pick the crew member you want to pilot the ship to the next planet.\n");
     		for (CrewMember member: crewList) {
     			i++;
     			System.out.println(i + ". " + member.getName());
     		}
     		System.out.println((i + 1) + ". Go back to menu.\n");
     		String question9 = "Pick the crew member you want to pilot the ship to the next planet.\n";
     		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question9);	
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
             			if (memPilot instanceof Type4) {
             				planetPieces = 1;
             				pilotList.clear();
             				memPilot.setActionCounter(memPilot.getActionCounter() - 1);
             				Random randAsteroid = new Random();
     						int n = randAsteroid.nextInt(2);
     						n += 1;
     						if (n == 1) {
     							random.asteroidBelt(ship);
     							if (ship.getShieldHealth() <= 0) {
     								System.out.println("The shield of your ship has depleted, and everyone on the crew has died!\n");
     								crew1.setNumPieces(100);
     								donePilot = true;
     							}
     						}
     						else {
     							System.out.println("You have sucessfully piloted the ship to a new planet.\n");
                 				donePilot = true;
     							}
             			}
             			else {
             				if (pilotList.contains(memPilot)) {
         						System.out.println("This crew member is already piloting the ship, to reach another planet you need one more crew member to pilot with them\n");
         						donePilot = true;
             				}
             				else {
             					if (pilotList.size() == 1) {
                     				planetPieces = 1;
                     				pilotList.clear();
                     				memPilot.setActionCounter(memPilot.getActionCounter() - 1);
             						Random randAsteroid = new Random();
             						int n = randAsteroid.nextInt(2);
             						n += 1;
             						if (n == 1) {
             							random.asteroidBelt(ship);
             							if (ship.getShieldHealth() <= 0) {
             								System.out.println("The shield of your ship has depleted, and everyone on the crew has died!\n");
             								crew1.setNumPieces(100);
             								donePilot = true;
             							}
             						}
             						else {
             							System.out.println("You have sucessfully piloted the ship to a new planet.\n");
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
             		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question8);	
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
             				int search = memSearch.search(memSearch);
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
                 				Random rand = new Random();
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
         		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question7);	
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
         				if (memRepair instanceof Type6) {
         					ship.repairShip(100);
                     		System.out.println(memRepair.getName() + " has fully repaired the ships shield!\n");
                     		memRepair.setActionCounter(memRepair.getActionCounter() - 1);
                     		doneRepair = true;
         				}
         				else {
             				ship.repairShip(40);
                     		System.out.println(memRepair.getName() + " has repaired the ship by 40.\n The ships shield is now at " + ship.getShieldHealth());
                     		memRepair.setActionCounter(memRepair.getActionCounter() - 1);
                     		doneRepair = true;
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
         		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question6);	
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
         		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question4);	            		
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
     	            		int medNum = getValidInput(input0, 1, (finalHealList.size()+1), question5);	
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
         public static void visitOutpost(boolean leaveOutPost, Scanner input0, SpaceOutpost outpost, Crew crew1) {
     		while (leaveOutPost == false) {
         		String question1 = ("Welcome to the space outpost, please choose what you would like to do: \n1. View owned items\n2. View Items for sale\n3. Go back\n");
         		int postNumber = getValidInput(input0, 1, 3, question1);
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
         				int num = getValidInput(input0, 1, 10, question2);
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
     		}}
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
         		int crewNum = getValidInput(input0, 1, (crewList.size()+1), question3);
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
         
         public static void getRandomEvent(Crew crew1, RandomEvents random) {
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
