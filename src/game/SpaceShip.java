package game;

public class SpaceShip {
	private static int shieldHealth = 100;
	private static String shipName;
	
	/* Getter and Setter for 
	 * shieldHealth, shipName
	 */
	
	public int getShieldHealth() {
		return shieldHealth;
	}

	public void setShieldHealth(int shieldHealth) {
		this.shieldHealth = shieldHealth;
	}
	public static String getShipName(){
		return shipName;
	}
	public void setShipName(String name) {
		this.shipName = name;
	}
	public void repairShip(int repair) {
		setShieldHealth(getShieldHealth() + repair);
		if (getShieldHealth() > 100) {
			shieldHealth = 100;
		}
	}
	public static String checkShipShield() {
		System.out.println(getShipName());
		return ("\n" + shipName + "'s status:\nShield: " + shieldHealth + "\n");
	}
}
