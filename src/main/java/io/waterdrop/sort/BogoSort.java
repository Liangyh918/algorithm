package io.waterdrop.sort;

import java.util.Random;

import io.waterdrop.sort.util.SortUtils;

public class BogoSort implements SortAlgorithm {

	private <T extends Comparable<T>> boolean isSorted(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (SortUtils.less(array[i + 1], array[i]))
				return false;
		}
		return true;
	}

	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {

		Random random = new Random();
		while (!isSorted(unsorted)) {
			// Randomly shuffles the array
			for (int i = 0; i < unsorted.length; i++) {
				SortUtils.swap(unsorted, i, i + random.nextInt(unsorted.length - i));
			}
		}

		return unsorted;

	}

}
