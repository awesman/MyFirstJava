package by.mantur.port.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.mantur.port.exception.PortException;
import by.mantur.port.generator.IdGenerator;


public class Ship implements Callable<Ship> {

	 private static Logger logger = LogManager.getLogger(Ship.class);
	    private final int ID;
	    private final int maxCapacity;
	    private List<Container> containers;
	    private int containersAmount;
	    private Port port;

	    public Ship(int maxCapacity, List<Container> containers, int containersAmount) {
	        this.ID = IdGenerator.getNextId();
	        this.maxCapacity = maxCapacity;
	        if (maxCapacity < 0) {
	        	maxCapacity = 0;
	            logger.log(Level.WARN, "maxCapacity below zero. Set equal to 0.");
	        }
	        this.containers = containers;
	        this.containersAmount = containersAmount;
	        if (containersAmount < 0) {
	        	containersAmount = 0;
	            logger.log(Level.WARN, "ContainersToLoadAmount below zero. Set equal to 0.");
	        }
	        if (containersAmount > maxCapacity) {
	        	containersAmount = maxCapacity;
	            logger.log(Level.WARN, "Trying to create ship with containersAmount amount more" +
	                    " than max containers amount.\nContainers to load amount is set equal to maxCapacity.");
	        }
	    }

	    private void enterPort() {
	        System.out.println(this + " : entered port.");
	        this.port = Port.getInstance();
	    }

	    private void exitPort() {
	        this.port = null;
	        System.out.println(this + " : exit port.");
	    }


	    private Pier moor() throws PortException {
	        System.out.println(this + " : trying to receive free Pier.");
	        Pier pier = null;
	        if (port != null) {
	        	pier = port.recievePier();
	            if (pier == null || pier.isBusy()) {
	                throw new PortException("Port returns incorrect pier.");
	            }
	        } else {
	            throw new PortException("No available port for this ship.");
	        }
	        pier.occupyPier();
	        return pier;
	    }

	    private void unMoor(Pier pier) throws PortException {
	    	pier.releasePier();
	        port.returnPier(pier);
	        System.out.println(this + " : Unmoored succesfully.");
	    }


	    private List<Container> unloadContainers() {
	        List<Container> result = containers;
	        containers = new ArrayList<>();
	        System.out.printf("%s : %d containers was unloaded. %d Containers left.%n",
	                this, result.size(), containers.size());
	        return result;
	    }

	    private void loadContainers(List<Container> containers) throws PortException {
	        if (containers != null && containers.size() == containersAmount) {
	            this.containers.addAll(containers);
	            System.out.println(this + " : loaded containers in number of " + containers.size());
	        } else {
	            throw new PortException("Try to load wrong containers.");
	        }
	    }

	    @Override
	    public String toString() {
	        return "Ship " + ID ;
	    }

	    @Override
	    public Ship call() {
	        try {
	            System.out.println("PORT_DISPATCHER : Accepted : " + this);
	            TimeUnit.SECONDS.sleep(1);
	            enterPort();
	            Pier freeDock = moor();
	            System.out.println(this + " : Succesfully moored to "+ freeDock);
	            if (containers.size() > 0) {
	                System.out.println(this + " : Trying to unload containers in number of " + containers.size());
	                TimeUnit.SECONDS.sleep(1);
	                port.storeContainers(unloadContainers());
	            }
	            if (containersAmount > 0) {
	                System.out.println(this + " : Trying to load containers in number of " + containersAmount);
	                TimeUnit.SECONDS.sleep(1);
	                loadContainers(port.recieveContainers(containersAmount));
	            }
	            System.out.println(this + " : loaded.Ready to go.");
	            unMoor(freeDock);
	            exitPort();
	        } catch (PortException | InterruptedException e) {
	            logger.log(Level.FATAL, e);
	            throw new RuntimeException(e);
	        }
	        return this;
	    }

		public int getMaxCapacity() {
		return maxCapacity;
	}
}
