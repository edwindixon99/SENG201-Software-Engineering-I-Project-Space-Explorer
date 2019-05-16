package game;
/**
 * This is the class for medical items, which is an extension of the Item class. It contains all variables and methods that are specifically for Medical items alone
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class MedicalItem extends Item {
	/**
	 * A boolean that represents whether or not the medical item can cure the space plague
	 */
	private boolean spacePlagueCure;
	/**
	 * The amount of health that the medical item will restore.
	 */
	private int healingAmount;
	
	
	/**
	 * A constructor for MedicalItem. It will set the name, price, healing amount and effectiveness against the space plague for all medical items
	 * @param tempName		The name of the medical item.
	 * @param tempSpacePlagueCure		Whether or not the medical item cures space plague.
	 * @param tempHealingAmount		How much health the medical item will restore
	 * @param tempPrice		The price of the medical item
	 * 
	 */
	public MedicalItem(String tempName, boolean tempSpacePlagueCure, int tempHealingAmount, double tempPrice) {
		setName(tempName);
		spacePlagueCure = tempSpacePlagueCure;
		healingAmount = tempHealingAmount;
		setPrice(tempPrice);
	}
	/**
	 * Returns a MedicalItem object in the form of a string. It was used for testing and is no longer used.
	 * @return		A string that contains all of the attributes of the item
	 */
	public String toString() {					
		String spacePlagueCure = "No";
		if (isSpacePlagueCure()) {
			spacePlagueCure = "Yes";
		}
		return "Medicine: " + getName() + "\nPrice: " + Double.toString(getPrice()) + "\nHealing Amount: " +  Integer.toString(healingAmount) + "\nSpace Plague Cure: " + spacePlagueCure;
	}
	/**
	 * @return		A boolean that checks whether the medical item can cure space plague or not
	 */
	public boolean isSpacePlagueCure() {
		return spacePlagueCure;
	}
	/**
	 * @param spacePlagueCure		A boolean that determines whether the medical item can cure the space plague
	 */
	public void setSpacePlagueCure(boolean spacePlagueCure) {
		this.spacePlagueCure = spacePlagueCure;
	}
	/**
	 * @return		The amount of health the medical item restores
	 */
	public int getHealingAmount() {
		return healingAmount;
	}
	/**
	 * @param healingAmount		the amount of health the medical item restores
	 */
	public void setHealingAmount(int healingAmount) {
		this.healingAmount = healingAmount;
	}

	

}
