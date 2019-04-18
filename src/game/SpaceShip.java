package game;

public class SpaceShip {
	private int shieldHealth;
	
	/* Getter and Setter for 
	 * shieldHealth
	 */
	
	public SpaceShip(int tempShieldHealth) {
		shieldHealth = tempShieldHealth;
	}
	
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
	
	public static void main(String[] args) {   // random testing
		SpaceShip rocket = new SpaceShip(100);
		System.out.println(rocket.getShieldHealth());
	}
	
}
