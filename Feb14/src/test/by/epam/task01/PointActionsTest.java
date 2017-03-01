package test.by.epam.task01;

import org.junit.Test;

import by.epam.task01.entity.Point;

import static by.epam.task01.logic.PointActions.distanceTo;
import static org.junit.Assert.assertEquals;

public class PointActionsTest {
	@Test
	public void distanceToTest() throws Exception {
		Point first = new Point(1, 2);
		Point second = new Point(4, 6);

		double expected = 5;
		double result = distanceTo(first, second);

		assertEquals(expected, result, 0.00001);
	}

}