package test.by.mantur.task02.factory;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.mantur.task02.entity.Autobus;
import by.mantur.task02.entity.AutobusType;
import by.mantur.task02.entity.Car;
import by.mantur.task02.entity.CargoTaxi;
import by.mantur.task02.entity.CargoTaxiType;
import by.mantur.task02.entity.CityTaxi;
import by.mantur.task02.entity.CityTaxiType;
import by.mantur.task02.entity.TaxiStation;
import by.mantur.task02.exception.CreatingCarException;
import by.mantur.task02.factory.TaxiStationFactory;

public class TaxiStationFactoryTest {
		
	private List<CityTaxi> list;
	private List<Autobus> list2;
	private List<CargoTaxi> list3;
	
	@Test
	public void createCityTaxiTest() {
		String[] str = { "13600", "400", "5", "LIMOUSINE" };
		CityTaxi manualCar = new CityTaxi(13600, 400, 5,
				CityTaxiType.SEDAN_TAXI);
		Car taxiFactory = new TaxiStationFactory()
				.createCityTaxi(str).get(0);
		Assert.assertNotEquals(manualCar, taxiFactory);
	}

	@Test
	public void createAutobusTest() {
		String[] str = { "45000", "1400", "25", "SUBURBAN_BUS" };
		Autobus manualBus = new Autobus(42100, 1200, 33,
				AutobusType.URBAN_BUS);
		Car busFactory = new TaxiStationFactory()
				.createAutobus(str).get(0);
		Assert.assertNotEquals(manualBus, busFactory);
	}

	@Test
	public void createCargoTaxi() {
		String[] str = { "27000", "1600", "3", "MEDIUM" };
		CargoTaxi manualCargo = new CargoTaxi(42100, 1200, 33,
				CargoTaxiType.LITLE);
		Car cargoFactory = new TaxiStationFactory()
				.createCargoTaxi(str).get(0);
		Assert.assertNotEquals(manualCargo, cargoFactory);
	}

	@Before
	public void initTestList() {
		CityTaxi cityTaxi=new CityTaxi(13600, 400, 5,CityTaxiType.SEDAN_TAXI);
		list.add(cityTaxi);
		Autobus autobus=new Autobus(42100, 1200, 33,AutobusType.URBAN_BUS);
		list2.add(autobus);
		CargoTaxi cargoTaxi=new CargoTaxi(42100, 1200, 33,CargoTaxiType.LITLE);
		list3.add(cargoTaxi);
			
	}

	@Test
	public void createStationTest() throws CreatingCarException {
		TaxiStation station;
		List<CityTaxi> expectedCityTaxi =Arrays.asList(new CityTaxi(13600, 400, 5,CityTaxiType.SEDAN_TAXI));
		List<Autobus> expectedAutobus =	Arrays.asList(new Autobus(42100, 1200, 33,AutobusType.URBAN_BUS));
		List<CargoTaxi> expectedCargoTaxi =	Arrays.asList(new CargoTaxi(42100, 1200, 33,CargoTaxiType.LITLE));
		station = new TaxiStation(expectedCityTaxi,expectedAutobus, expectedCargoTaxi);
		TaxiStation actualStation = TaxiStationFactory.createStation(list,list2,list3);
		Assert.assertEquals(station, actualStation);
	}

}
