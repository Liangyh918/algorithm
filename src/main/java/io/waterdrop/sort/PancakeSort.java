package io.waterdrop.sort;

import io.waterdrop.sort.util.SortUtils;

public class PancakeSort implements SortAlgorithm {

	/*
	 * 煎饼算法，找到未排序部分中的最大的元素，将从该元素到未排序部分的最后一个元素进行逆置操作，
	 * 直到排序完成。（该算法，只允许使用一种操作逆置某段序列） (non-Javadoc)
	 * 
	 * @see io.waterdrop.sort.SortAlgorithm#sort(java.lang.Comparable[])
	 */
	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		// 外层循环表示已排序部分元素的数量
		for (int i = 0; i < unsorted.length; i++) {
			int index = 0;
			// 内层循环对未排序部分进行遍历，找到最大元素，
			// 将从最大元素到未排序部分的最后一个元素进行逆置（flip）
			for (int j = 0; j < unsorted.length - i; j++) {
				if (SortUtils.less(unsorted[index], unsorted[j])) {
					index = j;
				}
			}
			SortUtils.flip(unsorted, index, unsorted.length - i - 1);
		}
		return unsorted;

	}

}
