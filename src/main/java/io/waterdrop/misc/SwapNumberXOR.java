package io.waterdrop.misc;

public class SwapNumberXOR {

	public static void swapNumber(byte x, byte y) {
		System.out.print("(" + x + "," + y + ")--->");
		x = (byte) (x ^ y);
		y = (byte) (x ^ y);
		x = (byte) (x ^ y);
		System.out.println("(" + x + "," + y + ")");
	}
	

	
	public static void main(String[] args) {
		/*swapNumber(1,2);
		swapNumber(-1,-2);
		swapNumber(0,2);*/
		swapNumber((byte)2,(byte)2);
	}
}
