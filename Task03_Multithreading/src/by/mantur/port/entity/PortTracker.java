package by.mantur.port.entity;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import by.mantur.port.creator.ContainerCreator;

public class PortTracker extends Thread {
	
	private static Logger logger = LogManager.getLogger(PortTracker.class);
    private Port trackedPort;

    public PortTracker() {
        this.trackedPort = Port.getInstance();
        this.setDaemon(true);
    }

    private boolean isStorageFull() {
        return trackedPort.getStorage().size() >= Port.getMaxStorageSize() * 4 / 5;
    }

    private boolean isStorageEmpty() {
        return trackedPort.getStorage().size() <=
                (Port.getMaxStorageSize() / 10 > 5 ? Port.getMaxStorageSize() / 10 : 5);
    }

    private void makeStorageHalfEmpty() {
        if (isStorageFull()) {
            trackedPort.recieveContainers(Port.getMaxStorageSize() / 2);
        } else if (isStorageEmpty()) {
            int amountAdd = (Port.getMaxStorageSize() - trackedPort.getStorage().size()) / 2;
            trackedPort.storeContainers(ContainerCreator.createContainerList(amountAdd));
        }
    }

    @Override
    public void run() {
        while (true) {
            trackedPort.lockStorage();
            System.out.println("Tracker : Working.");
            makeStorageHalfEmpty();
            trackedPort.unlockStorage();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, "StorageTracker stop working.", e);
            }
        }
    }
}
