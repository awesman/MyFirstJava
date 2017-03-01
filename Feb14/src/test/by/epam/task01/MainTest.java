package test.by.epam.task01;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Triangle;
import by.epam.task01.exception.TriangleException;
import by.epam.task01.io.PointsReader;
import by.epam.task01.logic.TriangleActions;

public class MainTest {

	@Test
	public void testProgram() throws TriangleException {
		String path = "data/input.txt";
		int firstId = 0;
		int secondId = 1;
		Point first = new Point(7, 5);
		Point second = new Point(3, 1);
		Point third = new Point(9, 2);
		Point fouth = new Point(5, 5);
		Point fifth = new Point(13, 4);
		Point sixth = new Point(11, 15);
		Triangle one =
				new Triangle(firstId, first, second, third);
		Triangle two =
				new Triangle(secondId, fouth, fifth, sixth);
		List<Triangle> triangles = new ArrayList<>();
		triangles.add(one);
		triangles.add(two);
		List<String> readLines = PointsReader.pointsInput(path);
		List<Triangle> generatedTriangles =
				TriangleActions.createTriangle(readLines);
		Assert.assertEquals(triangles, generatedTriangles);
	}

}
