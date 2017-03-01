package by.epam.task01.logic;

import static java.lang.Math.abs;

import by.epam.task01.entity.Point;

public class PointActions {

	public static double distanceTo(Point p, Point p1) {
		return Math.hypot(abs(p.getX() - p1.getX()),
				abs(p.getY() - p1.getY()));
	}

}
