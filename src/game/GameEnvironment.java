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
     	private int planetPieces = 1;
     	private String message = "";
     	private String actionTaken;
     	private int daysProgressedThrough = 1;
     	private boolean gameIsOver = false; 
		private int days;
     	private CrewMember pickedMember;
     	private RandomEvents random = new RandomEvents();  
     	private Crew crew1 = new Crew(); 
     	private SpaceShip ship = new SpaceShip();
     	private SpaceOutpost outpost = new SpaceOutpost();
     	private Scanner input0 = new Scanner(System.in);
     	private String secondMessage;

     	public GameEnvironment() {
     	}


     	public static void main(String[] args) {
     		GameEnvironment game = new GameEnvironment();
//     		Crew crew1 = game.getCrew1();
//     		SpaceShip ship = game.getShip();
     		game.playGame();
     		game.launchSetupWindow();
  	    
     	 }
     	public void playGame() {
     		outpost.setItemsForSale();
     		crew1.setMoney(50000000);
     	}
     /*	public void playGame() {
         	Scanner input = new Scanner(System.in);
         	outpost.setItemsForSale();
         	days = getNumOfDays(input);
         	crew1.setDays(days);
         	crew1.setCrewMemberList(getCrewList(input));

         	
         	 * This is where the main game loop starts, obviously it is not done yet, there are still many features to add
         	 * It starts by asking what the player wants to do, with the first option being to check the crews stats.
         	 
         	while (crew1.getNumPieces() < crew1.getRequiredPieces()) {
         		String question = "\nPick what you want to do: \n1. View the crew members status.\n2. View your space ships status\n3. Visit nearest outpost.\n4. Eat a food item.\n5. Heal a Crew Member\n6. Get a crew member to sleep\n7. Repair the ship\n8. Search the nearest planet.\n9. Pilot ship to another planet\n10. Next Day";
             	int number = getValidInput(input0, 1, 10, question);
             	if (number == 1) {
             		for (CrewMember member: crew1.getCrewMemberList()) {
             			System.out.println(member.viewStatus());
             		}	
             	}
             	option 2 is to check the shields stats ie just the shield level
             	 * 
             	 
             	if (number == 2) {
             		System.out.println(ship.checkShipShield());
             	}
             	if (number == 7) {
             		//repairShip();
             	}
             	
             	 * this allows the player to fly to a new planet, but only if two crew members do so
             	 
             	if (number == 9) {
//             		flyToNewPlanet();

             	}
             	if (number == 10) {
             		nextDay();
             	}
         	}
     	 }

     	 public int getNumOfDays(Scanner input) {
     		int days = 0;
     		String question = "How many days would you like to play?";
     		days = getValidInput(input, 3, 10, question);
     		return days;
     	}*/
     	 
     	public void setDays(int day) {
     		this.days = day;
     	}
     	
     	
 /*    	public int getNumCrew(Scanner input) {
     		int numCrew = 0;
     		String question = "How many crew Members would you like?";
     		numCrew = getValidInput(input, 2, 4, question);
     		return numCrew;
     		}
     	public ArrayList<CrewMember> getCrewList(Scanner input) {
     		ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
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

     	public String getInput() {						// so can have more than 1 word in input 
     	    Scanner input = new Scanner(System.in);
     	    return input.nextLine();
     	}

         public int getValidInput(Scanner input, int lowerBound, int upperBound, String question) {
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
     	public void viewTypes() {
     		System.out.println("Each of your crew members will need to be one of the following 6 types.");
     		System.out.println("Type 1:\nHunger degrade: high\nHealth degrade: medium\nTiredness Degrade: low\nSpecial ability: None\n");
     		System.out.println("Type 2:\nHunger degrade: low\nHealth degrade: high\nTiredness Degrade: medium\nSpecial ability: None\n");
     		System.out.println("Type 3:\nHunger degrade: medium\nHealth degrade: low\nTiredness Degrade: high\nSpecial ability: None\n");
     		System.out.println("Type 4:\nHunger degrade: medium\nHealth degrade: high\nTiredness Degrade: medium\nSpecial ability: Able to pilot the ship to a new planet by themselves\n");
     		System.out.println("Type 5:\nHunger degrade: medium\nHealth degrade: medium\nTiredness Degrade: high\nSpecial ability: Higher chance of finding a spaceship piece when searching a planet\n");
     		System.out.println("Type 6:\nHunger degrade: high\nHealth degrade: medium\nTiredness Degrade: medium\nSpecial ability: Fully repair the ships shield\n");
     	}	
*/
     	public String nextDay() {
     		String finalString = "";
     		crew1.setDays(crew1.getDays() + 1);
         	ArrayList<CrewMember> crewList = crew1.getCrewMemberList();
     		daysProgressedThrough += 1;
     		if (days < daysProgressedThrough) {
     			gameIsOver = true;
     			finalString += "Ran out of days!";
     		}
     		for (CrewMember member: crewList) {
     			member.newDay();
     		}
     		crew1.setCrewMemberList(crewList);
     		if (!gameIsOver) {
     			for (int i = 0; i < crewList.size(); i++) {
     				CrewMember member = crewList.get(i);
     				if (member.isDead()) {
     					finalString += member.getName() + "  has died, due to their health level dropping to 0.\n";
     					crewList.remove(member);
     				}
     			}
     		}
     		if (crewList.size() == 0) {
     			gameIsOver = true;
     			finalString += "Ran out of crew members!";
     		}
     		if (!gameIsOver) {
     			finalString += getRandomEvent();
     			finalString += "\nYou have moved on to day " + Integer.toString(daysProgressedThrough);	
     		}
     	return finalString;
     	}

     	 public String flyToNewPlanet(CrewMember memPilot) {
     		String finalString = "";
      		ArrayList<CrewMember> pilotList = crew1.getPilotCount();
     		if (memPilot.getActionCounter() == 0){
     			finalString += "This crew member does not have enough action points to pilot the ship!\nTo get more action points proceed to next day.\n";
     		}
     		else {
      			if (memPilot instanceof Type4) {
      				finalString += successfulFlight(memPilot, pilotList);
      			}
      			else {
      				if (pilotList.contains(memPilot)) {
      					finalString += "This crew member is already piloting the ship, to reach another planet you need one more crew member to pilot with them\n";
      				}
      				else {
      					if (pilotList.size() == 1) {
      						finalString += successfulFlight(memPilot, pilotList);
      					}
      					else {
      						pilotList.add(memPilot);
      						finalString += "You now have one crew member ready to pilot the ship, but you'll need one more if you want to fly the ship to a new planet\n";
          					memPilot.setActionCounter(memPilot.getActionCounter() - 1);
      					}
      				}
     			}	
     		}
      		return finalString;
          }
     	 public String searchPlanet(CrewMember member) {
     		String finalString = "";
     		if (planetPieces == 0) {
     			finalString += "All the spaceship pieces on this planet have been found, your crew will need to fly to another planet to find more.\nYou cannot find anything else useful.";
     		}
     		else {
     			CrewMember memSearch;
          			memSearch = member;
          			if (memSearch.getActionCounter() == 0) {
          				finalString += "This crewmember does not have enough action points to go searching.\nTo get more action points proceed to next day.\n";
          			}
          			else {
          				memSearch.setActionCounter(memSearch.getActionCounter() - 1);
          				int search = memSearch.search(memSearch);
              			if (search == 1) {
              				Random randMoney = new Random();
              				int amount = randMoney.nextInt(70) + 40;
              				crew1.setMoney((crew1.getMoney() + amount));
              				finalString += "You have found $" + Integer.toString(amount) + ".";
              			}
              			if (search == 2) {
              				int pieces = crew1.getRequiredPieces();
              				crew1.setRequiredPieces((pieces - 1));
              				planetPieces -= 1;
              				finalString += "You have found one of the missing pieces.";
              			}
              			if (search == 3) {
              				Random rand = new Random();
              				ArrayList<Food> foodList = crew1.getFoodItems();
              				ArrayList<MedicalItem> medicalList = crew1.getMedicalItems();
              				int randItem = rand.nextInt(outpost.getItemsForSale().size());
              				if ((outpost.getItemsForSale().get(randItem)) instanceof Food) {
                  				foodList.add((Food) outpost.getItemsForSale().get(randItem));
              				}
              				else {
                  				medicalList.add((MedicalItem) outpost.getItemsForSale().get(randItem));
              				}
              				finalString += "You have found a " + (outpost.getItemsForSale().get(randItem)).getName();
              			}
          			}
     		}
     		if (crew1.getRequiredPieces() <= 0) {
     			gameIsOver = true;
     		}
     		return finalString;
          }



		public String repairShip(CrewMember memRepair) {
         	if (ship.getShieldHealth() == 100) {
         		return ship.getShipName() + " already has full shield!";
         	}
     	 	if (memRepair.getActionCounter() == 0){
     	 		return memRepair.getName() + " doesn't have enough action points to repair " + ship.getShipName() + ".\nTo get more action points proceed to next day.\n";
     		}
     		else {
     			if (memRepair instanceof Type6) {
     				ship.repairShip(100);
              		memRepair.setActionCounter(memRepair.getActionCounter() - 1);
              		return memRepair.getName() + " has fully repaired the " + ship.getShipName() + "\'s shield!";
     			}
     			else {
      				ship.repairShip(40);
              		memRepair.setActionCounter(memRepair.getActionCounter() - 1);
              		return memRepair.getName() + " has repaired the ship by 40. The " + ship.getShipName() + "\'s shield is now at " + ship.getShieldHealth();
     			}
     		}
          }
          public String sleep(CrewMember member) {
          	ArrayList<CrewMember> crewList = crew1.getCrewMemberList();
       		int i = 0;
       		CrewMember memSleep;
           	memSleep = member;
           	if (member.getTiredness() == 100) {
           		return ("This Crew member does not need to sleep.");
           	}
           	if (memSleep.getActionCounter() == 0){
           		return ("This crew member doesn't have enough action points to sleep.\nTo get more action points proceed to next day.\n");
           	}
           	else {
           		memSleep.sleep();
                  return (memSleep.getName() + " has gone to sleep.\n");
           	}
           }
           

          public String viewOwnedFood() {
         	String finalString = "";
         	ArrayList<Food> foodList = crew1.getFoodItems();
     		if (foodList.isEmpty() == true) {
     			finalString += "You have no Food items\n";
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
     			finalString += "Your Food items are:\n";
       			for (String food: stringFood) {
       				finalString += food + "(" + (Collections.frequency(stringFoodList, food)) + ")\n";	
       			}
     		}
     		return finalString;
          }
          public String viewOwnedMedicalItems() {
         	 String finalString = "";
         	 ArrayList<MedicalItem> medicalList = crew1.getMedicalItems();
         	 if (medicalList.isEmpty() == true) {
      			finalString += "You have no medical items\n";
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
      			finalString += "Your medical items are:\n";
        			for (String med: stringMed) {
        				finalString += med + "(" + (Collections.frequency(stringMedList, med)) + ")\n";	
        			}
      		}
         	 return finalString;
          }
          public String heal(CrewMember member) {
         	ArrayList<MedicalItem> healList = crew1.getMedicalItems();
          	CrewMember memHeal = member; 
            if (memHeal.getActionCounter() == 0) {
            	return("You don't have enough action counter points remaining!\nTo get more action points proceed to next day.\n");
            }
            else {
            	if (healList.isEmpty() == true) {
            		return("You have no medical items\n");
                }
            }
			return ("");
           	}

          public String eat(CrewMember member) {
         	ArrayList<Food> foodList = crew1.getFoodItems();
          	CrewMember memEat = member; 
            if (memEat.getActionCounter() == 0) {
            	return("You don't have enough action counter points remaining!\nTo get more action points proceed to next day.\n");
            }
            else {
            	if (foodList.isEmpty() == true) {
            		return("You have no Food items\n");
                }
            }
			return ("");
           	}
          public String eat_food(CrewMember member, Food food, int index) {
        	  ArrayList<Food> foodList = crew1.getFoodItems();
        	  member.eat(food);
        	  member.setActionCounter(member.getActionCounter() - 1);
        	  foodList.remove(index);
        	  return (member.getName() + " has eaten a " + food.getName());
          }
          public String healMethod(CrewMember member, MedicalItem med, int index) {
        	  ArrayList<MedicalItem> healList = crew1.getMedicalItems();
        	  member.heal(med);
        	  member.setActionCounter(member.getActionCounter() - 1);
        	  healList.remove(index);
        	  return (member.getName() + " has healed using " + med.getName());
          }

          public String getRandomEvent() {
        	String finalString = "";
         	Random dayEvent = new Random();
     		int n = dayEvent.nextInt(3);
     		n += 1;
     		if (n == 1) {
     			finalString += random.alienPirates(crew1);	
     		}
     		if (n == 2) {
     			finalString += random.spacePlague(crew1);
     		}
     		return finalString;
     		}
          public String successfulFlight(CrewMember memPilot, ArrayList<CrewMember> pilotList) {
         	String finalString = "";
     		planetPieces = 1;
     		pilotList.clear();
     		memPilot.setActionCounter(memPilot.getActionCounter() - 1);
     		Random randAsteroid = new Random();
     		int n = randAsteroid.nextInt(2);
     		n += 1;
     		if (n == 1) {
     			finalString += random.asteroidBelt(ship);
     			if (ship.getShieldHealth() <= 0) {
     				return "The shield of your ship has depleted, and everyone on the crew has died!";
     			}else {
     				finalString += "You have sucessfully piloted the ship to a new planet.\n";
     			}
     		}
     		else {
     			finalString += "You have sucessfully piloted the ship to a new planet.\n";
     		}
     		return finalString;
          }  


         public void setActTaken(String actionTaken1) {
         	actionTaken = actionTaken1;
         }
         public String getActTaken() {
         	return actionTaken;
         }
         public CrewMember getPickedMember() {
         	return pickedMember;
         }
         public void setPickedMember(CrewMember pickedMember1) {
         	pickedMember = pickedMember1;
         }
         public void setMessage(String message) {
         	this.message = message;
         }
         public String getMessage() {
         	return message;
         }
         
         
         
     	public Crew getCrew1() {
     		return crew1;
     	}
     	public void setCrew1(Crew crew) {
     		crew1 = crew;
     	}
     	public SpaceShip getShip() {
     		return ship;
     	}
     	public void setShip(SpaceShip ship1) {
     		ship = ship1;
     	}
     	public void closeSetupScreen(SetupWindow setupWindow) {
     		setupWindow.closeWindow();
     		launchMainScreen(); 
     		}
     	public void closeEat(Eat eat) {
     		eat.closeWindow();
     	}
     	public void closeHeal(Heal heal) {
     		heal.closeWindow();
     	}
     	public void launchMainScreen() { 
     		MainWindow mainScreen = new MainWindow(this);
     	  }
     	public void closeMainScreen(MainWindow main) { 
     		main.closeWindow();
     	}

     	public void launchSetupWindow() { 
     		  SetupWindow setup = new SetupWindow(this); 
     	 }
     	public void launchEatWindow(CrewMember member) {
     		Eat eat = new Eat(this, member);
     		eat.setVisible(true);
     	}
     	public void launchHealWindow(CrewMember member) {
     		Heal heal = new Heal(this, member);
     		heal.setVisible(true);
     	}

     	public void launchMemberSelection() {
     		MemberSelection memberSelection = new MemberSelection(this);
//     		memberSelection.setVisible(true);
     	}
     	
     	public String convertToMultiline(String orig) {
     	    return "<html>" + orig.replaceAll("\n", "<br>");
     	}
     	
     	public void launchCrewMemberSelection() {
     		MemberSelection memberSelection = new MemberSelection(this);
     		memberSelection.setVisible(true);
     	}


     	public void closeMemberSelection(MemberSelection memberSelection) {
     		memberSelection.closeWindow();
     	}
     	public void launchSearchWindow() { 
     		  SearchPlanet search = new SearchPlanet(this);
     		  search.setVisible(true);
     	 }
     	public void launchFlyToNewPlanetWindow() {
     		FlyToNewPlanetWindow pilot = new FlyToNewPlanetWindow(this);
     		pilot.setVisible(true);
     	}


     	public void closeSpaceOutpost(SpaceOutpostWindow spaceOutpostWindow) {
     		spaceOutpostWindow.closeWindow();
     		
     	}


     	public String getsecondMessage() {
     		return secondMessage;
     	}


     	public void setsecondMessage(String secondMessage) {
     		this.secondMessage = secondMessage;
     	}


     	public void launchSpaceOutpost() {
     		SpaceOutpostWindow outpost = new SpaceOutpostWindow(this);		
     	}
     	public void launchGameOverWindow() {
     		GameOverWindow gameover = new GameOverWindow(this);
     		gameover.setVisible(true);
     	}


     	public void closeItemsForSale(ItemsForSale itemsForSale) {
     		itemsForSale.closeWindow();
     	}
     	public void launchItemsForSale() {
     		ItemsForSale itemsForSale = new ItemsForSale(this);
     		itemsForSale.setVisible(true);
     	}
     	public boolean isGameIsOver() {
			return gameIsOver;
		}

		public void setGameIsOver(boolean gameIsOver) {
			this.gameIsOver = gameIsOver;
		}

        public void launchWinnerWindow() {
			WinnerWindow winner = new WinnerWindow(this);
			winner.setVisible(true);
		}

     }
