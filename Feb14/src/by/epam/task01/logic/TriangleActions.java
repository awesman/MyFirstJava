package by.epam.task01.logic;

import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;

import by.epam.task01.entity.Point;
import by.epam.task01.entity.Triangle;
import by.epam.task01.exception.TriangleException;
import by.epam.task01.observer.Perimeter;
import by.epam.task01.observer.Square;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleActions {

	private static final Logger LOGGER = LogManager.getLogger();
	private static final int MAX_NUMBER_OF_TRIANGLE_COORDINATES =
			6;// Amount of coordinates, that we needed for
				// creation triangle

	public static boolean triangleExists(Triangle one) {

		double ab =
				PointActions.distanceTo(one.getA(), one.getB());
		double bc =
				PointActions.distanceTo(one.getB(), one.getC());
		double ca =
				PointActions.distanceTo(one.getC(), one.getA());
		return (ab < (bc + ca)) && (bc < (ab + ca))
				&& (ca < (ab + bc));
	}

	public static Perimeter trianglePerimeter(Triangle one) {
		Perimeter perimeter = Perimeter.getInstance();
		double ab =
				PointActions.distanceTo(one.getA(), one.getB());
		double bc =
				PointActions.distanceTo(one.getB(), one.getC());
		double ca =
				PointActions.distanceTo(one.getC(), one.getA());
		double p = ab + bc + ca;
		Perimeter.addPerimeter(one.getId(), p);
		LOGGER.log(Level.INFO, "Triangle id=" + one.getId()
				+ " perimeter = " + perimeter);
		return perimeter;

	}

	public static Square triangleSquare(Triangle one) {
		Square square = Square.getInstance();
		double ab =
				PointActions.distanceTo(one.getA(), one.getB());
		double bc =
				PointActions.distanceTo(one.getB(), one.getC());
		double ca =
				PointActions.distanceTo(one.getC(), one.getA());
		double p = (ab + bc + ca) / 2;
		double triangleSquare =
				sqrt(p * (p - ab) * (p - bc) * (p - ca));
		square.addSquare(one.getId(), triangleSquare);
		LOGGER.log(Level.INFO, "Triangle id=" + one.getId()
				+ " square = " + square);
		return square;

	}

	public static boolean angleRectangularExists(Triangle one)
			throws TriangleException {
		double ab =
				PointActions.distanceTo(one.getA(), one.getB());
		double bc =
				PointActions.distanceTo(one.getB(), one.getC());
		double ca =
				PointActions.distanceTo(one.getC(), one.getA());

		if (ab > bc && ab > ca) {
			return ab == Math
					.sqrt(Math.pow(bc, 2) + Math.pow(ca, 2));
		} else if (bc > ab && bc > ca) {
			return bc == Math
					.sqrt(Math.pow(ab, 2) + Math.pow(ca, 2));
		} else if (ca > bc && ca > ab) {
			return ca == Math
					.sqrt(Math.pow(bc, 2) + Math.pow(ab, 2));
		} else {
			throw new TriangleException(
					"Triangle does not exists");
		}
	}

	public static List<Triangle> createTriangle(
			List<String> lines) throws TriangleException {
		List<Triangle> triangles = new ArrayList<>();
		int Id = 0;
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			String[] coordinates = line.split("\\s");
			if (coordinates.length != MAX_NUMBER_OF_TRIANGLE_COORDINATES) {
				throw new TriangleException(
						"Incorrect file " + i);
			}
			try {
				Point first =
						new Point(Double.valueOf(coordinates[0]),
								Double.valueOf(coordinates[1]));
				Point second =
						new Point(Double.valueOf(coordinates[2]),
								Double.valueOf(coordinates[3]));
				Point third =
						new Point(Double.valueOf(coordinates[4]),
								Double.valueOf(coordinates[5]));
				triangles.add(new Triangle(Id,
						first, second, third));
				Id++;
			} catch (NumberFormatException e) {
				throw new TriangleException(
						"Incorrect file " + i);
			}
		}
		return triangles;
	}
}
