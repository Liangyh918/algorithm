package io.waterdrop.sort;

import io.waterdrop.sort.util.SortUtils;
import junit.runner.Sorter.Swapper;

public class SelectionSort implements SortAlgorithm {

	/*
	 * (non-Javadoc)
	 * @see io.waterdrop.sort.SortAlgorithm#sort(java.lang.Comparable[])
	 * 选择排序的思路：针对一个位置（已排序部分和未排序部分相邻的地方）找到应该放入
	 * 该位置的元素，并放置进去。直到数组有序
	 * 
	 * 具体到以下代码:已排序部分在数组最左侧，在未排序部分找到最小值，将该值与未排序部分的第一个元素
	 * 交换位置即可。
	 * 
	 */
	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {

		int k = unsorted.length;
		for (int i = 0; i < k - 1; i++) {
			T min = unsorted[i];
			for (int j = i + 1; j < k; j++) {
				if (SortUtils.less(unsorted[j], min))
					SortUtils.swap(unsorted, i, j);
			}
		}
		return unsorted;
	}

	
    // Driver Program
    public static void main(String[] args) {

        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        SelectionSort selectionSort = new SelectionSort();

        Integer[] sorted = selectionSort.sort(arr);

        // Output => 1	  4	 6	9	12	23	54	78	231
        SortUtils.print(sorted);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};
        String[] sortedStrings = selectionSort.sort(strings);

        //Output => a	b	 c  d	e
        SortUtils.print(sortedStrings);
    }
}
