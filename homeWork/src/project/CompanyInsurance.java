package project;

public class CompanyInsurance extends Insurance{
	
	private int bonus;
	private String companyName;
	
	public CompanyInsurance(int insuranceYearCost, int insuranceRisk,int bonus,String companyName) {
		super(insuranceYearCost, insuranceRisk);
		this.bonus=bonus;
		this.companyName=companyName;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
	
		
}
