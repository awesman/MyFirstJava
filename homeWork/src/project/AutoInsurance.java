package project;

import java.io.Serializable;

public class AutoInsurance extends PersonInsurance implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String carMark;
	
     public AutoInsurance(int insuranceYearCost, int insuranceRisk,String InsuranceName, int InsuranceTime, String carMark) {
		super(insuranceYearCost, insuranceRisk, InsuranceName,InsuranceTime);
		this.carMark=carMark;
		}

	public String getCarMark() {
		return carMark;
	}

	public void setCarMark(String carMark) {
		this.carMark = carMark;
	}

	@Override
	public String toString() {
		return "Страхование автомобиля: Стоимость страховки=" + getInsuranceCost()
				+ ", Название страховки=" + getInsuranceName()
				+ ", Длительность страховки=" + getInsuranceTime()
				+ ", Марка автомобиля=" + getCarMark()
				+ ", Страховые риски(%)=" + getInsuranceRisk();
	} 
	
	
}
