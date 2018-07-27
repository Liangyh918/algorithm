package io.waterdrop.dynamic;

public class FibToN {
	public static boolean fibToN(int N) {
		int first = 1;
		int second = 1;
		if (N < 1) {
			return false;
		}
		while (first <= N) {
			System.out.print(first + " ");
			int next = first + second;
			first = second;  
			second= next;			
		}	
		//System.out.println(first);
		return true;
	}
	
	
	public static void main(String[] args) {
		fibToN(20);
	}
}
