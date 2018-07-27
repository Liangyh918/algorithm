package io.waterdrop.mathproblem;

public class BinaryRepresentation {
	public static String getBinary(int decimal) {
		String binaryRepresentation;
		binaryRepresentation = Integer.toBinaryString(decimal);
		return binaryRepresentation;
	}

	public static void main(String[] args) {
		System.out.println(getBinary(-8));
	}
}
