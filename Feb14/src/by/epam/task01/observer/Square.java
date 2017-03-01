package by.epam.task01.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.task01.entity.Triangle;
import by.epam.task01.logic.TriangleActions;

public class Square implements TriangleObserver {
	
	private static final Logger LOGGER = LogManager.getLogger();
	private static Square instance = null;
    private List<Double> squares = new ArrayList<>();
    
    public static Square getInstance() {
        if (instance == null) {
            instance = new Square();
        }
        return instance;
    }
    
    public double getSquare(int id) {
        return squares.get(id);
    }
    
    public void addSquare(int id, double square) {
        squares.add(id, square);
    }

	@Override
	public void processTriangle(TriangleEvent event) {
		Triangle one=event.getOne();
		int id=one.getId();	
		LOGGER.log(Level.INFO, "Old triangular square= {}", squares.get(id));
        double newSquare = TriangleActions.triangleSquare(one).getSquare(id);
        squares.set(id, newSquare);
        LOGGER.log(Level.INFO, "New triangular square= {}", squares.get(id));
	}

}
