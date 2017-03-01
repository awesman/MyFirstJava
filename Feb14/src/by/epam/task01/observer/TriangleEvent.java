package by.epam.task01.observer;

import by.epam.task01.entity.Triangle;

public class TriangleEvent {
	
	Triangle one;
	
	public TriangleEvent(Triangle one){
		this.one=one;
	}
	
	public Triangle getOne(){
		return one;
	}
}
