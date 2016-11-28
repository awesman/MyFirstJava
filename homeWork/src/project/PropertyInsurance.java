package project;

import java.io.Serializable;

public class PropertyInsurance extends CompanyInsurance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int propertyPrice;

	public PropertyInsurance(int insuranceYearCost, int insuranceRisk,int bonus, String companyName,int propertyPrice) {
		super(insuranceYearCost, insuranceRisk, bonus, companyName);
		this.propertyPrice=propertyPrice;
	}
	public int getPropertyPrice() {
		return propertyPrice;
	}
	public void setPropertyPrice(int propertyPrice) {
		this.propertyPrice = propertyPrice;
	}
	@Override
	public String toString() {
		return "Страховка имущества: Стоимость страховки="
				+ getInsuranceCost() + ", Скидка%="
				+ getBonus() + ", Название компании="
				+ getCompanyName() + ", Цена имущества="
				+ getPropertyPrice() + ", Страховые риски%()="
				+ getInsuranceRisk();
	}
}
