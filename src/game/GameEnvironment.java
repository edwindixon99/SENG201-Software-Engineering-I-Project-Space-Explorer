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



/**
 * This is class contains variables and methods which are used throughout the game by other
 * classes. It is also where the main for the entire game is located 
 *
 * @author Matthew Ruffell
 * @version 1.1, Feb 2018.
 */
class GameEnvironment {
	/**
	 * The number planet pieces on one planet. This value is 1 when planet piece not found and 0 when it is.
	 */
     private int planetPieces = 1;
     /**
 	 * A string which is used by other classes to display an output in windows. 
 	 */
     private String message = "";
     /**
 	 * A string which tells certain classes what window to open next.
 	 */
     private String actionTaken;
     /**
 	 * The number of days progressed in the game. increases by one every in game day.
 	 */
     private int daysProgressedThrough = 1;
     /**
 	 * Boolean for whether game needs to end and display end game windows.
 	 */
	private boolean gameIsOver = false; 
	/**
	 * Number of days game will last for inputed by user.
	 */
	private int days;
	/**
	 * CrewMember that is selected used by classes for determining which CrewMember peforms an action.
	 */
     private CrewMember pickedMember;
     /**
 	 * an RandomEvents Object used in this class to access it's methods.
 	 */
     private RandomEvents random = new RandomEvents(); 
     /**
 	 * A Crew Object which is used in this class to access it's methods and acts as the user's crew.
 	 */
     private Crew crew1 = new Crew(); 
     /**
 	 * A SpaceShip Object which is used in this class to access it's methods and acts as the user's spaceship.
 	 */
     private SpaceShip ship = new SpaceShip();
     /**
 	 * A SpaceOutpost Object which is used in this class to access it's methods and acts as the space outpost that can be visited in the game.
 	 */
     private SpaceOutpost outpost = new SpaceOutpost();
     /**
 	 * A string which is an alternative to attribute message. A string which is used by other classes to display an output in windows.
 	 */
     private String secondMessage;
     /**
 	 * A score for the game which increases throughout the game with actions and is displayed 
 	 */  
     private int score = 0;
     /**
 	 * Class constructor
 	 */
	public GameEnvironment() {
     }

    /**
	 * Main class which creates the GameEnvironment and opens the launches the SetupWindow.
	 */
	public static void main(String[] args) {
 		GameEnvironment game = new GameEnvironment();
 		game.playGame();
 		game.launchSetupWindow();
    
 	 }
    /**
	 * Loads the outpost items into the outpost. 
	 */
 	public void playGame() {
 		outpost.setItemsForSale();
 	}
	/**
	 * Setter for days.
	 *
	 * @param day	Number of days
	 */
 	public void setDays(int day) {
 		this.days = day;
 	}
     	
	/**
	 * Game gets progressed to the next day.
	 *
	 * @return 		A message that will be displayed. 			
	 */ 
 	public String nextDay() {
 		String finalString = "";
 		crew1.setDays(crew1.getDays() + 1);
     	ArrayList<CrewMember> crewList = crew1.getCrewMemberList();
     	ArrayList<CrewMember> crewList2 = crew1.getCrewMemberList();
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
 			for (int j = crewList.size()-1; j >= 0; j--) {
 				CrewMember member = crewList2.get(j);
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
 	
	/**
	 * Crew member attempts to fly to a new planet.
	 *
	 * @param memPilot		The crew member attempting to fly.
	 * @return 		A message that will be displayed depending on the crews ability to fly. 			
	 */ 
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
	/**
	 * Crew member attempts to search the planet.
	 *
	 * @param member		The crew member attempting to search the planet.
	 * @return 		A message that will be displayed depending on what is found. 			
	 */ 
 	public String searchPlanet(CrewMember member) {
 		score += 10;
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
          				score += 70;
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


	/**
	 * Crew member attempts to repair the spaceship.
	 *
	 * @param memRepair		The crew member attempting to repair the spaceship.
	 * @return 		A message that will be displayed depending on the what happens to the spaceship. 			
	 */ 
	public String repairShip(CrewMember memRepair) {
		score += 30;
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
	/**
	 * Crew member goes to sleep.
	 *
	 * @param member		The crew member attempting to sleep.
	 * @return 		A message that will be displayed depending on whether or not the sleep was a success. 			
	 */ 
      public String sleep(CrewMember member) {
    	score += 10;
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
  	/**
  	 * Views the type and amounts of owned food the crew owns.
  	 *
  	 * @return 		A string that has 			
  	 */ 

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
    	  score += 10;
    	  ArrayList<Food> foodList = crew1.getFoodItems();
    	  member.eat(food);
    	  member.setActionCounter(member.getActionCounter() - 1);
    	  foodList.remove(food);
    	  return (member.getName() + " has eaten a " + food.getName());
      }
      public String healMethod(CrewMember member, MedicalItem med, int index) {
    	  score += 10;
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
    			  return "Fail";
    		  }else {
    			  finalString += "You have sucessfully piloted the ship to a new planet.\n";
    		  }
    	  }
    	  else {
    		  finalString += "You have sucessfully piloted the ship to a new planet.\n";
    	  }
    	  score += 20;
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
        
     	public int getDaysProgressedThrough() {
			return daysProgressedThrough;
		}
     	
     	public void setDaysProgressedThrough(int daysProgressedThrough) {
			this.daysProgressedThrough = daysProgressedThrough;
		}
     	
     	public int getScore() {
			return score;
		}


		public void setScore(int score) {
			this.score = score;
		}
		public int getCrewMemberScores() {
			int score = 50;
			ArrayList<CrewMember> memberList = crew1.getCrewMemberList();
			for (int i=0;i<memberList.size();i++) {
				score += memberList.get(i).getHealthLevel();
				score += memberList.get(i).getTiredness();
				score += memberList.get(i).getHungerLevel();
			}
			return score;
		}


     }
