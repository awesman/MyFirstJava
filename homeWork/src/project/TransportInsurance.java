package project;

public class TransportInsurance extends CompanyInsurance{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int transportCount;

	public TransportInsurance (int insuranceYearCost, int insuranceRisk,int bonus, String companyName,int transportCount) {
		super(insuranceYearCost, insuranceRisk, bonus, companyName);
		this.transportCount=transportCount;
	}
	public int getTransportCount() {
		return transportCount;
	}
	public void setTransportCount(int transportCount) {
		this.transportCount = transportCount;
	}    
}
