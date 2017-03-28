package by.mantur.port.creator;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.mantur.port.entity.Ship;
import by.mantur.port.entity.Container;

public class ShipCreator {
	
	 private Logger logger = LogManager.getLogger(ShipCreator.class);

	    public Queue<Ship> createShip(List<int[]> parametrs) {
	        Queue<Ship> shipQueue = new LinkedList<>();
	        for (int[] paramArray : parametrs) {
	            Ship nextShip;
	            List<Container> shipContainers;
	            if (paramArray.length == 3) {
	                shipContainers = ContainerCreator.createContainerList(paramArray[1]);
	                nextShip = new Ship(paramArray[0], shipContainers, paramArray[2]);
	                shipQueue.add(nextShip);
	            } else {
	                logger.log(Level.WARN, "Wrong parametrs.");
	            }
	        }
	        return shipQueue;
	    }

}
