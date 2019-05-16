package game;
/**
 * This is the class for the space ship, and includes methods and variables that affect the spaceship.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class SpaceShip {
	/**
	 * The level of the ships shield
	 */
	private int shieldHealth = 100;
	/**
	 * The ships name
	 */
	private String shipName;
	/**
	 * repairs the ships shield, while making sure that it does not go over its maximum of 100
	 * 
	 * @param repair		How much the ships shield is getting repaired by.		
	 */
	public void repairShip(int repair) {
		setShieldHealth(getShieldHealth() + repair);
		if (getShieldHealth() > 100) {
			shieldHealth = 100;
		}
	}
	/**
	 * Gets the ships shield and name and returns them in a string
	 * 
	 * @return		Returns the ships name and shield level in a string
	 */
	public String checkShipShield() {
		return ("\n" + shipName + "'s status:\nShield: " + shieldHealth + "\n");
	}
	/**
	 * @return		The ships shield level
	 */
	public int getShieldHealth() {
		return shieldHealth;
	}
	/**
	 * @param shieldHealth		The ships shield level
	 */
	public void setShieldHealth(int shieldHealth) {
		this.shieldHealth = shieldHealth;
	}
	/**
	 * @return		The ships name
	 */
	public String getShipName(){
		return shipName;
	}
	/**
	 * @param name		The ships name
	 */
	public void setShipName(String name) {
		this.shipName = name;
	}

}
