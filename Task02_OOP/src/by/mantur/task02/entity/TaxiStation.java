package by.mantur.task02.entity;

import java.util.List;

public class TaxiStation {

	private List<CityTaxi> cityTaxi;
	private List<Autobus> autobus;
	private List<CargoTaxi> cargoTaxi;
	
	
	public TaxiStation(List<CityTaxi> cityTaxi, List<Autobus> autobus,
			List<CargoTaxi> cargoTaxi) {
		super();
		this.cityTaxi = cityTaxi;
		this.autobus = autobus;
		this.cargoTaxi = cargoTaxi;
	}
	
	public List<CityTaxi> getCityTaxi() {
		return cityTaxi;
	}
	public void setCityTaxi(List<CityTaxi> cityTaxi) {
		this.cityTaxi = cityTaxi;
	}
	public List<Autobus> getAutobus() {
		return autobus;
	}
	public void setAutobus(List<Autobus> autobus) {
		this.autobus = autobus;
	}
	public List<CargoTaxi> getCargoTaxi() {
		return cargoTaxi;
	}
	public void setCargoTaxi(List<CargoTaxi> cargoTaxi) {
		this.cargoTaxi = cargoTaxi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((autobus == null) ? 0 : autobus.hashCode());
		result = prime * result + ((cargoTaxi == null) ? 0
				: cargoTaxi.hashCode());
		result = prime * result
				+ ((cityTaxi == null) ? 0 : cityTaxi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxiStation other = (TaxiStation) obj;
		if (autobus == null) {
			if (other.autobus != null)
				return false;
		} else if (!autobus.equals(other.autobus))
			return false;
		if (cargoTaxi == null) {
			if (other.cargoTaxi != null)
				return false;
		} else if (!cargoTaxi.equals(other.cargoTaxi))
			return false;
		if (cityTaxi == null) {
			if (other.cityTaxi != null)
				return false;
		} else if (!cityTaxi.equals(other.cityTaxi))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TaxiStation [cityTaxi=" + cityTaxi + ", autobus="
				+ autobus + ", cargoTaxi=" + cargoTaxi + "]";
	}
	
	
}
