package io.waterdrop.mathproblem;

public class PowerOfTwoOrNot {
	public static boolean isPowerOftwo(int number) {
		return number != 0 && ((number & (number - 1)) == 0);
	}

	public static void main(String[] args) {

		System.out.println(isPowerOftwo(2));
	}
}
