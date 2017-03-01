package by.epam.task01.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task01.entity.Triangle;
import by.epam.task01.logic.TriangleActions;

public class Perimeter implements TriangleObserver{
	
	private static final Logger LOGGER = LogManager.getLogger();
	public static Perimeter instance=null;
	private static List<Double> perimeters = new ArrayList<>();
	
	public static Perimeter getInstance() {
        if (instance == null) {
            instance = new Perimeter();
        }
        return instance;
    }
	
	 public double getPerimeter(int id){
	        return perimeters.get(id);
	    }
	 
	 public static void addPerimeter(int id, double perimeter){
	        perimeters.add(id,perimeter);
	    }

	@Override
	public void processTriangle(TriangleEvent event) {
		Triangle one=event.getOne();
		int id=one.getId();
		LOGGER.log(Level.INFO, "Old triangle perimeter= " + perimeters.get(id));
        double newPerimeter = TriangleActions.trianglePerimeter(one).getPerimeter(id);
        perimeters.set(one.getId(), newPerimeter);
        LOGGER.log(Level.INFO, "New triangle perimeter= " + perimeters.get(id));
		
		
	}

	
}
