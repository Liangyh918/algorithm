package io.waterdrop.search;

public class TernarySearch implements SearchAlgorithm {

	@Override
	public <T extends Comparable<T>> int find(T[] array, T key) {
		
		return search(array,key,0,array.length-1);
	}
	
	
	/**
	 * 思维漏洞：在递归调用调用中，left与right 应该取左右三等分点的前一位或后一位
	 */
	public static <T extends Comparable<T>> int search(T[] array,T key,int left,int right){
		if(left>right){
			return -1;
		}
		int leftTernaryPoint = left + (right-left)/3;
		int rightTernaryPoint = left + 2*(right-left)/3;
		if(key.compareTo(array[leftTernaryPoint])==0){
			return leftTernaryPoint;
		}
		if(key.compareTo(array[rightTernaryPoint])==0){
			return rightTernaryPoint;
		}
		if(key.compareTo(array[leftTernaryPoint])<0){
			return search(array,key,left,leftTernaryPoint-1);
		}
		else if(key.compareTo(array[rightTernaryPoint])>0){
			return search(array,key,rightTernaryPoint+1,right);
		}
		else{
			return search(array,key,leftTernaryPoint+1,rightTernaryPoint-1);
		}
		
		
		//return -1;//思考:该行无用，但是如果直接删掉则编译器无法通过。该怎么处理
	}
	
	
	public static void main(String[] args) {

		TernarySearch ternarySearch = new TernarySearch();
		Integer[] array = { 1, 2, 3, 4, 5, 6,7 };
		System.out.println(ternarySearch.find(array, -3));

		//////////////////////////
		/*
		 * righShift(-1); righShift(11); righShift(12); righShift(13);
		 */
	}

}
