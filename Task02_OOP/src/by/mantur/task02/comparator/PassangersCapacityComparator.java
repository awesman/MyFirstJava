package by.mantur.task02.comparator;

import java.util.Comparator;
import by.mantur.task02.entity.Car;

public class PassangersCapacityComparator implements Comparator<Car> {
	
	@Override
	public int compare(Car car1, Car car2) {

		Integer firstCarCapacity = car1.getPassangersCapacity();
		Integer secondCarCapacity = car2.getPassangersCapacity();

		return secondCarCapacity.compareTo(firstCarCapacity);
	}

}
