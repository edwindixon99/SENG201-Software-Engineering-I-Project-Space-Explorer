package game;

public class MedicalItem extends Item {
	private boolean spacePlagueCure;
	private int healingAmount;
	
	
	// Constructor for MedicalItem
	public MedicalItem(String tempName, boolean tempSpacePlagueCure, int tempHealingAmount, double tempPrice) {
		setName(tempName);
		spacePlagueCure = tempSpacePlagueCure;
		healingAmount = tempHealingAmount;
		setPrice(tempPrice);
	}
	
	public String toString() {					
		String spacePlagueCure = "No";
		if (isSpacePlagueCure()) {
			spacePlagueCure = "Yes";
		}
		return "Medicine: " + getName() + "\nPrice: " + Double.toString(getPrice()) + "\nHealing Amount: " +  Integer.toString(healingAmount) + "\nSpace Plague Cure: " + spacePlagueCure;
	}
	
	
	
	/* Getter and Setter for 
	 * spacePlague
	 * healingAmount
	 */
	
	
	public boolean isSpacePlagueCure() {
		return spacePlagueCure;
	}
	public void setSpacePlagueCure(boolean spacePlagueCure) {
		this.spacePlagueCure = spacePlagueCure;
	}
	public int getHealingAmount() {
		return healingAmount;
	}
	public void setHealingAmount(int healingAmount) {
		this.healingAmount = healingAmount;
	}

	

}
