package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Crew;
import game.Food;
import game.Item;
import game.MedicalItem;
import game.RandomEvents;
import game.SpaceOutpost;
import game.SpaceShip;
import game.Type1;

class GameTest {
	private Crew testCrew;
	private Food apple;
	private MedicalItem medicine;
	private MedicalItem spacePlagueCure;
	private SpaceShip ship;
	private Type1 member;
	private RandomEvents random;
	@BeforeEach
	void init() {
		testCrew = new Crew();
		apple = new Food("apple", 15, 7);
		medicine = new MedicalItem("Medicine", false, 20, 20);
		spacePlagueCure = new MedicalItem("spacePlagueCure", true, 0, 0);
		ship = new SpaceShip();
		member = new Type1("testMember", 25, 2, 40);
		random = new RandomEvents();
	}
	@Test
	void testCrew() {
		ArrayList<Food> testFoodList = new ArrayList<Food>();
		testFoodList.add(apple);
		testCrew.setMoney(10);
		assertEquals(("Successful Purchase of " + apple.getName()), testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), apple));
		assertEquals(3, testCrew.getMoney());
		assertEquals(testFoodList, testCrew.getFoodItems());
		testCrew.setMoney(5);
		assertEquals("Not enough money for purchase", testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), apple));	}
	
	@Test
	void testCrewMember() {
		member.newDay();
		assertEquals(60, member.getTiredness());
		assertEquals(75, member.getHungerLevel());
		member.eat(apple);
		assertEquals(90, member.getHungerLevel());
		member.sleep();
		assertEquals(100, member.getTiredness());
		member.setHealthLevel(0);
		assertEquals(true, member.isDead());
		member.heal(medicine);
		assertEquals(20, member.getHealthLevel());
		member.setSpacePlague(true);
		member.heal(spacePlagueCure);
		assertEquals(false, member.hasSpacePlague());
	}
	
	@Test
	void testFood() {
		assertEquals(("Food: " + apple.getName() + "\nPrice: " + Double.toString(apple.getPrice()) + "\nRemoved Hunger: " +  Integer.toString(apple.getHungerRemoved())), apple.toString());
	}
	@Test
	void testMedicine() {
		assertEquals(("Medicine: " + medicine.getName() + "\nPrice: " + Double.toString(medicine.getPrice()) + "\nHealing Amount: " +  Integer.toString(medicine.getHealingAmount()) + "\nSpace Plague Cure: " + "No"), medicine.toString());
	}
	@Test
	void testSpaceship() {
		ship.setShieldHealth(50);
		ship.repairShip(40);
		assertEquals(90, ship.getShieldHealth());
		assertEquals(("\n" + ship.getShipName() + "'s status:\nShield: " + ship.getShieldHealth() + "\n"), ship.checkShipShield());
	}
	@Test
	void testRandom() {
		ship.setShieldHealth(100);
		random.asteroidBelt(ship);
		assertEquals(60, ship.getShieldHealth());
		ship.setShieldHealth(20);
		random.asteroidBelt(ship);
		assertEquals(10, ship.getShieldHealth());
		
	}
	
}
