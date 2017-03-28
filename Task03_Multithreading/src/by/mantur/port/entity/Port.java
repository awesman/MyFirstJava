package by.mantur.port.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.locks.Condition;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Port {

	private final static int STORAGE_SIZE = 100;
    private final static int PIER_AMOUNT =3;
    private final static AtomicBoolean INSTANCE_CREATED = new AtomicBoolean(false);
    private final static Lock PORT_LOCK = new ReentrantLock(true);
    private static Port instance = null;
    private static Logger logger = LogManager.getLogger(Port.class);
    private final Lock piersLock;
    private final Condition piersEmptyCondition;
    private final Lock storageLock;
    private final Condition storageFullCondition;
    private final Condition storageEmptyCondition;

    private Queue<Pier> piers;
    private ArrayList<Container> storage;

    private Port() {
    	piersLock = new ReentrantLock(true);
        storageLock = new ReentrantLock(true);
        piersEmptyCondition = piersLock.newCondition();
        storageFullCondition = storageLock.newCondition();
        storageEmptyCondition = storageLock.newCondition();
        piers = new LinkedList<>();
        for (int i = 1; i <= PIER_AMOUNT; i++) {
        	piers.add(new Pier(i));
        }
        storage = new ArrayList<>();
    }

    public static Port getInstance() {
        if (!INSTANCE_CREATED.get()) {
            PORT_LOCK.lock();
            try {
                if (!INSTANCE_CREATED.get()) {
                    instance = new Port();
                    INSTANCE_CREATED.set(true);
                }
            } finally {
                PORT_LOCK.unlock();
            }
        }
        return instance;
    }

    public static int getDockAmount() {
        return PIER_AMOUNT;
    }

    public static int getMaxStorageSize() {
        return STORAGE_SIZE;
    }

    public ArrayList<Container> getStorage() {
        return storage;
    }

    public Pier recievePier() {
    	Pier result = null;
        piersLock.lock();
        try {
            while ( piers.size() <= 0) {
                try {
                    System.out.println("PORT : All piers are occupied. Please, wait.");
                    piersEmptyCondition.await();
                } catch (InterruptedException e) {
                    logger.log(Level.ERROR, Thread.currentThread() + " interrupted while waiting.", e);
                }
            }
            result =  piers.poll();
        } finally {
        	 piersLock.unlock();
        }

        return result;
    }

    public void returnPier(Pier pier) {
    	 piersLock.lock();
        try {
        	 piers.add(pier);
            System.out.println("PORT : one pier returned.Amount of free piers is : " +  piers.size());
            piersEmptyCondition.signal();
        } finally {
        	 piersLock.unlock();
        }
    }

    public void storeContainers(List<Container> containers) {
        storageLock.lock();
        try {
            System.out.printf("PORT : trying to store %d containers.%n", containers.size());
            while (STORAGE_SIZE - storage.size() <= containers.size()) {
                System.out.println("PORT : storage is full.Waiting for unloading.");
                try {
                    storageFullCondition.await();
                } catch (InterruptedException e) {
                    logger.log(Level.ERROR, Thread.currentThread() + " interrupted while waiting.", e);
                }
            }
            storage.addAll(containers);
            System.out.printf("PORT : %d containers succesfully added. Current containers amount is %d.%n",
                    containers.size(), storage.size());
            storageEmptyCondition.signalAll();
        } finally {
            storageLock.unlock();
        }
    }

    public List<Container> recieveContainers(int amount) {
        storageLock.lock();
        ArrayList<Container> result = null;
        try {
            System.out.printf("PORT : trying to recive %d containers.%n", amount);
            while (storage.size() < amount) {
                System.out.println("PORT : not enough containers.Please, wait.");
                try {
                    storageEmptyCondition.await();
                } catch (InterruptedException e) {
                    logger.log(Level.ERROR, Thread.currentThread() + " interrupted while waiting.", e);
                }
            }
            result = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                result.add(storage.remove(0));
            }
            System.out.printf("PORT : %d containers succesfully removed. Current containers amount is %d.%n",
                    result.size(), storage.size());
            storageFullCondition.signalAll();
        } finally {
            storageLock.unlock();
        }
        return result;
    }

    public void lockStorage() {
        storageLock.lock();
    }

    public void unlockStorage() {
        storageLock.unlock();
    }
}
