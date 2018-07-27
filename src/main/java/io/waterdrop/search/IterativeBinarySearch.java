package io.waterdrop.search;

public class IterativeBinarySearch implements SearchAlgorithm {

	@Override
	public <T extends Comparable<T>> int find(T[] array, T key) {
		int left = 0;
		int right = array.length-1;
		int median = (left + right) / 2;
		while (left <= right) {
			if (key.compareTo(array[median]) == 0)
				return median;
			else if ((key.compareTo(array[median]) < 0)) {
				 right = median - 1;
			} else if ((key.compareTo(array[median]) > 0)) {
				left = median + 1;
			}
			median = (left + right) / 2;
		}
		return -1;
	}

	
	public static void main(String[] args) {

		IterativeBinarySearch binarySearch = new IterativeBinarySearch();
		Integer[] array = { 1, 2, 3, 4, 5, 6,7 };
		System.out.println(binarySearch.find(array, 5));

		//////////////////////////
		/*
		 * righShift(-1); righShift(11); righShift(12); righShift(13);
		 */
	}
}
