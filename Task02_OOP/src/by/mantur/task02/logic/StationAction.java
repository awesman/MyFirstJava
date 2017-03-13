package by.mantur.task02.logic;

import java.util.List;
import by.mantur.task02.entity.Car;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StationAction {

	private static Logger logger = LogManager.getLogger(StationAction.class);

	public static int calculateStationCost(List<Car> cars) {
		int totalCost = 0;
		for (Car car : cars) {
			totalCost += car.getCarCost();
		}
		logger.log(Level.INFO,"Total Taxi Station cost = " + totalCost);
		return totalCost;
	}

}
