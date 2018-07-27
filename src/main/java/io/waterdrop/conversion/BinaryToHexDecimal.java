package io.waterdrop.conversion;

/**
 * 方法有两种： 一种是二进制转换成10进制，再10进制转换成16进制
 * 第二种是观察到4位二进制数的表示范围刚好是16进制数，因此可以对二进制数进行分块处理，一次得到16进制数的每一位。
 * 得到16进制的每一位的数值后找到该值的16进制表示有2种方法 1.将16进制的表示预存储，可以预存在字符串，数组，hashmap中 2.以A为base
 * Point，使用到的时候进行计算得到，公式：'A'+(i-10) 注意这个公式得到的结果是整型，需要转换成char
 * 
 * 这里使用第二种方法（更简单），找16进制表示的方式选第二种（更简单）。
 * 
 * @author liangyh
 *
 */
public class BinaryToHexDecimal {
	public static String convertBinaryToHexDecimal(int binary) {
		StringBuilder sb = new StringBuilder();
		int remainder = 0;
		int val = 0;
		while (binary != 0) {
			for (int i = 0; i < 4; i++) {
				remainder = binary % 10;
				binary /= 10;
				val += remainder * (int) Math.pow(2, i);
			}

			if (val < 10) {
				sb.append(val);
				// System.out.println(val);
			}
			if (val >= 10) {
				sb.append((char) ('A' + (val - 10)));
				System.out.println((char) ('A' + (val - 10)));
			}
			val = 0;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {

		System.out.println(convertBinaryToHexDecimal(1111));
	}
}
