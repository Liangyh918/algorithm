package io.waterdrop.dynamic;

/**
 * KadaneAlgorithm is to find max sum of subsequence
 * 
 * @author liangyh
 *
 */
public class KadaneAlgorithm {

	/**
	 * 错误代码，错误的根据数组元素来决定sum置零，正确的应是根据sum值是否小于0来置零
	 * 
	 * @param array
	 */
	// private void kadaneAlgorithm(int[] array) {
	// int maxValue = Integer.MIN_VALUE;
	// int sum = array[0];
	// if (sum > maxValue) {
	// maxValue = sum;
	// }
	// for (int i = 1; i < array.length; i++) {
	// if (array[i] < 0) {
	// sum = 0;
	// continue;
	// }
	// sum += array[i];
	// if (sum > maxValue)
	// maxValue = sum;
	// }
	// }

	public int kadaneAlgorithm(int array[]) {
		int maxValue = Integer.MIN_VALUE;
		int cursum = 0;
		if (array.length < 0) {
			return 0;
		}
		for (int i = 0; i < array.length; i++) {
			cursum += array[i];
			if (cursum > maxValue) {
				maxValue = cursum;
			}
			if (cursum <= 0) {
				cursum = 0;
			}
		}
		return maxValue;
	}

}
