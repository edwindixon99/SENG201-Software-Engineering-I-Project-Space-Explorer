package game;

public class Type_1 extends CrewMember {
	private int hungerDegradeValue = 10;
	private int healthDegradeValue = 10;
	private int tirednessDegradeValue = 10;
	
	
	 
	
	public void depletedHunger(){
		healthDegradeValue += 10; 
	}
	
	public void depletedtiredness(){
		healthDegradeValue += 10; 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// getters and setters
	public int getHealthDegradeValue() {
		return healthDegradeValue;
	}


	public void setHealthDegradeValue(int healthDegradeValue) {
		this.healthDegradeValue = healthDegradeValue;
	}


	public int getTirednessDegradeValue() {
		return tirednessDegradeValue;
	}


	public void setTirednessDegradeValue(int tirednessDegradeValue) {
		this.tirednessDegradeValue = tirednessDegradeValue;
	}


	public int getHungerDegradeValue() {
		return hungerDegradeValue;
	}


	public void setHungerDegradeValue(int hungerDegradeValue) {
		this.hungerDegradeValue = hungerDegradeValue;
	}
	
	
}

