package project;

public class EmergencyInsurance extends CompanyInsurance{
	
	public int workersCount;

	public EmergencyInsurance(int insuranceYearCost, int insuranceRisk,int bonus, String companyName,int workersCount) {
		super(insuranceYearCost, insuranceRisk, bonus, companyName);
		this.workersCount=workersCount;
	}

	public int getWorkersCount() {
		return workersCount;
	}

	public void setWorkersCount(int workersCount) {
		this.workersCount = workersCount;
	}

}
