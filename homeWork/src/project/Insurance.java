package project;

import java.io.Serializable;
import java.util.Comparator;

public class Insurance implements Comparable<Insurance>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int insuranceYearCost;
	protected int insuranceRisk;

	public Insurance(int insuranceYearCost, int insuranceRisk) {
		this.insuranceYearCost = insuranceYearCost;
		this.insuranceRisk = insuranceRisk;
	}
	public int getInsuranceCost() {
		return insuranceYearCost;
	}
	public void setInsuranceCost(int insuranceCost) {
		insuranceYearCost = insuranceCost;
	}

	public int getInsuranceRisk() {
		return insuranceRisk;
	}

	public void setInsuranceRisk(int insuranceRisk) {
		this.insuranceRisk = insuranceRisk;
	}

	@Override
	public int compareTo(Insurance o) {
		Integer p = insuranceYearCost;
		return p.compareTo((Integer) (o.getInsuranceRisk()));
	}

}

class InsuranceComporator implements Comparator<Insurance> {

	public int compare(Insurance a, Insurance b) {
		Integer risk1 = new Integer(a.getInsuranceRisk());
		Integer risk2 = new Integer(b.getInsuranceRisk());
		return risk2.compareTo(risk1);
	}
}

class PriceComporator implements Comparator<Insurance> {

	public int compare(Insurance a, Insurance b) {
		Integer price1 = new Integer(a.getInsuranceCost());
		Integer price2 = new Integer(b.getInsuranceCost());
		return price1.compareTo(price2);
	}
}
