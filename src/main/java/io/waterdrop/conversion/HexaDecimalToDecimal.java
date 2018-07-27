package io.waterdrop.conversion;

/**
 * 思路：在字符串中依次存储0~F，索引值代表这个符号对应的数字大小
 * 
 * @author liangyh
 */
public class HexaDecimalToDecimal {
	public static int convertHexaDecimalToDecimal(String HexaNum) {
		String digits = "0123456789ABCDEF";
		int decimalResult = 0;
		for (int i = 0; i < HexaNum.length(); i++) {
			int val = digits.indexOf(HexaNum.charAt(i));
			decimalResult = decimalResult * 16 + val;
		}
		return decimalResult;
	}
	
	public static void main(String[] args) {
		System.out.println(convertHexaDecimalToDecimal("BC"));
	}
}
