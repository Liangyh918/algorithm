package io.waterdrop.search;

public class LinearSearch implements SearchAlgorithm {

	@Override
	public <T extends Comparable<T>> int find(T[] array, T key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}

}
