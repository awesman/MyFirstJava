package test.by.epam.task01;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Triangle;
import by.epam.task01.exception.TriangleException;
import by.epam.task01.logic.TriangleActions;
import by.epam.task01.observer.Perimeter;
import by.epam.task01.observer.Square;

public class TriangleActionsTest {

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
	public void testTrianglePerimeter() {
		Perimeter trianglePerimeter =
				TriangleActions.trianglePerimeter(triangle);
		double perimetr = trianglePerimeter.getPerimeter(id);
		Assert.assertEquals(12, perimetr, 0.0001);
	}

	@Test
	public void testCalculateSquare() {
		Square triangleSquare =
				TriangleActions.triangleSquare(triangle);
		double square = triangleSquare.getSquare(id);
		Assert.assertEquals(6, square, 0.0001);
	}

	@Test
	public void existsTest() throws Exception {

		Point first = new Point(1, 2);
		Point second = new Point(4, 6);
		Point third = new Point(4, 2);
		Triangle one = new Triangle(1, first, second, third);

		boolean expected = true;
		boolean result = TriangleActions.triangleExists(one);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void TestCreateTriangle() throws TriangleException {
		List<String> lines = new ArrayList<>();
		lines.add("1 2 4 3 5 6");
		Triangle triangle = new Triangle(1, new Point(1, 2),
				new Point(3, 6), new Point(4, 5));
		List<Triangle> triangles = new ArrayList<>();
		triangles.add(triangle);
		List<Triangle> createTriangles =
				TriangleActions.createTriangle(lines);
		Assert.assertEquals(triangles, createTriangles);
	}

	@Test(expected = TriangleException.class)
	public void TestGenerateTrianglesException()
			throws TriangleException {
		List<String> lines = new ArrayList<>();
		lines.add("5 6 f 7 1 2");
		TriangleActions.createTriangle(lines);
	}

}