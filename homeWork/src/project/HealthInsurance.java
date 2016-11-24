package project;

import java.io.Serializable;

public class HealthInsurance extends PersonInsurance implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private int PersonAge;
	
	public HealthInsurance(	int insuranceYearCost, int insuranceRisk,String InsuranceName, int InsuranceTime,int PersonAge) {
		super(insuranceYearCost, insuranceRisk, InsuranceName,InsuranceTime);
		this.PersonAge=PersonAge;
	}

	public int getPersonAge() {
		return PersonAge;
	}

	public void setPersonAge(int personAge) {
		PersonAge = personAge;
	}

	@Override
	public String toString() {
		return "Страховка здоровья: Стоимость страховки="
				+ getInsuranceCost() + ", Название страховки="
				+ getInsuranceName() + ", Длительность страховки="
				+ getInsuranceTime() + ", Возраст страхуемого="
				+ getPersonAge() + ", Страховые риски%()="
				+ getInsuranceRisk();
	}

	
}


