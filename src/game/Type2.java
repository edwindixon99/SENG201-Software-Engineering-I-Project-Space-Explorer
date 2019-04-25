package game;

public class Type2 extends CrewMember {
	public Type2(String name, int tempHunger, int tempHealth, int tempTiredness) {
		setName(name);
		setHungerDegrade(tempHunger);
		setHealthDegrade(tempHealth);
		setTirednessDegrade(tempTiredness);
	}
}
