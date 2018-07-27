package io.waterdrop.mathproblem;

public class SieveOfEratosthenes {
	public static void findPrimesTillN(int N) {
		int[] array = new int[N + 1];
		for (int i = 0; i < array.length; i++) {
			array[i] = 1;
		}
		array[0] = 0;
		array[1] = 0;

		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (array[i] == 1) {
				for (int j = 2; i * j <= N; j++) {
					array[i * j] = 0;
				}
			}

		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				System.out.println(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		findPrimesTillN(100);
	}
}
