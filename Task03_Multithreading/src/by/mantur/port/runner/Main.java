package by.mantur.port.runner;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.mantur.port.creator.ShipCreator;
import by.mantur.port.dispatcher.PortDispatcher;
import by.mantur.port.entity.PortTracker;
import by.mantur.port.entity.Ship;
import by.mantur.port.parser.FileParser;
import by.mantur.port.reader.DataReader;

public class Main {

	private final static String DEFAULT_PATH ="data/input.txt";
	public static final Logger logger =	LogManager.getLogger(Main.class);

	public static void main(String[] args) {

		DataReader reader = new DataReader();
		FileParser parser = new FileParser();
		ShipCreator creator = new ShipCreator();
		List<String> stringFromDefaultFile = reader.readFile(DEFAULT_PATH);
		List<int[]> shipParametrs =parser.getParametrs(stringFromDefaultFile);
		Queue<Ship> ships =creator.createShip(shipParametrs);
		System.out.println("ShipQueue size : " + ships.size());
		PortDispatcher dispatcher = new PortDispatcher();
		PortTracker tracker =	new PortTracker();
		tracker.start();
		dispatcher.handleQueue(ships);
		dispatcher.stopWorking();
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			logger.log(Level.FATAL, e);
			throw new RuntimeException(e);
		}
		List<Ship> finished =dispatcher.getShipList();
		System.out.println("Finished ships : " + finished);
	}
}