package project;



public class HealthInsurance extends PersonInsurance{
	
	private static final long serialVersionUID = 3L;
	private int personAge;
	
	public HealthInsurance(	int insuranceYearCost, int insuranceRisk,String InsuranceName, int InsuranceTime,int PersonAge) {
		super(insuranceYearCost, insuranceRisk, InsuranceName,InsuranceTime);
		this.personAge=PersonAge;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
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


