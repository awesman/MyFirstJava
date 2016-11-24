package project;

import java.util.Comparator;

public class Insurance implements Comparable<Insurance>{
	
	protected  int InsuranceYearCost;
	protected  int InsuranceRisk;
	
	
	public Insurance(int insuranceYearCost, int insuranceRisk) {
		this.InsuranceYearCost = insuranceYearCost;
		this.InsuranceRisk = insuranceRisk;
		
	}
	public int getInsuranceCost() {
		return InsuranceYearCost;
	}
	public void setInsuranceCost(int insuranceCost) {
		InsuranceYearCost = insuranceCost;
	}
	public  int getInsuranceRisk() {
		return InsuranceRisk;
	}
	public void setInsuranceRisk(int insuranceRisk) {
		InsuranceRisk = insuranceRisk;
	}
	@Override
	public int compareTo(Insurance o) {
		Integer p=InsuranceYearCost;
		return p.compareTo((Integer)(o.getInsuranceRisk()));
	}
	

}

class InsuranceComporator implements Comparator<Insurance>{
	  
    public int compare(Insurance a, Insurance b){
    	Integer risk1=new Integer(a.getInsuranceRisk());
    	Integer risk2=new Integer(b.getInsuranceRisk());
    	return risk2.compareTo(risk1);
    }
}

class PriceComporator implements Comparator<Insurance>{
	  
    public int compare(Insurance a, Insurance b){
    	Integer price1=new Integer(a.getInsuranceCost());
    	Integer price2=new Integer(b.getInsuranceCost());
    	return price1.compareTo(price2);
    }
}
