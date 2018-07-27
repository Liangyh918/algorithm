package io.waterdrop.conversion;

/**
 * 仅处理正数，负数稍作判断即可
 * 
 * @author liangyh
 *
 */
public class DecimalToAnyBase {
	public static char reval(int num) {
		if (num >= 0 && num <= 9)
			return (char) (num + '0');
		else
			return (char) (num - 10 + 'A');
	}

	public static String convertDecimalToAnyBase(int decimal, int base) {
		StringBuilder result = new StringBuilder();
		int remainder = 0;
		while (decimal != 0) {
			remainder = decimal % base;
			result.append(reval(remainder));
			decimal /= base;
		}
		return result.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convertDecimalToAnyBase(200,16));
	}
}
