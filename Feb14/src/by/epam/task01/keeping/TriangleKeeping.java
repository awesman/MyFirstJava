package by.epam.task01.keeping;

import java.util.HashMap;
import java.util.Map;

import by.epam.task01.entity.Triangle;
import by.epam.task01.observer.Observer;

public class TriangleKeeping implements Observer{
	
	 private Map<Triangle, CalculationTriangleParametrs> triangle = new HashMap<>();
	 private final static TriangleKeeping INSTANCE = new TriangleKeeping();
	 
	 private TriangleKeeping() {}
	 
	 public static TriangleKeeping getInstance() {
	        return INSTANCE;
	    }
	
	@Override
	public void processTriangle(Triangle one){
		CalculationTriangleParametrs results = new CalculationTriangleParametrs(one);
		triangle.put( one, results);		
	}
	
	 public Map<Triangle, CalculationTriangleParametrs> getTriangles() {
	        return triangle;
	    }

}
