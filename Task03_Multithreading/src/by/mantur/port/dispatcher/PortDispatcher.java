package by.mantur.port.dispatcher;


import by.mantur.port.entity.Ship;
import by.mantur.port.entity.Port;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PortDispatcher {
	
	 private static Logger logger = LogManager.getLogger(PortDispatcher.class);
	    private final ExecutorService executorService;
	    private List<Future<Ship>> ships;

	    public PortDispatcher() {
	        executorService = Executors.newFixedThreadPool(Port.getDockAmount());
	        ships = new ArrayList<>();
	    }

	    public void handleQueue(Queue<Ship> shipQueue) {
	        try {
	            ships = executorService.invokeAll(shipQueue);
	        } catch (InterruptedException e) {
	            logger.log(Level.FATAL, "Not all ship was serviced", shipQueue);
	            throw new RuntimeException(e);
	        }
	    }

	    public void stopWorking() {
	        executorService.shutdown();
	    }

	    public List<Ship> getShipList() {
	        ArrayList<Ship> result = new ArrayList<>();
	        for (Future<Ship> ship : ships) {
	            if (ship.isDone()) {
	                try {
	                    result.add(ship.get());
	                } catch (InterruptedException | ExecutionException e) {
	                    logger.log(Level.FATAL,"Every ship must be served by task." );
	                    throw new RuntimeException(e);
	                }
	            }
	        }
	        return result;
	    }


}
