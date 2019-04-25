package game;

public class Type6 extends CrewMember {
	public Type6(String name, int tempHunger,int tempHealth, int tempTiredness) {
		setName(name);
		setHungerDegrade(tempHunger);
		setHealthDegrade(tempHealth);
		setTirednessDegrade(tempTiredness);
	}
}
