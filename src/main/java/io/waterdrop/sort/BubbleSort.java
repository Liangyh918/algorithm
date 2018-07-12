package io.waterdrop.sort;

import io.waterdrop.sort.util.SortUtils;

public class BubbleSort implements SortAlgorithm {
	/**
	 * This method implements the Generic Bubble Sort
	 * 
	 * 冒泡排序思路：
	 *
	 * @param array
	 *            The array to be sorted Sorts the array in increasing order
	 **/

	@Override
	public <T extends Comparable<T>> T[] sort(T[] array) {
		int last = array.length - 1;
		boolean swap;
		do {
			swap = false;
			for (int count = 0; count < last-1; count++) {

				if (!SortUtils.less(array[count], array[count + 1])) {
					swap = SortUtils.swap(array, count, count + 1);
				}
			}

		} while (swap);
		return null;
	}

}
