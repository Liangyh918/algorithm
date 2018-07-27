package io.waterdrop.String;

public class Palindrome {
	public static String reverseString(String original) {
		StringBuilder reversedString = null;
		for (int i = original.length() - 1; i >= 0; i--) {
			reversedString = reversedString.append(original.charAt(i));
		}
		return reversedString.toString();
	}

	public static boolean isPalindromeFirstWay(String testPalindrome) {
		return testPalindrome.equals(reverseString(testPalindrome));
	}

	public static boolean isPalindromeSecWay(String testPalindrome) {
		int i = 0, j = testPalindrome.length() - 1;
		while (i < j) {
			if (testPalindrome.charAt(i) != testPalindrome.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static boolean isPalindromeThirdWay(String testPalindrome) {
		if(testPalindrome.length()==0|| testPalindrome.length()==1){
			return true;
		}
		if(testPalindrome.charAt(0)!= testPalindrome.charAt(testPalindrome.length()-1)){
			return false;
		}
		return isPalindromeThirdWay(testPalindrome.substring(1, testPalindrome.length()-1));		
	}
}
