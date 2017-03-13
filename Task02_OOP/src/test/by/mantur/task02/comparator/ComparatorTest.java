package test.by.mantur.task02.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.mantur.task02.comparator.CargoCapacityComparator;
import by.mantur.task02.comparator.PassangersCapacityComparator;
import by.mantur.task02.entity.Autobus;
import by.mantur.task02.entity.AutobusType;
import by.mantur.task02.entity.Car;
import by.mantur.task02.entity.CargoTaxi;
import by.mantur.task02.entity.CargoTaxiType;
import by.mantur.task02.entity.CityTaxi;
import by.mantur.task02.entity.CityTaxiType;

public class ComparatorTest {

	static CityTaxi cityTaxi;
	static Autobus autobus;
	static CargoTaxi cargoTaxi;
	static List<Car> carsList;
	
	@BeforeClass
	public static void initMethod() {
		cityTaxi = new CityTaxi(13600, 400, 5, CityTaxiType.SEDAN_TAXI);
		autobus = new Autobus(42100, 1200, 33, AutobusType.SUBURBAN_BUS);
		cargoTaxi = new CargoTaxi(27100, 1600, 3, CargoTaxiType.MEDIUM);
		carsList = new ArrayList<>();
		carsList.add(cityTaxi);
		carsList.add(autobus);
		carsList.add(cargoTaxi);
	}
	
	@AfterClass
	public static void uninitMethod() {
		cityTaxi = null;
		autobus = null;
		cargoTaxi = null;
		carsList = null;
	}
	
	@Test
	public void compareByCargoCapacity() {
		Collections.sort(carsList, new CargoCapacityComparator());
	}

	@Test
	public void compareByPassangersCapacity() {
		Collections.sort(carsList, new PassangersCapacityComparator());
	}
}
