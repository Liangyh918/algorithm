package io.waterdrop.String;

public class RemoveDuplicateFromString {
	public static String removeDuplicateFromString(String str) {
		StringBuilder uniqueSeq = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			if (uniqueSeq.toString().indexOf(str.charAt(i)) == -1) {
				uniqueSeq.append(str.charAt(i));
			}
		}
		return uniqueSeq.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(removeDuplicateFromString("123523423534544"));
	}
}
