package io.waterdrop.search;

public class IterativeTernarySearch implements SearchAlgorithm {

	@Override
	public <T extends Comparable<T>> int find(T[] array, T key) {
	 return	search(array, key, 0, array.length - 1);
	
	}

	private <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
		int leftTernaryPoint = 0;
		int rightTernaryPoint = 0;
		while (left <= right) {
			leftTernaryPoint = left + (right - left) / 3;
			rightTernaryPoint = left + 2 * (right - left) / 3;
			if (key.equals(array[leftTernaryPoint])) {
				return leftTernaryPoint;
			}
			if (key.equals(array[rightTernaryPoint])) {
				return rightTernaryPoint;
			}
			if (key.compareTo(array[leftTernaryPoint]) < 0) {
				right = leftTernaryPoint - 1;
			} else if (key.compareTo(array[rightTernaryPoint]) > 0) {
				left = rightTernaryPoint + 1;
			} else {
				left = leftTernaryPoint + 1;
				right =  rightTernaryPoint - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		IterativeTernarySearch iterativeTernarySearch = new IterativeTernarySearch();
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(iterativeTernarySearch.find(array, 3));

		//////////////////////////
		/*
		 * righShift(-1); righShift(11); righShift(12); righShift(13);
		 */
	}

}
