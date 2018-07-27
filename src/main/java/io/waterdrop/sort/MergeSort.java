package io.waterdrop.sort;

import java.util.Arrays;

import io.waterdrop.sort.util.SortUtils;

public class MergeSort implements SortAlgorithm {

	private <T extends Comparable<T>> T[] doSort(T[] unsorted, T[] temporary, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			doSort(unsorted, temporary, left, mid);
			doSort(unsorted, temporary, mid + 1, right);
			merge(unsorted, temporary, left, mid, right);
		}
		return unsorted;

	}

	private <T extends Comparable<T>> void merge(T[] arr, T[] temp, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		System.arraycopy(arr, left, temp, left, right - left + 1);
		while (i <= mid && j <= right) {
			if (SortUtils.less(temp[i], temp[j])) {
				arr[k] = temp[i];
				i++;
			} else {
				arr[k] = temp[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			arr[k] = temp[i];
			i++;
			k++;
		}

		while (j <= right) {
			arr[k] = temp[j];
			j++;
			k++;
		}
	}

	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		// T[] temporary = Arrays.copyOf(unsorted, unsorted.length);
		T[] temporary = (T[]) new Comparable[unsorted.length];
		doSort(unsorted, temporary, 0, unsorted.length - 1);
		return unsorted;
	}

	// Driver Program
	public static void main(String[] args) {

		Integer[] arr = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };

		MergeSort mergeSort = new MergeSort();

		Integer[] sorted = mergeSort.sort(arr);

		// Output => 1 4 6 9 12 23 54 78 231
		SortUtils.print(sorted);

		// String Input
		String[] strings = { "c", "a", "e", "b", "d" };
		String[] sortedStrings = mergeSort.sort(strings);

		// Output => a b c d e
		SortUtils.print(sortedStrings);
	}

}
