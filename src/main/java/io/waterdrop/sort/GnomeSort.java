package io.waterdrop.sort;

import io.waterdrop.sort.util.SortUtils;

public class GnomeSort implements SortAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		int i = 1;
		int j = 2;
		do {
			if (SortUtils.less(unsorted[i], unsorted[i - 1])) {
				SortUtils.swap(unsorted, i, i - 1);
				if (--i == 0) {
					i = j++;//第一版代码这里写错，只做赋值，而没有自增j
				}
			} else {
				i = j++;
			}

		}
		//第一版代码此处写错，把循环条件错写成了终止条件
		while (i < unsorted.length);

		return null;
	}

}
