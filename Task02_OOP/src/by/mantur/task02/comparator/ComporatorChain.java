package by.mantur.task02.comparator;

import java.util.Comparator;

public class ComporatorChain<Car> {

	public Comparator<Car> getChainedComparator(Comparator<Car>... args) {
		
		Comparator<Car> comparator = null;
		
		for (int i = 1; i < args.length; i++) {
			comparator = comparator.thenComparing(args[i]);
		}
		
		return comparator;
	}

}
