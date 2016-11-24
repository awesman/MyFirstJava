package project;

public class PersonInsurance extends Insurance {
	
	private String InsuranceName;
	private int InsuranceTime;
	
	
	public PersonInsurance(int insuranceYearCost, int insuranceRisk,String InsuranceName, int InsuranceTime) {
		super(insuranceYearCost, insuranceRisk);
		this.InsuranceName=InsuranceName;
		this.InsuranceTime=InsuranceTime;	
	}


	public String getInsuranceName() {
		return InsuranceName;
	}


	public void setInsuranceName(String insuranceName) {
		InsuranceName = insuranceName;
	}


	public int getInsuranceTime() {
		return InsuranceTime;
	}


	public void setInsuranceTime(int insuranceTime) {
		InsuranceTime = insuranceTime;
	}
	
	

}
