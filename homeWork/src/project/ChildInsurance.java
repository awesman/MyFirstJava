package project;

public class ChildInsurance extends PersonInsurance{
	
	private int childCount;

	public ChildInsurance(int insuranceYearCost, int insuranceRisk,String InsuranceName, int InsuranceTime,int childCount) {
		super(insuranceYearCost, insuranceRisk, InsuranceName,InsuranceTime);
		this.childCount=childCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	
	
	

}
