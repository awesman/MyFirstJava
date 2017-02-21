package by.epam.task01.keeping;

import by.epam.task01.entity.Triangle;
import by.epam.task01.logic.TriangleActions;

public class CalculationTriangleParametrs {
	
	private Triangle triangle;
	private double perimeter;
	private double square;
	
	public CalculationTriangleParametrs (Triangle one) {
		this.triangle = one;
		perimeter = TriangleActions.trianglePerimeter(one);
		square = TriangleActions.triangleSquare(one);
	}
	
	public Triangle getTriangle() {
		return triangle;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public double getSquare() {
		return square;
	}

}
