package game;

public class Type4 extends CrewMember {
	public Type4(String name, int tempHunger,int tempHealth, int tempTiredness) {
		setName(name);
		setHungerDegrade(tempHunger);
		setHealthDegrade(tempHealth);
		setTirednessDegrade(tempTiredness);
	}
}
