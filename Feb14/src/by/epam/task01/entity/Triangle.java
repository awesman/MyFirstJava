package by.epam.task01.entity;

import by.epam.task01.keeping.TriangleKeeping;

public class Triangle {

	private TriangleKeeping observer =
			TriangleKeeping.getInstance();
	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		notifyObserver();
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
		notifyObserver();
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
		notifyObserver();
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
		notifyObserver();
	}

	public void notifyObserver() {
		observer.processTriangle(this);
	}

	@Override
	public String toString() {
		return String.format("A %s,B %s,C %s cteate a triangle",
				a, b, c);
	}

}
