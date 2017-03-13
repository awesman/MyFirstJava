package by.mantur.task02.entity;

public class CityTaxi extends Car {

	private CityTaxiType type;

	public CityTaxi(int carCost, int cargoCapacity,int passangersCapacity, CityTaxiType type) {
		super(carCost, cargoCapacity, passangersCapacity);
		this.type = type;
	}

	public CityTaxiType getType() {
		return type;
	}

	public void setType(CityTaxiType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityTaxi other = (CityTaxi) obj;
		if (type != other.type)
			return false;
		return true;
	}	
}
