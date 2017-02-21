package by.epam.task01.entity;

public class Point {

	private double x;
	private double y;

	
	public Point(String x,String y){
		this.x=Double.parseDouble(x);
		this.y=Double.parseDouble(y);	
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("Point x=%.2f Point y=%.2f ", x,y);
	}
}
