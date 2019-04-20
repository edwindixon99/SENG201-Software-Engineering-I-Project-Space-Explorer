package game;

public class SpaceShip {
	private String shipName;
	private int shieldHealth;
	
	/* Getter and Setter for 
	 * shieldHealth
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
			getShieldHealth();
		}
	}
	public static void main(String[] args) {   // random testing
		SpaceShip rocket = new SpaceShip();
		System.out.println(rocket.getShieldHealth());
	}
	
}
