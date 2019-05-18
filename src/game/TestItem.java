package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Crew;
import game.Food;
import game.Item;
import game.MedicalItem;
import game.SpaceOutpost;

class TestItem {
	Food Apple = new Food("Apple", 15, 7);
	Food Sandwich = new Food("Sandwich", 25, 12);
	Food Pie = new Food("Pie", 30, 15);
	Food Burger = new Food("Burger", 40, 20);
	Food Pizza = new Food("Pizza", 50, 25);
	Food Biscut = new Food("Biscut", 10, 5);
	MedicalItem SmallHealing = new MedicalItem("Small Healing", false, 10, 5);
	MedicalItem BigHealing = new MedicalItem("Big Healing", false, 40, 20);
	MedicalItem Spaceplaguecure = new MedicalItem("Space Plague Cure", true, 0, 15);
	
    @Test
    public void testGetPrice() {
        assertEquals(Apple.getPrice(), 7);
        assertEquals(Sandwich.getPrice(), 12);
        assertEquals(Pie.getPrice(), 15);
        assertEquals(Burger.getPrice(), 20);
        assertEquals(Pizza.getPrice(), 25);
        assertEquals(Biscut.getPrice(), 5);
        assertEquals(SmallHealing.getPrice(), 5);
        assertEquals(BigHealing.getPrice(), 20);
        assertEquals(Spaceplaguecure.getPrice(), 15);
    }

    @Test
    public void testGetHungerRemoved() {
    	 assertEquals(Apple.getHungerRemoved(), 15);
         assertEquals(Sandwich.getHungerRemoved(), 25);
         assertEquals(Pie.getHungerRemoved(), 30);
         assertEquals(Burger.getHungerRemoved(), 40);
         assertEquals(Pizza.getHungerRemoved(), 50);
         assertEquals(Biscut.getHungerRemoved(), 10);
    }

    @Test
    public void healingAmount() {
    	 assertEquals(SmallHealing.getHealingAmount(), 10);
         assertEquals(BigHealing.getHealingAmount(), 40);
         assertEquals(Spaceplaguecure.getHealingAmount(), 0);
    }

    @Test
    public void testSpacePlague() {
        assertTrue(Spaceplaguecure.isSpacePlagueCure());
        assertFalse(SmallHealing.isSpacePlagueCure());
        assertFalse(BigHealing.isSpacePlagueCure());
    }
}
