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
