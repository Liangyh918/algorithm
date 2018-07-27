package io.waterdrop.search;

public class BinarySearch implements SearchAlgorithm {

	@Override
	public <T extends Comparable<T>> int find(T[] array, T key) {
		return search(array, key, 0, array.length-1);
	}

	// 递归
	public static <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
		if (left > right)
			return -1;

		System.out.println("left:"+left);
		System.out.println("right:"+right);
		int median = (left + right) / 2;
//		System.out.println("median:"+median);
		int comp = key.compareTo(array[median]);

		if (comp < 0) {
			return search(array, key, left, median-1);
		} else if (comp > 0) {
			return search(array, key, median+1, right);
		}
		return median;
	}
/*    private static <T extends Comparable<T>> int search(T array[], T key, int left, int right){
        if (right < left) return -1; // this means that the key not found

        // find median
        int median = (left + right) >>> 1;
        int comp = key.compareTo(array[median]);

        if (comp < 0) {
            return search(array, key, left, median - 1);
        }

        if (comp > 0) {
            return search(array, key, median + 1, right);
        }

        return median;
    }*/
	// 右移测试
	public static void righShift(int a) {
		System.out.println(a << 1);
	}

	public static void main(String[] args) {

		BinarySearch binarySearch = new BinarySearch();
		Integer[] array = { 1, 2, 3, 4, 5, 6 };
		System.out.println(binarySearch.find(array, 7));

		//////////////////////////
		/*
		 * righShift(-1); righShift(11); righShift(12); righShift(13);
		 */
	}
}
