package io.waterdrop.conversion;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：16进制数的一位对应2进制数的4位，因此可以做一个16进制数到2进制数的映射表
 * 
 * (也可以16进制转换成10进制，再10进制转换成2进制)
 * 
 * @author liangyh
 *
 */
public class HexaDecimalToBinary {
	
	/**
	 * 只处理正数，负数情况稍加判断进行调整即可
	 * 
	 * @param HexaDecimal
	 * @return
	 */
	public static String convertHexaDecimalToBinary(String HexaDecimal) {
		Map<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("0", "0000");
		hashMap.put("1", "0001");
		hashMap.put("2", "0010");
		hashMap.put("3", "0011");
		hashMap.put("4", "0100");
		hashMap.put("5", "0101");
		hashMap.put("6", "0110");
		hashMap.put("7", "0111");
		hashMap.put("8", "1000");
		hashMap.put("9", "1001");
		hashMap.put("A", "1010");
		hashMap.put("B", "1011");
		hashMap.put("C", "1100");
		hashMap.put("D", "1101");
		hashMap.put("E", "1110");
		hashMap.put("F", "1111");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < HexaDecimal.length(); i++) {
			sb.append(hashMap.get(HexaDecimal.charAt(i)));
		}
		
		return HexaDecimal;

	}
}
