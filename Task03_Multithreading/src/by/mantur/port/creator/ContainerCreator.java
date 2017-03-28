package by.mantur.port.creator;

import java.util.ArrayList;
import java.util.List;

import by.mantur.port.entity.Container;

public class ContainerCreator {

	public static List<Container> createContainerList(int amount) {
		List<Container> result = new ArrayList<>();
		for (int i = 1; i <= amount; i++) {
			result.add(new Container());
		}
		return result;
	}
}
