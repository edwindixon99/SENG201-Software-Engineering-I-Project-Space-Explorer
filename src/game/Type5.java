
package game;
/**
 * This is the class for crew members that are of type 5. This class extends the CrewMember class.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class Type5 extends CrewMember {
	/**
	 * This is a constructor for Type5. This sets the name, along with the hunger, health and tiredness degrade for the crew members of type 5.
	 * 
	 * @param name		A String that is the name of the crew member.
	 * @param hungerDegrade		An Integer that is the rate that the crew members hunger level declines.
	 * @param healthDegrade		An Integer that is the rate that the crew members health level declines.
	 * @param tirednessDegrade		An Integer that is the rate that the crew members tiredness level declines.
	 */
	public Type5(String name, int hungerDegrade,int healthDegrade, int tirednessDegrade) {
		setName(name);
		setHungerDegrade(hungerDegrade);
		setHealthDegrade(healthDegrade);
		setTirednessDegrade(tirednessDegrade);
		setType("Type 5");
	}
}
