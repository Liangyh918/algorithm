package io.waterdrop.String;

import java.util.Arrays;

public class CountChar {
	public static int countCharFirstWay(String str) {
		int count = 0;
		if (str == null || str.isEmpty()) {
			return count;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				count++;
			}
		}
		return count;
	}

	public static int countCharSecWay(String str) {
		int count = 0;
		if (str == null || str.isEmpty()) {
			return count;
		}
		String[] array = str.split("[\\s]+");
		for (int i = 0; i < array.length; i++) {
			count += array[i].length();
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countCharFirstWay("123		  234"));
	}
}
