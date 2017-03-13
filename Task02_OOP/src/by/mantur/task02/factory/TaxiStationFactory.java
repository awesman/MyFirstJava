package by.mantur.task02.factory;

import java.util.ArrayList;
import java.util.List;

import by.mantur.task02.entity.Autobus;
import by.mantur.task02.entity.AutobusType;
import by.mantur.task02.entity.CargoTaxi;
import by.mantur.task02.entity.CargoTaxiType;
import by.mantur.task02.entity.CityTaxi;
import by.mantur.task02.entity.CityTaxiType;
import by.mantur.task02.entity.TaxiStation;
import by.mantur.task02.exception.CreatingCarException;

public class TaxiStationFactory {
	

	
	public List<CityTaxi> createCityTaxi(String[] cityTaxiParameters){
		List<CityTaxi> taxi = new ArrayList<>();
        int coast = Integer.parseInt(cityTaxiParameters[0]);
        int cargoCapacity = Integer.parseInt(cityTaxiParameters[1]);
        int passangersCapacity = Integer.parseInt(cityTaxiParameters[2]);
        CityTaxiType type = CityTaxiType.valueOf(cityTaxiParameters[3].toUpperCase());
        taxi.add(new CityTaxi(coast, cargoCapacity, passangersCapacity, type));  
        return taxi;               
    }
	
	public List<Autobus> createAutobus(String[] autobusParameters){
		List<Autobus> autobus = new ArrayList<>();
        int coast = Integer.parseInt(autobusParameters[0]);
        int cargoCapacity = Integer.parseInt(autobusParameters[1]);
        int passangersCapacity = Integer.parseInt(autobusParameters[2]);
        AutobusType type = AutobusType.valueOf(autobusParameters[3].toUpperCase());
        autobus.add(new Autobus(coast, cargoCapacity, passangersCapacity, type)); 
        return autobus;               
    }
	
	public List<CargoTaxi> createCargoTaxi(String[] cargoTaxiParameters) {
		List<CargoTaxi> cargoTaxi = new ArrayList<>();
        int coast = Integer.parseInt(cargoTaxiParameters[0]);
        int cargoCapacity = Integer.parseInt(cargoTaxiParameters[1]);
        int passangersCapacity = Integer.parseInt(cargoTaxiParameters[2]);
        CargoTaxiType type = CargoTaxiType.valueOf(cargoTaxiParameters[3].toUpperCase());
        cargoTaxi.add(new CargoTaxi(coast, cargoCapacity, passangersCapacity, type)); 
        return cargoTaxi;               
    }
	
	 public static TaxiStation createStation(List<CityTaxi> taxi,List<Autobus> autobus,List<CargoTaxi> cargo) throws CreatingCarException {
		return new TaxiStation(taxi, autobus, cargo);	   
	    }

}
