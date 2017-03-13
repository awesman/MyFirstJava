package by.mantur.task02.entity;

public abstract class Car {

	private int carCost;
	private int cargoCapacity;
	private int passangersCapacity;

	public Car(	int carCost, int cargoCapacity,int passangersCapacity) {
		this.carCost = carCost;
		this.cargoCapacity = cargoCapacity;
		this.passangersCapacity = passangersCapacity;
	}

	public int getCarCost() {
		return carCost;
	}

	public void setCarCost(int carCost) {
		this.carCost = carCost;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public int getPassangersCapacity() {
		return passangersCapacity;
	}

	public void setPassangersCapacity(int passangersCapacity) {
		this.passangersCapacity = passangersCapacity;
	}

	@Override
	public String toString() {
		return "Car [carCost=" + carCost + ", cargoCapacity="
				+ cargoCapacity + ", passangersCapacity="
				+ passangersCapacity + "]";
	}
}
