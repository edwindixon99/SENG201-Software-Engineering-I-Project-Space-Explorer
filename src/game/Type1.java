package game;

public class Type1 extends CrewMember {
	public Type1(String name, int tempHunger, int tempHealth, int tempTiredness) {
		setName(name);
		setHungerDegrade(tempHunger);
		setHealthDegrade(tempHealth);
		setTirednessDegrade(tempTiredness);
	}
}
