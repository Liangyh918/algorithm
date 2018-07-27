package io.waterdrop.search;
/**
 * 内插搜索是二分搜索的一种变体，主要思路是根据搜索空间array的取值区间结合内插法来计算分割点pos的位置（pos相当于median）
 * 只是，内插法需要查找空间的元素进行减法运算，所以不能进行减法运算的查找空间不能使用此法
 * @author liangyh
 *
 *
 */
public class InterpolationSearch {

	public <T extends Comparable<T>> int find(int[] array, int key) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = array.length-1;
		int pos = 0;
		if(key<array[left]||key>array[right]){
			return -1;
		}
		while(left <= right&&key>=array[left]&&key<=array[right]){
			pos = left + (right-left)/(array[right]-array[left])*(key-array[left]);
			if(array[pos]==key){
				return pos;
			}
			if(array[pos]>key){
				right = pos -1;
			}
			else if(array[pos]<key){
				left = pos +1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {

		InterpolationSearch interpolationSearch = new InterpolationSearch();
		int[] array = { 1, 2, 3, 4, 5, 6,7 };
		System.out.println(interpolationSearch.find(array, -3));

		//////////////////////////
		/*
		 * righShift(-1); righShift(11); righShift(12); righShift(13);
		 */
	}

	
}
