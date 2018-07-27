package io.waterdrop.String;

public class WordCount {
	public static int countWord(String words) {
		if (words == null || words.isEmpty()) {
			return 0;
		}

		return words.trim().split("[\\s]+").length;
	}
	
	public static void main(String[] args) {
		System.out.println(countWord("addbc  dsf"));
	}
}
