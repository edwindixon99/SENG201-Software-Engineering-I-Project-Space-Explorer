package game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;


class GameEnvironment {
	public static boolean finished;
	public static int requiredPieces;
	public static ArrayList<Food> foodList;
	public static ArrayList<CrewMember> crewList;
	public static ArrayList<MedicalItem> medicalList;
	
	
    public static void main(String[] args) {
    	Crew crew1 = new Crew();
    	SpaceShip ship = new SpaceShip();
    	foodList = new ArrayList<Food>();
    	crewList = new ArrayList<CrewMember>();
    	medicalList = new ArrayList<MedicalItem>();
    	crew1.setFoodItems(foodList);
    	crew1.setCrewMemberList(crewList);
    	crew1.setMedicalItems(medicalList);
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
    	while (finished == false) {
        	System.out.print("Pick what you want to do: \n1. View the crew members status.\n2.View your space ships status\n3. Visit nearest outpost.\n");
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
        		System.out.println(ship.getShipName() + "'s status:");
        		System.out.println("Shield: " + ship.getShieldHealth() + "\n");
        	}
        	/*
        	 * option 3 is to go to the outpost, where the player can buy items form the shop, or look at their own items
        	 * I have not yet implemented a money system yet, as at the moment there is no way of earning money
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
            			boolean shopping = false;
            			System.out.println("Pick an item that you want to buy.");
            			System.out.println("Medical Items:\n1. Small healing, Healing: 10, Price: $5\n2. Big healing, Healing: 40, Price: $20\n3. Space plague cure, Healing: Cures plague, Price: $15");
            			System.out.println("Food Items:\n4. Biscut, Hunger Replenished: 10, Price: $5\n5. Apples, Hunger Replenished: 15, Price: $7\n6. Sandwich, Hunger Replenished: 25, Price: $12\n7. Pie, Hunger Replenished: 30, Price: $15\n8. Burger, Hunger Replenished: 40, Price: $20\n9. Pizza, Hunger Replenished: 50, Price: $25\n10. Go back");
            			while (shopping == false) {
            				int num = input0.nextInt();
                			if (num == 1) {
                				MedicalItem med = new MedicalItem("SmallHealing", false, 10, 5);
                				System.out.println("You have bought a " + med.getName());
                				medicalList.add(med);
                			}
                			if (num == 2) {
                				MedicalItem med = new MedicalItem("Big Healing", false, 40, 20);
                				System.out.println("You have bought a " + med.getName());
                				medicalList.add(med);
                			}
                			if (num == 3) {
                				MedicalItem med = new MedicalItem("Space plague cure", true, 0, 15);
                				System.out.println("You have bought a " + med.getName());
                				medicalList.add(med);
                			}
                			if (num == 4) {
                				Food food = new Food("Biscut", 10, 5);
                				System.out.println("You have bought a " + food.getName());
                				foodList.add(food);
                			}
                			if (num == 5) {
                				Food food = new Food("Apple", 15, 7);
                				System.out.println("You have bought a " + food.getName());
                				foodList.add(food);
                			}
                			if (num == 6) {
                				Food food = new Food("Sandwich", 25, 12);
                				System.out.println("You have bought a " + food.getName());
                				foodList.add(food);
                			}
                			if (num == 7) {
                				Food food = new Food("Pie", 30, 15);
                				System.out.println("You have bought a " + food.getName());
                				foodList.add(food);
                			}
                			if (num == 8) {
                				Food food = new Food("Burger", 40, 20);
                				System.out.println("You have bought a " + food.getName());
                				foodList.add(food);
                			}
                			if (num == 9) {
                				Food food = new Food("Pizza", 50, 25);
                				System.out.println("You have bought a " + food.getName());
                				foodList.add(food);
                			}
                			if (num == 10) {
                				shopping = true;
                			}
            			}
            			
            		}
            		if (postNumber == 3) {
            			leaveOutPost = true;
            		}
        		}
        		
        	}
    	}
    }
}
