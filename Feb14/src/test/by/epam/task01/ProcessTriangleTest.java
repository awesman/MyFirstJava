package test.by.epam.task01;

import org.junit.*;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Triangle;
import by.epam.task01.observer.Perimeter;
import by.epam.task01.observer.Square;

public class ProcessTriangleTest {

	private static int id;
	private static Point first;
	private static Point second;
	private static Point third;
	private static Triangle triangle;

	@BeforeClass
	public static void initTriangle() {
		id = 0;
		first = new Point(1, 2);
		second = new Point(4, 6);
		third = new Point(4, 2);
		triangle = new Triangle(id, first, second, third);
	}

	@AfterClass
	public static void destroyTriangle() {
		triangle = null;
	}

	@Test
	public void testValueChangedPerimeter() {
		Perimeter trianglePerimeter = Perimeter.getInstance();
		double perimeter = trianglePerimeter.getPerimeter(id);
		triangle.addObserver(trianglePerimeter);
		Point newAPoint = new Point(-1, -1);
		triangle.setA(newAPoint);
		double changedPerimeter =
				trianglePerimeter.getPerimeter(id);
		Assert.assertNotEquals(perimeter, changedPerimeter);
	}

	@Test
	public void testValueChangedSquare() {
		Square triangleSquare = Square.getInstance();
		double square = triangleSquare.getSquare(id);
		triangle.addObserver(triangleSquare);
		Point newAPoint = new Point(-2, -2);
		triangle.setA(newAPoint);
		double changedSquare = triangleSquare.getSquare(id);
		Assert.assertNotEquals(square, changedSquare);
	}

}
