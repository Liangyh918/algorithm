package io.waterdrop.sort;

import io.waterdrop.sort.util.SortUtils;

public class InsertionSort implements SortAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		int i=1;
		int j=1;
		while(j<unsorted.length){
			T key=unsorted[j];		
			for(i=j-1;i>=0&&SortUtils.less(key, unsorted[i]);i--){
				unsorted[i+1]=unsorted[i];
			}
			j++;
			unsorted[i+1]=key;
		}
		return unsorted;
	}
	
    // Driver Program
    public static void main(String[] args) {

        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        InsertionSort insertionSort = new InsertionSort();

        Integer[] sorted = insertionSort.sort(arr);

        // Output => 1	  4	 6	9	12	23	54	78	231
        SortUtils.print(sorted);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};
        String[] sortedStrings = insertionSort.sort(strings);

        //Output => a	b	 c  d	e
        SortUtils.print(sortedStrings);
    }

}
