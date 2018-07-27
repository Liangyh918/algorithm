package io.waterdrop.mathproblem;

public class MathUtils {
	public static long factorial(int n) {
		int factorial = 1;
		for (int i = n; i >= 1; i--) {
			factorial *= i;
		}
		return factorial;
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(2));
	}
}
