package by.epam.task01.entity;

import java.util.ArrayList;
import java.util.List;

import by.epam.task01.logic.TriangleActions;
import by.epam.task01.observer.TriangleObserver;

public class Triangle {

	private int id;
	private Point a;
	private Point b;
	private Point c;
	private List<TriangleObserver> observerList = new ArrayList<>();
	
	public Triangle(int id,Point a, Point b, Point c) {
		this.id = id;
		this.a = a;
		this.b = b;
		this.c = c;
		TriangleActions.trianglePerimeter(this);
		TriangleActions.triangleSquare(this);	
	}
	
	public void addObserver(TriangleObserver observer) {
        observerList.add(observer);
    }
	
	
	public int getId() {
        return id;
    }

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;

	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}


	@Override
	public String toString() {
		return String.format("A %s,B %s,C %s cteate a triangle",
				a, b, c);
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (obj == null)
	            return false;
	        if (obj == this)
	            return true;
	        if (obj.getClass() == this.getClass()) {
	            Triangle triangle = (Triangle) obj;
	            if (triangle.id == this.id && triangle.a.equals(this.a)
	                    && triangle.b.equals(this.b)
	                    && triangle.c.equals(this.c))
	                return true;
	        }
	        return false;
	    }

}
