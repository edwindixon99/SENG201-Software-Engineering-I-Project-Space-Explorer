package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Crew;
import game.CrewMember;
import game.Food;
import game.MedicalItem;
import game.Type1;
import game.Type2;
import game.Type3;
import game.Type4;
import game.Type5;
import game.Type6;

class TestCrewMember {
	private Food apple;
	private Food pizza;
	private MedicalItem smallHealing;
	private MedicalItem bigHealing;
	private Type1 testCrewMember1;
	private Type2 testCrewMember2;
	private Type3 testCrewMember3;
	private Type4 testCrewMember4;
	private Type5 testCrewMember5;
	private Type6 testCrewMember6;
	private MedicalItem spacePlagueCure;
	
	@BeforeEach
	void init() {
		testCrewMember1 = new Type1("", 40, 2, 10);
		testCrewMember2 = new Type2("", 10, 1, 25);
		testCrewMember3 = new Type3("", 25, 4, 40);
		testCrewMember4 = new Type4("", 25, 1, 25);
		testCrewMember5 = new Type5("", 25, 2, 40);
		testCrewMember6 = new Type6("", 40, 2, 25);
		apple = new Food("apple", 15, 7);
		pizza = new Food("pizza", 50, 25);
		smallHealing = new MedicalItem("Small Healing", false, 10, 5);
		bigHealing = new MedicalItem("Big Healing", false, 40, 20);
		spacePlagueCure = new MedicalItem("Space Plague Cure", true, 0, 15);
		testCrewMember1.setActionCounter(2);
	}
	@Test
	void testEat() {
		testCrewMember1.setHungerLevel(40);
		assertTrue(testCrewMember1.getHungerLevel() == 40);
		
		testCrewMember1.eat(pizza);
		assertTrue(testCrewMember1.getHungerLevel() == 90);
		
		testCrewMember1.eat(apple);
		assertTrue(testCrewMember1.getHungerLevel() == 100);
	}
	
	@Test
	void testHeal() {
		testCrewMember1.setHealthLevel(55);
		assertTrue(testCrewMember1.getHealthLevel() == 55);
		
		testCrewMember1.heal(smallHealing);
		assertTrue(testCrewMember1.getHealthLevel() == 65);
		
		testCrewMember1.heal(bigHealing);
		assertTrue(testCrewMember1.getHealthLevel() == 100);
		
		testCrewMember1.setSpacePlague(true);
		assertTrue(testCrewMember1.hasSpacePlague());
		testCrewMember1.heal(spacePlagueCure);
		assertFalse(testCrewMember1.hasSpacePlague());
	}
	@Test
	void testSleep() {
		assertTrue(testCrewMember1.getActionCounter() == 2);
		
		testCrewMember1.setTiredness(1);
		assertTrue(testCrewMember1.getTiredness() == 1);
		
		testCrewMember1.sleep();
		assertTrue(testCrewMember1.getTiredness() == 100);
		
		assertTrue(testCrewMember1.getActionCounter() == 1);
	}
	@Test
	void testIsDead() {
		assertFalse(testCrewMember1.isDead());
		testCrewMember1.setHealthLevel(0);
		assertTrue(testCrewMember1.isDead());
	}
	@Test
	void testNextDay() {
		// All Tests are for crew members of type 1, and so the results will vary for different types
		assertTrue(testCrewMember1.getHungerLevel()==100);
		assertTrue(testCrewMember1.getHealthLevel()==100);
		assertTrue(testCrewMember1.getTiredness()==100);
		
		testCrewMember1.newDay();
		assertTrue(testCrewMember1.getHungerLevel()==60); 
		assertTrue(testCrewMember1.getHealthLevel()==100);
		assertTrue(testCrewMember1.getTiredness()==90);
		
		testCrewMember1.setTiredness(20);
		testCrewMember1.newDay();
		testCrewMember1.newDay();
		System.out.println(testCrewMember1.getHealthLevel());
		assertTrue(testCrewMember1.getHungerLevel()==0);
		assertTrue(testCrewMember1.getHealthLevel()==70);
		assertTrue(testCrewMember1.getTiredness()==0);
		
		testCrewMember1.setHealthLevel(100);
		testCrewMember1.setHungerLevel(100);
		testCrewMember1.setTiredness(100);
		assertTrue(testCrewMember1.getHealthLevel()==100);
		testCrewMember1.setSpacePlague(true);
		testCrewMember1.newDay();
		assertTrue(testCrewMember1.getHealthLevel()==90);		
	}
	
	@Test
	void testViewStatus(){
		assertEquals((testCrewMember1.getName() + "'s status: \nHealth level: " + testCrewMember1.getHealthLevel() + "\nHunger level: " + testCrewMember1.getHungerLevel() + "\nTiredness: " + testCrewMember1.getTiredness() + "\nSpacePlague: " + testCrewMember1.hasSpacePlague() + "\nActions left: " + testCrewMember1.getActionCounter()  + "\nType: " + testCrewMember1.getType() + "\n"), testCrewMember1.viewStatus());
	}
}
