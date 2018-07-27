package io.waterdrop.conversion;

public class BinaryToDecimal {

	public static int binaryToDecimal(String binaryString) {
		int binaryNum = Integer.valueOf(binaryString);
		// if()
		int sum = 0;
		int remainder = 0;
		int i = 0;
		while (binaryNum > 0) {
			remainder = binaryNum % 10;
			sum += remainder * Math.pow(2, i);
			binaryNum = binaryNum / 10;
			i++;
		}
		return sum;
	}
  public static void main(String[] args) {
	System.out.println(binaryToDecimal("110"));
}
}
