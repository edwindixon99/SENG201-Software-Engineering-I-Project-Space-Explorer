package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import game.Crew;
import game.Food;
import game.MedicalItem;
import game.RandomEvents;
import game.SpaceShip;
import game.Type1;

class TestCrew {
	private Food apple;
	private Food pizza;
	private MedicalItem smallHealing;
	private MedicalItem bigHealing;
	private Crew testCrew;
	private SpaceShip testShip;
	private RandomEvents testRandom;
	
	
	@BeforeEach
	void init() {
		testRandom = new RandomEvents();
		testCrew = new Crew();
		testShip = new SpaceShip();
		apple = new Food("apple", 15, 7);
		pizza = new Food("pizza", 50, 25);
		smallHealing = new MedicalItem("Small Healing", false, 10, 5);
		bigHealing = new MedicalItem("Big Healing", false, 40, 20);
		testCrew.setMoney(100);
	}
	@Test
	void testFoodBuy() {		
		assertTrue(testCrew.getFoodItems().size() == 0);
		
		testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), apple);
		testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), pizza);
	
		assertTrue(testCrew.getFoodItems().get(0).getName().equals(apple.getName()));
		assertTrue(testCrew.getFoodItems().get(1).getName().equals(pizza.getName()));
		assertTrue(testCrew.getFoodItems().size() == 2);
		
		assertEquals(("Successful Purchase of " + apple.getName()), testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), apple));
		
		testCrew.setMoney(2);
		assertEquals("Not enough money for purchase", testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), apple));}
	
	@Test
	void testMedicalBuy() {		
		assertTrue(testCrew.getMedicalItems().size() == 0);
		
		testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), smallHealing);
		testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), bigHealing);
		
		assertTrue(testCrew.getMedicalItems().get(0).getName().equals(smallHealing.getName()));
		assertTrue(testCrew.getMedicalItems().get(1).getName().equals(bigHealing.getName()));
		assertTrue(testCrew.getMedicalItems().size() == 2);
		
		assertEquals(("Successful Purchase of " + smallHealing.getName()), testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), smallHealing));
		
		testCrew.setMoney(2);
		assertEquals("Not enough money for purchase", testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), bigHealing));}
	
	@Test
	void testMoney() {		
		assertTrue(testCrew.getMoney() == 100);
		testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), apple);
		assertTrue(testCrew.getMoney() == 93);
		testCrew.buy(testCrew.getFoodItems(), testCrew.getMedicalItems(), bigHealing);
		assertTrue(testCrew.getMoney() == 73);
		}
	@Test
	void testShip() {		
		assertEquals(100, testShip.getShieldHealth());
		testRandom.asteroidBelt(testShip);
		assertEquals(60, testShip.getShieldHealth());
		assertEquals(("\n" + testShip.getShipName() + "'s status:\nShield: " + testShip.getShieldHealth() + "\n"), testShip.checkShipShield());
		testShip.repairShip(50);
		assertEquals(100, testShip.getShieldHealth());
		}
}


