package io.waterdrop.mathproblem;

public class ArmStrong {
	public static boolean isArmStrong(int num) {
		int sum = 0, remainder = 0;
		int temp=num;
		while(temp!=0){
			remainder = temp %10;
			sum +=(int) Math.pow(remainder, 3);
			temp /= 10; 
		}
		if(num==sum){
			return true;
		}
		return false;

	}
	
	public static void main(String[] args) {
		System.out.println(isArmStrong(372));
	}
}
