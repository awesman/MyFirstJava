package by.mantur.task02.entity;

public class CargoTaxi extends Car {

	private CargoTaxiType type;

	public CargoTaxi(int carCost, int cargoCapacity,int passangersCapacity, CargoTaxiType type) {
		super(carCost, cargoCapacity, passangersCapacity);
		this.type = type;
	}

	public CargoTaxiType getType() {
		return type;
	}

	public void setType(CargoTaxiType type) {
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
		CargoTaxi other = (CargoTaxi) obj;
		if (type != other.type)
			return false;
		return true;
	}
		
}
