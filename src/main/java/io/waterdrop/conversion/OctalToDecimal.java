package io.waterdrop.conversion;

public class OctalToDecimal {
	public static int convertOctalToDecimal(int octal) {
		@SuppressWarnings("unused")
		int remainder;
		int decimal = 0;
		int i = 0;
		while (octal != 0) {
			remainder = octal % 10;
			octal /= 10;
			decimal += remainder*(int) Math.pow(8, i++);
		}
		return decimal;
	}
	
	public static void main(String[] args) {
		System.out.println(convertOctalToDecimal(123));
	}
}
