package project;

public class PersonInsurance extends Insurance {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String insuranceName;
	private int insuranceTime;
		
	public PersonInsurance(int insuranceYearCost, int insuranceRisk,String InsuranceName, int InsuranceTime) {
		super(insuranceYearCost, insuranceRisk);
		this.insuranceName=InsuranceName;
		this.insuranceTime=InsuranceTime;	
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public int getInsuranceTime() {
		return insuranceTime;
	}
	public void setInsuranceTime(int insuranceTime) {
		this.insuranceTime = insuranceTime;
	}
}
