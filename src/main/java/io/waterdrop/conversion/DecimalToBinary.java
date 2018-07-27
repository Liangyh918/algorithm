package io.waterdrop.conversion;

public class DecimalToBinary {

	// 仅限正数
	public static String decimalToBinary(int decimal) {
		StringBuilder sb = new StringBuilder();
		int remainder = 0;
		while (decimal > 0) {
			remainder = decimal % 10;
			decimal = decimal / 10;
			sb.append(remainder);
		}
		return sb.reverse().toString();
	}
	
	//可转换负数，
	public static int convertDecimalToBinary(int decimal) {
		int binary = 0;
		int remainder = 0;
		int i=0;
		while (decimal != 0) {
			remainder = decimal % 2;
			decimal = decimal / 2;
			binary += remainder*(int)Math.pow(10, i++);
		}
		
		return binary;
	}
	
	//不可转换负数，使用位运算（bitwise）
	//思考如何用位运算进行转换负数，（记得有现成的算法）如果是负数则进行补码的逆运算得到原码，
	//原码到补码：原码取反+1
	//补码到原码：减1再取反，但是由于补码是负数，所以减1操作以加法加1实现
		public static int convertDecimalToBinaryBitwise(int decimal) {
			int binary = 0;
			int remainder = 0;
			int i=0;
			while (decimal != 0) {
				remainder = decimal & 1;
				decimal >>= 1 ;
				binary += remainder*(int)Math.pow(10, i++);
			}			
			return binary;
		}
	
	public static void main(String[] args) {
		System.out.println(convertDecimalToBinary(-3));
		System.out.println(convertDecimalToBinaryBitwise(-3));
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(Integer.numberOfLeadingZeros(3));
	}
}
