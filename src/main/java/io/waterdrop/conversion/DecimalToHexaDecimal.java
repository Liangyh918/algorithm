package io.waterdrop.conversion;

public class DecimalToHexaDecimal {
	/**
	 * 
	 * 
	 * @param decimal
	 * @return
	 */
	public static String convertDecimalToHexaDecimal(int decimalNum) {
		int decimal = Math.abs(decimalNum);
		int remainder = 0;
		StringBuilder sb = new StringBuilder();
		while (decimal != 0) {
			remainder = decimal % 16;
			decimal = decimal / 16;
			if (remainder < 10) {
				sb.append(remainder);
			}
			if (remainder >= 10) {
				sb.append((char) ('A' + (remainder - 10)));
			}
		}
		if(decimalNum<0){
			sb.append("-");
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		
		System.out.println(convertDecimalToHexaDecimal(-25));
	}
}
