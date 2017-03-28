package by.mantur.port.entity;

import by.mantur.port.generator.IdGenerator;

public class Container {

	private final int ID;

	public Container() {
		ID = IdGenerator.getNextId();
	}

	@Override
	public String toString() {
		return "Container " + ID;
	}
}
