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

class TestCrewMember {
	private Food apple;
	private Food pizza;
	private MedicalItem smallHealing;
	private MedicalItem bigHealing;
	private Type1 testCrewMember;
	private MedicalItem spacePlagueCure;
	
	@BeforeEach
	void init() {
		testCrewMember = new Type1("testMember", 40, 2, 10);
		apple = new Food("apple", 15, 7);
		pizza = new Food("pizza", 50, 25);
		smallHealing = new MedicalItem("Small Healing", false, 10, 5);
		bigHealing = new MedicalItem("Big Healing", false, 40, 20);
		spacePlagueCure = new MedicalItem("Space Plague Cure", true, 0, 15);
		testCrewMember.setActionCounter(2);
	}
	@Test
	void testEat() {
		testCrewMember.setHungerLevel(40);
		assertTrue(testCrewMember.getHungerLevel() == 40);
		
		testCrewMember.eat(pizza);
		assertTrue(testCrewMember.getHungerLevel() == 90);
		
		testCrewMember.eat(apple);
		assertTrue(testCrewMember.getHungerLevel() == 100);
	}
	
	@Test
	void testHeal() {
		testCrewMember.setHealthLevel(55);
		assertTrue(testCrewMember.getHealthLevel() == 55);
		
		testCrewMember.heal(smallHealing);
		assertTrue(testCrewMember.getHealthLevel() == 65);
		
		testCrewMember.heal(bigHealing);
		assertTrue(testCrewMember.getHealthLevel() == 100);
		
		testCrewMember.setSpacePlague(true);
		assertTrue(testCrewMember.hasSpacePlague());
		testCrewMember.heal(spacePlagueCure);
		assertFalse(testCrewMember.hasSpacePlague());
	}
	@Test
	void testSleep() {
		assertTrue(testCrewMember.getActionCounter() == 2);
		
		testCrewMember.setTiredness(1);
		assertTrue(testCrewMember.getTiredness() == 1);
		
		testCrewMember.sleep();
		assertTrue(testCrewMember.getTiredness() == 100);
		
		assertTrue(testCrewMember.getActionCounter() == 1);
	}
	@Test
	void testIsDead() {
		assertFalse(testCrewMember.isDead());
		testCrewMember.setHealthLevel(0);
		assertTrue(testCrewMember.isDead());
	}
	@Test
	void testNextDay() {
		// All Tests are for crew members of type 1, and so the results will vary for different types
		assertTrue(testCrewMember.getHungerLevel()==100);
		assertTrue(testCrewMember.getHealthLevel()==100);
		assertTrue(testCrewMember.getTiredness()==100);
		
		testCrewMember.newDay();
		assertTrue(testCrewMember.getHungerLevel()==60); 
		assertTrue(testCrewMember.getHealthLevel()==100);
		assertTrue(testCrewMember.getTiredness()==90);
		
		testCrewMember.newDay();
		testCrewMember.newDay();
		assertTrue(testCrewMember.getHungerLevel()==0);
		assertTrue(testCrewMember.getHealthLevel()==85);
		assertTrue(testCrewMember.getTiredness()==70);
		
		testCrewMember.setHealthLevel(100);
		testCrewMember.setHungerLevel(100);
		assertTrue(testCrewMember.getHealthLevel()==100);
		testCrewMember.setSpacePlague(true);
		testCrewMember.newDay();
		assertTrue(testCrewMember.getHealthLevel()==90);		
	}

}
