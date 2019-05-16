package game;
/**
 * This is the class for crew members that are of type 2. This class extends the CrewMember class.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class Type2 extends CrewMember {
	/**
	 * This is a constructor for Type2. This sets the name, along with the hunger, health and tiredness degrade for the crew members of type 2.
	 * 
	 * @param name		The name of the crew member
	 * @param hungerDegrade		The rate at which the crew members hunger level declines
	 * @param healthDegrade		The rate that the crew members health level declines
	 * @param tirednessDegrade		The rate that the crew members tiredness level declines
	 */
	public Type2(String name, int hungerDegrade, int healthDegrade, int tirednessDegrade) {
		setName(name);
		setHungerDegrade(hungerDegrade);
		setHealthDegrade(healthDegrade);
		setTirednessDegrade(tirednessDegrade);
	}
}
