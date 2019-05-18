package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Crew;
import game.CrewMember;
import game.Food;
import game.Item;
import game.MedicalItem;
import game.RandomEvents;
import game.SpaceShip;

class TestRandom {
		private Food apple;
		private Food pizza;
		private MedicalItem smallHealing;
		private MedicalItem bigHealing;
		private Crew testCrew;
		private SpaceShip testShip;
		private CrewMember testCrewMember;
		private RandomEvents testRandom;
		
		@BeforeEach
		void init() {
			testCrewMember = new CrewMember();
			testCrew = new Crew();
			testShip = new SpaceShip();
			testRandom = new RandomEvents();
			apple = new Food("apple", 15, 7);
			pizza = new Food("pizza", 50, 25);
			smallHealing = new MedicalItem("Small Healing", false, 10, 5);
			bigHealing = new MedicalItem("Big Healing", false, 40, 20);
		}
		@Test
		void testPirates() {
			ArrayList<Food> testFoodList = new ArrayList<Food>();
			ArrayList<MedicalItem> testMedicalList = new ArrayList<MedicalItem>();
			
			assertTrue(testFoodList.size()==0);
			assertTrue(testMedicalList.size()==0);
			assertEquals("Alien Pirates have boared the ship!\n\nThe alien Pirates have disembarked", testRandom.alienPirates(testCrew)); //If the there are no items to steal
			
			testFoodList.add(apple);
			testMedicalList.add(bigHealing);
			testCrew.setFoodItems(testFoodList);
			testCrew.setMedicalItems(testMedicalList);
			
			assertTrue(testMedicalList.size()==1);
			assertTrue(testFoodList.size()==1);
			testRandom.alienPirates(testCrew);
			if (testMedicalList.size() < testFoodList.size()) {
				assertTrue(testMedicalList.size()==0);
			}
			else {
				assertTrue(testFoodList.size()==0);
			}
			}
		@Test
		void testAsteroidBelt() {
			assertEquals(100, testShip.getShieldHealth());
			testRandom.asteroidBelt(testShip);
			assertEquals(60, testShip.getShieldHealth());
			
			testShip.setShieldHealth(20);
			testRandom.asteroidBelt(testShip);
			assertEquals(10, testShip.getShieldHealth()); // Shows that the damage done to the shield is scaled depending on what the shield level is
		}
		
		@Test
		void testSpacePlague() {
			ArrayList<CrewMember> testCrewMemberList = new ArrayList<CrewMember>();
			testCrewMemberList.add(testCrewMember);
			testCrew.setCrewMemberList(testCrewMemberList);
			
			assertFalse(testCrew.getCrewMemberList().get(0).hasSpacePlague());
			assertEquals(100, testCrew.getCrewMemberList().get(0).getHealthLevel());
			testRandom.spacePlague(testCrew);
			assertTrue(testCrew.getCrewMemberList().get(0).hasSpacePlague());
			assertEquals(80, testCrew.getCrewMemberList().get(0).getHealthLevel());
		}
		
	}
