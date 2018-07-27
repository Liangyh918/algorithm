package io.waterdrop.conversion;

public class BinaryToOctal {
	public static int binaryToOctal(String binaryString) {
		int decimalNum = BinaryToDecimal.binaryToDecimal(binaryString);
		StringBuilder octalString = new StringBuilder("");
		int remainder = 0;

		while (decimalNum > 0) {
			remainder = decimalNum % 8;
			octalString.append(remainder);
			decimalNum = decimalNum / 8;
		}
		octalString.reverse();
		return Integer.valueOf(octalString.toString());
	}
	
	/**
	 * 这是一个错误的解法，看之后按同样的思路进行解决
	 * @param b
	 * @return
	 */
	public static int convertBinaryToOctal(int b) {
		int o = 0, r=0, j =1 ;
		while(b!=0)
		{
			//r = b % 10;
			r = b % 2;
        		o = o + r * j;
       			j = j * 2;
        		b = b / 2;
		}
		return o;
	}
	
	public static void main(String[] args) {
		
		System.out.println(binaryToOctal("1111"));
		System.out.println(convertBinaryToOctal(1111));
	}
}
