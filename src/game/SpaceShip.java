package game;

public class SpaceShip {
	private int shieldHealth = 100;
	private String shipName;
	
	/* Getter and Setter for 
	 * shieldHealth, shipName
	 */
	
	public int getShieldHealth() {
		return shieldHealth;
	}

	public void setShieldHealth(int shieldHealth) {
		this.shieldHealth = shieldHealth;
	}
	public String getShipName(){
		return shipName;
	}
	public void setShipName(String name) {
		this.shipName = name;
	}
	public void repairShip() {
		setShieldHealth(getShieldHealth() + 100);
		if (getShieldHealth() > 100) {
			shieldHealth = 100;
		}
	}
}
