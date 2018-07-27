package io.waterdrop.mathproblem;

public class krishnamurthy {
	public static boolean isKrishnamurthy(int testNum) {
		int sum = 0;
		int testNumCopy = testNum;
		while (testNumCopy != 0) {
			int a = testNumCopy % 10;
			sum += MathUtils.factorial(a);
			//System.out.println(sum);
			testNumCopy = testNumCopy / 10;
		}
		//System.out.println(sum);
		//System.out.println(testNum);
		if (sum == testNum) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000000; i++) {
			if(isKrishnamurthy(i)==true)
			System.out.println(i+":"+isKrishnamurthy(i));
		}
		
	}
}
