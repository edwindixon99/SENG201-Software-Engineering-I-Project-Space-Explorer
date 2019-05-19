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
 * This class contains variables and methods which are used throughout the game by other
 * classes. It is also where the main for the entire game is located 
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class GameEnvironment {
	/**
	 *  An Integer that is the number planet pieces on one planet. This value is 1 when planet piece not found and 0 when it is.
	 */
     private int planetPieces = 1;
     /**
 	 * A string which is used by other classes to display an output in windows relating to an action performed. 
 	 */
     private String message = "";
     /**
 	 * A string which tells certain classes what window to open next.
 	 */
     private String actionTaken;
     /**
 	 *  An Integer that is the number of days progressed in the game. increases by one every in game day.
 	 */
     private int daysProgressedThrough = 1;
     /**
 	 * Boolean for whether game needs to end and display end game windows.
 	 */
	private boolean gameIsOver = false; 
	/**
	 * An Integer that is the number of days the game will last for inputed by user.
	 */
	private int days;
	/**
	 * a CrewMember object that is the crew member that is selected used by classes for determining which CrewMember performs an action.
	 */
     private CrewMember pickedMember;
     /**
 	 * A RandomEvents Object used in this class to access it's methods.
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
 	 * A string which is an alternative to attribute message when two unique messages are needed in one window. It is used by other classes to display an output in windows relating to an action performed.
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
	 * @param day	Integer for the number of days
	 */
 	public void setDays(int day) {
 		this.days = day;
 	}
     	
	/**
	 * Game gets progressed to the next day.
	 *
	 * @return 		A String that is a message that will be displayed relating to what happened in between the current day and the next day. 			
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
	 * @param memPilot		A CrewMember Object that is the crew member attempting to fly.
	 * @return 		A String that is the message that will be displayed depending on the crews ability to fly. 			
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
	 * @param member		A CrewMember Object that is the crew member attempting to search the planet.
	 * @return 		A String that is a message that will be displayed depending on what is found. 			
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
	 * @param memRepair		A CrewMember Object that is the crew member attempting to repair the spaceship.
	 * @return 		A String that is a message that will be displayed depending on the what happens to the spaceship. 			
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
	 * @param member		A CrewMember Object that is the crew member attempting to sleep.
	 * @return 				A String that is a message that will be displayed depending on whether or not the sleep was a success. 			
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
  	 * Makes a multi-line String that shows the name and amount of food owned by the crew.  
  	 * @return			A String that shows all the food items and amounts owned by the crew. 						
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
    	/**
    	 * Makes a multi-line String that shows the name and amount of medical items owned by the crew.  
    	 * @return			A String that shows all the medical items and amounts owned by the crew. 	
    	 */ 
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

  	/**
  	 * Checks conditions of crew member and crew to determine if they can be healed.
  	 *
  	 * @param member		A CrewMember Object that is the crew member attempting to be healed.
  	 * @return 				A String that is a message that will be either displayed on a window or an empty string which causes healMethod() to be called.		
  	 */ 
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

    	/**
    	 * Checks conditions of crew member and crew to determine if they can eat.
    	 *
    	 * @param member		A CrewMember Object that is the crew member attempting to eat.
    	 * @return 		A String that is a message that will be either displayed on a window or an empty string which causes eat() to be called.		
    	 */      
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
  	/**
  	 * Crew member eats a food.
  	 *
  	 * @param member		A CrewMember Object that is the crew member who eats.
  	 * @param food			A Food object that is the food that is consumed.
  	 * @param index			An Integer that is the index of the index of the food in the crews food items list.
  	 * @return 				A String that is a message that will be displayed on a window to say that the crew member has eaten. 	
  	 */       
      public String eat_food(CrewMember member, Food food, int index) {
    	  score += 10;
    	  ArrayList<Food> foodList = crew1.getFoodItems();
    	  member.eat(food);
    	  member.setActionCounter(member.getActionCounter() - 1);
    	  foodList.remove(food);
    	  return (member.getName() + " has eaten a " + food.getName());
      }
    	/**
    	 * Crew member heals with a medical item.
    	 *
    	 * @param member		A CrewMember Object that is the crew member who heals.
    	 * @param med			A MedicalItem object that is the medical item used.
    	 * @param index			An Integer that is the index of the medical item in the crews medical items list.
    	 * @return 				A String that is a message that will be displayed on a window to say that the crew member has healed. 		
    	 */          
      public String healMethod(CrewMember member, MedicalItem med, int index) {
    	  score += 10;
    	  ArrayList<MedicalItem> healList = crew1.getMedicalItems();
    	  member.heal(med);
    	  member.setActionCounter(member.getActionCounter() - 1);
    	  healList.remove(index);
    	  return (member.getName() + " has healed using " + med.getName());
      }
  	/**
  	 * Causes there to be a random event. 1 in 3 chance of either alien pirates, space plague, nothing happening.
  	 *
  	 * @return 		A String that is a message of if a random event occurred which will be displayed on a nextDayPopup window. If no random event occurs returns empty string.
  	 */     
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
      
  	/**
  	 * Crew member successfully flies spaceship to new planet.
  	 *
  	 * @param memPilot		A CrewMember Object that is the crew member who pilots the spaceship.
  	 * @param pilotList		An ArrayList of crew members that piloted the spaceship.
  	 * @return 		A String that is a message that will be displayed on a FlytoNewPlanet window about the flight.	
  	 */        
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

  	/**
  	 * @param actionTaken1		A String that is the action taken chosen in the MainWindow.
  	 */
     public void setActTaken(String actionTaken1) {
     	actionTaken = actionTaken1;
     }
    	/**
    	 * @return 			A String that contains an action that classes use.
    	 */
     public String getActTaken() {
     	return actionTaken;
     }
 	/**
 	 * @return 			A CrewMember object that is the selected crew member.
 	 */
     public CrewMember getPickedMember() {
     	return pickedMember;
     }
   	/**
   	 * @param pickedMember1 			A CrewMember Object that is the Crew member selected to perform an action.
   	 */
     public void setPickedMember(CrewMember pickedMember1) {
     	pickedMember = pickedMember1;
     }
    	/**
    	 * @param message 			A String that is a message which is used by other classes to display an output in windows.
    	 */
     public void setMessage(String message) {
     	this.message = message;
     }
 	/**
 	 * @return 			A String that is a message which is used by other classes to display an output in windows.
 	 */
     public String getMessage() {
     	return message;
     }
 	/**
 	 * @return			A Crew object that is the crew used in the game.				
 	 */
 	public Crew getCrew1() {
 		return crew1;
 	}
	/**
	 * @param crew			A Crew object that is the crew used in the game.			
	 */
 	public void setCrew1(Crew crew) {
 		crew1 = crew;
 	}
	/**
	 * @return		A SpaceShip object that is the crews ship.				
	 */
 	public SpaceShip getShip() {
 		return ship;
 	}
	/**
	 * @param ship1			A SpaceShip object that is the crews ship.				
	 */
 	public void setShip(SpaceShip ship1) {
 		ship = ship1;
 	}
  	/**
  	 * Closes the setup window.
  	 *
  	 * @param setupWindow 			A SetupWindow object. The window which makes the game based on users inputs.
  	 */  
 	public void closeSetupScreen(SetupWindow setupWindow) {
 		setupWindow.closeWindow();
 		launchMainScreen(); 
 		}
  	/**
  	 * Closes the Eat window.
  	 *
  	 * @param eat			An Eat object. The window where user decides what food to eat.
  	 */  
 	public void closeEat(Eat eat) {
 		eat.closeWindow();
 	}
  	/**
  	 * Closes the Heal window.
  	 *
  	 * @param heal			A Heal object. The window where user decides what medical item to use.
  	 */  
 	public void closeHeal(Heal heal) {
 		heal.closeWindow();
 	}
  	/**
  	 * Launches the MainWindow.
  	 *
  	 */  
 	public void launchMainScreen() { 
 		MainWindow mainScreen = new MainWindow(this);
 	  }
  	/**
  	 * Closes the Main window
  	 *
  	 * @param main			A MainWindow object. The main window where all stats and action options.
  	 */  
 	public void closeMainScreen(MainWindow main) { 
 		main.closeWindow();
 	}
  	/**
  	 * Launches the Setup Window
  	 *
  	 */  
 	public void launchSetupWindow() { 
 		  SetupWindow setup = new SetupWindow(this); 
 	 }
 	
  	/**
  	 * launches the Eat window.
  	 * 
  	 * @param member	 A CrewMember Object that is the crew member that will eat.
  	 */  
 	public void launchEatWindow(CrewMember member) {
 		Eat eat = new Eat(this, member);
 		eat.setVisible(true);
 	}
 	
  	/**
  	 * Launches the Heal window.
  	 * 
  	 * @param member		 A CrewMember Object that is the crew member that will heal.
  	 */  
 	public void launchHealWindow(CrewMember member) {
 		Heal heal = new Heal(this, member);
 		heal.setVisible(true);
 	}
  	/**
  	 * Launches the MemberSelection window.
  	 * 
  	 */  
 	public void launchMemberSelection() {
 		MemberSelection memberSelection = new MemberSelection(this);
     }
     
  	/**
  	 * converts a string to a multiple line string for windows.
  	 * 
  	 * @param orig		 A String that is the original string. 
  	 * @return 			A string that can be displayed as multiple lines for windows.
  	 */  
 	public String convertToMultiline(String orig) {
 	    return "<html>" + orig.replaceAll("\n", "<br>");
 	}
  	/**
  	 * Launches the MemberSelection window.
  	 * 
  	 */ 
 	public void launchCrewMemberSelection() {
 		MemberSelection memberSelection = new MemberSelection(this);
 		memberSelection.setVisible(true);
 	}

  	/**
  	 * Closes the MemberSelection Window.
  	 * 
  	 * @param memberSelection		A MemberSelection object that is the MemberSelection window. 
  	 */  
 	public void closeMemberSelection(MemberSelection memberSelection) {
 		memberSelection.closeWindow();
 	}
  	/**
  	 * Launches the SearchPlanet window.
  	 * 
  	 */ 
 	public void launchSearchWindow() { 
 		  SearchPlanet search = new SearchPlanet(this);
 		  search.setVisible(true);
 	 }
  	/**
  	 * Launches the FlyToNewPlanet window.
  	 * 
  	 */ 
 	public void launchFlyToNewPlanetWindow() {
 		FlyToNewPlanetWindow pilot = new FlyToNewPlanetWindow(this);
 		pilot.setVisible(true);
 	}

	/**
	 * Closes the space outpost window.
	 * 
	 * @param spaceOutpostWindow		A SpaceOutpostWindow object that is the space outpost window.
	 */
 	public void closeSpaceOutpost(SpaceOutpostWindow spaceOutpostWindow) {
 		spaceOutpostWindow.closeWindow();
 		
 	}

	/**
	 * @return 			A String that is a second message used by windows.
	 */
 	public String getsecondMessage() {
 		return secondMessage;
 	}

	/**
	 * @param secondMessage			A String that is a second message that is displayed in windows.
	 */
 	public void setsecondMessage(String secondMessage) {
 		this.secondMessage = secondMessage;
 	}

	/**
	 * Launches the items for space outpost window.
	 */
 	public void launchSpaceOutpost() {
 		SpaceOutpostWindow outpost = new SpaceOutpostWindow(this);		
 	}
	/**
	 * Launches the game over window.
	 */
 	public void launchGameOverWindow() {
 		GameOverWindow gameover = new GameOverWindow(this);
 		gameover.setVisible(true);
 	}

	/**
	 * Closes the items for sale window.
	 * @param itemsForSale				An ItemsForSale object that is the items for sale window.
	 */
 	public void closeItemsForSale(ItemsForSale itemsForSale) {
 		itemsForSale.closeWindow();
 	}
	/**
	 * Launches the items for sale window.
	 */
 	public void launchItemsForSale() {
 		ItemsForSale itemsForSale = new ItemsForSale(this);
 		itemsForSale.setVisible(true);
 	}
	/**
	 * @return 				Boolean that dictates whether the game is over.
	 */
 	public boolean isGameIsOver() {
		return gameIsOver;
	}
	/**
	 * @param gameIsOver				Boolean that dictates whether the game is over.
	 */
	public void setGameIsOver(boolean gameIsOver) {
		this.gameIsOver = gameIsOver;
	}
	/**
	 * Launches the winner window.
	 */
    public void launchWinnerWindow() {
		WinnerWindow winner = new WinnerWindow(this);
		winner.setVisible(true);
	}
	/**
	 * @return 			An Integer for the days the game has progressed through.
	 */
 	public int getDaysProgressedThrough() {
		return daysProgressedThrough;
	}
	/**
	 * @param daysProgressedThrough			An Integer for the days the game has progressed through.
	 */
 	public void setDaysProgressedThrough(int daysProgressedThrough) {
		this.daysProgressedThrough = daysProgressedThrough;
	}
  	/**
  	 *  
  	 * @return		An Integer for the game score.
  	 */ 
 	public int getScore() {
		return score;
	}

	/**
	 * @param score			An Integer for the game score.
	 */
	public void setScore(int score) {
		this.score = score;
	}
  	/**
  	 * Makes a score that will be added to the total based on the crew members stats.
  	 *  
  	 * @return			An Integer for the score based on crew members stats.
  	 */ 
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
