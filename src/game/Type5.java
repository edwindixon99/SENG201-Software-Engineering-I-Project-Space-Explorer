package game;

public class Type5 extends CrewMember {
	public Type5(String name, int tempHunger,int tempHealth, int tempTiredness) {
		setName(name);
		setHungerDegrade(tempHunger);
		setHealthDegrade(tempHealth);
		setTirednessDegrade(tempTiredness);
	}
}
