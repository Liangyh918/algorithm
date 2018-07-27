package io.waterdrop.String;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGen {
	public static String generatePassword(int minLength, int maxLength) {
		Random random = new Random();

		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialChars = "!@#$%^&*(){}?";

		String allChars = upper + lower + numbers + specialChars;

		List<Character> letters = new ArrayList<Character>();

		for (int i = 0; i < allChars.length(); i++) {
			letters.add(allChars.charAt(i));
		}

		Collections.shuffle(letters);
		String password = "";

		for (int i = 0; i < random.nextInt(maxLength - minLength) + minLength; i++) {
			password += letters.get(random.nextInt(letters.size()));
		}
		return password;
	}

	public static void main(String args[]) {
		String password = generatePassword(8, 16);
		System.out.print("Password: " + password);
	}
}
