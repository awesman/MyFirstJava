package by.mantur.task02.entity;

public class Autobus extends Car {

	private AutobusType type;

	public Autobus(
			int carCost, int cargoCapacity,
			int passangersCapacity, AutobusType type) {
		super(carCost, cargoCapacity, passangersCapacity);
		this.type = type;
	}

	public AutobusType getType() {
		return type;
	}

	public void setType(AutobusType type) {
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
		Autobus other = (Autobus) obj;
		if (type != other.type)
			return false;
		return true;
	}

}
